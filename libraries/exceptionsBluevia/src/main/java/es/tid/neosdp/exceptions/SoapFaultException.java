/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

/**
 * Class that contains the codes related to a soap fault exception.
 * It extends from UnicaException but the unica exception codes can
 * be null in case there is no fault detail associated.
 * 
 * @author Ana Junquera (anajf@tid.es)
 */
public class SoapFaultException extends UnicaException {

	/**
	 * Faultcode parameter
	 */
	private String faultcode;
	
	/**
	 * Faultstring parameter
	 */
	private String faultstring;
	
	
	/**
	 * Constructor
	 * 
	 * @param unicaException
	 * @param faultcode
	 * @param faultstring
	 */
	public SoapFaultException(final UnicaException unicaException, final String faultcode, final String faultstring) {
		super(unicaException.getCategoryId());
		this.setText(unicaException.getText());
		this.setParameters(unicaException.getParameters());
		this.setResponseCode(unicaException.getResponseCode());
		this.setFaultcode(faultcode);
		this.setFaultstring(faultstring);
	}
	
	/**
	 * Constructor
	 * 
	 * @param unicaException
	 * @param faultcode
	 * @param faultstring
	 */
	public SoapFaultException(final String faultcode, final String faultstring) {
		super(null);
		this.setText(null);
		this.setParameters(null);
		this.setResponseCode(500);
		this.setFaultcode(faultcode);
		this.setFaultstring(faultstring);
	}

	/**
	 * Get the faultcode parameter
	 * @return
	 */
	public String getFaultcode() {
		return faultcode;
	}

	/**
	 * Set the faultcode parameter
	 * 
	 * @param faultcode
	 */
	public void setFaultcode(String faultcode) {
		this.faultcode = faultcode;
	}
	/**
	 * Get the faultcode parameter
	 * @return
	 */
	public String getFaultstring() {
		return faultstring;
	}

	/**
	 * Set the faultstring parameter
	 * 
	 * @param faultstring
	 */
	public void setFaultstring(String faultstring) {
		this.faultstring = faultstring;
	}
	
}
