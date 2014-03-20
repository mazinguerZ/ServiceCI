/*
 * neoSDP (API management layer for Telefonica enablers) Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.payment.builders.bable;

import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

import com.telefonica.schemas.unica.rest.common.v2.NameValuePairType;

/**
 * Generates an amountTransaction body Request for B-able
 *
 * @author rps
 *
 */
public class AmountTransactionData {

    protected final String userId; // mandatory
    protected final List<String> description; // mandatory

    protected String amount;
    protected String currency;
    protected String totalAmount;
    protected String taxAmount;
    protected String v1taxes;
    protected String code;

    protected final String referenceCode; // mandatory
    protected String serverReferenceCode; // correlatorId-externalTransactionId (refunds)
    protected String originalServerReferenceCode; // mandatory in refund
    
    protected String merchantId;
    protected String channel;
    protected String productId;
    protected String productClass;

    protected com.telefonica.schemas.unica.rest.transactionstorage.v2_1.TransactionOperationTypeType tx_type; // mandatory for B-able transactions API
    protected com.telefonica.schemas.unica.rest.bablepayment.v2_1.TransactionOperationTypeType pay_type;
    
    protected com.telefonica.schemas.unica.rest.transactionstorage.v2_1.TransactionOperationStatusType tx_status;
    protected com.telefonica.schemas.unica.rest.bablepayment.v2_1.TransactionOperationStatusType pay_status;

    protected final String serviceId; // mandatory
    protected final String servingOB; // mandatory
    protected final String applicationId;

    protected String resultCode;
    
    protected String totalAmountCharged;
    protected String totalTaxAmount;

    protected String paymentMethodType;
    protected String paymentMethodId;
    protected String paymentMethodMaskedAccountNumber;
    protected String paymentMethodCvv;
    
    protected String resourceURL;
    protected String callbackUrl;
    
    protected XMLGregorianCalendar clientDate;

    /**
     * BableAdditionalChargingMetaData > additionalData field
     */
    protected List<NameValuePairType> additionalData;


    /**
     * Constructor
     *
     * @param userId
     * @param description
     * @param productId
     * @param referenceCode
     * @param serviceId
     * @param servingOB
     */
    public AmountTransactionData(String userId, List<String> description, String referenceCode, 
    		String serviceId, String applicationId, String servingOB) {

        this.userId = userId;
        this.description = description;
        this.referenceCode = referenceCode;
        this.serviceId = serviceId;
        this.applicationId = applicationId;
        this.servingOB = servingOB;
    }

    /**
     * Sets AmountTransaction transaction status
     *
     * @param status
     */
    public void setTxStatus(com.telefonica.schemas.unica.rest.transactionstorage.v2_1.TransactionOperationStatusType status) {

        this.tx_status = status;
    }

    /**
     * Sets AmountTransaction payment status
     *
     * @param status
     */
    public void setPayStatus(com.telefonica.schemas.unica.rest.bablepayment.v2_1.TransactionOperationStatusType status) {

        this.pay_status = status;
    }
    
    /**
     * Sets AmountTransaction transaction type
     *
     * @param type
     */
    public void setTxType(com.telefonica.schemas.unica.rest.transactionstorage.v2_1.TransactionOperationTypeType type) {

        this.tx_type = type;
    }

    /**
     * Sets AmountTransaction payment type
     *
     * @param type
     */
    public void setPayType(com.telefonica.schemas.unica.rest.bablepayment.v2_1.TransactionOperationTypeType type) {

        this.pay_type = type;
    }    

    /**
     * Sets amount, currency and taxes fields
     *
     * @param amount
     * @param currency
     * @param totalAmount
     * @param taxAmount
     * @param v1taxes
     */
    public void setPaymentAmountsTaxes(String amount, String currency, String totalAmount, String taxAmount,
            String v1taxes) {

        this.amount = amount;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.taxAmount = taxAmount;
        this.v1taxes = v1taxes;
    }
    
    /**
     * Sets totalAmountCharged & totalTaxAmount
     *
     * @param totalAmountCharged
     * @param totalTaxAmount
     */
    public void setTotalAmountsTaxes(String totalAmountCharged, String totalTaxAmount) {

        this.totalAmountCharged = totalAmountCharged;
        this.totalTaxAmount = totalTaxAmount;
    }

    /**
     * Sets code (pricepoints) field
     *
     * @param code
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * Sets originalServerReferenceCode (payment transactionId) field
     *
     * @param originalServerReferenceCode
     */
    public void setOriginalServerReferenceCode(String originalServerReferenceCode) {

        this.originalServerReferenceCode = originalServerReferenceCode;
    }

    /**
     * Sets serverReferenceCode (correlatorId-externalTransactionId in refunds)
     *
     * @param serverReferenceCode
     */
    public void setServerReferenceCode(String serverReferenceCode) {

        this.serverReferenceCode = serverReferenceCode;
    }

    /**
     * Sets resultCode field (from broker enabler)
     *
     * @param resultCode
     */
    public void setResultCode(String resultCode) {

        this.resultCode = resultCode;
    }

    /**
     * Sets paymentMethod fields (type, id, maskedAccountNumber, cvv)
     *
     * @param type
     * @param id
     * @param maskedAccountNumber
     * @param cvv
     */
    public void setPaymentMethod(String type, String id, String maskedAccountNumber, String cvv) {

        this.paymentMethodType = type;
        this.paymentMethodId = id;
        this.paymentMethodMaskedAccountNumber = maskedAccountNumber;
        this.paymentMethodCvv = cvv;
    }

    /**
     * Sets merchantId field
     *
     * @param merchantId
     */
    public void setMerchantId(String merchantId) {

        this.merchantId = merchantId;
    }

    /**
     * Sets channel field
     *
     * @param channel
     */
    public void setChannel(String channel) {

        this.channel = channel;
    }

    /**
     * Sets product fields (productId & productClass)
     * 
     * @param productId
     * @param productClass
     */
	public void setProduct(String productId, String productClass) {
		this.productId = productId;
		this.productClass = productClass;
	}    

	/**
	 * Sets redirectURL field
	 * 
	 * @param url
	 */
	public void setResourceURL(String url) {
		this.resourceURL = url;
	}
	
	/**
	 * Sets callbackURL field
	 * 
	 * @param url
	 */
	public void setCallbackUrl(String url) {
		this.callbackUrl = url;
	}
	
    /**
     * @return the additionalData
     */
    public List<NameValuePairType> getAdditionalData() {

        return additionalData;
    }

    /**
     * @param additionalData the additionalData to set
     */
    public void setAdditionalData(List<NameValuePairType> additionalData) {

        this.additionalData = additionalData;
    }
    
	/**
	 * Sets callbackURL field
	 * 
	 * @param url
	 */
	public void setClientDate(XMLGregorianCalendar clientDate) {
		this.clientDate = clientDate;
	}
    
}
