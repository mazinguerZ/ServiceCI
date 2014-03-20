/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 * Defined obId:
 * <ul>
 * 	<li>"722070" for Argentina</li>
 * 	<li>"33403" for Mexico</li>
 * 	<li>"23411" for United Kingdom</li>
 * 	<li>"21407" for Spain</li>
 * 	<li>"26207" for Germany</li>
 * 	<li>"732123" for Colombia</li>
 * 	<li>"73007" for Chile</li>
 * 	<li>"72410" for Brazil</li>
 * </ul>
 */
public class SMSSizeTest {

	@Test
	/**
	 * Test OB Mexico. (GSM7)
	 * Small message (< 160). Not oversized
	 */
	public void test_OB_Mexico1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("33403", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB Mexico. (GSM7)
	 * Big message ( > 160). Oversized
	 */
	public void test_OB_Mexico2() {
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("33403", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);
		assertTrue(numCharacters == 170);
	}
	
	@Test
	/**
	 * Test OB UK. (GSM7)
	 * Small message ( < 160). Not Oversized
	 */
	public void test_OB_UK1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("23411", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB UK. (GSM7)
	 * Big message ( > 160). Oversized
	 */
	public void test_OB_UK2() {
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("23411", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);
		assertTrue(numCharacters == 170);
	}
	
	@Test
	/**
	 * Test OB Chile. (ISO 8859-1)
	 * Small message ( < 140). Not Oversized
	 */
	public void test_OB_Chile1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("73007", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB Chile. (ISO 8859-1)
	 * Big message ( > 140). Oversized
	 */
	public void test_OB_Chile2() {
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("73007", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);
		assertTrue(numCharacters == 170);
	}
	
	@Test	
	/**
	 * Test OB Brazil. (ISO 8859-1)
	 * Small message ( < 140). Not Oversized
	 */
	public void test_OB_Brazil1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("72410", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB Brazil. (ISO 8859-1)
	 * Big message ( > 140). Oversized
	 */
	public void test_OB_Brazil2() {
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("72410", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);
		assertTrue(numCharacters == 170);
	}
	
	@Test
	/**
	 * Test OB Spain. (GSM7 con extensiones)
	 * Small message ( < 160). Not Oversized
	 */
	public void test_OB_Spain1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("21407", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB Spain. (GSM7 con extensiones)
	 * Small message ( < 160). Not Oversized. Special characters
	 */
	public void test_OB_Spain2() {
		// Special chars counted x2
		// 1234567890 -> 10
		// {}[]€^~ -> 7 x 2 = 14
		String message = "1234567890" + "{}[]€^~";
		
		SMSSize smsSize = new SMSSize("21407", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);		
		assertTrue(numCharacters == 24);
	}
	
	@Test
	/**
	 * Test OB Spain. (GSM7 with extensions)
	 * Big message ( > 160). Oversized.
	 */
	public void test_OB_Spain3() {
		// Special chars counted x2
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890";	// 170 chars
		
		SMSSize smsSize = new SMSSize("21407", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);		
		assertTrue(numCharacters == 170);
	}
	
	@Test	
	/**
	 * Test OB Germany. (GSM7 adapted for Germany)
	 * Small message ( < 160). Not Oversized.
	 */
	public void test_OB_Germany1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("26207", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB Germany. (GSM7 adapted for Germany)
	 * Small message ( < 160). not Oversized.
	 */
	public void test_OB_Germany2() {
		// Special chars counted x2
		// 1234567890 -> 10
		// {}[]^~ -> 6 x 1 = 6
		// € -> 2
		String message = "1234567890" + "{}[]€^~";
		
		SMSSize smsSize = new SMSSize("26207", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);		
		assertTrue(numCharacters == 18);
	}
	
	@Test
	/**
	 * Test OB Germany. (GSM7 adapted for Germany)
	 * Big message ( > 160). Oversized.
	 */
	public void test_OB_Germany3() {
		// Special chars counted x2
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + 
				"1234567890" + "1234567890";	// 170 chars
		
		SMSSize smsSize = new SMSSize("26207", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);		
		assertTrue(numCharacters == 170);
	}
	
	@Test	
	/**
	 * Test OB Colombia. (GSM7 o USC2)
	 * Small message ( < 160). Not Oversized. No special characters
	 */
	public void test_OB_Colombia1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("732123", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB Colombia. (GSM7 o USC2)
	 * Big message ( > 70). Oversized. Special characters.
	 */
	public void test_OB_Colombia2() {
		// Special chars counted: change to UCS2 Charset (limit 70 chars)
		// Message 71 chars 
		String message = "¨" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("732123", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);		
		assertTrue(numCharacters == 71);
	}
	
	@Test
	/**
	 * Test OB Colombia. (GSM7 o USC2)
	 * Small message ( < 160). Not Oversized. No special characters
	 */
	public void test_OB_Colombia3() {
		// No special character: GSM7 Charset (limit 160)
		// Message: 50 chars
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("732123", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);		
		assertTrue(numCharacters == 50);
	}
	
	@Test
	/**
	 * Test OB Colombia. (GSM7 o USC2)
	 * Big message ( > 160). Not Oversized. No special characters
	 */
	public void test_OB_Colombia4() {
		// No special character: GSM7 Charset (limit 160)
		// Message: 170 chars
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" 
						+"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
						+"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
						+"1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("732123", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);		
		assertTrue(numCharacters == 170);
	}
	
	@Test
	/**
	 * Test OB Colombia. (GSM7 o USC2)
	 * Small message ( < 70). Not Oversized. Special characters
	 */
	public void test_OB_Colombia5() {
		// Special chars counted: change to UCS2 Charset (limit 70 chars)
		// Message: 71 chars
		String message = "¨" + "1234567890" + "1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("732123", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);		
		assertTrue(numCharacters == 31);
	}
	
	@Test	
	/**
	 * Test OB Argentina. (GSM7 o USC2)
	 * Small message ( < 160). Not Oversized. No special characters
	 */
	public void test_OB_Argentina1() {
		String message = "Hello World!";
		
		SMSSize smsSize = new SMSSize("722070", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);
		assertTrue(numCharacters == 12);
	}

	@Test
	/**
	 * Test OB Argentina. (GSM7 o USC2)
	 * Big message ( > 70). Oversized. Special characters
	 */
	public void test_OB_Argentina2() {
		// Special chars counted: change to UCS2 Charset (limit 70 chars)
		// Message: 71 chars
		String message = "¨" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("722070", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);		
		assertTrue(numCharacters == 71);
	}
	
	@Test
	/**
	 * Test OB Argentina. (GSM7 o USC2)
	 * Small message ( < 160). Not Oversized. No special characters
	 */
	public void test_OB_Argentina3() {
		// No special character: GSM7 Charset (limit 160)
		// Message: 50 chars
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("722070", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);		
		assertTrue(numCharacters == 50);
	}
	
	@Test
	/**
	 * Test OB Argentina. (GSM7 o USC2)
	 * Big message ( > 160). Oversized. No special characters
	 */
	public void test_OB_Argentina4() {
		// No special character: GSM7 Charset (limit 160)
		// Message: 170 chars
		String message = "1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890" 
						+"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
						+"1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
						+"1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("722070", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == true);		
		assertTrue(numCharacters == 170);
	}
	
	@Test
	/**
	 * Test OB Argentina. (GSM7 o USC2)
	 * Small message ( < 70). Not Oversized. Special characters
	 */
	public void test_OB_Argentina5() {
		// Caracter especial (dieresis): se cambia a UCS2 con limite 70
		// Message con 71 caracteres
		String message = "¨" + "1234567890" + "1234567890" + "1234567890";
		
		SMSSize smsSize = new SMSSize("722070", message);
		boolean isOversized = smsSize.isOversize();
		int numCharacters = smsSize.getMessageCharacters();
		
		assertTrue(isOversized == false);		
		assertTrue(numCharacters == 31);
	}
}
