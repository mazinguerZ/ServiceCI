/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.users;

/**
 * ACR URI (acr:whatever;ncc=obid) to operator mapper.
 * 
 * @author Roberto Mier (rmescandon@gmail.com)
 * 
 */
public final class AcrURIToOperatorMapper {

    private AcrURIToOperatorMapper() {
    }

    /**
     * SEMICOLON.
     */
    private static final String SEMICOLON = ";";
    /**
     * EQUAL.
     */
    private static final String EQUAL = "=";
    /**
     * ACR_COLON.
     */
    private static final String ACR_COLON = "acr:";
    /**
     * NCC.
     */
    private static final String NCC = "ncc";

    /**
     * Returns operator id from acr Uri. Every ACR URI has this form acr:8909800980;ncc=23889. The value extracted in
     * this case would be 23889
     * 
     * @param acrURI
     *            uri in ACR URI scheme form for getting its operator id
     * 
     * @return value for ncc attribute into uri sheme
     * @throws IllegalArgumentException
     *             when impossible to determinate operator id related to received uri (Received uri has not or not valid
     *             ncc value)
     */
    public static int getOperatorId(String acrURI) {
        // check if received parameter is not null
        if (acrURI != null) {
            // check if uri starts with acr:
            if (acrURI.startsWith(AcrURIToOperatorMapper.ACR_COLON)) {
                // divide acr main value and related properties in tokens and move across them to find the one starting
                // with 'ncc'
                String[] tokens = acrURI.split(AcrURIToOperatorMapper.SEMICOLON);
                if (tokens != null) {
                    for (String token : tokens) {
                        if (token.startsWith(AcrURIToOperatorMapper.NCC)) {
                            // check the property has 'ncc' and a value for it
                            String[] nameValues = token.split(AcrURIToOperatorMapper.EQUAL);
                            if ((nameValues != null) && (nameValues.length == 2)) {
                                // return the value part for this property
                                return Integer.parseInt(nameValues[1]);
                            } else {
                                throw new IllegalArgumentException(
                                        "Received ACR URI is not well formed. "
                                                + AcrURIToOperatorMapper.NCC
                                                + " attribute value was not found. Impossible to determinate"
                                                + "its operator identifier - " + acrURI);
                            }
                        }
                    }
                    throw new IllegalArgumentException("Received ACR URI is not well formed. "
                            + AcrURIToOperatorMapper.NCC
                            + " attribute was not found. Impossible to determinate its operator identifier");
                } else {
                    throw new IllegalArgumentException("Received ACR URI is not well formed. "
                            + AcrURIToOperatorMapper.NCC
                            + " attribute was not found. Impossible to determinate its operator identifier - "
                            + acrURI);
                }
            } else {
                throw new IllegalArgumentException("Received ACR URI is not well formed. It musts start with '"
                        + AcrURIToOperatorMapper.ACR_COLON + "'");
            }
        } else {
            throw new IllegalArgumentException("Received ACR URI is null");
        }
    }
}
