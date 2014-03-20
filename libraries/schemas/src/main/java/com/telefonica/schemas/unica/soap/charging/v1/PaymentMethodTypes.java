//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.09 at 09:17:46 AM CEST 
//


package com.telefonica.schemas.unica.soap.charging.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethodTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethodTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="PaySafe"/>
 *     &lt;enumeration value="MoneyBookers"/>
 *     &lt;enumeration value="BankTransfer"/>
 *     &lt;enumeration value="CreditCard"/>
 *     &lt;enumeration value="PayPal"/>
 *     &lt;enumeration value="Redirect"/>
 *     &lt;enumeration value="UKash"/>
 *     &lt;enumeration value="TrialPay"/>
 *     &lt;enumeration value="DirectDebit"/>
 *     &lt;enumeration value="PartnerPaymentPlatform"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethodTypes")
@XmlEnum
public enum PaymentMethodTypes {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("PaySafe")
    PAY_SAFE("PaySafe"),
    @XmlEnumValue("MoneyBookers")
    MONEY_BOOKERS("MoneyBookers"),
    @XmlEnumValue("BankTransfer")
    BANK_TRANSFER("BankTransfer"),
    @XmlEnumValue("CreditCard")
    CREDIT_CARD("CreditCard"),
    @XmlEnumValue("PayPal")
    PAY_PAL("PayPal"),
    @XmlEnumValue("Redirect")
    REDIRECT("Redirect"),
    @XmlEnumValue("UKash")
    U_KASH("UKash"),
    @XmlEnumValue("TrialPay")
    TRIAL_PAY("TrialPay"),
    @XmlEnumValue("DirectDebit")
    DIRECT_DEBIT("DirectDebit"),
    @XmlEnumValue("PartnerPaymentPlatform")
    PARTNER_PAYMENT_PLATFORM("PartnerPaymentPlatform");
    private final String value;

    PaymentMethodTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentMethodTypes fromValue(String v) {
        for (PaymentMethodTypes c: PaymentMethodTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}