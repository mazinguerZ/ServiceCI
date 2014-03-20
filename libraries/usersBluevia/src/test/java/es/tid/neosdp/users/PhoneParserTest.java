/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.users;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit test for PhoneParser.
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public class PhoneParserTest {

    /**
     * Tests getCountryCode method.
     */
    @Test
    public void testGetCountryCode() {
        Assert.assertEquals(34, PhoneParser.getCountryCode("34983456789"));
        Assert.assertEquals(1, PhoneParser.getCountryCode("14983456789"));
        Assert.assertEquals(44, PhoneParser.getCountryCode("44983456789"));
        Assert.assertEquals(353, PhoneParser.getCountryCode("35383456789"));
        Assert.assertEquals(40, PhoneParser.getCountryCode("40383456789"));
        Assert.assertEquals(0, PhoneParser.getCountryCode("1"));
    }

    /**
     * More tests for getCountryCode method.
     */
    @Test
    public void testGetCountryCode2() {
        Assert.assertEquals(34, PhoneParser.getCountryCode("+34983456789"));
        Assert.assertEquals(1, PhoneParser.getCountryCode("+0014983456789"));
        Assert.assertEquals(44, PhoneParser.getCountryCode("+ 00 44 983 456789"));
        Assert.assertEquals(353, PhoneParser.getCountryCode("+0035383456789"));
    }
}