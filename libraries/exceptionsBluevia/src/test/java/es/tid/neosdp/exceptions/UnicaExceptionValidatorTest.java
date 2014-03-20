/*
 * neoSDP (API management layer for Telefonica enablers)
*/
package es.tid.neosdp.exceptions;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.tid.neosdp.plainmap.PlainMap;
import es.tid.neosdp.plainmap.PlainMapException;


/**
 * @author Ana Junquera (anajf)
 *
 */
public class UnicaExceptionValidatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	@Test
	public final void testValidatorJson() {
		PlainMap plainMap = new PlainMap();
		String exceptionId = "SVC3120";
		String exceptionText = "Both gUserId and userIdentifier cannot be empty if environment is not equal to 1";
		try {
	        plainMap.put("exceptionId", exceptionId);
	        plainMap.put("exceptionText", exceptionText);
        } catch (PlainMapException e) {
        	Assert.fail("Error extract unica exception codes: " +e.getMessage());
        }       
		int codeResponse = 400;
		UnicaException unicaException = UnicaExceptionValidator.getUnicaException(plainMap,
				codeResponse);
		Assert.assertEquals(unicaException.getResponseCode(), codeResponse);
		Assert.assertEquals(unicaException.getText(), exceptionText);
	}

}
