/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition of the GSM7 Charset.<p />
 * This utility test if a character is GSM7 and converts a char to Unicode hex representation.  
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public class GSM7Charset {
	
	private static Map<String, String> gsm7;
	
	static {
		// From:
		// http://www.cardboardfish.com/support/bin/view/Main/GSMEncoding
		// Key: Unicode Hex values
		// Value: GSM Hex values
		gsm7 = new HashMap<String, String>();
		// Build Charset
		gsm7.put("0x0040", "0x00");     // COMMERCIAL AT
		gsm7.put("0x00A3", "0x01");     // POUND SIGN
		gsm7.put("0x0024", "0x02");     // DOLLAR SIGN
		gsm7.put("0x00A5", "0x03");     // YEN SIGN
        gsm7.put("0x00E8", "0x04");     // LATIN SMALL LETTER E WITH GRAVE
        gsm7.put("0x00E9", "0x05");     // LATIN SMALL LETTER E WITH ACUTE
        gsm7.put("0x00F9", "0x06");     // LATIN SMALL LETTER U WITH GRAVE
        gsm7.put("0x00EC", "0x07");     // LATIN SMALL LETTER I WITH GRAVE
        gsm7.put("0x00F2", "0x08");     // LATIN SMALL LETTER O WITH GRAVE
        gsm7.put("0x00E7", "0x09");     // LATIN SMALL LETTER C WITH CEDILLA (case changed)
        gsm7.put("0x000A", "0x0A"); 	// Line Feed
        gsm7.put("0x00D8", "0x0B");     // LATIN CAPITAL LETTER O WITH STROKE
        gsm7.put("0x00F8", "0x0C");     // LATIN SMALL LETTER O WITH STROKE
        gsm7.put("0x000D", "0x0D");     // Carriage Return
        gsm7.put("0x00C5", "0x0E");     // LATIN CAPITAL LETTER A WITH RING ABOVE
        gsm7.put("0x00E5", "0x0F");     // LATIN SMALL LETTER A WITH RING ABOVE
        gsm7.put("0x0394", "0x10");     // GREEK CAPITAL LETTER DELTA
        gsm7.put("0x005F", "0x11");     // LOW LINE
        gsm7.put("0x03A6", "0x12");     // GREEK CAPITAL LETTER PHI
        gsm7.put("0x0393", "0x13");     // GREEK CAPITAL LETTER GAMMA
        gsm7.put("0x039B", "0x14");     // GREEK CAPITAL LETTER LAMBDA
        gsm7.put("0x03A9", "0x15");     // GREEK CAPITAL LETTER OMEGA
        gsm7.put("0x03A0", "0x16");     // GREEK CAPITAL LETTER PI
        gsm7.put("0x03A8", "0x17");     // GREEK CAPITAL LETTER PSI
        gsm7.put("0x03A3", "0x18");     // GREEK CAPITAL LETTER SIGMA
        gsm7.put("0x0398", "0x19");     // GREEK CAPITAL LETTER THETA
        gsm7.put("0x039E", "0x1A");     // GREEK CAPITAL LETTER XI
//        gsm7.put("", "0x1B"); 		// ESCAPE TO EXTENSION TABLE
        gsm7.put("0x0012", "0x1B0A");   // FORM FEED
        gsm7.put("0x005E", "0x1B14");   // CIRCUMFLEX ACCENT
        gsm7.put("0x007B", "0x1B28");   // LEFT CURLY BRACKET
        gsm7.put("0x007D", "0x1B29");   // RIGHT CURLY BRACKET
        gsm7.put("0x005C", "0x1B2F");   // REVERSE SOLIDUS (BACKSLASH)
        gsm7.put("0x005B", "0x1B3C");   // LEFT SQUARE BRACKET
        gsm7.put("0x007E", "0x1B3D");   // TILDE
        gsm7.put("0x005D", "0x1B3E");   // RIGHT SQUARE BRACKET
        gsm7.put("0x007C", "0x1B40");   // VERTICAL BAR
        gsm7.put("0x00C6", "0x1C");     // LATIN CAPITAL LETTER AE
        gsm7.put("0x00E6", "0x1D");     // LATIN SMALL LETTER AE
        gsm7.put("0x00DF", "0x1E");     // LATIN SMALL LETTER SHARP S (German)
        gsm7.put("0x00C9", "0x1F");     // LATIN CAPITAL LETTER E WITH ACUTE
        gsm7.put("0x0020", "0x20");     // SPACE
        gsm7.put("0x0021", "0x21");     // EXCLAMATION MARK
        gsm7.put("0x0022", "0x22");     // QUOTATION MARK
        gsm7.put("0x0023", "0x23");     // NUMBER SIGN
        gsm7.put("0x00A4", "0x24");     // EURO SIGN
        gsm7.put("0x0025", "0x25");     // PERCENT SIGN
        gsm7.put("0x0026", "0x26");     // AMPERSAND
        gsm7.put("0x0027", "0x27");     // APOSTROPHE
        gsm7.put("0x0028", "0x28");     // LEFT PARENTHESIS
        gsm7.put("0x0029", "0x29");     // RIGHT PARENTHESIS
        gsm7.put("0x002A", "0x2A");     // ASTERISK
        gsm7.put("0x002B", "0x2B");     // PLUS SIGN
        gsm7.put("0x002C", "0x2C");     // COMMA
        gsm7.put("0x002D", "0x2D");     // HYPHEN-MINUS
        gsm7.put("0x002E", "0x2E");     // FULL STOP
        gsm7.put("0x002F", "0x2F");     // SOLIDUS (SLASH)
        gsm7.put("0x0030", "0x30");     // DIGIT ZERO
        gsm7.put("0x0031", "0x31");     // DIGIT ONE
        gsm7.put("0x0032", "0x32");     // DIGIT TWO
        gsm7.put("0x0033", "0x33");     // DIGIT THREE
        gsm7.put("0x0034", "0x34");     // DIGIT FOUR
        gsm7.put("0x0035", "0x35");     // DIGIT FIVE
        gsm7.put("0x0036", "0x36");     // DIGIT SIX
        gsm7.put("0x0037", "0x37");     // DIGIT SEVEN
        gsm7.put("0x0038", "0x38");     // DIGIT EIGHT
        gsm7.put("0x0039", "0x39");     // DIGIT NINE
        gsm7.put("0x003A", "0x3A");     // COLON
        gsm7.put("0x003B", "0x3B");     // SEMICOLON
        gsm7.put("0x003C", "0x3C");     // LESS-THAN SIGN
        gsm7.put("0x003D", "0x3D");     // EQUALS SIGN
        gsm7.put("0x003E", "0x3E");     // GREATER-THAN SIGN
        gsm7.put("0x003F", "0x3F");     // QUESTION MARK
        gsm7.put("0x00A1", "0x40");     // INVERTED EXCLAMATION MARK
        gsm7.put("0x0041", "0x41");     // LATIN CAPITAL LETTER A
        gsm7.put("0x0042", "0x42");     // LATIN CAPITAL LETTER B
        gsm7.put("0x0043", "0x43");     // LATIN CAPITAL LETTER C
        gsm7.put("0x0044", "0x44");     // LATIN CAPITAL LETTER D
        gsm7.put("0x0045", "0x45");     // LATIN CAPITAL LETTER E
        gsm7.put("0x0046", "0x46");     // LATIN CAPITAL LETTER F
        gsm7.put("0x0047", "0x47");     // LATIN CAPITAL LETTER G
        gsm7.put("0x0048", "0x48");     // LATIN CAPITAL LETTER H
        gsm7.put("0x0049", "0x49");     // LATIN CAPITAL LETTER I
        gsm7.put("0x004A", "0x4A");     // LATIN CAPITAL LETTER J
        gsm7.put("0x004B", "0x4B");     // LATIN CAPITAL LETTER K
        gsm7.put("0x004C", "0x4C");     // LATIN CAPITAL LETTER L
        gsm7.put("0x004D", "0x4D");     // LATIN CAPITAL LETTER M
        gsm7.put("0x004E", "0x4E");     // LATIN CAPITAL LETTER N
        gsm7.put("0x004F", "0x4F");     // LATIN CAPITAL LETTER O
        gsm7.put("0x0050", "0x50");     // LATIN CAPITAL LETTER P
        gsm7.put("0x0051", "0x51");     // LATIN CAPITAL LETTER Q
        gsm7.put("0x0052", "0x52");     // LATIN CAPITAL LETTER R
        gsm7.put("0x0053", "0x53");     // LATIN CAPITAL LETTER S
        gsm7.put("0x0054", "0x54");     // LATIN CAPITAL LETTER T
        gsm7.put("0x0055", "0x55");     // LATIN CAPITAL LETTER U
        gsm7.put("0x0056", "0x56");     // LATIN CAPITAL LETTER V
        gsm7.put("0x0057", "0x57");     // LATIN CAPITAL LETTER W
        gsm7.put("0x0058", "0x58");     // LATIN CAPITAL LETTER X
        gsm7.put("0x0059", "0x59");     // LATIN CAPITAL LETTER Y
        gsm7.put("0x005A", "0x5A");     // LATIN CAPITAL LETTER Z
        gsm7.put("0x00C4", "0x5B");     // LATIN CAPITAL LETTER A WITH DIAERESIS
        gsm7.put("0x00D6", "0x5C");     // LATIN CAPITAL LETTER O WITH DIAERESIS
        gsm7.put("0x00D1", "0x5D");     // LATIN CAPITAL LETTER N WITH TILDE
        gsm7.put("0x00DC", "0x5E");     // LATIN CAPITAL LETTER U WITH DIAERESIS
        gsm7.put("0x00A7", "0x5F");     // SECTION SIGN
        gsm7.put("0x00BF", "0x60");     // INVERTED QUESTION MARK
        gsm7.put("0x0061", "0x61");     // LATIN SMALL LETTER A
        gsm7.put("0x0062", "0x62");     // LATIN SMALL LETTER B
        gsm7.put("0x0063", "0x63");     // LATIN SMALL LETTER C
        gsm7.put("0x0064", "0x64");     // LATIN SMALL LETTER D
        gsm7.put("0x0065", "0x65");     // LATIN SMALL LETTER E
        gsm7.put("0x0066", "0x66");     // LATIN SMALL LETTER F
        gsm7.put("0x0067", "0x67");     // LATIN SMALL LETTER G
        gsm7.put("0x0068", "0x68");     // LATIN SMALL LETTER H
        gsm7.put("0x0069", "0x69");     // LATIN SMALL LETTER I
        gsm7.put("0x006A", "0x6A");     // LATIN SMALL LETTER J
        gsm7.put("0x006B", "0x6B");     // LATIN SMALL LETTER K
        gsm7.put("0x006C", "0x6C");     // LATIN SMALL LETTER L
        gsm7.put("0x006D", "0x6D");     // LATIN SMALL LETTER M
        gsm7.put("0x006E", "0x6E");     // LATIN SMALL LETTER N
        gsm7.put("0x006F", "0x6F");     // LATIN SMALL LETTER O
        gsm7.put("0x0070", "0x70");     // LATIN SMALL LETTER P
        gsm7.put("0x0071", "0x71");     // LATIN SMALL LETTER Q
        gsm7.put("0x0072", "0x72");     // LATIN SMALL LETTER R
        gsm7.put("0x0073", "0x73");     // LATIN SMALL LETTER S
        gsm7.put("0x0074", "0x74");     // LATIN SMALL LETTER T
        gsm7.put("0x0075", "0x75");     // LATIN SMALL LETTER U
        gsm7.put("0x0076", "0x76");     // LATIN SMALL LETTER V
        gsm7.put("0x0077", "0x77");     // LATIN SMALL LETTER W
        gsm7.put("0x0078", "0x78");     // LATIN SMALL LETTER X
        gsm7.put("0x0079", "0x79");     // LATIN SMALL LETTER Y
        gsm7.put("0x007A", "0x7A");     // LATIN SMALL LETTER Z
        gsm7.put("0x00E4", "0x7B");     // LATIN SMALL LETTER A WITH DIAERESIS
        gsm7.put("0x00F6", "0x7C");     // LATIN SMALL LETTER O WITH DIAERESIS
        gsm7.put("0x00F1", "0x7D");     // LATIN SMALL LETTER N WITH TILDE
        gsm7.put("0x00FC", "0x7E");     // LATIN SMALL LETTER U WITH DIAERESIS
        gsm7.put("0x00E0", "0x7F");     // LATIN SMALL LETTER A WITH GRAVE
        gsm7.put("0x20AC", "0x1B65");   // EURO SIGN
	}

	/**
	 * Check if a character is included in the GSM7 map
	 * @param car
	 * @return
	 */
	public static boolean isGSM7(String character) {
		return gsm7.containsKey(character);		
	}
	
	/**
	 * Convert a single character to unicode hex representation
	 * @param str
	 * @return
	 */
	public static String convert(char c) {
		StringBuffer ostr = new StringBuffer();
		// Initial characters for hex representation
       	ostr.append("0x") ;								// hex standard unicode format.
		String hex = Integer.toHexString(c & 0xFFFF);	// Get hex value of the char. 
		for(int j=0; j < (4 - hex.length()); j++) {	// Add zeros: unicode requires 4 digits
			ostr.append("0");
		}
		// To uppercase
		ostr.append(hex.toUpperCase());		// standard unicode format.
		
		return (new String(ostr));		//Return the stringbuffer cast as a string.
	}
}
