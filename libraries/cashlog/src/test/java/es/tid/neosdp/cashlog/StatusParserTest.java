/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.cashlog;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for PEStatusParser
 *
 * @author juanc352 (jchernandez@full-on-net.com)
 */
public class StatusParserTest {

    /**
     * PE Invalid key -> default value
     */
    @Test
    public void testExecute_PE_invalidkey() {

        String key = "invalidKey";
        String defaultValue = "Denied";

        Assert.assertEquals(StatusParser.getPEStatus(key), defaultValue);

    }

    /**
     * PE valid key
     */
    @Test
    public void testExecute_PE_validkeys() {
        String key1 = "ERR_0997";
        String value1 = "Unauthorized";

        String key2 = "ERR_0150";
        String value2 = "Unauthorized";

        String key3 = "ERR_0400";
        String value3 = "Denied";

        Assert.assertEquals(StatusParser.getPEStatus(key1), value1);

        Assert.assertEquals(StatusParser.getPEStatus(key2), value2);

        Assert.assertEquals(StatusParser.getPEStatus(key3), value3);

    }

    /**
     * BV Invalid key -> default value
     */
    @Test
    public void testExecute_BV_invalidkey() {

        String key = "invalidKey";
        String defaultValue = "failed";

        Assert.assertEquals(StatusParser.getBVStatus(key), defaultValue);

    }

    /**
     * BV valid key
     */
    @Test
    public void testExecute_BV_validkeys() {
        String key1 = "ERR_0997";
        String value1 = "unAuthorized";

        String key2 = "ERR_0150";
        String value2 = "unAuthorized";

        String key3 = "ERR_0400";
        String value3 = "denied";

        Assert.assertEquals(StatusParser.getBVStatus(key1), value1);

        Assert.assertEquals(StatusParser.getBVStatus(key2), value2);

        Assert.assertEquals(StatusParser.getBVStatus(key3), value3);

    }

    /**
     * Subscription Invalid key -> default value
     */
    @Test
    public void testExecute_Subscription_invalidkey() {

        String key = "invalidKey";
        String defaultValue = "denied";

        Assert.assertEquals(StatusParser.getSubscriptionStatus(key), defaultValue);

    }

    /**
     * Subscription valid key
     */
    @Test
    public void testExecute_Subscription_validkeys() {
        String key1 = "ERR_0110";
        String value1 = "denied";

        String key2 = "ERR_0127";
        String value2 = "denied";

        String key3 = "ERR_0203";
        String value3 = "denied";

        Assert.assertEquals(StatusParser.getSubscriptionStatus(key1), value1);

        Assert.assertEquals(StatusParser.getSubscriptionStatus(key2), value2);

        Assert.assertEquals(StatusParser.getSubscriptionStatus(key3), value3);

    }

}
