//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.23 at 12:20:24 PM CEST 
//


package com.telefonica.schemas.unica.rest.transactionstorage.v2_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.schemas.unica.rest.transactionstorage.v2_1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AmountTransaction_QNAME = new QName("http://www.telefonica.com/schemas/UNICA/REST/transactionStorage/v2_1/", "amountTransaction");
    private final static QName _PaymentTransactionList_QNAME = new QName("http://www.telefonica.com/schemas/UNICA/REST/transactionStorage/v2_1/", "paymentTransactionList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.schemas.unica.rest.transactionstorage.v2_1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentTransactionListType }
     * 
     */
    public PaymentTransactionListType createPaymentTransactionListType() {
        return new PaymentTransactionListType();
    }

    /**
     * Create an instance of {@link AmountTransactionType }
     * 
     */
    public AmountTransactionType createAmountTransactionType() {
        return new AmountTransactionType();
    }

    /**
     * Create an instance of {@link ChargingInformationType }
     * 
     */
    public ChargingInformationType createChargingInformationType() {
        return new ChargingInformationType();
    }

    /**
     * Create an instance of {@link PaymentAmountType }
     * 
     */
    public PaymentAmountType createPaymentAmountType() {
        return new PaymentAmountType();
    }

    /**
     * Create an instance of {@link ChargingMetaDataType }
     * 
     */
    public ChargingMetaDataType createChargingMetaDataType() {
        return new ChargingMetaDataType();
    }

    /**
     * Create an instance of {@link PaymentMethodType }
     * 
     */
    public PaymentMethodType createPaymentMethodType() {
        return new PaymentMethodType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountTransactionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.telefonica.com/schemas/UNICA/REST/transactionStorage/v2_1/", name = "amountTransaction")
    public JAXBElement<AmountTransactionType> createAmountTransaction(AmountTransactionType value) {
        return new JAXBElement<AmountTransactionType>(_AmountTransaction_QNAME, AmountTransactionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentTransactionListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.telefonica.com/schemas/UNICA/REST/transactionStorage/v2_1/", name = "paymentTransactionList")
    public JAXBElement<PaymentTransactionListType> createPaymentTransactionList(PaymentTransactionListType value) {
        return new JAXBElement<PaymentTransactionListType>(_PaymentTransactionList_QNAME, PaymentTransactionListType.class, null, value);
    }

}
