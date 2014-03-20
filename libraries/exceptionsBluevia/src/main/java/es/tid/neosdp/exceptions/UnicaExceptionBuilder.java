/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.tid.neosdp.callouts.UnicaJavaCalloutException;

/**
 * Build a UnicaException instance
 * 
 * @author Ana Junquera (anajf@tid.es)
 * @author David Vicente (dvicente@full-on-net.com)
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class UnicaExceptionBuilder {
	
	/**
	 * Logger
	 */
	private final static Logger logger = Logger.getLogger(UnicaExceptionBuilder.class.getName());
	
	/**
	 * Path to the UNICA exception properties file (in the classpath)
	 */
	private final static String UNICA_EXCEPTION_PROPERTIES_PATH = "/properties/unica-exceptions.properties";
	
	/**
	 * Properties with the information of UNICA exceptions (text and code) by the category_id
	 */
	private static Properties UNICA_EXCEPTION_PROPERTIES = new Properties();
	static {
		try {
			InputStream inputStream = UnicaExceptionBuilder.class.getResourceAsStream(UnicaExceptionBuilder.UNICA_EXCEPTION_PROPERTIES_PATH);
			UnicaExceptionBuilder.UNICA_EXCEPTION_PROPERTIES.load(inputStream);
			logger.info("Loaded the unica exceptions properties file");
		} catch (Throwable t) {
			logger.log(Level.WARNING, "Error loading the unica exceptions properties file", t);
		}
	}
	
	/**
	 * Path to the Apigee exception properties file (in the classpath)
	 */
	private final static String APIGEE_EXCEPTION_PROPERTIES_PATH = "/properties/apigee-exceptions.properties";
	
	/**
	 * Properties with the mapping between Apigee exceptions and UNICA exceptions 
	 */
	private static Properties APIGEE_EXCEPTION_PROPERTIES = new Properties();
	static {
		try {
			InputStream inputStream = UnicaExceptionBuilder.class.getResourceAsStream(UnicaExceptionBuilder.APIGEE_EXCEPTION_PROPERTIES_PATH);
			UnicaExceptionBuilder.APIGEE_EXCEPTION_PROPERTIES.load(inputStream);
			logger.info("Loaded the Apigee exceptions properties file");
		} catch (Throwable t) {
			logger.log(Level.WARNING, "Error loading the Apigee exceptions properties file", t);
		}
	}
	
	/**
	 * Return a UnicaException by retrieving the exception information from the properties
	 * file "unica_exception.properties" (mainly the text and code of the exception).
	 * If the categoryId is not registered in the properties file, then return an internal
	 * server exception
	 * 
	 * @param categoryId
	 * @return
	 */
	public static UnicaException buildByCategoryId(final String categoryId) {
		return UnicaExceptionBuilder.buildByCategoryId(categoryId, null);
	}
	
	/**
	 * Return a UnicaException by retrieving the exception information from the properties
	 * file "unica_exception.properties" (mainly the text and code of the exception).
	 * If the categoryId is not registered in the properties file, then return an internal
	 * server exception.
	 * This method also adds to UnicaException the optional list of variables
	 * 
	 * @param categoryId
	 * @param listParameters
	 * @return
	 */
	public static UnicaException buildByCategoryId(final String categoryId, final List<String> listParameters) {
		return buildByCategoryId(categoryId, listParameters, null);
	}
	

	
	/**
	 * Return a UnicaException by retrieving the exception information from the properties
	 * file "unica_exception.properties" (mainly the text and code of the exception).
	 * If the categoryId is not registered in the properties file, then return an internal
	 * server exception.
	 * This method also adds to the UnicaException the optional list of variables
	 * In case of replaceParameters is true 
	 * 
	 * @param categoryId
	 * @param listParameters
	 * @param replaceParameters
	 * @return
	 */
	public static UnicaException buildByCategoryId(final String categoryId, final List<String> listParameters, final List<String> listVariables) {
		String exceptionText = UnicaExceptionBuilder.UNICA_EXCEPTION_PROPERTIES.getProperty(categoryId + ".text");
		
		// If there is no exception registered with this categoryId, then return an internal server exception
		if (exceptionText == null) {
			
			// Check if the categoryId maps to internal server, to avoid an infinite loop
			if (UnicaConstants.EXCEPTION_INTERNAL_SERVER_ID.equals(categoryId))
				return null;
			else
				return UnicaExceptionBuilder.buildInternalServerException();
		}
		String exceptionResponseCode = UnicaExceptionBuilder.UNICA_EXCEPTION_PROPERTIES.getProperty(categoryId + ".code");
		UnicaException unicaException = new UnicaException(categoryId);
		unicaException.setText(exceptionText);
		unicaException.setResponseCode(exceptionResponseCode);
		
		//Check if some parameter starts with the moreInfo prefix
		if(listParameters != null){
			for (int i = 0 ; i < listParameters.size(); i++) {
				String variable = listParameters.get(i);
				String[] elements = variable.split("moreInfo:");
				if (elements.length==2) {
					String moreInfo = elements[1];
					listParameters.remove(i);
					unicaException.setParameters(listParameters);
					
					//The moreInfo parameter will be treated in a special way, it will be part of the v2 unica exception 
					V2UnicaException v2UnicaException = new V2UnicaException(unicaException,moreInfo);
					unicaException = v2UnicaException;
				}
			}
		}
		
		unicaException.setParameters(listParameters);
		unicaException.setVariables(listVariables);
		return unicaException;
	}
	

	/**
	 * Returns a object <UnicaException> which contains the description,
	 * category, identifier and the code response of the exception. If any of
	 * the params is null returns an Internal Server Error because are mandatory
	 * @param exceptionCategory
	 * @param exceptionId
	 * @param text
	 * @return
	 */
	public static UnicaException buildByAllParameters(String categoryId,
			String exceptionText, int codeResponse, List<String> listParameters, List<String> listVariables) {
		UnicaException unicaException = null;
		if (exceptionText != null && categoryId != null) {
			unicaException = new UnicaException(categoryId);
			unicaException.setText(exceptionText);
			String exceptionResponseCode = UnicaExceptionBuilder.UNICA_EXCEPTION_PROPERTIES.getProperty(categoryId + ".code");
			if(exceptionResponseCode!=null){
				//It is necessary in case of the response code is different from the defined rest code response
				unicaException.setResponseCode(exceptionResponseCode);
			}else{
				unicaException.setResponseCode(codeResponse);
			}
			unicaException.setParameters(listParameters);
			unicaException.setVariables(listVariables);
		} else {
			unicaException = UnicaExceptionBuilder.buildByCategoryId(UnicaConstants.EXCEPTION_INTERNAL_SERVER_ID);
		}
		return unicaException;
	}
	
	/**
	 * Returns a object <UnicaException> which contains the description,
	 * category, identifier and the code response of the exception. If any of
	 * the params is null returns an Internal Server Error because are mandatory
	 * @param exceptionCategory
	 * @param exceptionId
	 * @param text
	 * @return
	 */
	public static UnicaException buildByAllParameters(String categoryId,
			String exceptionText, int codeResponse, List<String> listParameters) {
		return buildByAllParameters(categoryId,
				exceptionText,codeResponse,listParameters,null);
	}
	
	
	
	/**
	 * Returns a object <UnicaException> which contains the description,
	 * category, identifier and the code response of the exception. If any of
	 * the params is null returns an Internal Server Error because are mandatory
	 * 
	 * @param exceptionCategory
	 * @param exceptionId
	 * @param text
	 * @return
	 */
	public static UnicaException buildByResponseCode(int exceptionResponseCode) {
		UnicaException unicaException = new UnicaException(null);
		unicaException.setResponseCode(exceptionResponseCode);
		return unicaException;
	}
	
	/**
	 * Return a UnicaException from an Apigee error code. The Apigee error code is translated into a UNICA
	 * exception (category_id), and then generated the UnicaException. If the mapping fails, it is generated
	 * an Internal Server exception (SVR_1000).
	 * 
	 * @param errorCode
	 * @return
	 */
	public static UnicaException buildByApigeeErrorCode(final String errorCode) {
		String categoryId = UnicaExceptionBuilder.APIGEE_EXCEPTION_PROPERTIES.getProperty(errorCode, UnicaConstants.EXCEPTION_INTERNAL_SERVER_ID);
		UnicaException unicaException = UnicaExceptionBuilder.buildByCategoryId(categoryId);
		String text = unicaException.getText();
		text = text.replace(": %1", "");
		text = text.replace(" %1", "");
		unicaException.setText(text);
		return unicaException;
	}
	
	
	/**
	 * Return a UnicaException from an Apigee error trace which contains the unica code identifier as well as the optional list of variables.
	 * The input exceptions follows this format:
	 * <ul>
	 * <li>Fault Name: JavaCalloutFailure</li>
	 * <li>Error Type: JavaCalloutFailure</li>
	 * <li>Description: JavaCalloutFailure</li>
	 * <li>Message: error code,param1,param2,param3</li>
	 * <li>Service: service</li>
	 * <li>Endpoint: endpoint</li>
	 * <li>Operation (Client):operation</li>
	 * <li>FlowTransitionState : Client_Request_User_Error</li>
	 * <li>Policy : Policy</li>
	 * <li>javaCallout name</li>
	 * </ul>
	 * 
	 * @param apigeeFaultTrace
	 * @return
	 */
	public static UnicaException buildByApigeeException(final String apigeeFaultTrace) {
		String apigeeExceptionMessage = UnicaExceptionBuilder.extractValueFromApigeeTraceException(apigeeFaultTrace, "Message",": ");
		UnicaException unicaException= UnicaExceptionBuilder.buildByApigeeExceptionMessage(apigeeExceptionMessage);
		unicaException.setApigeeFaultTrace(apigeeFaultTrace);
		return unicaException;
	}
	
	
	/**
	 * Return a UnicaException from the error "Message" line. The "Message" line is parsed and the exception "category_id"
	 * is obtained, as well as the optional list of variables
	 * 
	 * @param apigeeException
	 * @return
	 */
	public static UnicaException buildByApigeeExceptionMessage(final String apigeeExceptionMessage) {
		UnicaException unicaException = null;
		if (apigeeExceptionMessage != null) {
			List<String> listExceptionInfo = UnicaJavaCalloutException.unformatMessage(apigeeExceptionMessage);
			if (listExceptionInfo != null && listExceptionInfo.size() > 0) {
				// The first list element is the UNICA exception "category_id"
				String code = listExceptionInfo.get(0);
				listExceptionInfo.remove(0);
				if(code.matches("[3-5][0-9][0-9]")){
					int responseCode = Integer.parseInt(code);
					unicaException = UnicaExceptionBuilder.buildByResponseCode(responseCode);
				}else{
					unicaException = UnicaExceptionBuilder.buildByCategoryId(code,listExceptionInfo);
				}
			}
		}else{
			unicaException = UnicaExceptionBuilder.buildInternalServerException();
		}
		return unicaException;
	}
	/**
	 * Build an internal server exception
	 * 
	 * @return
	 */
	public static UnicaException buildInternalServerException() {
		ArrayList<String> parameters = new ArrayList<String>();
		parameters.add("Exception does not match Unica standard");
		return UnicaExceptionBuilder.buildByCategoryId(UnicaConstants.EXCEPTION_INTERNAL_SERVER_ID,parameters);
	}
	
	

	/**
	 * Return the value related to the input key from an Apigee exception which follows
	 * this format:
	 * <ul>
	 * <li>Fault Name: JavaCalloutFailure</li>
	 * <li>Error Type: JavaCalloutFailure</li>
	 * <li>Description: JavaCalloutFailure</li>
	 * <li>Message: error code,param1,param2,param3</li>
	 * <li>Service: service</li>
	 * <li>Endpoint: endpoint</li>
	 * <li>Operation (Client):operation</li>
	 * <li>FlowTransitionState : Client_Request_User_Error</li>
	 * <li>Policy : Policy</li>
	 * <li>javaCallout name</li>
	 * </ul>
	 * 
	 * @param apigeeException
	 * @param key
	 * @return
	 */
	public static String extractValueFromApigeeTraceException(final String apigeeException, String key, String separator) {
		key = key+separator;
		if (apigeeException != null) {
			// Find the index of the key
			int indexStartMessage = apigeeException.indexOf(key);
			if (indexStartMessage >= 0) {
				indexStartMessage += key.length();
				// Find the end of line
				int indexEndMessage = apigeeException.indexOf('\n', indexStartMessage);
				if (indexEndMessage > 0) {
					// Check if the previous char is \r
					if (apigeeException.charAt(indexEndMessage - 1) == '\r')
						indexEndMessage--;
					return apigeeException.substring(indexStartMessage, indexEndMessage);
				} else
					return apigeeException.substring(indexStartMessage);
			}
		}
		return null;
	}
}