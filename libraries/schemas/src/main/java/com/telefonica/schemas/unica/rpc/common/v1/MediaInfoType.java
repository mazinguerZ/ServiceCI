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
 * Description of the Media
 * 
 * <p>Java class for MediaInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MediaInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="media" type="{http://www.telefonica.com/schemas/UNICA/RPC/common/v1}MediaType"/>
 *         &lt;element name="mediaDirection" type="{http://www.telefonica.com/schemas/UNICA/RPC/common/v1}MediaDirectionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MediaInfoType", propOrder = {
    "media",
    "mediaDirection"
})
public class MediaInfoType {

    @XmlElement(required = true)
    protected MediaType media;
    @XmlElement(required = true)
    protected MediaDirectionType mediaDirection;

    /**
     * Gets the value of the media property.
     * 
     * @return
     *     possible object is
     *     {@link MediaType }
     *     
     */
    public MediaType getMedia() {
        return media;
    }

    /**
     * Sets the value of the media property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaType }
     *     
     */
    public void setMedia(MediaType value) {
        this.media = value;
    }

    /**
     * Gets the value of the mediaDirection property.
     * 
     * @return
     *     possible object is
     *     {@link MediaDirectionType }
     *     
     */
    public MediaDirectionType getMediaDirection() {
        return mediaDirection;
    }

    /**
     * Sets the value of the mediaDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link MediaDirectionType }
     *     
     */
    public void setMediaDirection(MediaDirectionType value) {
        this.mediaDirection = value;
    }

}
