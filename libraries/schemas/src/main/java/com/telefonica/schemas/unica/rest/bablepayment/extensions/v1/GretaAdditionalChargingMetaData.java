//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.31 at 09:34:19 AM CEST 
//


package com.telefonica.schemas.unica.rest.bablepayment.extensions.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.telefonica.schemas.unica.rest.common.v2.NameValuePairType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="countryId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="additionalData" type="{http://www.telefonica.com/schemas/UNICA/REST/common/v2}NameValuePairType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="operationDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="taxApplied" type="{http://www.telefonica.com/schemas/UNICA/REST/bablePayment/extensions/v1/}AmountVariationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operatorId",
    "countryId",
    "additionalData",
    "operationDescription",
    "taxApplied"
})
@XmlRootElement(name = "gretaAdditionalChargingMetaData")
public class GretaAdditionalChargingMetaData {

    @XmlElement(required = true)
    protected String operatorId;
    @XmlElement(required = true)
    protected String countryId;
    protected List<NameValuePairType> additionalData;
    protected String operationDescription;
    protected List<AmountVariationType> taxApplied;

    /**
     * Gets the value of the operatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * Sets the value of the operatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * Gets the value of the countryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * Sets the value of the countryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryId(String value) {
        this.countryId = value;
    }

    /**
     * Gets the value of the additionalData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameValuePairType }
     * 
     * 
     */
    public List<NameValuePairType> getAdditionalData() {
        if (additionalData == null) {
            additionalData = new ArrayList<NameValuePairType>();
        }
        return this.additionalData;
    }

    /**
     * Gets the value of the operationDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationDescription() {
        return operationDescription;
    }

    /**
     * Sets the value of the operationDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationDescription(String value) {
        this.operationDescription = value;
    }

    /**
     * Gets the value of the taxApplied property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxApplied property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxApplied().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountVariationType }
     * 
     * 
     */
    public List<AmountVariationType> getTaxApplied() {
        if (taxApplied == null) {
            taxApplied = new ArrayList<AmountVariationType>();
        }
        return this.taxApplied;
    }

}