/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */

package es.tid.neosdp.cashlog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Util methods for cashlog dates
 *
 * @author juanc352 (jchernandez@full-on-net.com)
 */
public class DateUtils {

    // <timeStamp>2013-08-07 10:32:34.256</timeStamp>
    public static final String CASHLOG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * Gets a Calendar object from a string with a GMT date representation
     *
     * @param GMTDate
     * @return a calendar with the time of the GTMDate or null in error case
     */
    public static Calendar getCalendar(String GMTDate) {

        Calendar date = new GregorianCalendar();

        try{
            date.setTime(new SimpleDateFormat(CASHLOG_DATE_FORMAT).parse(GMTDate));
            date.setTimeZone(TimeZone.getTimeZone("GMT"));
        } catch (ParseException e) {
            return null;
        }

        return date;

    }

}
