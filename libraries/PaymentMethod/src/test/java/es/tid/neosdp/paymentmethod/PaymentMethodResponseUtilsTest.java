package es.tid.neosdp.paymentmethod;

import junit.framework.Assert;

import org.junit.Test;

import es.tid.neosdp.plainmap.PlainMap;

/**
 * Class for testing PaymentMethodResponseUtils class.
 * 
 * @author Pablo Meirino Feijoo (pmeirino@paradigmatecnologico.com)
 * 
 */
public class PaymentMethodResponseUtilsTest {

    /**
     * Create response without TosURL.
     */
    @Test
    public void testCreateResponseWithoutTosUrl() {
        try {
            PlainMap plainMapResult = PaymentMethodResponseUtils.createResponse(Boolean.TRUE, null, "directToBill");
            Assert.assertEquals(plainMapResult.getHierarchicalMap().toString(),
                    "{userChargeableStatusList={totalResults=1, userChargeableStatus=" + "[{isChargeable=true,"
                            + " paymentMethodType=directToBill}]}}");
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Failed test: " + t.getMessage());
        }
    }

    /**
     * Create response false.
     */
    @Test
    public void testCreateResponseFalse() {
        try {
            PlainMap plainMapResult = PaymentMethodResponseUtils.createResponse(Boolean.FALSE, "User not provisioned",
                    "directToBill", "http://cp.o2.cz/googletos/tos-v1/-379829120");
            Assert.assertEquals(plainMapResult.getHierarchicalMap().toString(),
                    "{userChargeableStatusList={totalResults=1, userChargeableStatus="
                            + "[{TosURL=http://cp.o2.cz/googletos/tos-v1/-379829120, reason=User not provisioned,"
                            + " isChargeable=false,"
                            + " paymentMethodType=directToBill}]}}");
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Failed test: " + t.getMessage());
        }
    }
    
    /**
     * Create response without isChargeable or TosURL.
     */
    @Test
    public void testCreateResponseWithoutIsChargeableOrTosUrl() {
        try {
            PlainMap plainMapResult = PaymentMethodResponseUtils.createResponse(null, null, "directToBill");
            Assert.assertEquals(plainMapResult.getHierarchicalMap().toString(),
                    "{userChargeableStatusList={totalResults=1, userChargeableStatus=" + "[{"
                            + "paymentMethodType=directToBill}]}}");
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Failed test: " + t.getMessage());
        }
    }

    /**
     * Create response with TosURL.
     */
    @Test
    public void testCreateResponseWithTosUrl() {
        try {
            PlainMap plainMapResult = PaymentMethodResponseUtils.createResponse(Boolean.TRUE, null, "directToBill",
                    "http://cp.o2.cz/googletos/tos-v1/-379829120");
            Assert.assertEquals(plainMapResult.getHierarchicalMap().toString(),
                    "{userChargeableStatusList={totalResults=1, userChargeableStatus="
                            + "[{TosURL=http://cp.o2.cz/googletos/tos-v1/-379829120,"
                            + " isChargeable=true,"
                            + " paymentMethodType=directToBill}]}}");
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Failed test: " + t.getMessage());
        }
    }
    
    /**
     * Create response with TosURL=null.
     */
    @Test
    public void testCreateResponseTosUrlNull() {
        try {
            PlainMap plainMapResult = PaymentMethodResponseUtils.createResponse(Boolean.FALSE, "User not provisioned",
                    "directToBill", null);
            Assert.assertEquals(plainMapResult.getHierarchicalMap().toString(),
                    "{userChargeableStatusList={totalResults=1, userChargeableStatus="
                            + "[{reason=User not provisioned, isChargeable=false,"
                            + " paymentMethodType=directToBill}]}}");
        } catch (Throwable t) {
            t.printStackTrace();
            Assert.fail("Failed test: " + t.getMessage());
        }
    }
}