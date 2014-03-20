/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.users;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * The class <code>ParseUserIdentityTest</code> contains tests for the class <code>{@link ParseUserIdentity}</code>.
 * 
 * @author juanc352 (jchernandez@full-on-net.com)
 * @version $Revision: 1.0 $
 */
public class ParseUserIdentityTest {

    /**
     * Run the boolean ParseUserIdentity for an user of email type.
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityMail() throws Exception {
        String userId = "mailto:jchernandez.full-on-net.com";

        Map<String, String> results = ParseUserIdentity.parseUserIdentity(userId);

        Assert.assertEquals("mailto", results.get(UsersConstants.RESULT_TYPE_KEY));
        Assert.assertEquals("jchernandez.full-on-net.com", results.get(UsersConstants.RESULT_VALUE_KEY));
    }

    /**
     * Run the boolean ParseUserIdentity for an user of alias type.
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityAlias() throws Exception {
        String userId = "alias:23423423423m";

        Map<String, String> results = ParseUserIdentity.parseUserIdentity(userId);

        Assert.assertEquals("alias", results.get(UsersConstants.RESULT_TYPE_KEY));
        Assert.assertEquals("23423423423m", results.get(UsersConstants.RESULT_VALUE_KEY));
    }

    /**
     * Run the boolean ParseUserIdentity for an user of msisdn type.
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityTel() throws Exception {
        String userId = "tel:+34983456123";

        Map<String, String> results = ParseUserIdentity.parseUserIdentity(userId);

        Assert.assertEquals("tel", results.get(UsersConstants.RESULT_TYPE_KEY));
        Assert.assertEquals("34983456123", results.get(UsersConstants.RESULT_VALUE_KEY));
        Assert.assertEquals("21407", results.get(UsersConstants.RESULT_TEL_OB_ID_KEY));
        Assert.assertEquals("214", results.get(UsersConstants.RESULT_TEL_COUNTRY_ID_KEY));
        Assert.assertEquals("07", results.get(UsersConstants.RESULT_TEL_OPERATOR_ID_KEY));
        Assert.assertEquals("34", results.get(UsersConstants.RESULT_TEL_COUNTRY_CODE_KEY));
    }

    /**
     * Run the boolean ParseUserIdentity for an user of msisdn type.
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityTelUNKNOWN() throws Exception {
        String userId = "tel:UNKNOWN";

        Map<String, String> results = ParseUserIdentity.parseUserIdentity(userId);

        Assert.assertEquals("tel", results.get(UsersConstants.RESULT_TYPE_KEY));
        Assert.assertEquals("UNKNOWN", results.get(UsersConstants.RESULT_VALUE_KEY));
    }

    /**
     * Run the boolean ParseUserIdentity for an user of mobileid type.
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityMobileid() throws Exception {
        String userId = "mobileid:123123-123123-123123-12112";

        Map<String, String> results = ParseUserIdentity.parseUserIdentity(userId);

        Assert.assertEquals("mobileid", results.get(UsersConstants.RESULT_TYPE_KEY));
        Assert.assertEquals("123123-123123-123123-12112", results.get(UsersConstants.RESULT_VALUE_KEY));
    }

    /**
     * Run the boolean ParseUserIdentity for an user of acr type.
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityAcr() throws Exception {
        String userId = "acr:123123-123123-123123-12112;ncc=50216";

        Map<String, String> results = ParseUserIdentity.parseUserIdentity(userId);

        Assert.assertEquals("acr", results.get(UsersConstants.RESULT_TYPE_KEY));
        Assert.assertEquals("123123-123123-123123-12112;ncc=50216", results.get(UsersConstants.RESULT_VALUE_KEY));
        Assert.assertEquals("123123-123123-123123-12112", results.get(UsersConstants.RESULT_ACR_TOKEN_KEY));
        Assert.assertEquals("50216", results.get(UsersConstants.RESULT_ACR_NCC_KEY));
        Assert.assertEquals("502", results.get(UsersConstants.RESULT_ACR_COUNTRY_KEY));
        Assert.assertEquals("60", results.get(UsersConstants.RESULT_ACR_COUNTRY_CODE_KEY));
    }

    /**
     * Run ParseUserIdentity for an user of Iso-3166-1-alpha2 type (country).
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityIso31661alpha2() throws Exception {
        String userId = "ES";

        Map<String, String> results = ParseUserIdentity.parseUserIdentity(userId);

        Assert.assertEquals(UsersConstants.ALPHA_2, results.get(UsersConstants.RESULT_TYPE_KEY));
        Assert.assertEquals(UsersConstants.TEL_UNKNOWN, results.get(UsersConstants.RESULT_VALUE_KEY));
        Assert.assertEquals("21407", results.get(UsersConstants.RESULT_ISO_OB_ID_KEY));
        Assert.assertEquals("214", results.get(UsersConstants.RESULT_ISO_COUNTRY_ID_KEY));
        Assert.assertEquals("07", results.get(UsersConstants.RESULT_ISO_OPERATOR_ID_KEY));
    }

    /**
     * Run ParseUserIdentity for an user of Iso-3166-1-alpha2 type (country). Country unknown
     * 
     * @throws Exception
     * 
     */
    @Test
    public void testParseUserIdentityIso31661alpha2unknown() throws Exception {
        String userId = "XX";
        try {
            ParseUserIdentity.parseUserIdentity(userId);
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

    }

    /**
     * Perform pre-test initialization.
     * 
     * @throws Exception
     *             if the initialization fails for some reason
     * 
     * 
     @Before public void setUp() throws Exception { // add additional set up code here }
     */

    /**
     * Perform post-test clean-up.
     * 
     * @throws Exception
     *             if the clean-up fails for some reason
     * 
     * 
     @After public void tearDown() throws Exception { // Add additional tear down code here }
     */

}
