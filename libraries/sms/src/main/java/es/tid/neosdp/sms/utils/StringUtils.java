/**
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.sms.utils;

/**
 * Some utilities to work with Strings...
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 */
public class StringUtils {
	
	// Utility class does not need a public constructor
	private StringUtils() {
		// ...
	}
	
	/**
	 * Test if a given String is not empty or null 
	 * @param sz String to test
	 * @return <code>TRUE</code> if the String is not empty or null, <code>FALSE</code> otherwise.
	 */
	public static Boolean isNotEmptyOrNull(String sz) {
		return !isEmptyOrNull(sz);
	}
	
	/**
	 * Test if a given String is empty or null 
	 * @param sz String to test
	 * @return <code>TRUE</code> if the String is empty or null, <code>FALSE</code> otherwise.
	 */
	public static Boolean isEmptyOrNull(String sz) {
		if (sz == null || sz.trim().length() == 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
