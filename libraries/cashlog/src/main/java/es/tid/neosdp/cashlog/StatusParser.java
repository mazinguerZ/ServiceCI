/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2013 Telefonica I+D
 */
package es.tid.neosdp.cashlog;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * load a properties file with the status parser between cashlog and bluevia/PE
 *
 * @author juanc352 (jchernandez@full-on-net.com)
 *
 */
public class StatusParser {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(StatusParser.class.getName());

    /**
     * parser properties
     */
    private static final String ERROR_PARSER_PATH = "/properties/cashlog_status.properties";

    /**
     * Properties with the information of status
     */
    private static Properties statusProperties = new Properties();

    /**
     * Default value for PE status
     */
    private static final String DEFAULT_PE_STATUS = "Denied";

    /**
     * Default value for PE subscription status
     */
    private static final String DEFAULT_PE_SUBSCRIPTION_STATUS = "denied";

    /**
     * Default value for BV status
     */
    private static final String DEFAULT_BV_STATUS = "failed";

    /**
     * properties values separator
     */
    private static final String SEPARATOR = ",";

    static {
        try {
            InputStream inputStream = StatusParser.class.getResourceAsStream(ERROR_PARSER_PATH);
            StatusParser.statusProperties.load(inputStream);
            StatusParser.logger.info("Loaded cashlog status properties file");
        } catch (Throwable t) {
            StatusParser.logger.log(Level.WARNING, "Error loading  cashlog status  properties file", t);
        }
    }

    /**
     * Get the PE status from the detailed error code
     *
     * @return PE status
     */
    public static String getPEStatus(String detailedErrorCode) {
        String result = (String) StatusParser.statusProperties.get(detailedErrorCode);
        if (result != null) {
            int separatorIndex = result.indexOf(SEPARATOR);
            if (separatorIndex != -1) {
                result = result.substring(0, separatorIndex);
            }
        }
        else{
            result = DEFAULT_PE_STATUS;
        }
        return result;
    }

    /**
     * Get the bluevia status from the detailed error code
     *
     * @return bluevia status
     */
    public static String getBVStatus(String detailedErrorCode) {
        String result = (String) StatusParser.statusProperties.get(detailedErrorCode);
        if (result != null) {
            int separatorIndex = result.indexOf(SEPARATOR);
            if (separatorIndex != -1) {
                int origin = separatorIndex + SEPARATOR.length();
                int separatorIndex2 = result.indexOf(SEPARATOR, origin);
                result = result.substring(origin, separatorIndex2);
            }
        }
        else{
            result = DEFAULT_BV_STATUS;
        }
        return result;
    }

    /**
     * Get the subscription status from the detailed error code
     *
     * @return subscription status
     */
    public static String getSubscriptionStatus(String detailedErrorCode) {
        String result = (String) StatusParser.statusProperties.get(detailedErrorCode);
        if (result != null) {
            int separatorIndex = result.lastIndexOf(SEPARATOR);
            if (separatorIndex != -1) {
                result = result.substring(separatorIndex + SEPARATOR.length());
            }
        }
        else{
            result = DEFAULT_PE_SUBSCRIPTION_STATUS;
        }
        return result;
    }
}
