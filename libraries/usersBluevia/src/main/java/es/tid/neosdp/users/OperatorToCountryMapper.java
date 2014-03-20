/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.users;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Maps operatorId to country code by taking MMC.
 * 
 * @author Roberto Mier (rmescandon@gmail.com)
 * 
 */
public final class OperatorToCountryMapper {

    private OperatorToCountryMapper() {
    }

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(OperatorPhoneMapper.class.getName());

    private static final String MCC_PROPERTIES_PATH = "/properties/mcc.properties";

    /**
     * Properties with the information of country codes related to ob ids.
     */
    private static Properties mccProperties = new Properties();
    static {
        try {
            InputStream inputStream = OperatorPhoneMapper.class
                    .getResourceAsStream(OperatorToCountryMapper.MCC_PROPERTIES_PATH);
            OperatorToCountryMapper.mccProperties.load(inputStream);
            OperatorToCountryMapper.logger.info("Loaded the mobile country code to country code properties file");
        } catch (Throwable t) {
            OperatorToCountryMapper.logger.log(Level.WARNING,
                    "Error loading the ob id to country code properties file", t);
        }
    }

    /**
     * Gets the county code related to an operator id (providerid). This way we have 34 (Spain cc) for 21407 (Movistar
     * Spain) The operation is done by reading MCC (three first ciphres) from operatorId
     * 
     * @param operatorId
     *            providerId whose country code is wanted to be known
     * @return integer with country code prefix for queried provider id
     * @throws IllegalArgumentException
     *             when input value is not valid (too short, not included into configured values, etc...)
     * @throws NumberFormatException
     *             when properties file to be queried for country code information has lack of some operators
     */
    public static int getCountryCode(int operatorId) {
        String sOperatorId = String.valueOf(operatorId);
        if (sOperatorId.length() > 3) {
            // extract first three chiphres (MCC)
            String mcc = sOperatorId.substring(0, 3);
            String countryCode = (String) OperatorToCountryMapper.mccProperties.get(mcc);
            if (countryCode == null) {
                throw new IllegalArgumentException(
                        "received operator id does not relates to any configured MMC's country code");
            }
            return Integer.parseInt(countryCode);
        } else {
            throw new IllegalArgumentException("operator id is too short to get its mobile country code");
        }
    }

}
