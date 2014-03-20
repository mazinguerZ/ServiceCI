/*
 * neoSDP (API management layer for Telefonica enablers) Copyright (c) 2011 Telefonica I+D
 */
package es.tid.neosdp.payment.builders.bable;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.telefonica.schemas.unica.rest.transactionstorage.extensions.v2_1.BableAdditionalChargingMetaData;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.AmountTransactionType;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.ChargingInformationType;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.ChargingMetaDataType;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.ObjectFactory;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.PaymentAmountType;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.PaymentMethodType;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.TransactionOperationStatusType;
import com.telefonica.schemas.unica.rest.transactionstorage.v2_1.TransactionOperationTypeType;
import com.telefonica.schemas.unica.rest.common.v2.ExtensionType;

import es.tid.neosdp.bluevia.payment.JAXBTransactionStorageExtensionv2_1RestContextSingleton;
import es.tid.neosdp.bluevia.payment.JAXBTransactionStoragev2_1RestContextSingleton;

/**
 * Generates an amountTransaction body Request for B-able
 *
 * @author rps
 * @author juanc352 (jchernandez@full-on-net.com)
 */
public class AmountTransactionTxBuilder extends AmountTransactionBuilder{

    private final ObjectFactory oF;

    /**
     * Logger
     */
    private final static Logger logger = Logger.getLogger(AmountTransactionTxBuilder.class.getName());
    
    /**
     * Default value for OperatorId (mandatory) field in Bable
     */
    //private final  String DEFAULT_VALUE_OPERATOR_ID = "";

    /**
     * Default value for CountryId (mandatory) field in Bable
     */
    //private final  String DEFAULT_VALUE_COUNTRY_ID = "";

    public static final String DIRECTTOBILL = "directToBill";

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
    public AmountTransactionTxBuilder(String userId, List<String> descriptionList, String referenceCode,
    		String serviceId, String applicationId, String servingOB) {
    	
    	super(userId, descriptionList, referenceCode, serviceId, applicationId, servingOB);
        oF = new ObjectFactory();
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
    public AmountTransactionTxBuilder(String userId, String description, String referenceCode,
    		String serviceId, String applicationId, String servingOB) {

    	super(userId, description, referenceCode, serviceId, applicationId, servingOB);
    	oF = new ObjectFactory();
    }

    /**
     * Sets AmountTransaction status
     *
     * @param status
     */
    public void setStatus(TransactionOperationStatusType status) {

        amountTransaction.setTxStatus(status);
    }
    
    /**
     * Sets AmountTransaction type
     *
     * @param type
     */
    public void setType(TransactionOperationTypeType type) {

        amountTransaction.setTxType(type);
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
     * marshals the AmountTransaction xml to a string using JAXB
     *
     * @param logger
     * @return
     * @throws Exception
     */
    public String marshalToString() throws Exception {

        try {
            logger.fine(this.getClass().getName() + ": Marshalling");

            // marshall JAXB object, so we get the body
            JAXBContext context = JAXBTransactionStoragev2_1RestContextSingleton.getJAXBContext();
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

        ChargingInformationType chargingInfoT = new ChargingInformationType();
        setChargingInfo(chargingInfoT);
        paymentAT.setChargingInformation(chargingInfoT);
        
        //information from eBC response
        if (amountTransaction.totalAmountCharged != null)
        	paymentAT.setTotalAmountCharged(new BigDecimal(amountTransaction.totalAmountCharged));
        if (amountTransaction.totalTaxAmount != null)
        	paymentAT.setTotalTaxAmount(new BigDecimal(amountTransaction.totalTaxAmount));
        
        ChargingMetaDataType chargingMDT = new ChargingMetaDataType();
        setChargingMetaData(chargingMDT);

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

        // amountTT.setServerReferenceCode(""); //es el correlatorId + externalTxId //PUT

        // para Update (PUT)
        if (amountTransaction.serverReferenceCode != null)
            amountTT.setServerReferenceCode(amountTransaction.serverReferenceCode);
        // en el refund
        if (amountTransaction.originalServerReferenceCode != null)
            amountTT.setOriginalServerReferenceCode(amountTransaction.originalServerReferenceCode);

        return amountTT;
    }

    private Document getGretaAdditionalChargingMetaData() throws Exception {

    	Document doc = null;
        com.telefonica.schemas.unica.rest.transactionstorage.extensions.v2_1.ObjectFactory oFgreta = new com.telefonica.schemas.unica.rest.transactionstorage.extensions.v2_1.ObjectFactory();
        BableAdditionalChargingMetaData gretaAdditionalChargingMetadata = 
        		oFgreta.createBableAdditionalChargingMetaData();
        /*
        if (amountTransaction.servingOB != null && !amountTransaction.servingOB.isEmpty()) {
            gretaAdditionalChargingMetadata.setCountryId(amountTransaction.servingOB.substring(0, 3));
            gretaAdditionalChargingMetadata.setOperatorId(amountTransaction.servingOB.substring(3));
        }
        else{
        	gretaAdditionalChargingMetadata.setCountryId(DEFAULT_VALUE_COUNTRY_ID);
        	gretaAdditionalChargingMetadata.setOperatorId(DEFAULT_VALUE_OPERATOR_ID);
        }
        */

        if (amountTransaction.resultCode != null) {
            gretaAdditionalChargingMetadata.setPaymentBrokerResultCode(amountTransaction.resultCode);
        }

        if(amountTransaction.additionalData!=null){
            gretaAdditionalChargingMetadata.getAdditionalData().addAll(amountTransaction.additionalData);
        }

        try {
            logger.fine(this.getClass().getName() + ": Marshalling GretaAdditionalChargingMetaData");

            JAXBContext context = JAXBTransactionStorageExtensionv2_1RestContextSingleton.getJAXBContext();
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
}
