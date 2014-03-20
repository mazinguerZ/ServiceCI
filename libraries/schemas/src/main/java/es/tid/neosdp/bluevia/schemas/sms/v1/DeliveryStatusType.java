//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.22 at 09:37:33 AM CET 
//


package es.tid.neosdp.bluevia.schemas.sms.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for DeliveryStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeliveryStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DeliveredToNetwork"/>
 *     &lt;enumeration value="DeliveryUncertain"/>
 *     &lt;enumeration value="DeliveryImpossible"/>
 *     &lt;enumeration value="MessageWaiting"/>
 *     &lt;enumeration value="DeliveredToTerminal"/>
 *     &lt;enumeration value="DeliveryNotificationNotSupported"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum DeliveryStatusType {

    @XmlEnumValue("DeliveredToNetwork")
    DELIVERED_TO_NETWORK("DeliveredToNetwork"),
    @XmlEnumValue("DeliveredToTerminal")
    DELIVERED_TO_TERMINAL("DeliveredToTerminal"),
    @XmlEnumValue("DeliveryImpossible")
    DELIVERY_IMPOSSIBLE("DeliveryImpossible"),
    @XmlEnumValue("DeliveryNotificationNotSupported")
    DELIVERY_NOTIFICATION_NOT_SUPPORTED("DeliveryNotificationNotSupported"),
    @XmlEnumValue("DeliveryUncertain")
    DELIVERY_UNCERTAIN("DeliveryUncertain"),
    @XmlEnumValue("MessageWaiting")
    MESSAGE_WAITING("MessageWaiting");
    private final String value;

    DeliveryStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeliveryStatusType fromValue(String v) {
        for (DeliveryStatusType c: DeliveryStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
