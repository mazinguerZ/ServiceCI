//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.21 at 08:40:35 AM CEST 
//


package com.telefonica.schemas.unica.soap.charging.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplicationControlsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplicationControlsResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicationID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="applicationUserLimit" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PriceType" minOccurs="0"/>
 *         &lt;element name="applicationUserExpenses" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PriceType" minOccurs="0"/>
 *         &lt;element name="applicationThresholdsList" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ThresholdsListResponseType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationControlsResponseType", propOrder = {
    "applicationID",
    "applicationUserLimit",
    "applicationUserExpenses",
    "applicationThresholdsList"
})
public class ApplicationControlsResponseType {

    protected int applicationID;
    protected PriceType applicationUserLimit;
    protected PriceType applicationUserExpenses;
    @XmlElement(required = true)
    protected ThresholdsListResponseType applicationThresholdsList;

    /**
     * Gets the value of the applicationID property.
     * 
     */
    public int getApplicationID() {
        return applicationID;
    }

    /**
     * Sets the value of the applicationID property.
     * 
     */
    public void setApplicationID(int value) {
        this.applicationID = value;
    }

    /**
     * Gets the value of the applicationUserLimit property.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getApplicationUserLimit() {
        return applicationUserLimit;
    }

    /**
     * Sets the value of the applicationUserLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setApplicationUserLimit(PriceType value) {
        this.applicationUserLimit = value;
    }

    /**
     * Gets the value of the applicationUserExpenses property.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getApplicationUserExpenses() {
        return applicationUserExpenses;
    }

    /**
     * Sets the value of the applicationUserExpenses property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setApplicationUserExpenses(PriceType value) {
        this.applicationUserExpenses = value;
    }

    /**
     * Gets the value of the applicationThresholdsList property.
     * 
     * @return
     *     possible object is
     *     {@link ThresholdsListResponseType }
     *     
     */
    public ThresholdsListResponseType getApplicationThresholdsList() {
        return applicationThresholdsList;
    }

    /**
     * Sets the value of the applicationThresholdsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThresholdsListResponseType }
     *     
     */
    public void setApplicationThresholdsList(ThresholdsListResponseType value) {
        this.applicationThresholdsList = value;
    }

}
