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
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.telefonica.schemas.unica.rest.bablepayment.extensions.v2_1.GretaAdditionalChargingMetaData;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.AmountTransactionType;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.ChargingInformationType;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.ChargingMetaDataType;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.ObjectFactory;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.PaymentAmountType;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.PaymentMethodType;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.TransactionOperationStatusType;
import com.telefonica.schemas.unica.rest.bablepayment.v2_1.TransactionOperationTypeType;
import com.telefonica.schemas.unica.rest.common.v2.ExtensionType;

import es.tid.neosdp.bluevia.payment.JAXBBablePaymentExtensionv2_1RestContextSingleton;
import es.tid.neosdp.bluevia.payment.JAXBBablePaymentv2_1RestContextSingleton;

/**
 * Generates an amountTransaction body Request for B-able
 *
 * @author rps
 * @author juanc352 (jchernandez@full-on-net.com)
 */
public class AmountTransactionv1Builder extends AmountTransactionBuilder{

    private final ObjectFactory oF;

    /**
     * Logger
     */
    private final static Logger logger = Logger.getLogger(AmountTransactionv1Builder.class.getName());
    
    /**
     * Default value for OperatorId (mandatory) field in Bable
     */
    //private final  String DEFAULT_VALUE_OPERATOR_ID = ""; //TGA

    /**
     * Default value for CountryId (mandatory) field in Bable
     */
    //private final  String DEFAULT_VALUE_COUNTRY_ID = ""; //ESP

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
    public AmountTransactionv1Builder(String userId, List<String> descriptionList, String referenceCode,
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
    public AmountTransactionv1Builder(String userId, String description, String referenceCode,
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

        amountTransaction.setPayStatus(status);
    }
    
    /**
     * Sets AmountTransaction type
     *
     * @param type
     */
    public void setType(TransactionOperationTypeType type) {

        amountTransaction.setPayType(type);
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
            JAXBContext context = JAXBBablePaymentv2_1RestContextSingleton.getJAXBContext();
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
        paymentMethodType.setType(amountTransaction.paymentMethodType);
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


        paymentAT.setChargingMetaData(chargingMDT);

        amountTT.setPaymentAmount(paymentAT);

        amountTT.setTransactionOperationType(amountTransaction.pay_type);

        // Information describing the transaction status.
        amountTT.setTransactionOperationStatus(amountTransaction.pay_status);

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
        com.telefonica.schemas.unica.rest.bablepayment.extensions.v2_1.ObjectFactory oFgreta = new com.telefonica.schemas.unica.rest.bablepayment.extensions.v2_1.ObjectFactory();
        GretaAdditionalChargingMetaData gretaAdditionalChargingMetadata = 
        		oFgreta.createGretaAdditionalChargingMetaData();
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

        if(amountTransaction.additionalData!=null){
            gretaAdditionalChargingMetadata.getAdditionalData().addAll(amountTransaction.additionalData);
        }

        try {
            logger.fine(this.getClass().getName() + ": Marshalling GretaAdditionalChargingMetaData");

            JAXBContext context = JAXBBablePaymentExtensionv2_1RestContextSingleton.getJAXBContext();
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
