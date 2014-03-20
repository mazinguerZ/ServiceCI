/*
 * neoSDP (API management layer for Telefonica enablers)
 * Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.charging;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import es.tid.neosdp.plainmap.PlainMap;
import es.tid.neosdp.plainmap.PlainMapException;
import es.tid.neosdp.users.OperatorPhoneMapper;

/**
 * Charging plain map
 *
 * @author rps
 *
 */
public class ChargingPlainMap {

	PlainMap map;

	/**
	 * ChargingPlainMap Constructor
	 *
	 * @param requestId
	 * @param phoneNumber
	 * @throws PlainMapException
	 */
	public ChargingPlainMap(String requestId, String phoneNumber) throws PlainMapException {
		map = new PlainMap();
		map.put(ChargingConstants.REQUEST_ID_KEY, requestId);
		try {
			map.put(ChargingConstants.TIMESTAMP_KEY, ChargingUtils.getTimestamp());
		} catch (DatatypeConfigurationException e) {
			throw new PlainMapException("DatatypeConfigurationException in timestamp");
		}
		map.put(ChargingConstants.SENDER_IDENTITY_KEY, ChargingConstants.SENDER_IDENTITY_VALUE);
		if (phoneNumber != null) {
			map.put(ChargingConstants.USER_ID_PHONE_NUMBER_KEY, phoneNumber);
		}
	}

	/**
	 * Sets code1, code2 & code3 elements of the charging plain map
	 *
	 * @param code1
	 * @param code2
	 * @param code3
	 * @throws PlainMapException
	 */
	public void setCodes(String code1, String code2, String code3) throws PlainMapException {
		map.put(ChargingConstants.CODE1_KEY, code1);
		map.put(ChargingConstants.CODE2_KEY, code2);
		map.put(ChargingConstants.CODE3_KEY, code3);
	}

	/**
	 * Sets operatorId element of the charging plain map
	 *
	 * @param operatorId
	 * @throws PlainMapException
	 */
	public void setOperatorId(String operatorId) throws PlainMapException {
		map.put(ChargingConstants.OPERATOR_ID, operatorId);
	}

	/**
	 * Sets purchaseCode element of the charging plain map
	 *
	 * @param purchaseCode
	 * @throws PlainMapException
	 */
	public void setPurchaseCode(String purchaseCode) throws PlainMapException {
		map.put(ChargingConstants.PURCHASE_CODE_KEY, purchaseCode);
	}

	/**
	 * Sets subPurchaseCode element of the charging plain map
	 *
	 * @param subPurchaseCode
	 * @throws PlainMapException
	 */
	public void setSubPurchaseCode(String subPurchaseCode) throws PlainMapException {
		map.put(ChargingConstants.SUBPURCHASE_CODE_KEY, subPurchaseCode);
	}

	/**
	 * Sets description element of the charging plain map
	 *
	 * @param description
	 * @throws PlainMapException
	 */
	public void setDescription(String description) throws PlainMapException {
		map.put(ChargingConstants.DESCRIPTION_KEY, description);
	}

	/**
     * Sets requestedServiceUnits element of the charging plain map.
     * <ul>
     *  <li> sets genericUnits = 1 </li>
     *  <li> if testing = true, sets usageType = 1, else sets usageType = 0 </li>
     * </ul>
     *
     * @param addUsage parameter that indicates if request needs the usage type field
     * @param testing parameter that indicates if request is of testing usage type
     * @throws PlainMapException
     */
    public void setOneRequestedServiceUnits(boolean addUsage,boolean testing) throws PlainMapException {
        map.put(ChargingConstants.RSUU_GENERIC_UNITS_KEY, "1");
        if(addUsage){
            map.put(ChargingConstants.RSUU_USAGE_TYPE_KEY, (testing ? "1" : "0"));
        }
    }

	/**
	 * Sets applicationReference element of the charging plain map
	 *
	 * @param applicationReference
	 * @throws PlainMapException
	 */
	public void setApplicationReference(String applicationReference) throws PlainMapException {
		map.put(ChargingConstants.APPLICATION_REFERENCE_KEY, applicationReference);
	}

	/**
	 * Sets appProviderId element of the charging plain map
	 *
	 * @param appProviderId
	 * @throws PlainMapException
	 */
	public void setAppProviderId(String appProviderId) throws PlainMapException {
		map.put(ChargingConstants.APP_PROVIDER_ID_KEY, appProviderId);
	}

	/**
	 * Sets additionalInfo element of the charging plain map
	 *
	 * @param additionalInfo
	 * @throws PlainMapException
	 */
	public void setAdditionalInfo(String additionalInfo) throws PlainMapException {
		map.put(ChargingConstants.ADDITIONAL_INFO_KEY, additionalInfo);
	}

	/**
	 * Sets serviceInformation element of the charging plain map for SMSs
	 *
	 * @param origPhoneN
	 * @param recpPhoneN
	 * @throws PlainMapException
	 */
	public void setServiceInformationSMS(String origPhoneN, String recpPhoneN) throws PlainMapException {
		if (origPhoneN != null)
			map.put(ChargingConstants.SI_SMS_ORIG_PHONE_NUMBER_KEY, origPhoneN);
		if (origPhoneN != null)
			map.put(ChargingConstants.SI_SMS_RECP_PHONE_NUMBER_KEY, recpPhoneN);
	}

	/**
	 * Sets serviceInformation element of the charging plain map for MMSs
	 *
	 * @param origPhoneN
	 * @param recpPhoneN
	 * @param msgLength
	 * @throws PlainMapException
	 */
	public void setServiceInformationMMS(String origPhoneN, String recpPhoneN, String msgLength) throws PlainMapException {
		if (origPhoneN != null)
			map.put(ChargingConstants.SI_MMS_ORIG_PHONE_NUMBER_KEY, origPhoneN);
		if (origPhoneN != null)
			map.put(ChargingConstants.SI_MMS_RECP_PHONE_NUMBER_KEY, recpPhoneN);
		if (msgLength != null)
			map.put(ChargingConstants.SI_MMS_MESSAGE_SIZE_KEY, msgLength);
	}

	/**
	 * Sets expandedResponse element of the charging plain map
	 *
	 * @param expandedResponse
	 * @throws PlainMapException
	 */
	public void setExpandedResponse(boolean expandedResponse) throws PlainMapException {
		map.put(ChargingConstants.EXPANDED_RESPONSE_KEY, expandedResponse ? "true" : "false");
	}

	/**
	 * Set the aggregateVouchers element of the charging plain map
	 *
	 * @param aggregateVouchers
	 * @throws PlainMapException
	 */
	public void setAggregateVouchers(String aggregateVouchers) throws PlainMapException {
		map.put(ChargingConstants.AGGREGATE_VOUCHERS_KEY, aggregateVouchers);
	}

	/**
	 * Sets language element of the charging plain map
	 *
	 * @param language
	 * @throws PlainMapException
	 */
	public void setLanguage(String language) throws PlainMapException {
		map.put(ChargingConstants.LANGUAGE_KEY, language);
	}

	/**
     * Sets some basic info of the vouchers in the charging plain map
     *
     * @param purchaseModelUnitAndAction
     * @param renewalAction
     * @param partialCharge
     * @throws PlainMapException
     */
    public void setVoucherInfo(String purchaseModelUnitAndAction,String renewalAction, String partialCharge) throws PlainMapException {
        map.put(ChargingConstants.RSUU_PURCHASE_MUAA_KEY, purchaseModelUnitAndAction);
        if(renewalAction!=null && renewalAction.equalsIgnoreCase("active"))
            map.put(ChargingConstants.RSUU_RENEWAL_ACTION_KEY, "1");
        else
            map.put(ChargingConstants.RSUU_RENEWAL_ACTION_KEY, "0");
        map.put(ChargingConstants.RSU_PARTIAL_CHARGE_KEY, partialCharge);
    }



	/**
	 * Adds a new triplet of code1, code2 & code3 in requestedEvents field of the plain map
	 * TODO revisar
	 *
	 * @param code1
	 * @param code2
	 * @param code3
	 * @throws PlainMapException
	 */
	@SuppressWarnings("unchecked")
	public void addRequestedEvent(String code1, String code2, String code3) throws PlainMapException {
		List<String> events = (List<String>) map.get(ChargingConstants.EVENTS_KEY);
		int length = 0;

		if (events != null)
			length = events.size();

		this.addRequestedEvent(length, code1, code2, code3);
	}

	/**
	 * Adds a new triplet of code1, code2 & code3 in requestedEvents field of the plain map.
	 * This method allows to set a specific id for the requestedEvent array.
	 *
	 * @param id
	 * @param code1
	 * @param code2
	 * @param code3
	 * @throws PlainMapException
	 */
	public void addRequestedEvent(int id, String code1, String code2, String code3) throws PlainMapException {
		String s1 = String.format(ChargingConstants.REQUESTED_EVENTS_CODE1_KEY, id);
		String s2 = String.format(ChargingConstants.REQUESTED_EVENTS_CODE2_KEY, id);
		String s3 = String.format(ChargingConstants.REQUESTED_EVENTS_CODE3_KEY, id);

		map.put(s1, code1);
		map.put(s2, code2);
		map.put(s3, code3);
	}

	/**
	 * Sets the rollback key depending on the value of the status
	 *
	 * @param status
	 * @throws PlainMapException
	 */
	public void setRollback(String status) throws PlainMapException{
		if (ChargingConstants.STATUS_ACTIVE_VALUE.equalsIgnoreCase(status)){
			map.put(ChargingConstants.ROLLBACK_KEY, Boolean.TRUE.toString());

		} else if (ChargingConstants.STATUS_INACTIVE_VALUE.equalsIgnoreCase(status)){
			map.put(ChargingConstants.ROLLBACK_KEY, Boolean.FALSE.toString());

		} else {
			throw new PlainMapException("Unknown status value: " + status);
		}
	}

	/**
	 * Obtains the DirectDebit plainMap
	 *
	 * @return
	 * @throws PlainMapException
	 */
	public PlainMap getDirectDebitMap() throws PlainMapException{
		map.put(ChargingConstants.REQUEST_NUMBER_KEY, ChargingConstants.REQUEST_NUMBER_VALUE);
		map.put(ChargingConstants.SERVICE_CONTEXT_ID_KEY, ChargingConstants.SERVICE_CONTEXT_ID_VALUE);

		map.addRootPath(ChargingConstants.DIRECT_DEBIT_KEY);
		return map;
	}

	/**
	 * Obtains the CheckBalance plainMap
	 *
	 * @return
	 * @throws PlainMapException
	 */
	public PlainMap getCheckBalanceMap() throws PlainMapException{
		map.put(ChargingConstants.REQUEST_NUMBER_KEY, ChargingConstants.REQUEST_NUMBER_VALUE);
		map.put(ChargingConstants.SERVICE_CONTEXT_ID_KEY, ChargingConstants.SERVICE_CONTEXT_ID_VALUE);

		map.addRootPath(ChargingConstants.CHECK_BALANCE_KEY);
		return map;
	}

	/**
	 * Obtains the GenerateRecord (CDR) plainMap
	 *
	 * @return
	 * @throws PlainMapException
	 */
	public PlainMap getGenerateRecordMap() throws PlainMapException{
		map.put(ChargingConstants.REQUEST_NUMBER_KEY, ChargingConstants.REQUEST_NUMBER_VALUE);
		map.put(ChargingConstants.SERVICE_CONTEXT_ID_KEY, ChargingConstants.SERVICE_CONTEXT_ID_VALUE);

		map.addRootPath(ChargingConstants.GENERATE_RECORD_KEY);
		return map;
	}

	/**
	 * Obtains the GetPurchaseModelOfEvents plain map modificated for GetPurchasedVouchers Request.
	 *
	 * @return
	 * @throws PlainMapException
	 */
	public PlainMap getGetPurchasedVoucherMap() throws PlainMapException {
		String phoneNumber = (String) map.get(ChargingConstants.USER_ID_PHONE_NUMBER_KEY);
		String operatorId = String.valueOf(OperatorPhoneMapper.getOperatorId(phoneNumber));

		map.put(ChargingConstants.SERVICE_CONTEXT_ID_KEY, ChargingConstants.SERVICE_CONTEXT_ID_VALUE);
		map.put(ChargingConstants.OPERATOR_ID, operatorId);
		map.put(ChargingConstants.TYPE_OF_QUERY_KEY, ChargingConstants.TYPE_OF_QUERY_VALUE_2);
		// Ensure null values for some keys...
		map.remove(ChargingConstants.AGGREGATE_VOUCHERS_KEY);
		map.remove(ChargingConstants.SUBS_TIME_ZONE_KEY);
		map.remove(ChargingConstants.LOC_TIME_ZONE_KEY);
		map.remove(ChargingConstants.SHOW_OTHER_EVENTS_KEY);
		map.remove(ChargingConstants.SERVICE_INFORMATION_KEY);

		map.addRootPath(ChargingConstants.GPMOE_KEY);
		return map;
	}
	/**
	 * Obtains the GetPurchaseModelOfEvents plainMap
	 *
	 * @return
	 * @throws PlainMapException
	 */
	public PlainMap getGetPurchaseModelsOfEventsMap() throws PlainMapException{

		String phoneNumber = (String) map.get(ChargingConstants.USER_ID_PHONE_NUMBER_KEY);
		String operatorId = String.valueOf(OperatorPhoneMapper.getOperatorId(phoneNumber));

		map.put(ChargingConstants.SERVICE_CONTEXT_ID_KEY, ChargingConstants.SERVICE_CONTEXT_ID_VALUE);
		map.put(ChargingConstants.OPERATOR_ID, operatorId);
		map.put(ChargingConstants.TYPE_OF_QUERY_KEY, ChargingConstants.TYPE_OF_QUERY_VALUE);

		map.addRootPath(ChargingConstants.GPMOE_KEY);
		return map;
	}

	/**
	 * Obtains the CancelRenewal plainMap
	 *
	 * @return
	 * @throws PlainMapException
	 */
	public PlainMap getCancelRenewal() throws PlainMapException{
		String phoneNumber = (String) map.get(ChargingConstants.USER_ID_PHONE_NUMBER_KEY);
		String operatorId = String.valueOf(OperatorPhoneMapper.getOperatorId(phoneNumber));

		map.put(ChargingConstants.SERVICE_CONTEXT_ID_KEY, ChargingConstants.SERVICE_CONTEXT_ID_VALUE);
		map.put(ChargingConstants.OPERATOR_ID, operatorId);

		map.put(ChargingConstants.REQUEST_NUMBER_KEY, ChargingConstants.REQUEST_NUMBER_VALUE);

		map.put(ChargingConstants.SUBS_TIME_ZONE_KEY, null);
		map.put(ChargingConstants.LOC_TIME_ZONE_KEY, null);

		map.put(ChargingConstants.CODE1_KEY, null);
		map.put(ChargingConstants.CODE2_KEY, null);
		map.put(ChargingConstants.CODE3_KEY, null);
		map.put(ChargingConstants.ADDITIONAL_INFO_KEY, null);

		map.addRootPath(ChargingConstants.CANCEL_RENEWAL_KEY);
		return map;
	}

	/**
	 * Obtains the GetPurchaseModelOfEvents plainMap
	 *
	 * @return
	 * @throws PlainMapException
	 */
	public PlainMap ChargingGetExpensesControlConfigurationMap() throws PlainMapException{

		String phoneNumber = (String) map.get(ChargingConstants.USER_ID_PHONE_NUMBER_KEY);
		String operatorId = String.valueOf(OperatorPhoneMapper.getOperatorId(phoneNumber));

		map.put(ChargingConstants.SERVICE_CONTEXT_ID_KEY, ChargingConstants.SERVICE_CONTEXT_ID_VALUE);
		map.put(ChargingConstants.OPERATOR_ID, operatorId);

		map.addRootPath(ChargingConstants.GECC_KEY);
		return map;
	}


}
