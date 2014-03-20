/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;


import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import es.tid.neosdp.Utils;

/**
 * Unit test for UnicaExceptionBuilderTest
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class UnicaExceptionBuilderTest {
	@Test
	public void testBuildByCategoryId() {
		UnicaException unicaException = UnicaExceptionBuilder.buildByCategoryId("SVC_1000");
		Assert.assertEquals("SVC_1000", unicaException.getCategoryId());
		Assert.assertEquals("SVC", unicaException.getCategory());
		Assert.assertEquals("1000", unicaException.getId());
		Assert.assertEquals(400, unicaException.getResponseCode());
		Assert.assertEquals("Missing mandatory parameter: %1", unicaException.getText());
	}
	
	@Test
	public void testBuildByApigeeErrorCode() {
		UnicaException unicaException = UnicaExceptionBuilder.buildByApigeeErrorCode("26110");
		Assert.assertEquals("SVC_1002", unicaException.getCategoryId());
		Assert.assertEquals("SVC", unicaException.getCategory());
		Assert.assertEquals("1002", unicaException.getId());
		Assert.assertEquals(404, unicaException.getResponseCode());
		Assert.assertEquals("Requested URI does not exist", unicaException.getText());
	}	
	
	@Test
	public void testBuildByAgigeeException() {
		String path = "/ApigeeException.xml";
		String messageContent = Utils.readFileAsString(path);
		UnicaException unicaException = UnicaExceptionBuilder.buildByApigeeException(messageContent);
		Assert.assertEquals("SVC_0002", unicaException.getCategoryId());
		Assert.assertEquals("SVC", unicaException.getCategory());
		Assert.assertEquals("0002", unicaException.getId());
		Assert.assertEquals(400, unicaException.getResponseCode());
		Assert.assertEquals("Invalid parameter value: accountId with value 'tel:aa447725180586' does not match pattern tel:[+]?[0-9]+", unicaException.getTextMergingParameters());
	}
	
	@Test
	public void testBuildByAgigeeException1() {
		String path = "/ApigeeException1.xml";
		String messageContent = Utils.readFileAsString(path);
		UnicaException unicaException = UnicaExceptionBuilder.buildByApigeeException(messageContent);
		Assert.assertEquals("SVC_0002", unicaException.getCategoryId());
		Assert.assertEquals("SVC", unicaException.getCategory());
		Assert.assertEquals("0002", unicaException.getId());
		Assert.assertEquals(400, unicaException.getResponseCode());
		Assert.assertEquals("Invalid parameter value: %1", unicaException.getTextMergingParameters());
	}
	
	@Test
	public void testBuildByAgigeeExceptionWithMoreInfo() {
		String path = "/ApigeeExceptionWithMoreInfo.xml";
		String messageContent = Utils.readFileAsString(path);
		UnicaException unicaException = UnicaExceptionBuilder.buildByApigeeException(messageContent);
		Assert.assertEquals("SVC_0002", unicaException.getCategoryId());
		Assert.assertEquals("SVC", unicaException.getCategory());
		Assert.assertEquals("0002", unicaException.getId());
		Assert.assertEquals(400, unicaException.getResponseCode());
		Assert.assertEquals("Invalid parameter value: %1", unicaException.getTextMergingParameters());
		V2UnicaException v2UnicaException = (V2UnicaException)unicaException;
		Assert.assertEquals("/prueba/service", v2UnicaException.getMoreInfo());
	}
	
	@Test
	public void testBuildByAgigeeExceptionWithHttpCode() {
		String path = "/ApigeeExceptionWithHttpCode.xml";
		String messageContent = Utils.readFileAsString(path);
		UnicaException unicaException = UnicaExceptionBuilder.buildByApigeeException(messageContent);
		Assert.assertEquals(403, unicaException.getResponseCode());
	}
	
	@Test
	public void testBuildByCategoryIdAndParameters() {
		List<String> parameters = new ArrayList<String>();
		parameters.add("447000000007 - Provisioning request for this MSISDN is already in progress");
		UnicaException unicaException = UnicaExceptionBuilder.buildByAllParameters("SVC_4007", "Activation In Progress: %1", 403, parameters);
		Assert.assertEquals(403, unicaException.getResponseCode());
		Assert.assertEquals("Activation In Progress: 447000000007 - Provisioning request for this MSISDN is already in progress", unicaException.getTextMergingParameters());
	}
	
	@Test
	public void testBuildByCategoryIdAndVariablesSoap() {
		List<String> variables = new ArrayList<String>();
		variables.add("Generic RemoteException");
		UnicaException unicaException = UnicaExceptionBuilder.buildByCategoryId("SVR_1000", null, variables);
		Assert.assertEquals(500, unicaException.getResponseCode());
		Assert.assertEquals("Generic Server Error: %1", unicaException.getTextMergingParameters());
		Assert.assertEquals("Generic RemoteException", unicaException.getVariables().get(0));
	}
}