/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms.ob;

import es.tid.neosdp.sms.SMSSizeException;

/**
 * Abstract class to be implemented by each OB size calculator.
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 */
public abstract class OBSizeCalculator {

	/**
	 * Maximum number of characters per message.
	 */
	private int maxCharsPerMessage;
	/**
	 * SMS message is larger than maximum size for 1 single message ? 
	 */
	private boolean oversized;
	/**
	 * Number of the characters of the SMS.
	 */
	private int messageCharacters;
	/**
	 * Number of bytes of the SMS.
	 */
	private int messageBytes;
	/**
	 * Default constructor.
	 */
	public OBSizeCalculator() {
		super();
		// Defaults
		this.setMessageBytes(0);
		this.setMessageCharacters(0);
		this.setOversized(false);
	}
	
	/**
	 * @return the maxCharsPerMessage
	 */
	public final int getMaxCharsPerMessage() {
		return maxCharsPerMessage;
	}
	/**
	 * @param maxCharsPerMessage the maxCharsPerMessage to set
	 */
	public final void setMaxCharsPerMessage(int maxCharsPerMessage) {
		this.maxCharsPerMessage = maxCharsPerMessage;
	}

	/**
	 * @param oversized the oversized to set
	 */
	public final void setOversized(boolean oversized) {
		this.oversized = oversized;
	}
	/**
	 * @return the oversize
	 */
	public boolean isOversized() {
		return oversized;
	}
	/**
	 * @param messageCharacters the messageCharacters to set
	 */
	public final void setMessageCharacters(int messageCharacters) {
		this.messageCharacters = messageCharacters;
	}
	/**
	 * @return the messageCharacters
	 */
	public int getMessageCharacters() {
		return messageCharacters;
	}
	/**
	 * @param messageBytes the messageBytes to set
	 */
	public final void setMessageBytes(int messageBytes) {
		this.messageBytes = messageBytes;
	}
	/**
	 * @return the messageBytes
	 */
	public int getMessageBytes() {
		return messageBytes;
	}

	/**
	 * Calculate the SMS Size.
	 * @param message Message to calculate the size.
	 * @throws SMSSizeException if something goes wrong...
	 */
	public abstract void calculateSize(String message) throws SMSSizeException;	
}