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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AvailablePurchaseModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AvailablePurchaseModelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purchaseCode" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PurchaseCodeType"/>
 *         &lt;element name="description" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}DescriptionType"/>
 *         &lt;element name="promotional" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validityStartType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validityStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validityEndType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validityUnits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="validityEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="purchaseCostUnitValue" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PriceType" minOccurs="0"/>
 *         &lt;element name="thresholdInformation" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ThresholdInformationType" minOccurs="0"/>
 *         &lt;element name="renewalInformation" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}RenewalInformationType" minOccurs="0"/>
 *         &lt;element name="otherEvents" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}EventsListType" minOccurs="0"/>
 *         &lt;element name="purchaseModelInfo" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PurchaseModelType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailablePurchaseModelType", propOrder = {
    "purchaseCode",
    "description",
    "promotional",
    "startDate",
    "endDate",
    "validityStartType",
    "validityStartDate",
    "validityEndType",
    "validityUnits",
    "validityEndDate",
    "purchaseCostUnitValue",
    "thresholdInformation",
    "renewalInformation",
    "otherEvents",
    "purchaseModelInfo"
})
public class AvailablePurchaseModelType {

    protected int purchaseCode;
    @XmlElement(required = true)
    protected String description;
    protected Integer promotional;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected int validityStartType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validityStartDate;
    protected int validityEndType;
    protected Integer validityUnits;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validityEndDate;
    protected PriceType purchaseCostUnitValue;
    protected ThresholdInformationType thresholdInformation;
    protected RenewalInformationType renewalInformation;
    protected EventsListType otherEvents;
    @XmlElement(required = true)
    protected PurchaseModelType purchaseModelInfo;

    /**
     * Gets the value of the purchaseCode property.
     * 
     */
    public int getPurchaseCode() {
        return purchaseCode;
    }

    /**
     * Sets the value of the purchaseCode property.
     * 
     */
    public void setPurchaseCode(int value) {
        this.purchaseCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the promotional property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPromotional() {
        return promotional;
    }

    /**
     * Sets the value of the promotional property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPromotional(Integer value) {
        this.promotional = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the validityStartType property.
     * 
     */
    public int getValidityStartType() {
        return validityStartType;
    }

    /**
     * Sets the value of the validityStartType property.
     * 
     */
    public void setValidityStartType(int value) {
        this.validityStartType = value;
    }

    /**
     * Gets the value of the validityStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityStartDate() {
        return validityStartDate;
    }

    /**
     * Sets the value of the validityStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityStartDate(XMLGregorianCalendar value) {
        this.validityStartDate = value;
    }

    /**
     * Gets the value of the validityEndType property.
     * 
     */
    public int getValidityEndType() {
        return validityEndType;
    }

    /**
     * Sets the value of the validityEndType property.
     * 
     */
    public void setValidityEndType(int value) {
        this.validityEndType = value;
    }

    /**
     * Gets the value of the validityUnits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValidityUnits() {
        return validityUnits;
    }

    /**
     * Sets the value of the validityUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValidityUnits(Integer value) {
        this.validityUnits = value;
    }

    /**
     * Gets the value of the validityEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidityEndDate() {
        return validityEndDate;
    }

    /**
     * Sets the value of the validityEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidityEndDate(XMLGregorianCalendar value) {
        this.validityEndDate = value;
    }

    /**
     * Gets the value of the purchaseCostUnitValue property.
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getPurchaseCostUnitValue() {
        return purchaseCostUnitValue;
    }

    /**
     * Sets the value of the purchaseCostUnitValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setPurchaseCostUnitValue(PriceType value) {
        this.purchaseCostUnitValue = value;
    }

    /**
     * Gets the value of the thresholdInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ThresholdInformationType }
     *     
     */
    public ThresholdInformationType getThresholdInformation() {
        return thresholdInformation;
    }

    /**
     * Sets the value of the thresholdInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThresholdInformationType }
     *     
     */
    public void setThresholdInformation(ThresholdInformationType value) {
        this.thresholdInformation = value;
    }

    /**
     * Gets the value of the renewalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RenewalInformationType }
     *     
     */
    public RenewalInformationType getRenewalInformation() {
        return renewalInformation;
    }

    /**
     * Sets the value of the renewalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenewalInformationType }
     *     
     */
    public void setRenewalInformation(RenewalInformationType value) {
        this.renewalInformation = value;
    }

    /**
     * Gets the value of the otherEvents property.
     * 
     * @return
     *     possible object is
     *     {@link EventsListType }
     *     
     */
    public EventsListType getOtherEvents() {
        return otherEvents;
    }

    /**
     * Sets the value of the otherEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventsListType }
     *     
     */
    public void setOtherEvents(EventsListType value) {
        this.otherEvents = value;
    }

    /**
     * Gets the value of the purchaseModelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseModelType }
     *     
     */
    public PurchaseModelType getPurchaseModelInfo() {
        return purchaseModelInfo;
    }

    /**
     * Sets the value of the purchaseModelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseModelType }
     *     
     */
    public void setPurchaseModelInfo(PurchaseModelType value) {
        this.purchaseModelInfo = value;
    }

}