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
 * <p>Java class for UnitValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnitValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="valueDigits" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ValueDigitsType"/>
 *         &lt;element name="exponent" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}ExponentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitValueType", propOrder = {
    "valueDigits",
    "exponent"
})
public class UnitValueType {

    protected int valueDigits;
    protected Long exponent;

    /**
     * Gets the value of the valueDigits property.
     * 
     */
    public int getValueDigits() {
        return valueDigits;
    }

    /**
     * Sets the value of the valueDigits property.
     * 
     */
    public void setValueDigits(int value) {
        this.valueDigits = value;
    }

    /**
     * Gets the value of the exponent property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getExponent() {
        return exponent;
    }

    /**
     * Sets the value of the exponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setExponent(Long value) {
        this.exponent = value;
    }

}