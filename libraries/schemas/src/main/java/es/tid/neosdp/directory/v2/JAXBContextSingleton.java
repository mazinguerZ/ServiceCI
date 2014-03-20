package es.tid.neosdp.directory.v2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JAXBContextSingleton {

	private JAXBContext jaxbContext;
	private static JAXBContextSingleton instance;
	
	private JAXBContextSingleton() throws JAXBException{
		jaxbContext=JAXBContext.newInstance("es.tid.neosdp.bluevia.schemas.directory.v2");
	}
	
	public static JAXBContextSingleton getInstance() throws JAXBException{
		if (instance==null){
			instance=new JAXBContextSingleton();
		}
		return instance;
	}
	
	public JAXBContext getJAXBContext(){
		return jaxbContext;
	}
}
