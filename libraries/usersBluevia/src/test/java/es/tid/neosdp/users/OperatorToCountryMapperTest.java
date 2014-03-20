/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.users;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for OperatorToCountryMapper.
 * 
 * @author
 * 
 */
public class OperatorToCountryMapperTest {

    /**
     * Tests a valid operatorId.
     */
    @Test
    public void testValidOperatorId() {
        try {
            String operatorId = "722070";
            int countryCode = OperatorToCountryMapper.getCountryCode(Integer.parseInt(operatorId));
            Assert.assertEquals(countryCode, 54);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests a too short operatorId.
     */
    @Test
    public void testOperatorIdTooShort() {
        try {
            String operatorId = "72";
            OperatorToCountryMapper.getCountryCode(Integer.parseInt(operatorId));
        } catch (IllegalArgumentException iae) {
            Assert.assertTrue(iae.getMessage().contains("operator id is too short to get its mobile country code"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    /**
     * Tests an unknown operatorId.
     */
    @Test
    public void testOperatorIdNotFound() {
        try {
            String operatorId = "55566";
            OperatorToCountryMapper.getCountryCode(Integer.parseInt(operatorId));
        } catch (IllegalArgumentException iae) {
            Assert.assertTrue(iae.getMessage().contains(
                    "received operator id does not relates to any configured MMC's country code"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}
