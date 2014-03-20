/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */

package es.tid.neosdp.charging;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Common util methods for charging (eBC) requests
 * 
 * @author Raul Pastor (rps@tid.es)
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public class ChargingUtils {

	public static final String ZULE_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	
    private static GregorianCalendar gCalendar = new GregorianCalendar(TimeZone.getTimeZone("Zulu"));
	
    /**
     * Gets an XMLGregorianCalendar to build a timestamp with the current time in Zulu timezone
     * 
     * @return
     * @throws DatatypeConfigurationException
     */
	public static XMLGregorianCalendar getXMLGregorianCalendar() throws DatatypeConfigurationException
	{
	    gCalendar.setTime(new Date()); // now
	    XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
	    return cal;
	}
	
	/**
	 * Gets a string containing current timestamp in Zulu timezone
	 * @return
	 * @throws DatatypeConfigurationException
	 */
	public static String getTimestamp() throws DatatypeConfigurationException
	{
		return getXMLGregorianCalendar().toString();
	}
	
	/**
	 * Gets a Date object from a string with a Zule date representation
	 * @param zuluDate
	 * @return
	 * @throws ParseException 
	 * @throws DatatypeConfigurationException 
	 */
	public static Calendar getCalendar(String zuluDate) throws DatatypeConfigurationException {
		
		XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		return cal.toGregorianCalendar();
//		DateFormat df = new SimpleDateFormat(ZULE_DATE_FORMAT);
//		// explicitly set timezone of input if needed
//		df.setTimeZone(TimeZone.getTimeZone("Zulu"));		
//		Calendar cal = Calendar.getInstance(); 	// creates calendar
//	    cal.setTime(df.parse(zuluDate)); 		// sets calendar time/date	    
//	    return cal;
	}
	
	/**
	 * Returns the string representation in Zulu format of a given date.
	 * @param date Date to get the Zulu string representation.
	 * @return
	 */
	public static String getZuluString(Date date) {
		DateFormat df = new SimpleDateFormat(ZULE_DATE_FORMAT);
		// explicitly set timezone of input if needed
		df.setTimeZone(TimeZone.getTimeZone("Zulu"));	
		// format...
		return df.format(date);
	}
	/**
	 * Check if the parameter is an empty string.
	 * @param sz String to check
	 * @return <code>NULL</code> if the string to check is null. 
	 * 		<code>TRUE</code> if the string is empty, <code>FALSE</code> otherwise.
	 */
	public static Boolean isEmpty(String sz) {
		if (sz == null) {
			return null;
		}
		
		if (sz.trim().length() == 0) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
}
