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
 * Usages - eBC code3 mapper
 *
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public class UsagesEbcMapper {

	/**
	 * Logger
	 */
	private final static Logger logger = Logger.getLogger(UsagesEbcMapper.class.getName());

	private static final String USAGE_CODES_PROPERTIES_PATH = "/properties/usagecodes.properties";

	private static final String USAGE_ALL_CODES_KEY = "all.usages";

	/**
	 * Properties with the information of operator ids by country code
	 */
	private static Properties USAGE_CODES_PROPERTIES = new Properties();
	static {
		try {
			InputStream inputStream = UsagesEbcMapper.class.getResourceAsStream(UsagesEbcMapper.USAGE_CODES_PROPERTIES_PATH);
			UsagesEbcMapper.USAGE_CODES_PROPERTIES.load(inputStream);
			logger.info("Loaded the usage codes properties file");
		} catch (Throwable t) {
			logger.log(Level.WARNING, "Error loading the usage codes properties file", t);
		}
	}

	/**
	 * Return the usage description for eBC code
	 * @param code2
	 * @return
	 */
	public static String getInverseCode2(String code2) {
		if ("1".equalsIgnoreCase(code2)) {
			return "testing";

		} else if ("2".equalsIgnoreCase(code2)) {
			return "commercial";

		} else if ("3".equalsIgnoreCase(code2)) {
			return "scratching";

		} else if ("4".equalsIgnoreCase(code2)) {
			return "refund";
		}
		return "";
	}
	/**
	 * Returns the eBC code2 for the usage
	 *
	 * @param usage
	 * @return
	 */
	public static String getCode2(String usage){

		return UsagesEbcMapper.USAGE_CODES_PROPERTIES.getProperty(usage, "");
	}
	/**
	 * Return the eBC code2 for all usages
	 *
	 * @return
	 */
	public static String getCode2AllUsages() {
		return UsagesEbcMapper.USAGE_CODES_PROPERTIES.getProperty(USAGE_ALL_CODES_KEY, "");
	}

	/**
    *
    * validate the value of usageCode
    * @return true if it's OK
    */
   public static boolean validateUsageCode(String usageCode) {
    // for usage, now only testing (1) and commercial (2) values are supported

       if(usageCode==null || usageCode.isEmpty()){
           return false;
       }
       else{
          try{
              int code=Integer.valueOf(usageCode);
              if(code==1 || code==2)
                  return true;
              else
                  return false;
          }catch(Exception e){
              return false;
          }

       }
   }
}
