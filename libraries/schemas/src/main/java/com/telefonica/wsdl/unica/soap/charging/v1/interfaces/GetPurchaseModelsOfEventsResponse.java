//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.21 at 08:40:35 AM CEST 
//


package com.telefonica.wsdl.unica.soap.charging.v1.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.telefonica.schemas.unica.soap.charging.v1.ExtensionType;
import com.telefonica.schemas.unica.soap.charging.v1.PurchaseModelsOfEventsListType;
import com.telefonica.schemas.unica.soap.charging.v1.UnitValueType;


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
 *         &lt;element name="requestId" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}RequestIdType"/>
 *         &lt;element name="senderIdentity" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}SenderIdentityType"/>
 *         &lt;element name="resultCode" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ResultCodeType"/>
 *         &lt;element name="costBeforeTaxes" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="taxes" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}UnitValueType" minOccurs="0"/>
 *         &lt;element name="purchaseModelsOfEventsList" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PurchaseModelsOfEventsListType" minOccurs="0"/>
 *         &lt;element name="extension" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ExtensionType" maxOccurs="unbounded" minOccurs="0"/>
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
    "requestId",
    "senderIdentity",
    "resultCode",
    "costBeforeTaxes",
    "taxes",
    "purchaseModelsOfEventsList",
    "extension"
})
@XmlRootElement(name = "getPurchaseModelsOfEventsResponse")
public class GetPurchaseModelsOfEventsResponse {

    @XmlElement(required = true)
    protected String requestId;
    @XmlElement(required = true)
    protected String senderIdentity;
    protected int resultCode;
    @XmlSchemaType(name = "unsignedInt")
    protected Long costBeforeTaxes;
    protected UnitValueType taxes;
    protected PurchaseModelsOfEventsListType purchaseModelsOfEventsList;
    protected List<ExtensionType> extension;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the senderIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderIdentity() {
        return senderIdentity;
    }

    /**
     * Sets the value of the senderIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderIdentity(String value) {
        this.senderIdentity = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     */
    public void setResultCode(int value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the costBeforeTaxes property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCostBeforeTaxes() {
        return costBeforeTaxes;
    }

    /**
     * Sets the value of the costBeforeTaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCostBeforeTaxes(Long value) {
        this.costBeforeTaxes = value;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link UnitValueType }
     *     
     */
    public UnitValueType getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitValueType }
     *     
     */
    public void setTaxes(UnitValueType value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the purchaseModelsOfEventsList property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseModelsOfEventsListType }
     *     
     */
    public PurchaseModelsOfEventsListType getPurchaseModelsOfEventsList() {
        return purchaseModelsOfEventsList;
    }

    /**
     * Sets the value of the purchaseModelsOfEventsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseModelsOfEventsListType }
     *     
     */
    public void setPurchaseModelsOfEventsList(PurchaseModelsOfEventsListType value) {
        this.purchaseModelsOfEventsList = value;
    }

    /**
     * Gets the value of the extension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionType }
     * 
     * 
     */
    public List<ExtensionType> getExtension() {
        if (extension == null) {
            extension = new ArrayList<ExtensionType>();
        }
        return this.extension;
    }

}