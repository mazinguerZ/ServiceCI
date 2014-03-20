/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.users;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * this class extracts all information of the userId.
 * 
 * @author juanc352 (jchernandez@full-on-net.com)
 * @author rps (rps@tid.es)
 */
public final class ParseUserIdentity {

    private ParseUserIdentity() {
    }

    /**
     * It extracts all information of the userId:
     * <ul>
     * <li>tel fields: type, value, obId, countryId and operatorId</li>
     * <li>alias fields: type, value</li>
     * <li>mobileid fields: type, value</li>
     * <li>acr fields: type, value, token, ncc value and countryId</li>
     * <li>mailto fields: type, value</li>
     * <li>country ISO 3166-1 Alpha-2 code: type, value, obId, countryId and operatorId</li>
     * </ul>
     * 
     * @param userId
     *            userId
     * @return hashMap with user information, null for empty or null userId
     */
    public static Map<String, String> parseUserIdentity(String userId) {

        if (userId != null) {
            userId = userId.trim();
            if (!userId.isEmpty()) {
                HashMap<String, String> result = new HashMap<String, String>();
                int separatorIndex = userId.indexOf(UsersConstants.SEPARATOR);
                if (separatorIndex != -1) {
                    String prefix = userId.substring(0, separatorIndex);
                    // tel fields: type, value, obId, countryId and operatorId
                    if (UsersConstants.TEL.equals(prefix)) {
                        result.put(UsersConstants.RESULT_TYPE_KEY, UsersConstants.TEL);
                        // Adapt the phone number to remove the uri part, international prefix 00, and + symbol
                        String phoneValue = PhoneParser.getCountryPhoneNumber(userId.substring(separatorIndex
                                + UsersConstants.SEPARATOR.length()));
                        result.put(UsersConstants.RESULT_VALUE_KEY, phoneValue);
                        if (!UsersConstants.TEL_UNKNOWN.equals(userId)) {
                            String ob = String.valueOf(OperatorPhoneMapper.getOperatorId(phoneValue));
                            if (ob != null && !ob.isEmpty()) {
                                result.put(UsersConstants.RESULT_TEL_OB_ID_KEY, ob);
                                if (!ob.equals("0")) {
                                    result.put(UsersConstants.RESULT_TEL_COUNTRY_ID_KEY, ob.substring(0, 3));
                                    int countryCode = OperatorToCountryMapper.getCountryCode(Integer.parseInt(ob));
                                    result.put(UsersConstants.RESULT_TEL_COUNTRY_CODE_KEY, String.valueOf(countryCode));
                                    result.put(UsersConstants.RESULT_TEL_OPERATOR_ID_KEY, ob.substring(3));
                                }
                            }
                        }
                    } else if (UsersConstants.ALIAS.equals(prefix)) {
                        // alias fields: type, value
                        result.put(UsersConstants.RESULT_TYPE_KEY, UsersConstants.ALIAS);
                        result.put(UsersConstants.RESULT_VALUE_KEY,
                                userId.substring(separatorIndex + UsersConstants.SEPARATOR.length()));
                    } else if (UsersConstants.MOBILE_ID.equals(prefix)) {
                        // mobileid fields: type, value
                        result.put(UsersConstants.RESULT_TYPE_KEY, UsersConstants.MOBILE_ID);
                        result.put(UsersConstants.RESULT_VALUE_KEY,
                                userId.substring(separatorIndex + UsersConstants.SEPARATOR.length()));
                    } else if (UsersConstants.ACR.equals(prefix)) {
                        // acr fields: type, value, token, ncc value and countryId

                        result.put(UsersConstants.RESULT_TYPE_KEY, UsersConstants.ACR);
                        String acrValue = userId.substring(separatorIndex + UsersConstants.SEPARATOR.length());
                        result.put(UsersConstants.RESULT_VALUE_KEY, acrValue);
                        int acrSeparatorIndex = acrValue.indexOf(UsersConstants.ACR_SEPARATOR);
                        if (acrSeparatorIndex != -1) {
                            result.put(UsersConstants.RESULT_ACR_TOKEN_KEY, acrValue.substring(0, acrSeparatorIndex));
                        }

                        int nccTagIndex = acrValue.indexOf(UsersConstants.ACR_NCC_TAG);
                        if (nccTagIndex != -1) {
                            int origen = nccTagIndex + UsersConstants.ACR_NCC_TAG.length();
                            int nccEndIndex = acrValue.indexOf(UsersConstants.ACR_SEPARATOR, origen);
                            String ncc;
                            if (nccEndIndex != -1) {
                                ncc = acrValue.substring(origen, nccEndIndex);
                            } else {
                                ncc = acrValue.substring(origen);
                            }
                            result.put(UsersConstants.RESULT_ACR_NCC_KEY, ncc);
                            if (!ncc.isEmpty()) {
                                // extract first three chiphres (MCC)
                                String mcc = ncc.substring(0, 3);
                                result.put(UsersConstants.RESULT_ACR_COUNTRY_KEY, mcc);
                                int countryCode = OperatorToCountryMapper.getCountryCode(Integer.valueOf(ncc));
                                result.put(UsersConstants.RESULT_ACR_COUNTRY_CODE_KEY, String.valueOf(countryCode));
                            }
                        }
                    } else if (UsersConstants.MAIL_TO.equals(prefix)) {
                        // mailto fields: type, value
                        result.put(UsersConstants.RESULT_TYPE_KEY, UsersConstants.MAIL_TO);
                        result.put(UsersConstants.RESULT_VALUE_KEY,
                                userId.substring(separatorIndex + UsersConstants.SEPARATOR.length()));

                    }
                } else if (userId.length() == 2 && StringUtils.isAlpha(userId) && StringUtils.isAllUpperCase(userId)) {
                    // no separator (:) found, so it can be country ISO 3166-1 Alpha-2 code

                    result.put(UsersConstants.RESULT_TYPE_KEY, UsersConstants.ALPHA_2);
                    result.put(UsersConstants.RESULT_VALUE_KEY, UsersConstants.TEL_UNKNOWN);
                    String ob = String.valueOf(Iso31661alpha2ToOperatorMapper.getOperatorId(userId));
                    if (ob != null && !ob.isEmpty()) {
                        result.put(UsersConstants.RESULT_ISO_OB_ID_KEY, ob);
                        result.put(UsersConstants.RESULT_ISO_COUNTRY_ID_KEY, ob.substring(0, 3));
                        result.put(UsersConstants.RESULT_ISO_OPERATOR_ID_KEY, ob.substring(3));
                    }
                }
                return result;
            }
        }
        return null;
    }
}
