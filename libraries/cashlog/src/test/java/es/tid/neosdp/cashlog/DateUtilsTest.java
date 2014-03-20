/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.cashlog;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for DateUtils
 *
 * @author juanc352 (jchernandez@full-on-net.com)
 */
public class DateUtilsTest {

    /**
     * PE Invalid key
     */
    @Test
    public void testExecute_invaliDate() {

        String invalidDate = "dfsdfsfsdfsfd";

        Calendar result = DateUtils.getCalendar(invalidDate);

        Assert.assertNull(result);

    }

    /**
     * valid date
     */
    @Test
    public void testExecute_valiDate() {

        String validDate = "2013-08-07 10:32:34.256";

        Calendar result = DateUtils.getCalendar(validDate);

        Assert.assertEquals(result.get(Calendar.YEAR),2013);

        Assert.assertEquals(result.get(Calendar.MINUTE),32);

        Assert.assertEquals(result.get(Calendar.MILLISECOND),256);


    }


    /**
     * valid date, only 2 digits in milisecond field
     */
    @Test
    public void testExecute_valiDateMilisecond() {

        String invaliDate = "2013-08-07 10:32:34.42";

        Calendar result = DateUtils.getCalendar(invaliDate);

        Assert.assertEquals(result.get(Calendar.YEAR),2013);

        Assert.assertEquals(result.get(Calendar.MINUTE),32);

        Assert.assertEquals(result.get(Calendar.MILLISECOND),42);


    }


}
