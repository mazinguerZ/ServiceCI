//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 03:57:54 PM CEST 
//


package com.bluevia.api.schemas.payment.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReservedPaymentStatusValuesType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReservedPaymentStatusValuesType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="processing"/>
 *     &lt;enumeration value="reserved"/>
 *     &lt;enumeration value="charged"/>
 *     &lt;enumeration value="released"/>
 *     &lt;enumeration value="deniedByUser"/>
 *     &lt;enumeration value="denied"/>
 *     &lt;enumeration value="failed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReservedPaymentStatusValuesType")
@XmlEnum
public enum ReservedPaymentStatusValuesType {

    @XmlEnumValue("processing")
    PROCESSING("processing"),
    @XmlEnumValue("reserved")
    RESERVED("reserved"),
    @XmlEnumValue("charged")
    CHARGED("charged"),
    @XmlEnumValue("released")
    RELEASED("released"),
    @XmlEnumValue("deniedByUser")
    DENIED_BY_USER("deniedByUser"),
    @XmlEnumValue("denied")
    DENIED("denied"),
    @XmlEnumValue("failed")
    FAILED("failed");
    private final String value;

    ReservedPaymentStatusValuesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReservedPaymentStatusValuesType fromValue(String v) {
        for (ReservedPaymentStatusValuesType c: ReservedPaymentStatusValuesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
