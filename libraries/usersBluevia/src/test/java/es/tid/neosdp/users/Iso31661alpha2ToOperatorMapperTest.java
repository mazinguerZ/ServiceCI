/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.users;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit tests for Iso31661alpha2ToOperatorMapper.
 * 
 * @author rps@tid.es
 */
public class Iso31661alpha2ToOperatorMapperTest {

    /**
     * Tests for getOperatorId method.
     */
    @Test
    public void testGetOperatorId() {

        Assert.assertEquals(21407, Iso31661alpha2ToOperatorMapper.getOperatorId("ES"));

        // Any other operator launches an IllegalArgumentException
        try {
            Iso31661alpha2ToOperatorMapper.getOperatorId("DE");
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        try {
            Iso31661alpha2ToOperatorMapper.getOperatorId("BR");
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        try {
            Iso31661alpha2ToOperatorMapper.getOperatorId("XX");
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        try {
            Iso31661alpha2ToOperatorMapper.getOperatorId("XXXXX");
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

    }
}