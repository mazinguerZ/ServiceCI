//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.09 at 05:39:53 PM CEST 
//


package es.tid.neosdp.bluevia.schemas.payments.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentStatusValuesType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentStatusValuesType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="pendingAuthorization"/>
 *     &lt;enumeration value="authorized"/>
 *     &lt;enumeration value="processing"/>
 *     &lt;enumeration value="charged"/>
 *     &lt;enumeration value="unAuthorized"/>
 *     &lt;enumeration value="deniedByUser"/>
 *     &lt;enumeration value="denied"/>
 *     &lt;enumeration value="failed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentStatusValuesType")
@XmlEnum
public enum PaymentStatusValuesType {

    @XmlEnumValue("pendingAuthorization")
    PENDING_AUTHORIZATION("pendingAuthorization"),
    @XmlEnumValue("authorized")
    AUTHORIZED("authorized"),
    @XmlEnumValue("processing")
    PROCESSING("processing"),
    @XmlEnumValue("charged")
    CHARGED("charged"),
    @XmlEnumValue("unAuthorized")
    UN_AUTHORIZED("unAuthorized"),
    @XmlEnumValue("deniedByUser")
    DENIED_BY_USER("deniedByUser"),
    @XmlEnumValue("denied")
    DENIED("denied"),
    @XmlEnumValue("failed")
    FAILED("failed");
    private final String value;

    PaymentStatusValuesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentStatusValuesType fromValue(String v) {
        for (PaymentStatusValuesType c: PaymentStatusValuesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
