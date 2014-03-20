//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.21 at 08:40:35 AM CEST 
//


package com.telefonica.schemas.unica.soap.charging.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.telefonica.schemas.unica.soap.common.v1.UserIdType;


/**
 * <p>Java class for SMSInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SMSInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="originatorAddress" type="{http://www.telefonica.com/schemas/UNICA/SOAP/common/v1}UserIdType" minOccurs="0"/>
 *         &lt;element name="recipientAddress" type="{http://www.telefonica.com/schemas/UNICA/SOAP/common/v1}UserIdType" minOccurs="0"/>
 *         &lt;element name="extension" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SMSInformationType", propOrder = {
    "originatorAddress",
    "recipientAddress",
    "extension"
})
public class SMSInformationType {

    protected UserIdType originatorAddress;
    protected UserIdType recipientAddress;
    protected ExtensionType extension;

    /**
     * Gets the value of the originatorAddress property.
     * 
     * @return
     *     possible object is
     *     {@link UserIdType }
     *     
     */
    public UserIdType getOriginatorAddress() {
        return originatorAddress;
    }

    /**
     * Sets the value of the originatorAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserIdType }
     *     
     */
    public void setOriginatorAddress(UserIdType value) {
        this.originatorAddress = value;
    }

    /**
     * Gets the value of the recipientAddress property.
     * 
     * @return
     *     possible object is
     *     {@link UserIdType }
     *     
     */
    public UserIdType getRecipientAddress() {
        return recipientAddress;
    }

    /**
     * Sets the value of the recipientAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserIdType }
     *     
     */
    public void setRecipientAddress(UserIdType value) {
        this.recipientAddress = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setExtension(ExtensionType value) {
        this.extension = value;
    }

}
