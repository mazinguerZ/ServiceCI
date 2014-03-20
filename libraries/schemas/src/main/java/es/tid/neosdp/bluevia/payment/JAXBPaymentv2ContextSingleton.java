/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.bluevia.payment;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * JAXBPaymentv2RestContextSingleton
 * 
 * @author rps
 *
 */
public class JAXBPaymentv2ContextSingleton {
	protected static JAXBContext context = null;
	
	public static JAXBContext getJAXBContext() throws JAXBException
	{
		if(context==null)
		{
			context = JAXBContext.newInstance("com.bluevia.api.schemas.payment.v2");
		}
		return context;
	}
}
