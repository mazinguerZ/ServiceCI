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


/**
 * <p>Java class for EventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code1" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}CodeType"/>
 *         &lt;element name="code2" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}CodeType"/>
 *         &lt;element name="code3" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}CodeType"/>
 *         &lt;element name="promotionalCode" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PromotionalCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventType", propOrder = {
    "code1",
    "code2",
    "code3",
    "promotionalCode"
})
public class EventType {

    protected int code1;
    protected int code2;
    protected int code3;
    protected String promotionalCode;

    /**
     * Gets the value of the code1 property.
     * 
     */
    public int getCode1() {
        return code1;
    }

    /**
     * Sets the value of the code1 property.
     * 
     */
    public void setCode1(int value) {
        this.code1 = value;
    }

    /**
     * Gets the value of the code2 property.
     * 
     */
    public int getCode2() {
        return code2;
    }

    /**
     * Sets the value of the code2 property.
     * 
     */
    public void setCode2(int value) {
        this.code2 = value;
    }

    /**
     * Gets the value of the code3 property.
     * 
     */
    public int getCode3() {
        return code3;
    }

    /**
     * Sets the value of the code3 property.
     * 
     */
    public void setCode3(int value) {
        this.code3 = value;
    }

    /**
     * Gets the value of the promotionalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionalCode() {
        return promotionalCode;
    }

    /**
     * Sets the value of the promotionalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionalCode(String value) {
        this.promotionalCode = value;
    }

}
