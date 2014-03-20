/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms;

import es.tid.neosdp.sms.ob.OB;
import es.tid.neosdp.sms.ob.OBSizeCalculator;

/**
 * Class for calculating the size of an SMS according to the OB.
 * <p />
 * Steps:
 * <ol>
 * 	<li>Create the SMSSize object usign obId and message as parameters</li>
 * 	<li>Call "calculate" method</li>
 * 	<li>Get the value of "isOversized" method to check if the message needs 
 * only 1 SMS (false value) or more than one (true)</li>
 * 	<li>Get the value of "getMessageCharacters" method to get the real number of 
 * characters that the OB will send. This number is calculated in the OB that 
 * will send the SMS using some business rules.</li>  
 * </ol>
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 */
public class SMSSize {

	/**
	 * OB identifier.
	 */
	private String obId;
	/**
	 * SMS Message.
	 */
	private String message;
	/**
	 * SMS message is larger than maximum size for 1 single message ? 
	 */
	private boolean oversize;
	/**
	 * Number of the characters of the SMS.
	 */
	private int messageCharacters;
	/**
	 * Constructor.
	 * @param obId Id of the OB.
	 * @param message SMS Message.
	 */
	public SMSSize(String obId, String message) throws SMSSizeException {
		this.obId = obId;
		this.message = message;
		
		// Calculate size...
		this.calculate();
	}
	/**
	 * @return the obId
	 */
	public String getObId() {
		return obId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the oversize
	 */
	public boolean isOversize() {
		return oversize;
	}
	/**
	 * @return the messageCharacters
	 */
	public int getMessageCharacters() {
		return messageCharacters;
	}
	/**
	 * Calculate the SMS Size...
	 */
	private void calculate() throws SMSSizeException {
		OB ob = OB.fromObId(obId);		
		OBSizeCalculator obSizeCalculator = ob.getObSizeCalculator();
		// Calculate
		obSizeCalculator.calculateSize(message);
		// Results
		oversize = obSizeCalculator.isOversized();
		messageCharacters = obSizeCalculator.getMessageCharacters();
	}		
}
