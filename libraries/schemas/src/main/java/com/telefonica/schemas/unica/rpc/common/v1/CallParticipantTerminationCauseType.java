//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.09 at 09:34:13 AM CEST 
//


package com.telefonica.schemas.unica.rpc.common.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CallParticipantTerminationCauseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CallParticipantTerminationCauseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callParticipantTerminationCause">
 *           &lt;simpleType>
 *             &lt;union memberTypes=" {http://www.telefonica.com/schemas/UNICA/RPC/common/v1}CallParticipantTerminationCausesType {http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/union>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CallParticipantTerminationCauseType", propOrder = {
    "callParticipantTerminationCause"
})
public class CallParticipantTerminationCauseType {

    @XmlElement(required = true)
    protected String callParticipantTerminationCause;

    /**
     * Gets the value of the callParticipantTerminationCause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallParticipantTerminationCause() {
        return callParticipantTerminationCause;
    }

    /**
     * Sets the value of the callParticipantTerminationCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallParticipantTerminationCause(String value) {
        this.callParticipantTerminationCause = value;
    }

}
