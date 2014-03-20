/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.users;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Phone (msisdn) - Operator Id Mapper.
 * 
 * @author Jesus Diaz Artiaga (jda@creativit.com)
 * 
 */
public final class OperatorPhoneMapper {

    private OperatorPhoneMapper() {
    }

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(OperatorPhoneMapper.class.getName());

    private static final String OPERATORS_PROPERTIES_PATH = "/properties/operators.properties";

    /**
     * Properties with the information of operator ids by country code.
     */
    private static Properties operatorsProperties = new Properties();
    static {
        try {
            InputStream inputStream = OperatorPhoneMapper.class
                    .getResourceAsStream(OperatorPhoneMapper.OPERATORS_PROPERTIES_PATH);
            OperatorPhoneMapper.operatorsProperties.load(inputStream);
            OperatorPhoneMapper.logger.info("Loaded the operators properties file");
        } catch (Throwable t) {
            OperatorPhoneMapper.logger.log(Level.WARNING, "Error loading the operators properties file", t);
        }
    }

    /**
     * Returns the operator id of the phone number's country.
     * 
     * @param phoneNumber
     * @return
     */
    public static int getOperatorId(String phoneNumber) {

        String countryCode = String.valueOf(PhoneParser.getCountryCode(phoneNumber));
        String operatorId = OperatorPhoneMapper.operatorsProperties.getProperty(countryCode, "0"); // TODO default
        return Integer.parseInt(operatorId);
    }

}
