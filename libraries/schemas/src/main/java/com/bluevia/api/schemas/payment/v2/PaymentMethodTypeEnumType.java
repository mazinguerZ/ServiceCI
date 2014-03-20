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
 * <p>Java class for PaymentMethodTypeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethodTypeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="directToBill"/>
 *     &lt;enumeration value="eMoney"/>
 *     &lt;enumeration value="bankAccount"/>
 *     &lt;enumeration value="debitCard"/>
 *     &lt;enumeration value="creditCard"/>
 *     &lt;enumeration value="prepaidCard"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethodTypeEnumType")
@XmlEnum
public enum PaymentMethodTypeEnumType {

    @XmlEnumValue("directToBill")
    DIRECT_TO_BILL("directToBill"),
    @XmlEnumValue("eMoney")
    E_MONEY("eMoney"),
    @XmlEnumValue("bankAccount")
    BANK_ACCOUNT("bankAccount"),
    @XmlEnumValue("debitCard")
    DEBIT_CARD("debitCard"),
    @XmlEnumValue("creditCard")
    CREDIT_CARD("creditCard"),
    @XmlEnumValue("prepaidCard")
    PREPAID_CARD("prepaidCard");
    private final String value;

    PaymentMethodTypeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentMethodTypeEnumType fromValue(String v) {
        for (PaymentMethodTypeEnumType c: PaymentMethodTypeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
