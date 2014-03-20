//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.05 at 02:12:15 PM CET 
//


package es.tid.neosdp.bluevia.schemas.location.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for DistanceCriteriaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DistanceCriteriaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AllWithinDistance"/>
 *     &lt;enumeration value="AnyWithinDistance"/>
 *     &lt;enumeration value="AllBeyondDistance"/>
 *     &lt;enumeration value="AnyBeyondDistance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DistanceCriteriaType {

    @XmlEnumValue("AllWithinDistance")
    ALL_WITHIN_DISTANCE("AllWithinDistance"),
    @XmlEnumValue("AnyWithinDistance")
    ANY_WITHIN_DISTANCE("AnyWithinDistance"),
    @XmlEnumValue("AllBeyondDistance")
    ALL_BEYOND_DISTANCE("AllBeyondDistance"),
    @XmlEnumValue("AnyBeyondDistance")
    ANY_BEYOND_DISTANCE("AnyBeyondDistance");
    private final String value;

    DistanceCriteriaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DistanceCriteriaType fromValue(String v) {
        for (DistanceCriteriaType c: DistanceCriteriaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}