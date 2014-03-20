/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.charging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for ApiIdsEbcMapper
 * 
 * @author Jesus Diaz Artiaga (jda@creativit.com)
 */
public class ApiIdsEbcMapperTest {

	@Test
	public void testGetApiCode3() {
		
		assertEquals("1,", ApiIdsEbcMapper.getApiCode3("sms.send"));
		assertEquals("2,", ApiIdsEbcMapper.getApiCode3("sms.receive"));
		assertEquals("1,2,", ApiIdsEbcMapper.getApiCode3("sms.*"));
		assertEquals("3,", ApiIdsEbcMapper.getApiCode3("mms.send"));
		assertEquals("4,", ApiIdsEbcMapper.getApiCode3("mms.receive"));
		assertEquals("3,4,", ApiIdsEbcMapper.getApiCode3("mms.*"));
	}

	@Test
	public void testGetCode3AllTypes() {
		assertTrue("1,2,3,4,".equals(ApiIdsEbcMapper.getCode3AllTypes()));
		assertTrue("1,2,3,4,".equals(ApiIdsEbcMapper.getApiCode3("all.values")));
	}
	
	@Test
	public void testGetInverseCode3() {
		assertTrue("sms.send".equals(ApiIdsEbcMapper.getInverseCode3("1")));
		assertTrue("sms.receive".equals(ApiIdsEbcMapper.getInverseCode3("2")));
		assertTrue("mms.send".equals(ApiIdsEbcMapper.getInverseCode3("3")));
		assertTrue("mms.receive".equals(ApiIdsEbcMapper.getInverseCode3("4")));
		assertTrue("".equals(ApiIdsEbcMapper.getInverseCode3("5")));
		assertTrue("".equals(ApiIdsEbcMapper.getInverseCode3("")));
	}
}