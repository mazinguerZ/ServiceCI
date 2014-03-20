/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

/**
 * Constants to handle UNICA exceptions
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class UnicaConstants {	
	/*
	 * UNICA exception categories
	 */
	public final static String EXCEPTION_CATEGORY_SVR = "SVR";
	public final static String EXCEPTION_CATEGORY_SVC = "SVC";
	public final static String EXCEPTION_CATEGORY_SEC = "SEC";
	public final static String EXCEPTION_CATEGORY_POL = "POL";
	
	/**
	 * Category_id for UNICA internal server error 
	 */
	public final static String EXCEPTION_INTERNAL_SERVER_ID = "SVR_1000";
	
	/*
	 * Constants for UNICA exception v1
	 */
	public final static String SERVER_EXCEPTION_ELEMENT = "ServerException";
	public final static String CLIENT_EXCEPTION_ELEMENT = "ClientException";
	public final static String SERVER_EXCEPTION_TYPE = "ServerExceptionType";
	public final static String CLIENT_EXCEPTION_TYPE = "ClientExceptionType";
	public final static String EXCEPTION_CATEGORY = "exceptionCategory";
	public final static String EXCEPTION_ID = "exceptionId";
	public final static String EXCEPTION_TEXT = "text";
	public final static String EXCEPTION_VARIABLES = "variables";
	
	public final static String EXCEPTION_V2_ROOT = "exception.";
	public final static String EXCEPTION_V2_ELEMENT = "exception";
	public final static String EXCEPTION_V2_TYPE = "ExceptionType";
	public final static String EXCEPTION_V2_ID = "exceptionId";
	public final static String EXCEPTION_V2_TEXT = "exceptionText";
	public final static String EXCEPTION_V2_MORE_INFO = "moreInfo";
	public final static String EXCEPTION_V2_USER_MESSAGE = "userMessage";
	
	/*
	 * Constants for RPC exceptions
	 */
	public final static String EXCEPTION_RPC_ROOT_ELEMENT = "methodResponse";
	public final static String EXCEPTION_RPC_ROOT_TYPE = "MethodResponseType";
	public final static String EXCEPTION_RPC_ID = "id";
	public final static String EXCEPTION_RPC_VERSION = "version";
	public final static String EXCEPTION_RPC_ERROR = "error";
	public final static String EXCEPTION_RPC_CODE = "code";
	public final static String EXCEPTION_RPC_MESSAGE = "message";
	
	/*
	 * Constants for SOAP exceptions
	 */
	public final static String EXCEPTION_SOAP_FAULTSTRING_ELEMENT = "faultstring";
	public final static String EXCEPTION_SOAP_FAULTCODE_ELEMENT = "faultcode";
	
	/**
	 * Constanst for the apigee variables to save the unica exception codes
	 */
	public final static String PATH_EXCEPTION_CATEGORY_ID = "_flow.msgvar.neosdp.exception.categoryId";
	public final static String PATH_EXCEPTION_TEXT = "_flow.msgvar.neosdp.exception.text";
	public final static String PATH_EXCEPTION_HTTP_CODE = "_flow.msgvar.neosdp.exception.httpCode";
	public final static String PATH_EXCEPTION_APIGEE_CODE = "_flow.msgvar.neosdp.exception.apigee.code";
	public final static String PATH_EXCEPTION_VARIABLE = "_flow.msgvar.neosdp.exception.variable";

	
	/**
	 * Constanst for the apigee variables to save the soap fault codes
	 */
	public final static String PATH_EXCEPTION_SOAP_FAULTCODE = "_flow.msgvar.neosdp.exception.soap.faultcode";
	public final static String PATH_EXCEPTION_SOAP_FAULTSTRING = "_flow.msgvar.neosdp.exception.soap.faultstring";

	/**
	 * Constant for the apigee variables to save the moreInfo element when rest v2 unica exception
	 */
	public final static String PATH_EXCEPTION_MORE_INFO = "_flow.msgvar.neosdp.exception.moreInfo";
	
	/*
	 * Schema namespaces
	 */
	/**
	 * Namespace for UNICA API REST v1
	 */
	public final static String NAMESPACE_UNICA_REST_V1 = "http://www.telefonica.com/schemas/UNICA/REST/common/v1";
	/**
	 * Namespace for UNICA API RPC v1
	 */
	public final static String NAMESPACE_UNICA_RPC_V1 = "http://www.telefonica.com/schemas/UNICA/RPC/definition/v1";
	/**
	 * Namespace for UNICA API SOAP v1
	 */
	public final static String NAMESPACE_UNICA_SOAP_V1 = "http://www.telefonica.com/schemas/UNICA/SOAP/common/v1";
	/**
	 * Namespace for UNICA API SOAP FAULTS v1
	 */
	public final static String NAMESPACE_UNICA_SOAP_FAULTS_V1 = "http://www.telefonica.com/wsdl/UNICA/SOAP/common/v1/faults";
	
	/**
	 * Namespace for UNICA API SOAP FAULTS v2
	 */
	public final static String NAMESPACE_UNICA_SOAP_FAULTS_V2 = "http://www.telefonica.com/wsdl/UNICA/SOAP/common/v2/faults";
	
	/**
	 * Namespace for UNICA API SOAP v2
	 */
	public final static String NAMESPACE_UNICA_SOAP_V2 = "http://www.telefonica.com/schemas/UNICA/SOAP/common/v2";
	/**
	 * Namespace for UNICA API REST v2
	 */
	public final static String NAMESPACE_UNICA_REST_V2 = "http://www.telefonica.com/schemas/UNICA/REST/common/v2";
	/**
	 * Namespace for Bluevia API REST v2
	 */
	public final static String NAMESPACE_UNICA_BLUEVIA_V2 = "http://api.bluevia.com/schemas/common/v2";
}
