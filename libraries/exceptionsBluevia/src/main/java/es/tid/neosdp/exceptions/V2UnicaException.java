/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.exceptions;

/**
 * UnicaException for v2
 * 
 * @author Ana Junquera (anajf@tid.es)
 */
public class V2UnicaException extends UnicaException {

	/**
	 * More info parameter
	 */
	private String moreInfo;
	
	
	/**
	 * Constructor
	 * 
	 * @param unicaException
	 * @param moreInfo
	 */
	public V2UnicaException(final UnicaException unicaException, final String moreInfo) {
		super(unicaException.getCategoryId());
		this.setText(unicaException.getText());
		this.setParameters(unicaException.getParameters());
		this.setResponseCode(unicaException.getResponseCode());
		this.setMoreInfo(moreInfo);
	}

	/**
	 * Get the moreInfo parameter
	 * @return
	 */
	public String getMoreInfo() {
		return moreInfo;
	}

	/**
	 * Set the moreInfo parameter
	 * 
	 * @param moreInfo
	 */
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
}