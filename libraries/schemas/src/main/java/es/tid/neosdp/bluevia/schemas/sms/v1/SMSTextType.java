//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.22 at 09:37:33 AM CET 
//


package es.tid.neosdp.bluevia.schemas.sms.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SMSTextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SMSTextType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.telefonica.com/schemas/UNICA/REST/common/v1}UserIdType" maxOccurs="unbounded"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="receiptRequest" type="{http://www.telefonica.com/schemas/UNICA/REST/common/v1}SimpleReferenceType" minOccurs="0"/>
 *         &lt;element name="senderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originAddress" type="{http://www.telefonica.com/schemas/UNICA/REST/common/v1}UserIdType"/>
 *         &lt;element name="encode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceport" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="destinationport" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="esm_class" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="data_coding" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SMSTextType", propOrder = {
    "address",
    "message",
    "receiptRequest",
    "senderName",
    "originAddress",
    "encode",
    "sourceport",
    "destinationport",
    "esmClass",
    "dataCoding"
})
@XmlRootElement()
public class SMSTextType {

    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/", required = true)
    protected List<UserIdType> address;
    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/", required = true)
    protected String message;
    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/")
    protected SimpleReferenceType receiptRequest;
    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/")
    protected String senderName;
    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/", required = true)
    protected UserIdType originAddress;
    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/")
    protected String encode;
    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/")
    protected Integer sourceport;
    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/")
    protected Integer destinationport;
    @XmlElement(name = "esm_class", namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/")
    protected Integer esmClass;
    @XmlElement(name = "data_coding", namespace = "http://www.telefonica.com/schemas/UNICA/REST/sms/v1/")
    protected Integer dataCoding;

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserIdType }
     * 
     * 
     */
    public List<UserIdType> getAddress() {
        if (address == null) {
            address = new ArrayList<UserIdType>();
        }
        return this.address;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
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
     * Gets the value of the senderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Sets the value of the senderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderName(String value) {
        this.senderName = value;
    }

    /**
     * Gets the value of the originAddress property.
     * 
     * @return
     *     possible object is
     *     {@link UserIdType }
     *     
     */
    public UserIdType getOriginAddress() {
        return originAddress;
    }

    /**
     * Sets the value of the originAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserIdType }
     *     
     */
    public void setOriginAddress(UserIdType value) {
        this.originAddress = value;
    }

    /**
     * Gets the value of the encode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncode() {
        return encode;
    }

    /**
     * Sets the value of the encode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncode(String value) {
        this.encode = value;
    }

    /**
     * Gets the value of the sourceport property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSourceport() {
        return sourceport;
    }

    /**
     * Sets the value of the sourceport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSourceport(Integer value) {
        this.sourceport = value;
    }

    /**
     * Gets the value of the destinationport property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationport() {
        return destinationport;
    }

    /**
     * Sets the value of the destinationport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationport(Integer value) {
        this.destinationport = value;
    }

    /**
     * Gets the value of the esmClass property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEsmClass() {
        return esmClass;
    }

    /**
     * Sets the value of the esmClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEsmClass(Integer value) {
        this.esmClass = value;
    }

    /**
     * Gets the value of the dataCoding property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDataCoding() {
        return dataCoding;
    }

    /**
     * Sets the value of the dataCoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDataCoding(Integer value) {
        this.dataCoding = value;
    }

}