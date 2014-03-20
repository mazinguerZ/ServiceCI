/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.bluevia.payment;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * JAXBPaymentv1rpcContextSingleton
 * 
 * @author rps
 *
 */
public class JAXBPaymentv1rpcContextSingleton {
	protected static JAXBContext context = null;
	
	public static JAXBContext getJAXBContext() throws JAXBException
	{
		if(context==null)
		{
			context = JAXBContext.newInstance("com.telefonica.schemas.unica.rpc.payment.v1");
		}
		return context;
	}
}
