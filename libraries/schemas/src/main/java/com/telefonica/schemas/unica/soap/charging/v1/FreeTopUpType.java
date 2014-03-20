//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.09 at 09:17:46 AM CEST 
//


package com.telefonica.schemas.unica.soap.charging.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for FreeTopUpType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FreeTopUpType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updateAmount" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}CurrencyAmountType" minOccurs="0"/>
 *         &lt;element name="chargeType" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ChargeTypeTypes" minOccurs="0"/>
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="freeTopUpTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreeTopUpType", propOrder = {
    "userId",
    "updateAmount",
    "chargeType",
    "paymentDate",
    "freeTopUpTransactionId"
})
public class FreeTopUpType {

    @XmlElementRef(name = "userId", namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1", type = JAXBElement.class)
    protected JAXBElement<String> userId;
    @XmlElementRef(name = "updateAmount", namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1", type = JAXBElement.class)
    protected JAXBElement<CurrencyAmountType> updateAmount;
    protected ChargeTypeTypes chargeType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentDate;
    @XmlElementRef(name = "freeTopUpTransactionId", namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1", type = JAXBElement.class)
    protected JAXBElement<String> freeTopUpTransactionId;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserId(JAXBElement<String> value) {
        this.userId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the updateAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CurrencyAmountType }{@code >}
     *     
     */
    public JAXBElement<CurrencyAmountType> getUpdateAmount() {
        return updateAmount;
    }

    /**
     * Sets the value of the updateAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CurrencyAmountType }{@code >}
     *     
     */
    public void setUpdateAmount(JAXBElement<CurrencyAmountType> value) {
        this.updateAmount = ((JAXBElement<CurrencyAmountType> ) value);
    }

    /**
     * Gets the value of the chargeType property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeTypeTypes }
     *     
     */
    public ChargeTypeTypes getChargeType() {
        return chargeType;
    }

    /**
     * Sets the value of the chargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeTypeTypes }
     *     
     */
    public void setChargeType(ChargeTypeTypes value) {
        this.chargeType = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentDate(XMLGregorianCalendar value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the freeTopUpTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFreeTopUpTransactionId() {
        return freeTopUpTransactionId;
    }

    /**
     * Sets the value of the freeTopUpTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFreeTopUpTransactionId(JAXBElement<String> value) {
        this.freeTopUpTransactionId = ((JAXBElement<String> ) value);
    }

}
