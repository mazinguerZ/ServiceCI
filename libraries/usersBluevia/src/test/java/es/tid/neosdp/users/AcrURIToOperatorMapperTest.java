/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.users;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for AcrURIOperatorMapperTest.
 * 
 * @author
 * 
 */
public class AcrURIToOperatorMapperTest {

    /**
     * Tests a valid acr URI.
     */
    @Test
    public void testValidAcrURI() {
        try {
            String acrURI = "acr:12345678901234567890;ncc=33403";
            int operatorId = AcrURIToOperatorMapper.getOperatorId(acrURI);
            Assert.assertEquals(operatorId, 33403);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests a valid acr URI with several params.
     */
    @Test
    public void testValidAcrURIWithSeveralParams() {
        try {
            String acrURI = "acr:12345678901234567890;ncc=33403;type=DYNA;domain=example.com";
            int operatorId = AcrURIToOperatorMapper.getOperatorId(acrURI);
            Assert.assertEquals(operatorId, 33403);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests a valid acr URI with several params not ordered.
     */
    @Test
    public void testValidAcrURIWithSeveralNotOrderedParams() {
        try {
            String acrURI = "acr:12345678901234567890;type=DYNA;ncc=33403;domain=example.com";
            int operatorId = AcrURIToOperatorMapper.getOperatorId(acrURI);
            Assert.assertEquals(operatorId, 33403);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests a valid acr URI with several params not ordered(2).
     */
    @Test
    public void testValidAcrURIWithSeveralNotOrderedParams2() {
        try {
            String acrURI = "acr:12345678901234567890;type=DYNA;domain=example.com;ncc=33403";
            int operatorId = AcrURIToOperatorMapper.getOperatorId(acrURI);
            Assert.assertEquals(operatorId, 33403);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests a null ACR URI.
     */
    @Test
    public void testNullAcrURI() {
        try {
            String acrURI = null;
            AcrURIToOperatorMapper.getOperatorId(acrURI);
        } catch (IllegalArgumentException iae) {
            Assert.assertTrue(iae.getMessage().contains("Received ACR URI is null"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests and acr without ncc.
     */
    @Test
    public void testNoNcc() {
        try {
            String acrURI = "acr:12345678901234567890";
            AcrURIToOperatorMapper.getOperatorId(acrURI);
        } catch (IllegalArgumentException iae) {
            System.out.println("IAE:" + iae);
            Assert.assertTrue(iae.getMessage().contains("ncc attribute was not found"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests and acr with an empty ncc.
     */
    @Test
    public void testNccIsEmpty() {
        try {
            String acrURI = "acr:12345678901234567890;ncc=";
            AcrURIToOperatorMapper.getOperatorId(acrURI);
        } catch (IllegalArgumentException iae) {
            Assert.assertTrue(iae.getMessage().contains("ncc attribute value was not found"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests and acr with ncc and without = symbol.
     */
    @Test
    public void testNccIsEmptyWithoutEqualsSymbol() {
        try {
            String acrURI = "acr:12345678901234567890;ncc";
            AcrURIToOperatorMapper.getOperatorId(acrURI);
        } catch (IllegalArgumentException iae) {
            Assert.assertTrue(iae.getMessage().contains("ncc attribute value was not found"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

}
