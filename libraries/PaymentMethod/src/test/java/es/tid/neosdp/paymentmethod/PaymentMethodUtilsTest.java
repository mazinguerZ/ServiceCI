package es.tid.neosdp.paymentmethod;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Class for testing PaymentMethodUtils class.
 * 
 * @author Pablo Meirino Feijoo (pmeirino@paradigmatecnologico.com)
 * 
 */
public class PaymentMethodUtilsTest {

    /**
     * Validate userId tel: format.
     */
    @Test
    public void testValidateUserIdTel() {
        String userId = "tel:+999112233";
        Assert.assertTrue(PaymentMethodUtils.validateUserId(userId));
        userId = "tel:999112233";
        Assert.assertTrue(PaymentMethodUtils.validateUserId(userId));
    }

    /**
     * Validate userId mobileid: format.
     */
    @Test
    public void testValidateUserIdMobileid() {
        String userId = "mobileid:b55e586e3fd889170545799d3c41997Q";
        Assert.assertTrue(PaymentMethodUtils.validateUserId(userId));
    }

    /**
     * Validate userId acr: format.
     */
    @Test
    public void testValidateUserAcr() {
        String userId = "acr:999112233";
        Assert.assertTrue(PaymentMethodUtils.validateUserId(userId));
    }

    /**
     * Incorrect userId format.
     */
    @Test
    public void testValidateUserIncorrect() {
        String userId = "999112233";
        Assert.assertFalse(PaymentMethodUtils.validateUserId(userId));
    }

}
