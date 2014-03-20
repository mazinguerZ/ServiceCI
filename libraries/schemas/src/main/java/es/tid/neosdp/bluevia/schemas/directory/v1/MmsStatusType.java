//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.28 at 10:59:11 AM CET 
//


package es.tid.neosdp.bluevia.schemas.directory.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for MmsStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MmsStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="activated"/>
 *     &lt;enumeration value="deactivated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum MmsStatusType {

    @XmlEnumValue("activated")
    ACTIVATED("activated"),
    @XmlEnumValue("deactivated")
    DEACTIVATED("deactivated");
    private final String value;

    MmsStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MmsStatusType fromValue(String v) {
        for (MmsStatusType c: MmsStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
