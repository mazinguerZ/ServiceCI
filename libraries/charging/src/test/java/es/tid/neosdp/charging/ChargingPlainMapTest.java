/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.charging;

import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import junit.framework.Assert;

import org.junit.Test;

import es.tid.neosdp.charging.ChargingPlainMap;
import es.tid.neosdp.charging.ChargingUtils;
import es.tid.neosdp.plainmap.PlainMap;
import es.tid.neosdp.plainmap.PlainMapException;
import es.tid.neosdp.representations.Map2Xml;

/**
 * Unit test for ChargingPlainMapUtils
 *
 * @author Raul Pastor (rps@tid.es)
 */
public class ChargingPlainMapTest {

	@Test
	public void testDirectDebitPlainMap() {
		try {
			ChargingPlainMap chargingMap = new ChargingPlainMap("1234", "983000000");
			PlainMap map= chargingMap.getDirectDebitMap();
			Map2Xml m2xml = new Map2Xml();
			
			
		} catch (PlainMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testRequetedEvents() {
		try {
			ChargingPlainMap chargingMap = new ChargingPlainMap("1234", "983000000");
			chargingMap.addRequestedEvent("1", "1", "1");
			chargingMap.addRequestedEvent("1", "20", "21");
			chargingMap.addRequestedEvent("1", "30", "32");
			chargingMap.addRequestedEvent("1", "40", "43");
			PlainMap map = chargingMap.getGetPurchaseModelsOfEventsMap();
			Map<String, Object> s = map.getHierarchicalMap();
			String ss = s.toString();
			ss.toCharArray();
			
		} catch (PlainMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
