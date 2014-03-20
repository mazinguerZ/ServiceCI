/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms;

/**
 * Customized exception for SMS Size calculation.
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public class SMSSizeException extends RuntimeException {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public SMSSizeException() {
		super();
	}

	/**
	 * Constructor with customized message.
	 * @param message Customized exception message.
	 */
	public SMSSizeException(String message) {
		super(message);
	}

	/**
	 * Constructor with cause of the exception.
	 * 
	 * @param cause Cause of the exception.
	 */
	public SMSSizeException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor with cause of the exception and customized message.
	 * 
	 * @param message Customized exception message.
	 * @param cause Cause of the exception.
	 */
	public SMSSizeException(String message, Throwable cause) {
		super(message, cause);
	}
}
