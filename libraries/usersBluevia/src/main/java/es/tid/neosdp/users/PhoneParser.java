/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.users;

/**
 * Phone (msisdn) parser. See country codes at http://countrycode.org/
 * 
 * @author Jorge Lorenzo (jorgelg@tid.es)
 */
public final class PhoneParser {

    private PhoneParser() {
    }

    /**
     * Transform the input phone number to remove spaces, uri "tel:", +, 00 international code For example, phoneNumber:
     * "tel:+0034 544 54 32" would be transformed into "345445432".
     * 
     * @param phoneNumber
     * @return
     */
    public static String getCountryPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        // Remove the spaces
        phoneNumber = phoneNumber.replaceAll(" ", "");
        int countryCodeIndex = phoneNumber.startsWith("tel:") ? 4 : 0;
        if (phoneNumber.charAt(countryCodeIndex) == '+') {
            countryCodeIndex++;
        }
        if (phoneNumber.charAt(countryCodeIndex) == '0' && phoneNumber.charAt(countryCodeIndex + 1) == '0') {
            countryCodeIndex += 2;
        }
        if (countryCodeIndex != 0) {
            return phoneNumber.substring(countryCodeIndex);
        } else {
            return phoneNumber;
        }
    }

    /**
     * Get the country code (phone number prefix). If error, then return 0
     * 
     * @param phoneNumber
     * @return
     */
    public static int getCountryCode(String phoneNumber) {
        phoneNumber = PhoneParser.getCountryPhoneNumber(phoneNumber);
        if (phoneNumber == null || phoneNumber.length() < 4) {
            return 0;
        }
        // Remove the spaces
        phoneNumber = phoneNumber.replaceAll(" ", "");
        int countryCodeIndex = 0;
        if (phoneNumber.charAt(0) == '+') {
            countryCodeIndex++;
        }
        if (phoneNumber.charAt(countryCodeIndex) == '0' && phoneNumber.charAt(countryCodeIndex + 1) == '0') {
            countryCodeIndex += 2;
        }
        if (countryCodeIndex != 0) {
            phoneNumber = phoneNumber.substring(countryCodeIndex);
        }
        // Get the country code
        switch (phoneNumber.charAt(0)) {
            case '3':
                switch (phoneNumber.charAt(1)) {
                    case '4':
                        return 34; // Spain
                    case '5':
                    case '7':
                    case '8':
                        return PhoneParser.getTripleCountryCode(phoneNumber);
                    default:
                        return PhoneParser.getDoubleCountryCode(phoneNumber);
                }
            case '4':
                switch (phoneNumber.charAt(1)) {
                    case '4':
                        return 44; // UK
                    case '9':
                        return 49; // Germany
                    case '2':
                        return PhoneParser.getTripleCountryCode(phoneNumber);
                    default:
                        return PhoneParser.getDoubleCountryCode(phoneNumber);
                }
            case '5':
                switch (phoneNumber.charAt(1)) {
                    case '1':
                        return 51; // Peru
                    case '2':
                        return 52; // Mexico
                    case '3':
                        return 53; // Cuba
                    case '4':
                        return 54; // Argentina
                    case '5':
                        return 55; // Brazil
                    case '6':
                        return 56; // Chile
                    case '7':
                        return 57; // Colombia
                    case '8':
                        return 58; // Venezuela
                    default:
                        return PhoneParser.getTripleCountryCode(phoneNumber);
                }
            case '1':
                return 1; // USA, Canada, ...
            case '7':
                return 7; // Russia
            case '2':
                switch (phoneNumber.charAt(1)) {
                    case '0':
                    case '7':
                        return PhoneParser.getDoubleCountryCode(phoneNumber);
                    default:
                        return PhoneParser.getTripleCountryCode(phoneNumber);
                }
            case '6':
                switch (phoneNumber.charAt(1)) {
                    case '7':
                    case '8':
                    case '9':
                        return PhoneParser.getTripleCountryCode(phoneNumber);
                    default:
                        return PhoneParser.getDoubleCountryCode(phoneNumber);
                }
            case '8':
                switch (phoneNumber.charAt(1)) {
                    case '5':
                    case '7':
                    case '8':
                        return PhoneParser.getTripleCountryCode(phoneNumber);
                    default:
                        return PhoneParser.getDoubleCountryCode(phoneNumber);
                }
            case '9':
                switch (phoneNumber.charAt(1)) {
                    case '6':
                    case '7':
                    case '9':
                        return PhoneParser.getTripleCountryCode(phoneNumber);
                    default:
                        return PhoneParser.getDoubleCountryCode(phoneNumber);
                }
            default:
                break;
        }
        return 0;
    }

    /**
     * Take the first 3 digits of the phone number and convert into an integer.
     * 
     * @param phoneNumber
     * @return
     */
    private static int getTripleCountryCode(final String phoneNumber) {
        return Integer.parseInt(phoneNumber.substring(0, 3));
    }

    /**
     * Take the first 2 digits of the phone number and convert into an integer.
     * 
     * @param phoneNumber
     * @return
     */
    private static int getDoubleCountryCode(final String phoneNumber) {
        return Integer.parseInt(phoneNumber.substring(0, 2));
    }
}