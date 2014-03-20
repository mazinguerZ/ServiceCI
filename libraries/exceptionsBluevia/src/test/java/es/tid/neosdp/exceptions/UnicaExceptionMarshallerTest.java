/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import es.tid.neosdp.Constants;
import es.tid.neosdp.plainmap.PlainMap;
import es.tid.neosdp.representations.Json2Map;
import es.tid.neosdp.representations.Xml2Map;
import es.tid.neosdp.representations.schema.SchemaCallback;
import es.tid.neosdp.representations.validation.MapValidation;

/**
 * Unit test for UnicaExceptionMarshaller
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class UnicaExceptionMarshallerTest {
	
	private UnicaException unicaException;
	
	private SchemaCallback schemaCallback;
	
	@Before
	public void setUp() throws Exception {
		this.unicaException = UnicaExceptionBuilder.buildByCategoryId("SVC_1000");
		List<String> parameters = new ArrayList<String>();
		parameters.add("testParameter");
		this.unicaException.setParameters(parameters);
		this.schemaCallback = new ExceptionSchemaCallback();
	}

	@Test
	public void testMarshalV1() {
		try {
			// Generate a JSON v1 exception
			List<String> variables = new ArrayList<String>();
			variables.add("variables");
			this.unicaException.setVariables(variables);
			String jsonException = UnicaExceptionMarshaller.marshal(unicaException, Constants.REPRESENTATION_REST_JSON, Constants.VERSION_V1);
			System.out.println(jsonException);
			// Validate the generated JSON document
			PlainMap plainMap = new PlainMap(Json2Map.parse(jsonException));
			Assert.assertEquals("SVC", plainMap.get("ClientException.exceptionCategory"));
			Assert.assertEquals("1000", plainMap.get("ClientException.exceptionId"));
			Assert.assertEquals("Missing mandatory parameter: testParameter", plainMap.get("ClientException.text"));
			Assert.assertEquals("variables", plainMap.get("ClientException.variables[0]"));
			Assert.assertEquals("1", plainMap.get("ClientException.variables.length"));
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to JSON: " + t.getMessage());
		}
	
		try {
			// Generate a XML v1 exception
			List<String> variables = new ArrayList<String>();
			variables.add("variables");
			this.unicaException.setVariables(variables);
			String xmlException = UnicaExceptionMarshaller.marshal(unicaException, Constants.REPRESENTATION_REST_XML, Constants.VERSION_V1);
			System.out.println(xmlException);
			// Validate the generated XML document
			Map<String, Object> xmlMap = Xml2Map.parse(xmlException);
			new MapValidation(UnicaConstants.NAMESPACE_UNICA_REST_V1, schemaCallback).validate(xmlMap);
			PlainMap plainMap = new PlainMap(xmlMap);
			Assert.assertEquals("SVC", plainMap.get("ClientException.exceptionCategory"));
			Assert.assertEquals("1000", plainMap.get("ClientException.exceptionId"));
			Assert.assertEquals("Missing mandatory parameter: testParameter", plainMap.get("ClientException.text"));
			Assert.assertEquals("variables", plainMap.get("ClientException.variables[0]"));
			Assert.assertEquals("1", plainMap.get("ClientException.variables.length"));
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to XML: " + t.getMessage());
		}
		try {
			// Generate a SOAP v1 exception
			String soapException = UnicaExceptionMarshaller.marshal(unicaException, Constants.REPRESENTATION_SOAP, Constants.VERSION_V1);
			System.out.println(soapException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to SOAP: " + t.getMessage());
		}
	}
	
	@Test
	public void testMarshalV1Rpc() {
		RpcUnicaException rpcUnicaException = new RpcUnicaException(unicaException, "111", "v1");
		try {
			// Generate a RPC v1 exception
			String rpcJsonException = UnicaExceptionMarshaller.marshal(rpcUnicaException, Constants.REPRESENTATION_REST_JSON, Constants.VERSION_V1_RPC);
			// Validate the generated JSON document
			PlainMap plainMap = new PlainMap(Json2Map.parse(rpcJsonException));
			Assert.assertEquals("111", plainMap.get("methodResponse.id"));
			Assert.assertEquals("v1", plainMap.get("methodResponse.version"));
			Assert.assertEquals("SVC1000", plainMap.get("methodResponse.error.code"));
			Assert.assertEquals("Missing mandatory parameter: testParameter", plainMap.get("methodResponse.error.message"));
			System.out.println(rpcJsonException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to JSON: " + t.getMessage());
		}
		
		try {
			String rpcXmlException = UnicaExceptionMarshaller.marshal(rpcUnicaException, Constants.REPRESENTATION_REST_XML, Constants.VERSION_V1_RPC);
			System.out.println(rpcXmlException);
			// Validate the generated XML document
			Map<String, Object> xmlMap = Xml2Map.parse(rpcXmlException);
			MapValidation mapValidation = new MapValidation(UnicaConstants.NAMESPACE_UNICA_RPC_V1, schemaCallback);
			mapValidation.validateType("methodResponse", xmlMap.get("methodResponse"), "MethodResponseType", UnicaConstants.NAMESPACE_UNICA_RPC_V1);
			PlainMap plainMap = new PlainMap(xmlMap);
			Assert.assertEquals("111", plainMap.get("methodResponse.id"));
			Assert.assertEquals("v1", plainMap.get("methodResponse.version"));
			Assert.assertEquals("SVC1000", plainMap.get("methodResponse.error.code"));
			Assert.assertEquals("Missing mandatory parameter: testParameter", plainMap.get("methodResponse.error.message"));
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to JSON: " + t.getMessage());
		}
	}
			
	@Test
	public void testMarshalV2Unica() {
		try {
			// Generate a UNICA v2 exception
			V2UnicaException v2UnicaException = new V2UnicaException(unicaException,"http://prueba");
			String jsonUnicaException = UnicaExceptionMarshaller.marshal(v2UnicaException, Constants.REPRESENTATION_REST_JSON, Constants.VERSION_V2_UNICA);
			System.out.println(jsonUnicaException);
			String xmlUnicaException = UnicaExceptionMarshaller.marshal(v2UnicaException, Constants.REPRESENTATION_REST_XML, Constants.VERSION_V2_UNICA);
			System.out.println(xmlUnicaException);
			String soapUnicaException = UnicaExceptionMarshaller.marshal(v2UnicaException, Constants.REPRESENTATION_SOAP, Constants.VERSION_V2_UNICA);
			System.out.println(soapUnicaException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to JSON: " + t.getMessage());
		}
	}
	
	
	@Test
	public void testMarshalV2UnicaWithVariables() {
		try {
			// Generate a UNICA v2 exception
			this.unicaException = UnicaExceptionBuilder.buildByCategoryId("SVC_1000");
			List<String> variables = new ArrayList<String>();
			variables.add("testParameter");
			unicaException.setVariables(variables);
			String jsonUnicaException = UnicaExceptionMarshaller.marshal(unicaException, Constants.REPRESENTATION_REST_JSON, Constants.VERSION_V2_UNICA);
			System.out.println(jsonUnicaException);
			String xmlUnicaException = UnicaExceptionMarshaller.marshal(unicaException, Constants.REPRESENTATION_REST_XML, Constants.VERSION_V2_UNICA);
			System.out.println(xmlUnicaException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to JSON: " + t.getMessage());
		}
	}
			
	
	@Test
	public void testMarshalV2Bluevia() {
		try {
			// Generate a Bluevia v2 exception
			V2UnicaException v2UnicaException = new V2UnicaException(unicaException,"http://prueba");
			String jsonBlueviaException = UnicaExceptionMarshaller.marshal(v2UnicaException, Constants.REPRESENTATION_REST_JSON, Constants.VERSION_V2_BLUEVIA);
			System.out.println(jsonBlueviaException);
			String xmlBlueviaException = UnicaExceptionMarshaller.marshal(v2UnicaException, Constants.REPRESENTATION_REST_XML, Constants.VERSION_V2_BLUEVIA);
			System.out.println(xmlBlueviaException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to JSON: " + t.getMessage());
		}
	}
	
	@Test
	public void testMarshalSoapV1() {
		try {
			// Generate a soap exception
			String soapException = UnicaExceptionMarshaller.marshal(unicaException, Constants.REPRESENTATION_SOAP, Constants.VERSION_V1);
			System.out.println(soapException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to SOAP: " + t.getMessage());
		}
	}
	
	@Test
	public void testMarshalSoapFaultUnicaNoDetail() {
		try {
			// Generate a soap exception
			String soapException = UnicaExceptionMarshaller.marshalSoapFaultNoDetail(unicaException);
			System.out.println(soapException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to SOAP: " + t.getMessage());
		}
	}

	@Test
	public void testMarshalSoapFaultWsaNoDetail() {
		try {
			// Generate a soap exception
			String soapException = UnicaExceptionMarshaller.marshalSoapFaultNoDetail("wsa:MessageInformationHeaderRequired","Mising mandatory parameter");
			System.out.println(soapException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to SOAP: " + t.getMessage());
		}
	}
	
	@Test
	public void testMarshalSoapFaultWsseNoDetail() {
		try {
			// Generate a soap exception
			String soapException = UnicaExceptionMarshaller.marshalSoapFaultNoDetail("wsse:InvalidSecurity","Invalid or missing security header: Consumer authentication ");
			System.out.println(soapException);
		} catch (Throwable t) {
			Assert.fail("Error marshalling a UnicaException to SOAP: " + t.getMessage());
		}
	}

}