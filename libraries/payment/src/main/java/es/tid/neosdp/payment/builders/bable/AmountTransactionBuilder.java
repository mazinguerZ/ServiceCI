/*
 * neoSDP (API management layer for Telefonica enablers) Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.payment.builders.bable;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

import com.telefonica.schemas.unica.rest.common.v2.NameValuePairType;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.ChargingInformationTypeInt;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.ChargingMetaDataTypeInt;

/**
 * Generates an amountTransaction body Request for B-able
 *
 * @author rps
 */
public abstract class AmountTransactionBuilder {

    //private final ObjectFactory oF;

    AmountTransactionData amountTransaction; 
    
    //public static final String DIRECTTOBILL = "directToBill";


    /**
     * Constructor
     *
     * @param userId
     * @param descriptionList
     * @param productId
     * @param referenceCode
     * @param serviceId
     * @param servingOB
     */
    public AmountTransactionBuilder(String userId, List<String> descriptionList, String referenceCode,
    		String serviceId, String applicationId, String servingOB) {

        //oF = new ObjectFactory();
        amountTransaction = new AmountTransactionData(userId, descriptionList, referenceCode, serviceId, applicationId, servingOB);
    }

    /**
     * Constructor
     *
     * @param userId
     * @param description
     * @param referenceCode
     * @param serviceId
     * @param applicationId
     * @param servingOB
     */
    public AmountTransactionBuilder(String userId, String description, String referenceCode,
    		String serviceId, String applicationId, String servingOB) {

        //oF = new ObjectFactory();
        ArrayList<String> descriptionList = new ArrayList<String>();
        descriptionList.add(description);
        amountTransaction = new AmountTransactionData(userId, descriptionList, referenceCode, serviceId, applicationId, servingOB);
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

        amountTransaction.setPaymentAmountsTaxes(amount, currency, totalAmount, taxAmount, v1taxes);
    }

    /**
     * Sets totalAmountCharged & totalTaxAmount
     *
     * @param totalAmountCharged
     * @param totalTaxAmount
     */
    public void setTotalAmountsTaxes(String totalAmountCharged, String totalTaxAmount) {

    	amountTransaction.setTotalAmountsTaxes(totalAmountCharged, totalTaxAmount);
    }

    /**
     * Sets code (pricepoints) field
     *
     * @param code
     */
    public void setCode(String code) {

        amountTransaction.setCode(code);
    }

    /**
     * Sets originalServerReferenceCode (payment transactionId) field
     *
     * @param originalServerReferenceCode
     */
    public void setOriginalServerReferenceCode(String originalServerReferenceCode) {

        amountTransaction.setOriginalServerReferenceCode(originalServerReferenceCode);
    }

    /**
     * Sets serverReferenceCode (correlatorId-externalTransactionId in refunds)
     *
     * @param serverReferenceCode
     */
    public void setServerReferenceCode(String serverReferenceCode) {

        amountTransaction.setServerReferenceCode(serverReferenceCode);
    }

    /**
     * Sets resultCode field (from broker enabler)
     *
     * @param resultCode
     */
    public void setResultCode(String resultCode) {

        amountTransaction.setResultCode(resultCode);
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

        amountTransaction.setPaymentMethod(type, id, maskedAccountNumber, cvv);
    }

    /**
     * Sets merchantId field
     *
     * @param merchantId
     */
    public void setMerchantId(String merchantId) {

        amountTransaction.setMerchantId(merchantId);
    }

    /**
     * Sets channel field
     *
     * @param channel
     */
    public void setChannel(String channel) {

        amountTransaction.setChannel(channel);
    }

    /**
     * Sets product fields (productId & productClass)
     *
     * @param productId
     * @param productClass
     */
    public void setProduct(String productId, String productClass) {

        amountTransaction.setProduct(productId, productClass);
    }

    /**
     * Sets resourceURL field
     *
     * @param merchantId
     */
    public void setResourceURL(String url) {

        amountTransaction.setResourceURL(url);
    }

    /**
     * Sets callbakUrl field
     *
     * @param merchantId
     */
    public void setCallbackUrl(String url) {

        amountTransaction.setCallbackUrl(url);
    }

    /**
     * Sets BableAdditionalChargingMetaData field
     *
     * @param additionalData
     */
    public void setAdditionalData(List<NameValuePairType> additionalData) {

        amountTransaction.setAdditionalData(additionalData);
    }

    /**
     * Sets ClientDate field
     *
     * @param merchantId
     */
    public void setClientDate(XMLGregorianCalendar clientDate) {

        amountTransaction.setClientDate(clientDate);
    }

    /**
     * sets ChargingInformation: holds the charge with amount, currency and description text
     * 
     * @param chargingInfoT
     */
    protected <T extends ChargingInformationTypeInt> void setChargingInfo(T chargingInfoT){
    	
	    // Description: The first entry of a list will often be used to provide billing text
	    List<String> descriptionList = chargingInfoT.getDescription();
	    descriptionList.addAll(amountTransaction.description);
	
	    // Amount to be charged. It requires one of the next combination to work: Code | Amount (+ currency)
	    if (amountTransaction.totalAmount != null && !amountTransaction.totalAmount.isEmpty()) {
	        chargingInfoT.setTotalAmount(new BigDecimal(amountTransaction.totalAmount));
	        chargingInfoT.setCurrency(amountTransaction.currency);
	        if (amountTransaction.taxAmount != null && !amountTransaction.taxAmount.isEmpty())
	        	chargingInfoT.setTaxAmount(new BigDecimal(amountTransaction.taxAmount));
	        if (amountTransaction.amount != null && !amountTransaction.amount.isEmpty())
	        	chargingInfoT.setAmount(new BigDecimal(amountTransaction.amount));
	    } else if (amountTransaction.amount != null && !amountTransaction.amount.isEmpty()) {
	        chargingInfoT.setAmount(new BigDecimal(amountTransaction.amount));
	        chargingInfoT.setCurrency(amountTransaction.currency);
	        if (amountTransaction.v1taxes != null && !amountTransaction.v1taxes.isEmpty()) {
	            Double taxesAmount = (Double.parseDouble(amountTransaction.v1taxes) / 100.)
	                    * Double.parseDouble(amountTransaction.amount);
	            DecimalFormat dFormat = new DecimalFormat("00.#######");
	            chargingInfoT.setTaxAmount(new BigDecimal(dFormat.format(taxesAmount)));
	        }
	    } else {
	        chargingInfoT.setCode(amountTransaction.code);
	    }
    }
    
    /**
     * sets ChargingMatadata
     * 
     * @param chargingInfoT
     */
    protected <T extends ChargingMetaDataTypeInt> void setChargingMetaData(T chargingMDT) {
    	
        chargingMDT.setServiceId(amountTransaction.serviceId);
        chargingMDT.setApplicationId(amountTransaction.applicationId);

        if (amountTransaction.productId != null)
        	chargingMDT.setProductId(amountTransaction.productId); // ProductId en v2. En v1 no hay ??
        
        if (amountTransaction.productClass != null)
        	chargingMDT.setProductClass(amountTransaction.productClass);

        if (amountTransaction.merchantId != null)
            chargingMDT.setMerchantId(amountTransaction.merchantId);

        if (amountTransaction.channel != null)
            chargingMDT.setChannel(amountTransaction.channel);
    }
    
    /**
     * marshals the AmountTransaction xml to a string using JAXB
     *
     * @param logger
     * @return
     * @throws Exception
     */
    /*
    public String marshalToString() throws Exception {

        try {
            logger.fine(this.getClass().getName() + ": Marshalling");

            // marshall JAXB object, so we get the body
            JAXBContext context = JAXBTransactionStoragev1RestContextSingleton.getJAXBContext();
            Marshaller marshaller = context.createMarshaller();

            // logger.fine(this.className + ": createMarshaller() done");

            OutputStream oS = new ByteArrayOutputStream();
            // logger.debug(this.className + ": marshal 1");
            JAXBElement<AmountTransactionType> amountT = oF.createAmountTransaction(getCreateAmountTransactionType());
            // logger.debug(this.className + ": marshal 2");
            marshaller.marshal(amountT, oS);
            // logger.fine(this.className + ": marshaled");

            return oS.toString();
        } catch (Exception e) {
            logger.severe(this.getClass().getName() + ": " + e.getMessage());
            logger.severe(this.getClass().getName() + ":" + e.toString());
            e.printStackTrace();
            throw new Exception("Marshaling error :"+e.getMessage());
        }

    }
	*/
    
    /*
    private AmountTransactionType getCreateAmountTransactionType() throws Exception {

        // ##Prepare Greta amountTransaction request##
        AmountTransactionType amountTT = oF.createAmountTransactionType();

        // End user's account to be charged.
        // logger.fine("userId: " + amountTransaction.userId);
        amountTT.setEndUserId(amountTransaction.userId); // TODO: Deberia ir con tel: ??

        if (amountTransaction.resourceURL != null) {
        	//TODO: esto puede que no sea asi
        	amountTT.setResourceURL(amountTransaction.resourceURL);
        }
        if (amountTransaction.callbackUrl != null) {
        	amountTT.setCallbackUrl(amountTransaction.callbackUrl);
        }

        // Information on the amount charge to be made
        PaymentAmountType paymentAT = new PaymentAmountType();

        // ChargingInformation: holds the charge with amount, currency and description text
        ChargingInformationType chargingInfoT = new ChargingInformationType();
        ChargingMetaDataType chargingMDT = new ChargingMetaDataType();
        // Description: The first entry of a list will often be used to provide billing text
        List<String> descriptionList = chargingInfoT.getDescription();
        descriptionList.addAll(amountTransaction.description);

        // Amount to be charged. It requires one of the next combination to work: Code | Amount (+ currency)
        if (amountTransaction.totalAmount != null && !amountTransaction.totalAmount.isEmpty()) {
            chargingInfoT.setTotalAmount(new BigDecimal(amountTransaction.totalAmount));
            chargingInfoT.setCurrency(amountTransaction.currency);
            if (amountTransaction.taxAmount != null && !amountTransaction.taxAmount.isEmpty())
            	chargingInfoT.setTaxAmount(new BigDecimal(amountTransaction.taxAmount));
            if (amountTransaction.amount != null && !amountTransaction.amount.isEmpty())
            	chargingInfoT.setAmount(new BigDecimal(amountTransaction.amount));
        } else if (amountTransaction.amount != null && !amountTransaction.amount.isEmpty()) {
            chargingInfoT.setAmount(new BigDecimal(amountTransaction.amount));
            chargingInfoT.setCurrency(amountTransaction.currency);
            if (amountTransaction.v1taxes != null && !amountTransaction.v1taxes.isEmpty()) {
                Double taxesAmount = (Double.parseDouble(amountTransaction.v1taxes) / 100.)
                        * Double.parseDouble(amountTransaction.amount);
                DecimalFormat dFormat = new DecimalFormat("00.#######");
                chargingInfoT.setTaxAmount(new BigDecimal(dFormat.format(taxesAmount)));
            }
        } else {
            chargingInfoT.setCode(amountTransaction.code);
        }
        paymentAT.setChargingInformation(chargingInfoT);

        //information from eBC response
        if (amountTransaction.totalAmountCharged != null)
        	paymentAT.setTotalAmountCharged(new BigDecimal(amountTransaction.totalAmountCharged));
        if (amountTransaction.totalTaxAmount != null)
        	paymentAT.setTotalTaxAmount(new BigDecimal(amountTransaction.totalTaxAmount));

        chargingMDT.setServiceId(amountTransaction.serviceId);
        //applicationId
        chargingMDT.setApplicationId(amountTransaction.applicationId);

        if (amountTransaction.productId != null) {
        	chargingMDT.setProductId(amountTransaction.productId); // ProductId en v2. En v1 no hay ??
        }
        if (amountTransaction.productClass != null) {
        	chargingMDT.setProductClass(amountTransaction.productClass);
        }

        if (amountTransaction.merchantId != null) {
            chargingMDT.setMerchantId(amountTransaction.merchantId);
        }

        if (amountTransaction.channel != null) {
            chargingMDT.setChannel(amountTransaction.channel);
        }

        PaymentMethodType paymentMethodType = new PaymentMethodType();
        if (amountTransaction.paymentMethodType != null)
        	paymentMethodType.setType(amountTransaction.paymentMethodType);
        else
        	paymentMethodType.setType(DIRECTTOBILL); // Por defecto es diretToBill si no se indica
        logger.fine(this.getClass().getName() + ": paymentMethodType: " + amountTransaction.paymentMethodType);
        if (amountTransaction.paymentMethodId != null)
        	paymentMethodType.setId(amountTransaction.paymentMethodId);
        if (amountTransaction.paymentMethodMaskedAccountNumber != null)
        	paymentMethodType.setMaskedAccountNumber(amountTransaction.paymentMethodMaskedAccountNumber);
        if (amountTransaction.paymentMethodCvv != null)
        	paymentMethodType.setCvv(amountTransaction.paymentMethodCvv);
        chargingMDT.setPaymentMethod(paymentMethodType);

        // Adding the element to extensionType
        ExtensionType extensionType = new ExtensionType();
        Document doc = getGretaAdditionalChargingMetaData();
        Element rootEle = doc.getDocumentElement();
        extensionType.getAny().add(rootEle);

        chargingMDT.setAdditionalChargingMetaData(extensionType);

        if (amountTransaction.clientDate != null)
        	chargingMDT.setClientDate(amountTransaction.clientDate);

        paymentAT.setChargingMetaData(chargingMDT);

        amountTT.setPaymentAmount(paymentAT);

        amountTT.setTransactionOperationType(amountTransaction.tx_type);

        // Information describing the transaction status.
        amountTT.setTransactionOperationStatus(amountTransaction.tx_status);

        // amountTT.setTransactionOperationStatusDescription("");

        // Textual information to uniquely identify the request inside a specific service
        // (generated by app)
        amountTT.setReferenceCode(amountTransaction.referenceCode);

        // amountTT.setServerReferenceCode(""); //es el correlatorId + externalTxId //2� PUT

        // para Update (PUT)
        if (amountTransaction.serverReferenceCode != null)
            amountTT.setServerReferenceCode(amountTransaction.serverReferenceCode);
        // en el refund
        if (amountTransaction.originalServerReferenceCode != null)
            amountTT.setOriginalServerReferenceCode(amountTransaction.originalServerReferenceCode);

        return amountTT;
    }
    */

    /*
    private Document getGretaAdditionalChargingMetaData() throws Exception {

    	Document doc = null;
        com.telefonica.schemas.unica.rest.transactionstorage.extensions.v1.ObjectFactory oFgreta = new com.telefonica.schemas.unica.rest.transactionstorage.extensions.v1.ObjectFactory();
        BableAdditionalChargingMetaData gretaAdditionalChargingMetadata = oFgreta
                .createBableAdditionalChargingMetaData();
        if (amountTransaction.servingOB != null) {
            gretaAdditionalChargingMetadata.setCountryId(amountTransaction.servingOB.substring(0, 3));
            gretaAdditionalChargingMetadata.setOperatorId(amountTransaction.servingOB.substring(3));
        }
        else{
            gretaAdditionalChargingMetadata.setCountryId("");
            gretaAdditionalChargingMetadata.setOperatorId("");
        }

        if (amountTransaction.resultCode != null) {
            gretaAdditionalChargingMetadata.setPaymentBrokerResultCode(amountTransaction.resultCode);
        }

        if(amountTransaction.additionalData!=null){
            gretaAdditionalChargingMetadata.getAdditionalData().addAll(amountTransaction.additionalData);
        }

        try {
            logger.fine(this.getClass().getName() + ": Marshalling GretaAdditionalChargingMetaData");

            JAXBContext context = JAXBTransactionStorageExtensionv1RestContextSingleton.getJAXBContext();
            Marshaller marshaller = context.createMarshaller();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            doc = dbf.newDocumentBuilder().newDocument();

            marshaller.marshal(gretaAdditionalChargingMetadata, doc);
            logger.fine(this.getClass().getName() + ":GretaAdditionalChargingMetaData marshaled");
            return doc;
        } catch (Exception e) {
            logger.severe(this.getClass().getName() + ": " + e.getMessage());
            logger.severe(this.getClass().getName() + ": " + e.toString());
            e.printStackTrace();
            throw new Exception(this.getClass().getName() + " :" +e.getMessage());
        }
    }
    */
}
