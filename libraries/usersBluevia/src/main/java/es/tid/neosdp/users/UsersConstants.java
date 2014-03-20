/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.users;

/**
 * Generic constants in users fields.
 * 
 * @author juanc352 (jchernandez@full-on-net.com)
 * 
 */
public final class UsersConstants {

    private UsersConstants() {
    }

    // AnyUri User's types
    /**
     * phone number prefix of AnyUri User's types.
     */
    public static final String TEL = "tel";
    /**
     * alias prefix of AnyUri User's types.
     */
    public static final String ALIAS = "alias";
    /**
     * mobile id token prefix of AnyUri User's types.
     */
    public static final String MOBILE_ID = "mobileid";
    /**
     * Telenor token prefix of AnyUri User's types.
     */
    public static final String ACR = "acr";
    /**
     * Mail prefix of AnyUri User's types.
     */
    public static final String MAIL_TO = "mailto";
    /**
     * Iso 3166-1 alpha2 AnyUri User's types.
     */
    public static final String ALPHA_2 = "alpha2";

    /**
     * AnyUri User's separator.
     */
    public static final String SEPARATOR = ":";

    // ACR constants
    /**
     * ACR, NCC atribute's tag.
     */
    public static final String ACR_NCC_TAG = ";ncc=";
    /**
     * ACR, field's separator.
     */
    public static final String ACR_SEPARATOR = ";";

    // ParseUserIdentity - HashMap result keys
    /**
     * Result key for type value.
     */
    public static final String RESULT_TYPE_KEY = "type";
    /**
     * Result key for type value.
     */
    public static final String RESULT_VALUE_KEY = "value";
    /**
     * Result key for the OB of the MSISDN value.
     */
    public static final String RESULT_TEL_OB_ID_KEY = "tel_ob";
    /**
     * Result key for the country of the MSISDN value.
     */
    public static final String RESULT_TEL_COUNTRY_ID_KEY = "tel_country";
    /**
     * Result key for the country code of the MSISDN value.
     */
    public static final String RESULT_TEL_COUNTRY_CODE_KEY = "tel_country_code";
    /**
     * Result key for the operator of the MSISDN value.
     */
    public static final String RESULT_TEL_OPERATOR_ID_KEY = "tel_operator";

    /**
     * Result key for ACR NCC.
     */
    public static final String RESULT_ACR_NCC_KEY = "acr_ncc";
    /**
     * Result key for ACR token.
     */
    public static final String RESULT_ACR_TOKEN_KEY = "acr_token";
    /**
     * Result key for ACR countryId.
     */
    public static final String RESULT_ACR_COUNTRY_KEY = "acr_country";
    /**
     * Result key for ACR country code.
     */
    public static final String RESULT_ACR_COUNTRY_CODE_KEY = "acr_country_code";

    /**
     * Result key for the OB of the ISO 3166-1 alpha 2.
     */
    public static final String RESULT_ISO_OB_ID_KEY = "iso_ob";
    /**
     * Result key for the country of the ISO 3166-1 alpha 2.
     */
    public static final String RESULT_ISO_COUNTRY_ID_KEY = "iso_country";
    /**
     * Result key for the operator of the ISO 3166-1 alpha 2.
     */
    public static final String RESULT_ISO_OPERATOR_ID_KEY = "iso_operator";
    /**
     * Unknown tel URI fo PE when ISO 3166-1 alpha 2 UserId
     */
    public static final String TEL_UNKNOWN = "tel:UNKNOWN";

}
