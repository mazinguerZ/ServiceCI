/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms.ob;

import java.util.HashMap;
import java.util.Map;

import es.tid.neosdp.sms.SMSSizeException;
import es.tid.neosdp.sms.utils.GSM7Charset;
import es.tid.neosdp.sms.utils.StringUtils;

/**
 * Calculate SMS Size for Spain OB.<p />
 * obId: 21407<p/>
 * Encoding: GSM7 with extensions<p/>
 * Rules to calculate the size:
 * <ul>
 * 	<li>If all characters of the message can be encoded as GSM7, every character must be counted as 1 
 * and the SMS maximum size is 160 chars</li>
 *  <li>If the character belongs to the extension group ({, }, [, ], ^, €, ~), it must be counted as 2. 
 *  The maximum size of the SMS is 160 chars</li>
 * </ul>
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public class OB_Spain extends OBSizeCalculator {

	/**
	 * Spanish extension
	 */
	private static Map<String, String> gsm7extension;
	// Build GSM7 extension
	static {		
		// Key: Unicode Hex values
		// Value: GSM Hex values
		gsm7extension = new HashMap<String, String>();
		// Build Charset
		gsm7extension.put("0x005E", "0x1B14");   // CIRCUMFLEX ACCENT ^
		gsm7extension.put("0x007B", "0x1B28");   // LEFT CURLY BRACKET {
		gsm7extension.put("0x007D", "0x1B29");   // RIGHT CURLY BRACKET }
		gsm7extension.put("0x005B", "0x1B3C");   // LEFT SQUARE BRACKET [
		gsm7extension.put("0x007E", "0x1B3D");   // TILDE ~
		gsm7extension.put("0x005D", "0x1B3E");   // RIGHT SQUARE BRACKET ]
		gsm7extension.put("0x007C", "0x1B40");   // VERTICAL BAR | 
		gsm7extension.put("0x20AC", "0x1B65");   // EURO SIGN €
	}
	
	/**
	 * Default constructor.
	 * @param maxChars Maximum 
	 */
	public OB_Spain(int maxChars) {
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
		// Spain: SMS-MT must be limited to 160 characters. Each character counts x1, 
		// except for the following characters which will count as x2 each one:     
		// {, }, [, ], ^, € , ~, |
		int numchars = 0;
		
		for (char c : message.toCharArray()) {
			String hex = GSM7Charset.convert(c);			
			if (gsm7extension.containsKey(hex)) {
				numchars += 2;
			} else {
				numchars += 1;
			}
		}
		
		this.setMessageCharacters(numchars);
		this.setOversized(numchars > getMaxCharsPerMessage());
	}
}
