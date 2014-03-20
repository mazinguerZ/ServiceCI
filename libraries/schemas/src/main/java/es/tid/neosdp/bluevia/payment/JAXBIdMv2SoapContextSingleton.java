/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.bluevia.payment;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * JAXBCIdMv2SoapContextSingleton
 * 
 * @author rps
 *
 */
public class JAXBIdMv2SoapContextSingleton {
	protected static JAXBContext context = null;
	
	public static JAXBContext getJAXBContext() throws JAXBException
	{
		if(context==null)
		{
			context = JAXBContext.newInstance("com.telefonica.wsdl.unica.soap.iam_identitymanagement.v2.local");
		}
		return context;
	}
}
