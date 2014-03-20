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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdatePlanTopUpSettingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatePlanTopUpSettingsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planRegistrationId" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}guidType" minOccurs="0"/>
 *         &lt;element name="autoTopUp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="autoTopUpAmount" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}CurrencyAmountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdatePlanTopUpSettingsType", propOrder = {
    "userId",
    "planRegistrationId",
    "autoTopUp",
    "autoTopUpAmount"
})
public class UpdatePlanTopUpSettingsType {

    @XmlElementRef(name = "userId", namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1", type = JAXBElement.class)
    protected JAXBElement<String> userId;
    protected String planRegistrationId;
    @XmlElementRef(name = "autoTopUp", namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1", type = JAXBElement.class)
    protected JAXBElement<Boolean> autoTopUp;
    @XmlElementRef(name = "autoTopUpAmount", namespace = "http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1", type = JAXBElement.class)
    protected JAXBElement<CurrencyAmountType> autoTopUpAmount;

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
     * Gets the value of the planRegistrationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanRegistrationId() {
        return planRegistrationId;
    }

    /**
     * Sets the value of the planRegistrationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanRegistrationId(String value) {
        this.planRegistrationId = value;
    }

    /**
     * Gets the value of the autoTopUp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getAutoTopUp() {
        return autoTopUp;
    }

    /**
     * Sets the value of the autoTopUp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setAutoTopUp(JAXBElement<Boolean> value) {
        this.autoTopUp = ((JAXBElement<Boolean> ) value);
    }

    /**
     * Gets the value of the autoTopUpAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CurrencyAmountType }{@code >}
     *     
     */
    public JAXBElement<CurrencyAmountType> getAutoTopUpAmount() {
        return autoTopUpAmount;
    }

    /**
     * Sets the value of the autoTopUpAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CurrencyAmountType }{@code >}
     *     
     */
    public void setAutoTopUpAmount(JAXBElement<CurrencyAmountType> value) {
        this.autoTopUpAmount = ((JAXBElement<CurrencyAmountType> ) value);
    }

}