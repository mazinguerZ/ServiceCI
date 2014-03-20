/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

import java.util.HashMap;
import java.util.Map;

import es.tid.neosdp.Constants;
import es.tid.neosdp.representations.Map2Json;
import es.tid.neosdp.representations.Map2Xml;
import es.tid.neosdp.representations.Xml2Soap;
import es.tid.neosdp.representations.exceptions.InvalidDocumentFormatException;
import es.tid.neosdp.representations.exceptions.MapSchemaMismatchException;
import es.tid.neosdp.representations.exceptions.NotAvailableTypeException;
import es.tid.neosdp.representations.schema.SchemaCallback;

/**
 * Generates a JSON, XML, SOAP or RPC document for a given UnicaException and version. 
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 * @author Ana Junquera (anajf@tid.es)
 * @author Roberto Mier (rmescandon@gmail.com)
 */
public class UnicaExceptionMarshaller {
	
	/**
	 * Schema callback to retrieve the XML schemas to manage exceptions
	 */
	private final static SchemaCallback exceptionSchemaCallback = new ExceptionSchemaCallback();
	
	/*
	 * Transformers for each representation and version. These are static to minimize the creation of these objects (impact in Java garbage collector) 
	 */
	private final static Map2Json MAP2JSON_REST_V1 = new Map2Json(UnicaConstants.NAMESPACE_UNICA_REST_V1, UnicaExceptionMarshaller.exceptionSchemaCallback, false);
	private final static Map2Xml MAP2XML_REST_V1 = new Map2Xml(UnicaConstants.NAMESPACE_UNICA_REST_V1, UnicaExceptionMarshaller.exceptionSchemaCallback);
	private final static Map2Xml MAP2XML_SOAP_V1 = new Map2Xml(UnicaConstants.NAMESPACE_UNICA_SOAP_V1, UnicaExceptionMarshaller.exceptionSchemaCallback);
	private final static Map2Json MAP2JSON_RPC_V1 = new Map2Json(UnicaConstants.NAMESPACE_UNICA_RPC_V1, UnicaExceptionMarshaller.exceptionSchemaCallback, false);
	private final static Map2Xml MAP2XML_RPC_V1 = new Map2Xml(UnicaConstants.NAMESPACE_UNICA_RPC_V1, UnicaExceptionMarshaller.exceptionSchemaCallback);
	private final static Map2Json MAP2JSON_REST_V2 = new Map2Json(UnicaConstants.NAMESPACE_UNICA_REST_V2, UnicaExceptionMarshaller.exceptionSchemaCallback, true);
	private final static Map2Xml MAP2XML_REST_V2 = new Map2Xml(UnicaConstants.NAMESPACE_UNICA_REST_V2, UnicaExceptionMarshaller.exceptionSchemaCallback);
	private final static Map2Json MAP2JSON_BLUEVIA_V2 = new Map2Json(UnicaConstants.NAMESPACE_UNICA_BLUEVIA_V2, UnicaExceptionMarshaller.exceptionSchemaCallback, true);
	private final static Map2Xml MAP2XML_BLUEVIA_V2 = new Map2Xml(UnicaConstants.NAMESPACE_UNICA_BLUEVIA_V2, UnicaExceptionMarshaller.exceptionSchemaCallback);
	private final static Map2Xml MAP2XML_SOAP_V2 = new Map2Xml(UnicaConstants.NAMESPACE_UNICA_SOAP_V2, UnicaExceptionMarshaller.exceptionSchemaCallback);
	
	/**
	 * Marshal a UnicaException into a document considering the requested representation (JSON, XML, SOAP) and version (v1, v1-RPC, v2-Unica, v2-Bluevia)
	 * 
	 * @param unicaException
	 * @param representation
	 * @param version
	 * @return
	 */
	public static String marshal(final UnicaException unicaException, final String representation, final String version) {
		// Convert the representation from string to int
		int repr = Constants.REPRESENTATION_REST_JSON;
		if (Constants.REPRESENTATION_STR_REST_XML.equals(representation)) {
			repr = Constants.REPRESENTATION_REST_XML;
		} else if (Constants.REPRESENTATION_STR_SOAP.equals(representation)) {
			repr = Constants.REPRESENTATION_SOAP;
		} 
		
		// Convert the version from string to int
		int vers = Constants.VERSION_V2_UNICA;
		if (Constants.VERSION_STR_V1.equals(version))
			vers = Constants.VERSION_V1;
		else if (Constants.VERSION_STR_V2_BLUEVIA.equals(version))
			vers = Constants.VERSION_V2_BLUEVIA;
		else if (Constants.VERSION_STR_V1_RPC.equals(version))
			vers = Constants.VERSION_V1_RPC;
		return UnicaExceptionMarshaller.marshal(unicaException, repr, vers);
	}
	
	/**
	 * Marshal a UnicaException into a document considering the requested representation (JSON, XML, SOAP) and version (v1, v1-RPC, v2-Unica, v2-Bluevia)
	 * 
	 * @param unicaException
	 * @param representation
	 * @param version
	 * @return
	 */
	public static String marshal(final UnicaException unicaException, final int representation, final int version) {
		String exceptionDocument = null;
		try {
			switch (version) {
				case Constants.VERSION_V1:
					exceptionDocument = UnicaExceptionMarshaller.marshalV1(unicaException, representation);
					break;
				case Constants.VERSION_V1_RPC:
					exceptionDocument = UnicaExceptionMarshaller.marshalV1Rpc((RpcUnicaException)unicaException, representation);
					break;
				case Constants.VERSION_V2_UNICA:
					if (representation==Constants.REPRESENTATION_SOAP) {
						exceptionDocument = UnicaExceptionMarshaller.marshalV2Soap(unicaException);
					} else {
						exceptionDocument = UnicaExceptionMarshaller.marshalV2(unicaException, representation, false);
					}
					break;
				case Constants.VERSION_V2_BLUEVIA:
					exceptionDocument = UnicaExceptionMarshaller.marshalV2(unicaException, representation, true);
					break;
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return exceptionDocument;
	}
	
	/**
	 * Marshal a UnicaException according to UNICA API v1 specification
	 * 
	 * @param unicaException
	 * @param representation
	 * @return
	 * @throws NotAvailableTypeException
	 * @throws MapSchemaMismatchException
	 * @throws InvalidDocumentFormatException
	 */
	protected static String marshalV1(final UnicaException unicaException, final int representation) throws NotAvailableTypeException, MapSchemaMismatchException, InvalidDocumentFormatException {
		// Prepare the exception map
		Map<String, Object> exceptionMap = new HashMap<String, Object>();
		exceptionMap.put(UnicaConstants.EXCEPTION_CATEGORY, unicaException.getCategory());
		exceptionMap.put(UnicaConstants.EXCEPTION_ID, unicaException.getId());
		exceptionMap.put(UnicaConstants.EXCEPTION_TEXT, unicaException.getTextMergingParameters());
		if (unicaException.getVariables() != null)
			exceptionMap.put(UnicaConstants.EXCEPTION_VARIABLES, unicaException.getVariables());
		// Prepare the root element name and type
		String rootElementName = UnicaConstants.CLIENT_EXCEPTION_ELEMENT;
		String rootElementType = UnicaConstants.CLIENT_EXCEPTION_TYPE;
		if (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(unicaException.getCategory())) {
			rootElementName = UnicaConstants.SERVER_EXCEPTION_ELEMENT;
			rootElementType = UnicaConstants.SERVER_EXCEPTION_TYPE;
		}
		// Marshal the exception map according to the representation
		String category = unicaException.getCategory();
		String faultCode = null;
		String faultString = null;
	
		switch (representation) {
			case Constants.REPRESENTATION_REST_JSON:
				return UnicaExceptionMarshaller.MAP2JSON_REST_V1.generate(rootElementName, exceptionMap, rootElementType);
			case Constants.REPRESENTATION_REST_XML:
				return UnicaExceptionMarshaller.MAP2XML_REST_V1.generate(rootElementName, exceptionMap, rootElementType);
			case Constants.REPRESENTATION_SOAP:
				faultCode = "soap:"+ (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(category)?"Server":"Client");
				faultString = (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(category)?"Server":"Client")+" exception";
				return Xml2Soap.addSoapFault(UnicaConstants.NAMESPACE_UNICA_SOAP_FAULTS_V1, faultCode, faultString, UnicaExceptionMarshaller.MAP2XML_SOAP_V1.generate(rootElementName, exceptionMap, rootElementType), true, false);
			case Constants.REPRESENTATION_SOAP_FAULT_NOT_DETAIL_FAULT:
				faultCode = "soap:"+ (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(category)?"Server":"Client");
				faultString = unicaException.getCategory()+unicaException.getId()+":"+unicaException.getTextMergingParameters();
				return Xml2Soap.addSoapFaultNoDetail(faultCode, faultString, true, false);
		}
		return null;
	}
	
	/**
	 * Marshal a UnicaException according to UNICA API v1 for RPC specification
	 * 
	 * @param unicaException
	 * @param representation
	 * @return
	 * @throws NotAvailableTypeException
	 * @throws MapSchemaMismatchException
	 * @throws InvalidDocumentFormatException
	 */
	protected static String marshalV1Rpc(final RpcUnicaException unicaException, final int representation) throws NotAvailableTypeException, MapSchemaMismatchException, InvalidDocumentFormatException {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put(UnicaConstants.EXCEPTION_RPC_CODE, unicaException.getCategory() + unicaException.getId());
		errorMap.put(UnicaConstants.EXCEPTION_RPC_MESSAGE, unicaException.getTextMergingParameters());
		Map<String, Object> methodResponseMap = new HashMap<String, Object>();
		methodResponseMap.put(UnicaConstants.EXCEPTION_RPC_ID, unicaException.getRpcId());
		methodResponseMap.put(UnicaConstants.EXCEPTION_RPC_VERSION, unicaException.getRpcVersion());
		methodResponseMap.put(UnicaConstants.EXCEPTION_RPC_ERROR, errorMap);
		// Marshal the exception map according to the representation
		switch (representation) {
			case Constants.REPRESENTATION_REST_JSON:
				return UnicaExceptionMarshaller.MAP2JSON_RPC_V1.generate(UnicaConstants.EXCEPTION_RPC_ROOT_ELEMENT, methodResponseMap, UnicaConstants.EXCEPTION_RPC_ROOT_TYPE);
			case Constants.REPRESENTATION_REST_XML:
				return UnicaExceptionMarshaller.MAP2XML_RPC_V1.generate(UnicaConstants.EXCEPTION_RPC_ROOT_ELEMENT, methodResponseMap, UnicaConstants.EXCEPTION_RPC_ROOT_TYPE);
		}
		return null;
	}
	
	/**
	 * Marshal a UnicaException according to UNICA API v2 or Bluevia API v2 specifications 
	 * 
	 * @param unicaException
	 * @param representation
	 * @param isBlueviaVersion
	 * @return
	 * @throws NotAvailableTypeException
	 * @throws MapSchemaMismatchException
	 * @throws InvalidDocumentFormatException
	 */
	protected static String marshalV2(final UnicaException unicaException, final int representation, final boolean isBlueviaVersion) throws NotAvailableTypeException, MapSchemaMismatchException, InvalidDocumentFormatException {
		// Prepare the exception map
		Map<String, Object> exceptionMap = new HashMap<String, Object>();
		exceptionMap.put(UnicaConstants.EXCEPTION_V2_ID, unicaException.getCategory() + unicaException.getId());
		exceptionMap.put(UnicaConstants.EXCEPTION_V2_TEXT, unicaException.getTextMergingParameters());
		
		if(unicaException instanceof V2UnicaException){
			V2UnicaException v2UnicaException = (V2UnicaException)unicaException;
			exceptionMap.put(UnicaConstants.EXCEPTION_V2_MORE_INFO, v2UnicaException.getMoreInfo());
		}
		
		// Marshal the exception map according to the representation
		switch (representation) {
			case Constants.REPRESENTATION_REST_JSON:
				Map2Json map2Json = isBlueviaVersion ? MAP2JSON_BLUEVIA_V2 : MAP2JSON_REST_V2;
				return map2Json.generate(UnicaConstants.EXCEPTION_V2_ELEMENT, exceptionMap, UnicaConstants.EXCEPTION_V2_TYPE);	
			case Constants.REPRESENTATION_REST_XML:
				Map2Xml map2Xml = isBlueviaVersion ? MAP2XML_BLUEVIA_V2 : MAP2XML_REST_V2;
				return map2Xml.generate(UnicaConstants.EXCEPTION_V2_ELEMENT, exceptionMap, UnicaConstants.EXCEPTION_V2_TYPE);
		}
		return null;
	}
	
	/**
	 * Marshal a UnicaException according to UNICA API v2 or Bluevia API v2 specifications 
	 * 
	 * @param unicaException
	 * @param representation
	 * @param isBlueviaVersion
	 * @return
	 * @throws NotAvailableTypeException
	 * @throws MapSchemaMismatchException
	 * @throws InvalidDocumentFormatException
	 */
	protected static String marshalV2Soap(final UnicaException unicaException) throws NotAvailableTypeException, MapSchemaMismatchException, InvalidDocumentFormatException {
		// Prepare the exception map
		Map<String, Object> exceptionMap = new HashMap<String, Object>();
		exceptionMap.put(UnicaConstants.EXCEPTION_CATEGORY, unicaException.getCategory());
		exceptionMap.put(UnicaConstants.EXCEPTION_ID, unicaException.getId());
		exceptionMap.put(UnicaConstants.EXCEPTION_TEXT, unicaException.getTextMergingParameters());
		
		//Prepare the faultcode and the faultstring
		String category = unicaException.getCategory();
		String faultCode = "soap:"+ (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(category)?"Server":"Client");
		String faultString = (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(category)?"Server":"Client")+" Exception";
				
		// Prepare the root element name and type
		String rootElementName = UnicaConstants.CLIENT_EXCEPTION_ELEMENT;
		String rootElementType = UnicaConstants.CLIENT_EXCEPTION_TYPE;
		if (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(unicaException.getCategory())) {
			rootElementName = UnicaConstants.SERVER_EXCEPTION_ELEMENT;
			rootElementType = UnicaConstants.SERVER_EXCEPTION_TYPE;
		}
		return Xml2Soap.addSoapFault(UnicaConstants.NAMESPACE_UNICA_SOAP_FAULTS_V2,faultCode, faultString, UnicaExceptionMarshaller.MAP2XML_SOAP_V2.generate(rootElementName, exceptionMap, rootElementType), true, false);
		
	}
	
	/**
	 * Marshal a Soap fault without fault details.
	 * Receives the unica exception codes and set the faultstring as categoryId:exceptionText.
	 * This shall be used for http layer errors when soap accessing.  
	 * @param unicaException
	 * @return
	 * @throws NotAvailableTypeException
	 * @throws MapSchemaMismatchException
	 * @throws InvalidDocumentFormatException
	 */
	public static String marshalSoapFaultNoDetail(final UnicaException unicaException) throws NotAvailableTypeException, MapSchemaMismatchException, InvalidDocumentFormatException {
		// Prepare the exception map
		Map<String, Object> exceptionMap = new HashMap<String, Object>();
		exceptionMap.put(UnicaConstants.EXCEPTION_CATEGORY, unicaException.getCategory());
		exceptionMap.put(UnicaConstants.EXCEPTION_ID, unicaException.getId());
		exceptionMap.put(UnicaConstants.EXCEPTION_TEXT, unicaException.getTextMergingParameters());
		
		//Prepare the faultcode and the faultstring
		String category = unicaException.getCategory();
		String faultCode = "soap:"+ (UnicaConstants.EXCEPTION_CATEGORY_SVR.equals(category)?"Server":"Client");
		String faultString = unicaException.getCategory()+unicaException.getId()+":"+unicaException.getTextMergingParameters();
				
		return Xml2Soap.addSoapFaultNoDetail(faultCode, faultString, true, false);
		
	}
	
	/**
	 * Marshal a Soap fault without fault details. 
	 * Receives the final faultcode and faultstring that will be set into exception message.
	 * This shall be used for WSSE and WSA related exceptions. 
	 * @param faultCode
	 * @param faultString
	 * @return
	 * @throws NotAvailableTypeException
	 * @throws MapSchemaMismatchException
	 * @throws InvalidDocumentFormatException
	 */
	public static String marshalSoapFaultNoDetail(String faultCode, String faultString) throws NotAvailableTypeException, MapSchemaMismatchException, InvalidDocumentFormatException {
		return Xml2Soap.addSoapFaultNoDetail(faultCode, faultString, true, false);
	}
}