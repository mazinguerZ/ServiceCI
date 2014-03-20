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
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.telefonica.schemas.unica.soap.charging.v1.EventsListType;
import com.telefonica.schemas.unica.soap.charging.v1.ExtensionType;
import com.telefonica.schemas.unica.soap.charging.v1.ServiceInformationType;
import com.telefonica.schemas.unica.soap.common.v1.UserIdType;


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
 *         &lt;element name="timestamp" type="{http://www.telefonica.com/schemas/UNICA/SOAP/common/v1}TimestampType"/>
 *         &lt;element name="senderIdentity" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}SenderIdentityType"/>
 *         &lt;element name="serviceContextId" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ServiceContextIdType"/>
 *         &lt;element name="userId" type="{http://www.telefonica.com/schemas/UNICA/SOAP/common/v1}UserIdType" maxOccurs="unbounded"/>
 *         &lt;element name="operatorId" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}OperatorIdType" minOccurs="0"/>
 *         &lt;element name="subsTimeZone" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}TimeZoneType" minOccurs="0"/>
 *         &lt;element name="locTimeZone" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}TimeZoneType" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}LanguageType" minOccurs="0"/>
 *         &lt;element name="typeOfQuery" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}TypeOfQueryType" minOccurs="0"/>
 *         &lt;element name="showOtherEvents" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ShowOtherEventsType" minOccurs="0"/>
 *         &lt;element name="aggregateVouchers" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}AggregateVouchersType" minOccurs="0"/>
 *         &lt;element name="serviceInformation" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ServiceInformationType" minOccurs="0"/>
 *         &lt;element name="requestedEvents" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}EventsListType"/>
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
    "timestamp",
    "senderIdentity",
    "serviceContextId",
    "userId",
    "operatorId",
    "subsTimeZone",
    "locTimeZone",
    "language",
    "typeOfQuery",
    "showOtherEvents",
    "aggregateVouchers",
    "serviceInformation",
    "requestedEvents",
    "extension"
})
@XmlRootElement(name = "getPurchaseModelsOfEvents")
public class GetPurchaseModelsOfEvents {

    @XmlElement(required = true)
    protected String requestId;
    @XmlElement(required = true)
    protected XMLGregorianCalendar timestamp;
    @XmlElement(required = true)
    protected String senderIdentity;
    @XmlElement(required = true)
    protected String serviceContextId;
    @XmlElement(required = true)
    protected List<UserIdType> userId;
    protected String operatorId;
    protected String subsTimeZone;
    protected String locTimeZone;
    protected String language;
    protected Integer typeOfQuery;
    protected Boolean showOtherEvents;
    protected Boolean aggregateVouchers;
    protected ServiceInformationType serviceInformation;
    @XmlElement(required = true)
    protected EventsListType requestedEvents;
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
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
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
     * Gets the value of the serviceContextId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceContextId() {
        return serviceContextId;
    }

    /**
     * Sets the value of the serviceContextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceContextId(String value) {
        this.serviceContextId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserIdType }
     * 
     * 
     */
    public List<UserIdType> getUserId() {
        if (userId == null) {
            userId = new ArrayList<UserIdType>();
        }
        return this.userId;
    }

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
     * Gets the value of the subsTimeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubsTimeZone() {
        return subsTimeZone;
    }

    /**
     * Sets the value of the subsTimeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubsTimeZone(String value) {
        this.subsTimeZone = value;
    }

    /**
     * Gets the value of the locTimeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocTimeZone() {
        return locTimeZone;
    }

    /**
     * Sets the value of the locTimeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocTimeZone(String value) {
        this.locTimeZone = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the typeOfQuery property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTypeOfQuery() {
        return typeOfQuery;
    }

    /**
     * Sets the value of the typeOfQuery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTypeOfQuery(Integer value) {
        this.typeOfQuery = value;
    }

    /**
     * Gets the value of the showOtherEvents property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowOtherEvents() {
        return showOtherEvents;
    }

    /**
     * Sets the value of the showOtherEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowOtherEvents(Boolean value) {
        this.showOtherEvents = value;
    }

    /**
     * Gets the value of the aggregateVouchers property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAggregateVouchers() {
        return aggregateVouchers;
    }

    /**
     * Sets the value of the aggregateVouchers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAggregateVouchers(Boolean value) {
        this.aggregateVouchers = value;
    }

    /**
     * Gets the value of the serviceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceInformationType }
     *     
     */
    public ServiceInformationType getServiceInformation() {
        return serviceInformation;
    }

    /**
     * Sets the value of the serviceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceInformationType }
     *     
     */
    public void setServiceInformation(ServiceInformationType value) {
        this.serviceInformation = value;
    }

    /**
     * Gets the value of the requestedEvents property.
     * 
     * @return
     *     possible object is
     *     {@link EventsListType }
     *     
     */
    public EventsListType getRequestedEvents() {
        return requestedEvents;
    }

    /**
     * Sets the value of the requestedEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventsListType }
     *     
     */
    public void setRequestedEvents(EventsListType value) {
        this.requestedEvents = value;
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