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
 * <p>Java class for PurchaseModelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PurchaseModelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="purchaseModelUnit" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PurchaseModelUnitType"/>
 *         &lt;element name="purchaseModelVoucher" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PurchaseModelVoucherType"/>
 *         &lt;element name="purchaseModelUsageTariff" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PurchaseModelUsageTariffType"/>
 *         &lt;element name="purchaseModelSubscription" type="{http://www.telefonica.com/schemas/UNICA/SOAP/charging/v1}PurchaseModelSubscriptionType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurchaseModelType", propOrder = {
    "purchaseModelUnit",
    "purchaseModelVoucher",
    "purchaseModelUsageTariff",
    "purchaseModelSubscription"
})
public class PurchaseModelType {

    protected PurchaseModelUnitType purchaseModelUnit;
    protected PurchaseModelVoucherType purchaseModelVoucher;
    protected PurchaseModelUsageTariffType purchaseModelUsageTariff;
    protected PurchaseModelSubscriptionType purchaseModelSubscription;

    /**
     * Gets the value of the purchaseModelUnit property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseModelUnitType }
     *     
     */
    public PurchaseModelUnitType getPurchaseModelUnit() {
        return purchaseModelUnit;
    }

    /**
     * Sets the value of the purchaseModelUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseModelUnitType }
     *     
     */
    public void setPurchaseModelUnit(PurchaseModelUnitType value) {
        this.purchaseModelUnit = value;
    }

    /**
     * Gets the value of the purchaseModelVoucher property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseModelVoucherType }
     *     
     */
    public PurchaseModelVoucherType getPurchaseModelVoucher() {
        return purchaseModelVoucher;
    }

    /**
     * Sets the value of the purchaseModelVoucher property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseModelVoucherType }
     *     
     */
    public void setPurchaseModelVoucher(PurchaseModelVoucherType value) {
        this.purchaseModelVoucher = value;
    }

    /**
     * Gets the value of the purchaseModelUsageTariff property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseModelUsageTariffType }
     *     
     */
    public PurchaseModelUsageTariffType getPurchaseModelUsageTariff() {
        return purchaseModelUsageTariff;
    }

    /**
     * Sets the value of the purchaseModelUsageTariff property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseModelUsageTariffType }
     *     
     */
    public void setPurchaseModelUsageTariff(PurchaseModelUsageTariffType value) {
        this.purchaseModelUsageTariff = value;
    }

    /**
     * Gets the value of the purchaseModelSubscription property.
     * 
     * @return
     *     possible object is
     *     {@link PurchaseModelSubscriptionType }
     *     
     */
    public PurchaseModelSubscriptionType getPurchaseModelSubscription() {
        return purchaseModelSubscription;
    }

    /**
     * Sets the value of the purchaseModelSubscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link PurchaseModelSubscriptionType }
     *     
     */
    public void setPurchaseModelSubscription(PurchaseModelSubscriptionType value) {
        this.purchaseModelSubscription = value;
    }

}
