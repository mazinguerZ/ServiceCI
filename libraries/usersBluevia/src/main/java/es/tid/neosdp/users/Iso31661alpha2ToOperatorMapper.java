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
 * Iso 3166-1 Alpha-2 code to OperatorId Mapper.
 * 
 * @author rps@tid.es
 * 
 */
public final class Iso31661alpha2ToOperatorMapper {

    private Iso31661alpha2ToOperatorMapper() {
    }

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(Iso31661alpha2ToOperatorMapper.class.getName());

    private static final String ISO31661ALPHA2_PROPERTIES_PATH = "/properties/iso31661alpha2.properties";

    /**
     * Properties with the information of operator ids by Iso 3166-1 Alpha-2 country code.
     */
    private static Properties operatorsProperties = new Properties();
    static {
        try {
            InputStream inputStream = Iso31661alpha2ToOperatorMapper.class
                    .getResourceAsStream(Iso31661alpha2ToOperatorMapper.ISO31661ALPHA2_PROPERTIES_PATH);
            Iso31661alpha2ToOperatorMapper.operatorsProperties.load(inputStream);
            Iso31661alpha2ToOperatorMapper.logger.info("Loaded the iso31661alpha2 to operators properties file");
        } catch (Throwable t) {
            Iso31661alpha2ToOperatorMapper.logger.log(Level.WARNING,
                    "Error loading the iso31661alpha2 to operators properties file", t);
        }
    }

    /**
     * Gets the operator id of the Iso 3166-1 Alpha-2 country code. If the country code is not found, returns 0
     * 
     * @param country
     * @return
     */
    public static int getOperatorId(String countryCode) {
        String operatorId = Iso31661alpha2ToOperatorMapper.operatorsProperties.getProperty(countryCode);
        if (operatorId == null) {
            throw new IllegalArgumentException(
                    "received Iso 3166-1 Alpha-2 country code does not relates to any configured operatorId");
        }
        return Integer.parseInt(operatorId);
    }

}
