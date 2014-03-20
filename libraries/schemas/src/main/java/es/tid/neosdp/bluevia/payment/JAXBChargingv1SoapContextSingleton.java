/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.bluevia.payment;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * JAXBChargingv1SoapContextSingleton
 * 
 * @author rps
 *
 */
public class JAXBChargingv1SoapContextSingleton {
	protected static JAXBContext context = null;
	
	public static JAXBContext getJAXBContext() throws JAXBException
	{
		if(context==null)
		{
			context = JAXBContext.newInstance("com.telefonica.wsdl.unica.soap.charging.v1.interfaces");
		}
		return context;
	}
}
