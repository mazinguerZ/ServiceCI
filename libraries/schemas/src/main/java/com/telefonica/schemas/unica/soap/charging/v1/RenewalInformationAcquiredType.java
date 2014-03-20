//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.21 at 08:40:35 AM CEST 
//


package com.telefonica.schemas.unica.soap.charging.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RenewalInformationAcquiredType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RenewalInformationAcquiredType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}RenewalInformationType">
 *       &lt;sequence>
 *         &lt;element name="firstRenewalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="renewalStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RenewalInformationAcquiredType", propOrder = {
    "firstRenewalDate",
    "renewalStatus"
})
public class RenewalInformationAcquiredType
    extends RenewalInformationType
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar firstRenewalDate;
    @XmlSchemaType(name = "unsignedInt")
    protected long renewalStatus;

    /**
     * Gets the value of the firstRenewalDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstRenewalDate() {
        return firstRenewalDate;
    }

    /**
     * Sets the value of the firstRenewalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstRenewalDate(XMLGregorianCalendar value) {
        this.firstRenewalDate = value;
    }

    /**
     * Gets the value of the renewalStatus property.
     * 
     */
    public long getRenewalStatus() {
        return renewalStatus;
    }

    /**
     * Sets the value of the renewalStatus property.
     * 
     */
    public void setRenewalStatus(long value) {
        this.renewalStatus = value;
    }

}