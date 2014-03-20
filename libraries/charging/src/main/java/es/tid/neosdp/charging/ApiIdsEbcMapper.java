/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2012 Telefonica I+D
 */
package es.tid.neosdp.charging;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Api id - eBC code3 mapper
 * 
 * @author Jesus Diaz Artiaga (jda@creativit.com)
 *
 */
public class ApiIdsEbcMapper {
	
	/**
	 * Logger
	 */
	private final static Logger logger = Logger.getLogger(ApiIdsEbcMapper.class.getName());
	
	private static final String API_CODES_PROPERTIES_PATH = "/properties/apicodes.properties";
	
//	private static final String TYPES_ALL_CODES_KEY = "all.values";
	
	/**
	 * Properties with the information of operator ids by country code
	 */
	private static Properties API_CODES_PROPERTIES = new Properties();
	static {
		try {
			InputStream inputStream = ApiIdsEbcMapper.class.getResourceAsStream(ApiIdsEbcMapper.API_CODES_PROPERTIES_PATH);
			ApiIdsEbcMapper.API_CODES_PROPERTIES.load(inputStream);
			logger.info("Loaded the api codes properties file");
		} catch (Throwable t) {
			logger.log(Level.WARNING, "Error loading the api codes properties file", t);
		}
	}

	/**
	 * Return the apiCode description for eBC code
	 * @param code3
	 * @return
	 */
	public static String getInverseCode3(String code3) {
		if ("1".equalsIgnoreCase(code3)) {
			return "sms.send";
			
		} else if ("2".equalsIgnoreCase(code3)) {
			return "sms.receive";
			
		} else if ("3".equalsIgnoreCase(code3)) {
			return "mms.send";
			
		} else if ("4".equalsIgnoreCase(code3)) {
			return "mms.receive";
		}				
		return "";
	}
	
	/**
	 * Returns the eBC code3 for the api id
	 * 
	 * @param apiIds
	 * @return
	 */
	public static String getApiCode3(String apiIds){
		
		return ApiIdsEbcMapper.API_CODES_PROPERTIES.getProperty(apiIds, "");
	}

	/**
	 * Return all valid code3 in a string
	 * @return
	 */
	public static String getCode3AllTypes() {	
		return "1,2,3,4,";
//		return ApiIdsEbcMapper.API_CODES_PROPERTIES.getProperty("all.values", "");
	}
	
}
