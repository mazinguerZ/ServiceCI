/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms.ob;

import es.tid.neosdp.sms.SMSSizeException;
import es.tid.neosdp.sms.utils.GSM7Charset;
import es.tid.neosdp.sms.utils.StringUtils;

/**
 * Calculate SMS Size for Colombia OB.<p />
 * obId: 732123<p/>
 * Encoding: GSM7 or UCS2 if special characters out of GSM7 are present<p/>
 * Rules to calculate the size:
 * <ul>
 * 	<li>If all characters of the message can be encoded as GSM7, every character must be counted as 1 
 * and the SMS maximum size is 160 chars</li>
 *  <li>If there is one or more than one character of the message that can not be encoded as GSM7, 
 *  every character must be counted as 1 and the SMS maximum size is 70 chars</li>
 * </ul>
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public class OB_Colombia extends OBSizeCalculator {

	/**
	 * Maximum number of chars for a GSM7 message.
	 */
	private int gsm7NumChars;
	/**
	 * Maximum number of chars for a UCS2 message.
	 */
	private int ucs2NumChars;
	/**
	 * Default constructor.
	 * @param maxChars Maximum 
	 */
	public OB_Colombia(int gsm7NumChars, int ucs2NumChars) {
		this.gsm7NumChars = gsm7NumChars;
		this.ucs2NumChars = ucs2NumChars; 
	}

	/* (non-Javadoc)
	 * @see es.tid.neosdp.sms.ob.OBSizeCalculator#calculateSize(java.lang.String)
	 */
	@Override
	public void calculateSize(String message) throws SMSSizeException {
		if (StringUtils.isEmptyOrNull(message)) {
			return;	// chars = 0, bytes = 0, oversized = false;
		}
		// Colombia: SMS-MT must be limited to 160 characters only if all chars are GSM7. 
		// Otherwise SMS-MT will be limited to 70 chars.
		int numchars = message.toCharArray().length;;
		// All chars are GSM7 ?
		boolean allGSM7 = true;
		for (char c : message.toCharArray()) {
			String hex = GSM7Charset.convert(c);			
			if (!GSM7Charset.isGSM7(hex)) {
				allGSM7 = false;
				break;
			}
		}
		
		if (allGSM7) {
			this.setMaxCharsPerMessage(gsm7NumChars);
		} else {
			this.setMaxCharsPerMessage(ucs2NumChars);
		}		
		this.setMessageCharacters(numchars);
		this.setOversized(numchars > getMaxCharsPerMessage());
	}
}
