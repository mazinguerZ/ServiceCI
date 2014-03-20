//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.09 at 11:22:41 AM CEST 
//


package com.telefonica.schemas.unica.rest.payment.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.telefonica.schemas.unica.rest.common.v2.SimpleReferenceType;


/**
 * <p>Java class for AmountReservationTransactionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmountReservationTransactionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="endUserId" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="paymentAmount" type="{http://www.telefonica.com/schemas/UNICA/REST/payment/v3/}PaymentAmountType"/>
 *         &lt;element name="referenceSequence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="referenceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serverReferenceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalServerReferenceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receiptRequest" type="{http://www.telefonica.com/schemas/UNICA/REST/common/v2}SimpleReferenceType" minOccurs="0"/>
 *         &lt;element name="clientCorrelator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionOperationStatus" type="{http://www.telefonica.com/schemas/UNICA/REST/payment/v3/}TransactionOperationStatusType"/>
 *         &lt;element name="transactionOperationStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizationScope" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountReservationTransactionType", propOrder = {
    "endUserId",
    "paymentAmount",
    "referenceSequence",
    "referenceCode",
    "serverReferenceCode",
    "originalServerReferenceCode",
    "receiptRequest",
    "clientCorrelator",
    "validationCode",
    "transactionOperationStatus",
    "transactionOperationStatusDescription",
    "authorizationScope",
    "resourceURL",
    "link"
})
public class AmountReservationTransactionType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String endUserId;
    @XmlElement(required = true)
    protected PaymentAmountType paymentAmount;
    protected int referenceSequence;
    protected String referenceCode;
    protected String serverReferenceCode;
    protected String originalServerReferenceCode;
    protected SimpleReferenceType receiptRequest;
    protected String clientCorrelator;
    protected String validationCode;
    @XmlElement(required = true)
    protected TransactionOperationStatusType transactionOperationStatus;
    protected String transactionOperationStatusDescription;
    protected String authorizationScope;
    @XmlSchemaType(name = "anyURI")
    protected String resourceURL;
    @XmlSchemaType(name = "anyURI")
    protected List<String> link;

    /**
     * Gets the value of the endUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndUserId() {
        return endUserId;
    }

    /**
     * Sets the value of the endUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndUserId(String value) {
        this.endUserId = value;
    }

    /**
     * Gets the value of the paymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAmountType }
     *     
     */
    public PaymentAmountType getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAmountType }
     *     
     */
    public void setPaymentAmount(PaymentAmountType value) {
        this.paymentAmount = value;
    }

    /**
     * Gets the value of the referenceSequence property.
     * 
     */
    public int getReferenceSequence() {
        return referenceSequence;
    }

    /**
     * Sets the value of the referenceSequence property.
     * 
     */
    public void setReferenceSequence(int value) {
        this.referenceSequence = value;
    }

    /**
     * Gets the value of the referenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceCode() {
        return referenceCode;
    }

    /**
     * Sets the value of the referenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceCode(String value) {
        this.referenceCode = value;
    }

    /**
     * Gets the value of the serverReferenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerReferenceCode() {
        return serverReferenceCode;
    }

    /**
     * Sets the value of the serverReferenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerReferenceCode(String value) {
        this.serverReferenceCode = value;
    }

    /**
     * Gets the value of the originalServerReferenceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalServerReferenceCode() {
        return originalServerReferenceCode;
    }

    /**
     * Sets the value of the originalServerReferenceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalServerReferenceCode(String value) {
        this.originalServerReferenceCode = value;
    }

    /**
     * Gets the value of the receiptRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleReferenceType }
     *     
     */
    public SimpleReferenceType getReceiptRequest() {
        return receiptRequest;
    }

    /**
     * Sets the value of the receiptRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleReferenceType }
     *     
     */
    public void setReceiptRequest(SimpleReferenceType value) {
        this.receiptRequest = value;
    }

    /**
     * Gets the value of the clientCorrelator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientCorrelator() {
        return clientCorrelator;
    }

    /**
     * Sets the value of the clientCorrelator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientCorrelator(String value) {
        this.clientCorrelator = value;
    }

    /**
     * Gets the value of the validationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationCode() {
        return validationCode;
    }

    /**
     * Sets the value of the validationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationCode(String value) {
        this.validationCode = value;
    }

    /**
     * Gets the value of the transactionOperationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionOperationStatusType }
     *     
     */
    public TransactionOperationStatusType getTransactionOperationStatus() {
        return transactionOperationStatus;
    }

    /**
     * Sets the value of the transactionOperationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionOperationStatusType }
     *     
     */
    public void setTransactionOperationStatus(TransactionOperationStatusType value) {
        this.transactionOperationStatus = value;
    }

    /**
     * Gets the value of the transactionOperationStatusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionOperationStatusDescription() {
        return transactionOperationStatusDescription;
    }

    /**
     * Sets the value of the transactionOperationStatusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionOperationStatusDescription(String value) {
        this.transactionOperationStatusDescription = value;
    }

    /**
     * Gets the value of the authorizationScope property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationScope() {
        return authorizationScope;
    }

    /**
     * Sets the value of the authorizationScope property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationScope(String value) {
        this.authorizationScope = value;
    }

    /**
     * Gets the value of the resourceURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceURL() {
        return resourceURL;
    }

    /**
     * Sets the value of the resourceURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceURL(String value) {
        this.resourceURL = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the link property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLink().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLink() {
        if (link == null) {
            link = new ArrayList<String>();
        }
        return this.link;
    }

}
