//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.29 at 01:15:52 PM CET 
//


package es.tid.neosdp.bluevia.schemas.mms.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageDeliveryStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageDeliveryStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="messageDeliveryStatus" type="{http://www.telefonica.com/schemas/UNICA/REST/mms/v1/}DeliveryInformationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageDeliveryStatusType", propOrder = {
    "messageDeliveryStatus"
})
public class MessageDeliveryStatusType {

    @XmlElement(namespace = "http://www.telefonica.com/schemas/UNICA/REST/mms/v1/", required = true)
    protected List<DeliveryInformationType> messageDeliveryStatus;

    /**
     * Gets the value of the messageDeliveryStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageDeliveryStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageDeliveryStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryInformationType }
     * 
     * 
     */
    public List<DeliveryInformationType> getMessageDeliveryStatus() {
        if (messageDeliveryStatus == null) {
            messageDeliveryStatus = new ArrayList<DeliveryInformationType>();
        }
        return this.messageDeliveryStatus;
    }

}
