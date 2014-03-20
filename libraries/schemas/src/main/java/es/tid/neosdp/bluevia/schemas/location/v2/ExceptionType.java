//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.22 at 08:53:40 AM CET 
//


package es.tid.neosdp.bluevia.schemas.location.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Returned by server in case of a fault
 * 
 * <p>Java class for ExceptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExceptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exceptionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="exceptionMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="moreInfo" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="userMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExceptionType", propOrder = {
    "exceptionId",
    "exceptionMessage",
    "moreInfo",
    "userMessage"
})
public class ExceptionType {

    @XmlElement(required = true)
    protected String exceptionId;
    @XmlElement(required = true)
    protected String exceptionMessage;
    @XmlSchemaType(name = "anyURI")
    protected String moreInfo;
    protected String userMessage;

    /**
     * Gets the value of the exceptionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionId() {
        return exceptionId;
    }

    /**
     * Sets the value of the exceptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionId(String value) {
        this.exceptionId = value;
    }

    /**
     * Gets the value of the exceptionMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * Sets the value of the exceptionMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptionMessage(String value) {
        this.exceptionMessage = value;
    }

    /**
     * Gets the value of the moreInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoreInfo() {
        return moreInfo;
    }

    /**
     * Sets the value of the moreInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoreInfo(String value) {
        this.moreInfo = value;
    }

    /**
     * Gets the value of the userMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * Sets the value of the userMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMessage(String value) {
        this.userMessage = value;
    }

}