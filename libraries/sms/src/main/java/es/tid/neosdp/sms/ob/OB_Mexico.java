/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms.ob;

import es.tid.neosdp.sms.SMSSizeException;
import es.tid.neosdp.sms.utils.StringUtils;

/**
 * Calculate SMS Size for Mexico OB.<p />
 * obId: 33403<p/>
 * Encoding: GSM7<p/>
 * Rules to calculate the size:
 * <ul>
 * 	<li>All characters must be counted as 1 and the SMS maximum size is 160 chars</li>
 * </ul>
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public class OB_Mexico extends OBSizeCalculator {

	/**
	 * Default constructor.
	 * @param maxChars Maximum 
	 */
	public OB_Mexico(int maxChars) {
		this.setMaxCharsPerMessage(maxChars); 
	}

	/* (non-Javadoc)
	 * @see es.tid.neosdp.sms.ob.OBSizeCalculator#calculateSize(java.lang.String)
	 */
	@Override
	public void calculateSize(String message) throws SMSSizeException {
		if (StringUtils.isEmptyOrNull(message)) {			
			return;	// chars = 0, bytes = 0, oversized = false;
		}
		// Mexico: SMS-MT must be limited to 160 characters.
		int numchars = message.toCharArray().length;
		
		this.setMessageCharacters(numchars);
		this.setOversized(numchars > getMaxCharsPerMessage());
	}
}
