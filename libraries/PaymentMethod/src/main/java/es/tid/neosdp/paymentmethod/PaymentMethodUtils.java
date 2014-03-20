/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.paymentmethod;

/**
 * Some Utilities for working with telURI:.
 * <ul>
 * <li>Create a telURI form a number</li>
 * <li>Create an international format of telURI</li>
 * </ul>
 * 
 * @author Fernando Jordan Silva (fjordan@aubay.es), Pablo Meirino Feijoo (pmeirino@paradigmatecnologico.com)
 */
public final class PaymentMethodUtils {

    public static final String TEL_PROTOCOL = "tel:";
    public static final String PLUS = "+";
    public static final String MOBILEID_PROTOCOL = "mobileid:";
    public static final String ACR_PROTOCOL = "acr:";

    /**
     * Private Constructor. Utility classes don't need constructor.
     */
    private PaymentMethodUtils() {
        // ...
    }

    /**
     * Create a telURI.
     * 
     * @param uri
     * @return
     */
    public static String createTelURI(final String uri) {
        // Create format
        return TEL_PROTOCOL + PLUS + PaymentMethodUtils.internationalFormatFromTelURI(uri);
    }

    /**
     * Validate a userId that can be in telURI format or not.
     * 
     * @param userId
     * @return
     */
    public static Boolean validateUserId(final String userId) {
        // 1. Validate Format
        if (userId.startsWith(TEL_PROTOCOL) || userId.startsWith(PLUS)) {
            String u = PaymentMethodUtils.internationalFormatFromTelURI(userId);
            if (u.matches("\\d+")) {
                return Boolean.TRUE;
            }
        } else if (userId.startsWith(MOBILEID_PROTOCOL)) {
            return Boolean.TRUE;
        } else if (userId.startsWith(ACR_PROTOCOL)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Create a number with international format from a telURI.
     * 
     * @param telURI
     * @return
     */
    public static String internationalFormatFromTelURI(final String telURI) {
        String uri = telURI;
        if (uri.startsWith(TEL_PROTOCOL)) {
            uri = uri.substring(TEL_PROTOCOL.length());
        }
        if (uri.startsWith(PLUS)) {
            uri = uri.substring(PLUS.length());
        }
        return uri;
    }
}
