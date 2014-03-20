//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 12:38:21 PM CEST 
//


package com.telefonica.wsdl.unica.soap.iam_identitymanagement.v2.local;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.telefonica.schemas.unica.soap.common.v1.ExtensionType;
import com.telefonica.schemas.unica.soap.common.v1.UserIdType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://www.telefonica.com/schemas/UNICA/SOAP/common/v1}UserIdType"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userRole" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="additionalCredentials" type="{http://www.telefonica.com/schemas/UNICA/SOAP/common/v1}ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "user",
    "password",
    "userRole",
    "additionalCredentials"
})
@XmlRootElement(name = "authenticateUser")
public class AuthenticateUser {

    @XmlElement(required = true)
    protected UserIdType user;
    @XmlElement(required = true)
    protected String password;
    @XmlSchemaType(name = "unsignedInt")
    protected Long userRole;
    protected ExtensionType additionalCredentials;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link UserIdType }
     *     
     */
    public UserIdType getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserIdType }
     *     
     */
    public void setUser(UserIdType value) {
        this.user = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the userRole property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserRole() {
        return userRole;
    }

    /**
     * Sets the value of the userRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserRole(Long value) {
        this.userRole = value;
    }

    /**
     * Gets the value of the additionalCredentials property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getAdditionalCredentials() {
        return additionalCredentials;
    }

    /**
     * Sets the value of the additionalCredentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setAdditionalCredentials(ExtensionType value) {
        this.additionalCredentials = value;
    }

}