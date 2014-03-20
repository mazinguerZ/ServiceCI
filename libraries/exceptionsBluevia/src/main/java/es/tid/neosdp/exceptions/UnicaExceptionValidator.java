/*
 * neoSDP (API management layer for Telefonica enablers)
 */
package es.tid.neosdp.exceptions;

import java.util.ArrayList;
import java.util.List;

import es.tid.neosdp.plainmap.PlainMap;

/**
 * Receives a plainMap <PlainMap> with the keys and values of a message of
 * exception. Checks if the exception keys matches an Unica Exception or it is
 * convertible to the Unica standard.
 * 
 * Matches the following types exceptions: Unica exceptions from enablers:
 * <ul>
 * <li>Unica exceptions in rest/xml-v1 or soap</li>
 * <li>Unica exceptions in rest/json-v2</li>
 * </ul>
 * 
 * Internal exceptions from apigee applications:
 * <ul>
 * <li>Apigee exceptions in rest/text</li>
 * <li>Apigee exceptions in soap</li>
 * </ul>
 * 
 * Return an object <UnicaException> with the associated Unica exception codes,
 * otherwise return null. A null response means that the exception could have
 * not been translated to an Unica exception.
 * 
 * @author Ana Junquera (anajf)
 * 
 */
public class UnicaExceptionValidator {
	/**
	 * Constants for path exceptions
	 */
	private static final String PATH_SOAPFAULT_DETAIL = "Envelope.Body.Fault.detail";
	private static final String PATH_SOAPFAULT = "Envelope.Body.Fault";
	private static final String PATH_APIGEE_ERRORCODE = "fault.detail.errorcode";
	private static final String PATH_APIGEE_TRACE = "fault.detail.trace";
	private static final String PATH_APIGEE_SOAP_ERRORCODE = "source.errorcode";
	private static final String PATH_APIGEE_SOAP_TRACE = "source.trace";
	private static final String PATH_RPC_EXCEPTION_CODE = "methodResponse.error.code";
	private static final String PATH_RPC_EXCEPTION_MESSAGE = "methodResponse.error.message";
	

	/**
	 * Constants for apigee javacallout exception code
	 */
	private static final int JAVACALLOUT_EXCEPTION_CODE = 34100;

	/**
	 * Receives a hashMap with the keys and values of a message of exception.
	 * Check if the exception keys matches an Unica Exception or it is
	 * convertible to Unica standard. Return an object <UnicaException> with the
	 * associated Unica codes, otherwise return null.
	 * 
	 * @param plainMap
	 * @param codeResponse
	 * @return
	 */
	public static UnicaException getUnicaException(PlainMap plainMap,
			int codeResponse) {
		String exceptionId = null;
		String text = null;
		String exceptionCategory = null;
		List<String> listVariables = null;

		// First REST/XML V1 UNICA ClientException is searched
		String typeException = UnicaConstants.CLIENT_EXCEPTION_ELEMENT;
		exceptionCategory = (String) plainMap.get(typeException.concat(".")
				.concat(UnicaConstants.EXCEPTION_CATEGORY));

		if (exceptionCategory == null) {
			// Otherwise a REST/XML V1 UNICA ServerException is searched
			typeException = UnicaConstants.SERVER_EXCEPTION_ELEMENT;
			exceptionCategory = (String) plainMap.get(typeException.concat(".")
					.concat(UnicaConstants.EXCEPTION_CATEGORY));

			if (exceptionCategory == null) {
				// Otherwise a SOAP V1 UNICA Client Exception is searched
				typeException = PATH_SOAPFAULT_DETAIL + "."
						+ UnicaConstants.CLIENT_EXCEPTION_ELEMENT;
				exceptionCategory = (String) plainMap.get(typeException.concat(
						".").concat(UnicaConstants.EXCEPTION_CATEGORY));

				if (exceptionCategory == null) {
					// Otherwise a SOAP V1 UNICA Server Exception is
					// searched
					typeException = PATH_SOAPFAULT_DETAIL + "."
							+ UnicaConstants.SERVER_EXCEPTION_ELEMENT;
					exceptionCategory = (String) plainMap.get(typeException
							.concat(".").concat(
									UnicaConstants.EXCEPTION_CATEGORY));
				}
		
			}
		}

		// In case of a UNICA Exception is found, fills the UnicaException
		// object with the values of the exception
		if (exceptionCategory != null) {
			exceptionId = (String) plainMap.get(typeException.concat(".")
					.concat(UnicaConstants.EXCEPTION_ID));
			
			//Checks if it related to common 2.0
			String[] elements = exceptionId.split(" ");
			if(elements!=null&&elements.length==2){
				exceptionCategory=elements[0];
				exceptionId=elements[1];
			}
			
			text = (String) plainMap.get(typeException.concat(".").concat(
					UnicaConstants.EXCEPTION_TEXT));
			
			
			String numVariables = (String) plainMap.get(typeException
					.concat(".").concat(UnicaConstants.EXCEPTION_VARIABLES)
					.concat(".length"));
			
			int num = 0;
			if (numVariables != null) {
				num = Integer.parseInt(numVariables);
			}

			if (num >= 1) {
				listVariables = new ArrayList<String>();
				for (int i = 0; i < num; i++) {
					String variable = (String) plainMap.get(typeException
							.concat(".").concat(
									UnicaConstants.EXCEPTION_VARIABLES)
							+ "[" + i + "]");
					listVariables.add(variable.trim());
				}
			} else {
				String variables = (String) plainMap.get(typeException
						.concat(".").concat(UnicaConstants.EXCEPTION_VARIABLES));
				if(variables!=null){
					listVariables = new ArrayList<String>();
					listVariables.add(variables);
				}
			}

			if (exceptionCategory != null && exceptionId != null
					&& text != null) {
				// All parameters are mandatory, if any of them is not present
				// is not unica valid exception
				if(exceptionId.length()==1){
					//Necessary for fixing the bluevia bug with the codes 000X
					exceptionId="000"+exceptionId;
				}
				return UnicaExceptionBuilder.buildByAllParameters(
						exceptionCategory + UnicaException.SEPARATOR
								+ exceptionId, text, codeResponse,
						null, listVariables);
			} else {
				return null;
			}

		}
		
		// Otherwise a SOAP exceptions without fault detail is searched
		String faultcode = (String) plainMap.get(PATH_SOAPFAULT.concat(".").concat(UnicaConstants.EXCEPTION_SOAP_FAULTCODE_ELEMENT));
		String faultstring = (String) plainMap.get(PATH_SOAPFAULT.concat(".").concat(UnicaConstants.EXCEPTION_SOAP_FAULTSTRING_ELEMENT));
		if(faultcode!=null&&faultstring!=null){
			SoapFaultException soapUnicaException = new SoapFaultException(faultcode, faultstring);
			return soapUnicaException;
		}

		// Otherwise a REST/JSON V2 UNICA Exception is
		// searched
		String exceptionCode = (String) plainMap
				.get(UnicaConstants.EXCEPTION_V2_ID);
		if (exceptionCode != null) {
			int size = exceptionCode.length();
			try {
				exceptionId = exceptionCode.substring(size - 4);
				exceptionCategory = exceptionCode.substring(0, size - 4);
				text = (String) plainMap.get(UnicaConstants.EXCEPTION_V2_TEXT);
				
				String moreInfo = (String) plainMap
						.get(UnicaConstants.EXCEPTION_V2_MORE_INFO);
				
				UnicaException unicaException = UnicaExceptionBuilder.buildByAllParameters(
						exceptionCategory + UnicaException.SEPARATOR
								+ exceptionId, text, codeResponse, null);
				
				if(moreInfo!=null){
					 unicaException = new V2UnicaException(unicaException,moreInfo);
				}
				return unicaException;
			} catch (Exception e) {
				return null;
			}

		}

		// Otherwise a REST/XML V2 UNICA Exception is
		// searched
		exceptionCode = (String) plainMap.get(UnicaConstants.EXCEPTION_V2_ROOT
				+ UnicaConstants.EXCEPTION_V2_ID);
		if (exceptionCode != null) {
			int size = exceptionCode.length();
			try {
				exceptionId = exceptionCode.substring(size - 4);
				exceptionCategory = exceptionCode.substring(0, size - 4);
				text = (String) plainMap.get(UnicaConstants.EXCEPTION_V2_ROOT
						+ UnicaConstants.EXCEPTION_V2_TEXT);
				
				String moreInfo = (String) plainMap
						.get(UnicaConstants.EXCEPTION_V2_ROOT+UnicaConstants.EXCEPTION_V2_MORE_INFO);
				
				UnicaException unicaException = UnicaExceptionBuilder.buildByAllParameters(
						exceptionCategory + UnicaException.SEPARATOR
								+ exceptionId, text, codeResponse, null);
				
				if(moreInfo!=null){
					 unicaException = new V2UnicaException(unicaException,moreInfo);
				}
				return unicaException;
			} catch (Exception e) {
				return null;
			}
		}
		
		
		// Otherwise a RPC UNICA Exception is
		// searched
		exceptionCode = (String) plainMap
				.get(PATH_RPC_EXCEPTION_CODE);
		
		if(exceptionCode!=null){
			int size = exceptionCode.length();
			try {
				exceptionId = exceptionCode.substring(size - 4);
				exceptionCategory = exceptionCode.substring(0, size - 4);
				text = (String) plainMap.get(PATH_RPC_EXCEPTION_MESSAGE);
				return UnicaExceptionBuilder.buildByAllParameters(
						exceptionCategory + UnicaException.SEPARATOR
								+ exceptionId, text, codeResponse, null);
			} catch (Exception e) {
				return null;
			}
		}

		// Otherwise a APIGEE Exception is searched
		exceptionId = (String) plainMap.get(PATH_APIGEE_ERRORCODE);
		
		if (exceptionId != null) {
			int apigeeFaultCode = Integer.parseInt(exceptionId);
			if (apigeeFaultCode==JAVACALLOUT_EXCEPTION_CODE) {
				// UnicaJavaCallout trace is searched
				String apigeeFaultTrace = (String) plainMap
						.get(PATH_APIGEE_TRACE);
				return UnicaExceptionBuilder
						.buildByApigeeException(apigeeFaultTrace);

			} else {
				String apigeeFaultTrace = (String) plainMap
						.get(PATH_APIGEE_TRACE);
				// otherwise apigee error code is translated
				UnicaException unicaException =  UnicaExceptionBuilder
						.buildByApigeeErrorCode(exceptionId);
				unicaException.setApigeeFaultTrace(apigeeFaultTrace);
				unicaException.setApigeeFaultCode(apigeeFaultCode);
				return unicaException;
			}
		} else {
			// Otherwise a Soap Apigee exception is searched
			exceptionId = (String) plainMap.get(PATH_SOAPFAULT_DETAIL + "."
					+ PATH_APIGEE_SOAP_ERRORCODE);
			if (exceptionId != null) {
				int apigeeFaultCode = Integer.parseInt(exceptionId);
				if (apigeeFaultCode==JAVACALLOUT_EXCEPTION_CODE) {
					// UnicaJavaCallout trace is searched
					String apigeeFaultTrace = (String) plainMap
							.get(PATH_SOAPFAULT_DETAIL + "."
									+ PATH_APIGEE_SOAP_TRACE);
					return UnicaExceptionBuilder
							.buildByApigeeException(apigeeFaultTrace);
				} else {
					// otherwise apigee error code is translated
					String apigeeFaultTrace = (String) plainMap
							.get(PATH_SOAPFAULT_DETAIL + "."
									+ PATH_APIGEE_SOAP_TRACE);
					UnicaException unicaException =  UnicaExceptionBuilder
							.buildByApigeeErrorCode(exceptionId);
					unicaException.setApigeeFaultTrace(apigeeFaultTrace);
					unicaException.setApigeeFaultCode(apigeeFaultCode);
					return unicaException;
				}
			}
		}
		return null;

	}

}
