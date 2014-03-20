/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.users;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit tests for OperatorPhoneMapper.
 * 
 * @author Jesus Diaz Artiaga (jda@creativit.com)
 */
public class OperatorPhoneMapperTest {

    /**
     * Tests for getOperatorId method.
     */
    @Test
    public void testGetOperatorId() {

        Assert.assertEquals(33403, OperatorPhoneMapper.getOperatorId("525532904077"));
        Assert.assertEquals(23411, OperatorPhoneMapper.getOperatorId("447725180585"));
        Assert.assertEquals(26207, OperatorPhoneMapper.getOperatorId("4917670103706"));
        Assert.assertEquals(722070, OperatorPhoneMapper.getOperatorId("541156978819"));
        Assert.assertEquals(21407, OperatorPhoneMapper.getOperatorId("34618110489"));
    }

    /**
     * More tests for getOperatorId method.
     */
    @Test
    public void testGetOperatorId2() {

        Assert.assertEquals(33403, OperatorPhoneMapper.getOperatorId("+525532904077"));
        Assert.assertEquals(23411, OperatorPhoneMapper.getOperatorId("+447725180585"));
        Assert.assertEquals(26207, OperatorPhoneMapper.getOperatorId("00 4917670103706"));
        Assert.assertEquals(722070, OperatorPhoneMapper.getOperatorId("+00541156978819"));
        Assert.assertEquals(21407, OperatorPhoneMapper.getOperatorId("00 34 618 11 04 89"));
    }

}