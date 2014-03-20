//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.20 at 01:33:48 PM CEST 
//


package com.telefonica.schemas.unica.rest.transactionstorage.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionOperationStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionOperationStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ChargeRequest"/>
 *     &lt;enumeration value="RefundRequest"/>
 *     &lt;enumeration value="ChargeInProgress"/>
 *     &lt;enumeration value="RefundInProgress"/>
 *     &lt;enumeration value="ChargedErrorRetry"/>
 *     &lt;enumeration value="RefundedErrorRetry"/>
 *     &lt;enumeration value="ChargedSuccessfully"/>
 *     &lt;enumeration value="RefundedSuccessfully"/>
 *     &lt;enumeration value="ChargedFailed"/>
 *     &lt;enumeration value="RefundedFailed"/>
 *     &lt;enumeration value="ChargedUncertain"/>
 *     &lt;enumeration value="RefundedUncertain"/>
 *     &lt;enumeration value="Processing"/>
 *     &lt;enumeration value="AuthorizationInProgress"/>
 *     &lt;enumeration value="Authorized"/>
 *     &lt;enumeration value="Charged"/>
 *     &lt;enumeration value="Refunded"/>
 *     &lt;enumeration value="Credited"/>
 *     &lt;enumeration value="Reserved"/>
 *     &lt;enumeration value="Released"/>
 *     &lt;enumeration value="Denied"/>
 *     &lt;enumeration value="Refused"/>
 *     &lt;enumeration value="Unauthorized"/>
 *     &lt;enumeration value="Terminated"/>
 *     &lt;enumeration value="CompensationInProgress"/>
 *     &lt;enumeration value="Compensated"/>
 *     &lt;enumeration value="ErrorRetry"/>
 *     &lt;enumeration value="Uncertain"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionOperationStatusType")
@XmlEnum
public enum TransactionOperationStatusType {

    @XmlEnumValue("ChargeRequest")
    CHARGE_REQUEST("ChargeRequest"),
    @XmlEnumValue("RefundRequest")
    REFUND_REQUEST("RefundRequest"),
    @XmlEnumValue("ChargeInProgress")
    CHARGE_IN_PROGRESS("ChargeInProgress"),
    @XmlEnumValue("RefundInProgress")
    REFUND_IN_PROGRESS("RefundInProgress"),
    @XmlEnumValue("ChargedErrorRetry")
    CHARGED_ERROR_RETRY("ChargedErrorRetry"),
    @XmlEnumValue("RefundedErrorRetry")
    REFUNDED_ERROR_RETRY("RefundedErrorRetry"),
    @XmlEnumValue("ChargedSuccessfully")
    CHARGED_SUCCESSFULLY("ChargedSuccessfully"),
    @XmlEnumValue("RefundedSuccessfully")
    REFUNDED_SUCCESSFULLY("RefundedSuccessfully"),
    @XmlEnumValue("ChargedFailed")
    CHARGED_FAILED("ChargedFailed"),
    @XmlEnumValue("RefundedFailed")
    REFUNDED_FAILED("RefundedFailed"),
    @XmlEnumValue("ChargedUncertain")
    CHARGED_UNCERTAIN("ChargedUncertain"),
    @XmlEnumValue("RefundedUncertain")
    REFUNDED_UNCERTAIN("RefundedUncertain"),
    @XmlEnumValue("Processing")
    PROCESSING("Processing"),
    @XmlEnumValue("AuthorizationInProgress")
    AUTHORIZATION_IN_PROGRESS("AuthorizationInProgress"),
    @XmlEnumValue("Authorized")
    AUTHORIZED("Authorized"),
    @XmlEnumValue("Charged")
    CHARGED("Charged"),
    @XmlEnumValue("Refunded")
    REFUNDED("Refunded"),
    @XmlEnumValue("Credited")
    CREDITED("Credited"),
    @XmlEnumValue("Reserved")
    RESERVED("Reserved"),
    @XmlEnumValue("Released")
    RELEASED("Released"),
    @XmlEnumValue("Denied")
    DENIED("Denied"),
    @XmlEnumValue("Refused")
    REFUSED("Refused"),
    @XmlEnumValue("Unauthorized")
    UNAUTHORIZED("Unauthorized"),
    @XmlEnumValue("Terminated")
    TERMINATED("Terminated"),
    @XmlEnumValue("CompensationInProgress")
    COMPENSATION_IN_PROGRESS("CompensationInProgress"),
    @XmlEnumValue("Compensated")
    COMPENSATED("Compensated"),
    @XmlEnumValue("ErrorRetry")
    ERROR_RETRY("ErrorRetry"),
    @XmlEnumValue("Uncertain")
    UNCERTAIN("Uncertain");
    private final String value;

    TransactionOperationStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionOperationStatusType fromValue(String v) {
        for (TransactionOperationStatusType c: TransactionOperationStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}