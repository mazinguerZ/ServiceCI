/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.charging;

/**
 * Charging library contants
 *
 * @author rps
 *
 */

public class ChargingConstants {

	//eBC requests constants
	public static final String SENDER_IDENTITY_VALUE = 		"neoSDP.bluevia.com";
	public static final String SERVICE_CONTEXT_ID_VALUE = 	"10.GlobalOCS-Event@telefonica.com";
	public static final String REQUEST_NUMBER_VALUE = 		"0";
	public static final String TYPE_OF_QUERY_VALUE = 		"0";
	public static final String TYPE_OF_QUERY_VALUE_2 = 		"2";
	public static final String AGGREGATE_VOUCHERS_VALUE = 	"false";

	//eBC operations
	public static final String DIRECT_DEBIT_KEY = 			"directDebit";
	public static final String CHECK_BALANCE_KEY = 			"checkBalance";
	public static final String GENERATE_RECORD_KEY = 		"generateRecord";
	public static final String CANCEL_RENEWAL_KEY = 		"cancelRenewal";
	public static final String REFUND_KEY = 				"refund";
	public static final String GPMOE_KEY = 					"getPurchaseModelsOfEvents";
	public static final String GECC_KEY = 					"getExpensesControlConfiguration";
	public static final String SECC_KEY = 					"setExpensesControlConfiguration";

	//charging eBC data KEYS
	public static final String REQUEST_ID_KEY = 			"requestId";
	public static final String REQUEST_NUMBER_KEY = 		"requestNumber";
	public static final String TIMESTAMP_KEY = 				"timestamp";
	public static final String SENDER_IDENTITY_KEY = 		"senderIdentity";
	public static final String SERVICE_CONTEXT_ID_KEY = 	"serviceContextId";
	public static final String SUBS_TIME_ZONE_KEY = 	    "subsTimeZone";
	public static final String LOC_TIME_ZONE_KEY =	    	"locTimeZone";
	public static final String SHOW_OTHER_EVENTS_KEY =	    "showOtherEvents";
	public static final String SERVICE_INFORMATION_KEY =    "serviceInformation";

	static final String USER_ID_PREFIX = 					"userId.";
	public static final String USER_ID_PHONE_NUMBER_KEY = 	USER_ID_PREFIX + "phoneNumber";

	public static final String OPERATOR_ID =				"operatorId";
	public static final String CODE1_KEY =					"code1";
	public static final String CODE2_KEY =					"code2";
	public static final String CODE3_KEY =					"code3";
	public static final String PURCHASE_CODE_KEY = 			"purchaseCode";
	public static final String SUBPURCHASE_CODE_KEY = 		"subPurchaseCode";
	public static final String DESCRIPTION_KEY = 			"description";
	static final String REQUESTED_SERVICE_UNITS_PREFIX = 	"requestedServiceUnits.";
	static final String RSU_UNITS_PREFIX = 					REQUESTED_SERVICE_UNITS_PREFIX + "units.";
	public static final String RSUU_GENERIC_UNITS_KEY =		RSU_UNITS_PREFIX + "genericUnits";
	public static final String RSUU_USAGE_TYPE_KEY =		RSU_UNITS_PREFIX + "usageType";
	public static final String RSUU_PURCHASE_MUAA_KEY = 	RSU_UNITS_PREFIX + "purchaseModelUnitAndAction";
	public static final String RSUU_RENEWAL_ACTION_KEY = 	RSU_UNITS_PREFIX + "renewalAction";
	static final String RSU_PARTIAL_CHARGE_KEY =			REQUESTED_SERVICE_UNITS_PREFIX + "partialCharge";
	public static final String APPLICATION_REFERENCE_KEY =	"applicationReference";
	public static final String APP_PROVIDER_ID_KEY =		"appProviderId";
	public static final String ADDITIONAL_INFO_KEY =		"additionalInfo";

	static final String SERVICE_INFORMATION_PREFIX =    		"serviceInformation.";

	static final String SI_SMS_INFORMATION_PREFIX =    			SERVICE_INFORMATION_PREFIX + "SMSInformation.";
	static final String SI_SMS_ORIG_ADDRESS_PREFIX =			SI_SMS_INFORMATION_PREFIX + "originatorAddress.";
	static final String SI_SMS_RECP_ADDRESS_PREFIX =			SI_SMS_INFORMATION_PREFIX + "recipientAddress.";
	public static final String SI_SMS_ORIG_PHONE_NUMBER_KEY =	SI_SMS_ORIG_ADDRESS_PREFIX + "phoneNumber";
	public static final String SI_SMS_RECP_PHONE_NUMBER_KEY =	SI_SMS_RECP_ADDRESS_PREFIX + "phoneNumber";

	static final String SI_MMS_INFORMATION_PREFIX =    			SERVICE_INFORMATION_PREFIX + "MMSInformation.";
	static final String SI_MMS_ORIG_ADDRESS_PREFIX =			SI_MMS_INFORMATION_PREFIX + "originatorAddress.";
	static final String SI_MMS_RECP_ADDRESS_PREFIX =			SI_MMS_INFORMATION_PREFIX + "recipientAddress.";
	public static final String SI_MMS_ORIG_PHONE_NUMBER_KEY =	SI_MMS_ORIG_ADDRESS_PREFIX + "phoneNumber";
	public static final String SI_MMS_RECP_PHONE_NUMBER_KEY =	SI_MMS_RECP_ADDRESS_PREFIX + "phoneNumber";
	public static final String SI_MMS_MESSAGE_SIZE_KEY =		SI_MMS_INFORMATION_PREFIX + "messageSize" ;

	public static final String EXPANDED_RESPONSE_KEY =		"expandedResponse";

	public static final String TYPE_OF_QUERY_KEY = 			"typeOfQuery";
	public static final String AGGREGATE_VOUCHERS_KEY = 	"aggregateVouchers";
	public static final String LANGUAGE_KEY = 				"language";

	public static final String REQUESTED_EVENTS_PREFIX =	"requestedEvents";
	static final String EVENTS_KEY =						REQUESTED_EVENTS_PREFIX + ".event";
	static final String EVENTS_ARRAY_PREFIX =				EVENTS_KEY + "[%s].";
	public static final String REQUESTED_EVENTS_CODE1_KEY = EVENTS_ARRAY_PREFIX + CODE1_KEY;
	public static final String REQUESTED_EVENTS_CODE2_KEY = EVENTS_ARRAY_PREFIX + CODE2_KEY;
	public static final String REQUESTED_EVENTS_CODE3_KEY = EVENTS_ARRAY_PREFIX + CODE3_KEY;

	public static final String ROLLBACK_KEY = "rollback";
	public static final String STATUS_INACTIVE_VALUE = "inactive";
	public static final String STATUS_ACTIVE_VALUE = "active";

	//eBC period times values
	public static final int START_TYPE_ABSOLUTE = 1;
	public static final int START_TYPE_RELATIVE = 2;
	public static final int START_TYPE_RELATIVE_TO_HIERARCHY = 3;

	public static final int END_TYPE_HOURS = 1;
	public static final int END_TYPE_WEEKS = 2;
	public static final int END_TYPE_MONTHS = 3;
	public static final int END_TYPE_UNLIMITED = 4;
	public static final int END_TYPE_ABSOLUTE = 5;


}
