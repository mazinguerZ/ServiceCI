/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.charging;

import javax.xml.datatype.DatatypeConfigurationException;

import junit.framework.Assert;

import org.junit.Test;

import es.tid.neosdp.charging.ChargingUtils;

/**
 * Unit test for CharginUtils
 *
 * @author Raul Pastor (rps@tid.es)
 */
public class ChargingUtilsTest {

	@Test
	public void testTimestamps() {
		try {
			String timestamp = ChargingUtils.getTimestamp();
			System.out.println(timestamp);
			Assert.assertTrue(timestamp.endsWith("Z"));
			Assert.assertEquals(timestamp.length(), 24);
			
		} catch (DatatypeConfigurationException e) {
			Assert.fail(e.getMessage());
		}
	}

}
