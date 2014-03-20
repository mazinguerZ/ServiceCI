/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.paymentmethod;

import es.tid.neosdp.callouts.NeosdpVariables;

/**
 * Some constants for Payment Method...
 *  
 * @author Fernando Jordan Silva (fjordan@aubay.es)
 *
 */
public final class PaymentMethodConstants {

	/**
	 * Active status of de user account in the OB.
	 */
	public static final String STATUS_ACTIVE = "active";
	/**
	 * Inactive status of de user account in the OB.
	 */
	public static final String STATUS_INACTIVE = "inactive";

    /**
     * Flow var for paymentMethodType
     */
    public static final String PAYMENT_METHOD_TYPE_VAR = NeosdpVariables.PATH_NEOSDP + "paymentMethodType";
    /**
     * Default paymenth method type if it is not defined.
     */
    public static final String DEFAULT_PAYMENT_METHOD_TYPE = "directToBill";
    
    /**
     * Components in json response.
     */
    static final String USER_CHARGEABLE_PREFIX = "userChargeableStatus[0].";
    static final String PAYMENTMETHOD_TYPE_ELEMENT = USER_CHARGEABLE_PREFIX + "paymentMethodType";
    static final String IS_CHARGEABLE_ELEMENT = USER_CHARGEABLE_PREFIX + "isChargeable";
    static final String REASON_ELEMENT = USER_CHARGEABLE_PREFIX + "reason";
    static final String TOTAL_RESULTS_ELEMENT = "totalResults";
    static final String TOTAL_RESULTS_RESP = "1";
    static final String TOS_URL_ELEMENT = "userChargeableStatusList.userChargeableStatus[0].TosURL";
}
