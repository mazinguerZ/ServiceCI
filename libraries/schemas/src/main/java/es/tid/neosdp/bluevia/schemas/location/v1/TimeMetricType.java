//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.05 at 02:12:15 PM CET 
//


package es.tid.neosdp.bluevia.schemas.location.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeMetricType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeMetricType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metric" type="{http://www.telefonica.com/schemas/UNICA/REST/location/v1/}TimeMetricsType"/>
 *         &lt;element name="units" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeMetricType", propOrder = {
    "metric",
    "units"
})
public class TimeMetricType {

    @XmlElement(required = true)
    protected TimeMetricsType metric;
    protected float units;

    /**
     * Gets the value of the metric property.
     * 
     * @return
     *     possible object is
     *     {@link TimeMetricsType }
     *     
     */
    public TimeMetricsType getMetric() {
        return metric;
    }

    /**
     * Sets the value of the metric property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeMetricsType }
     *     
     */
    public void setMetric(TimeMetricsType value) {
        this.metric = value;
    }

    /**
     * Gets the value of the units property.
     * 
     */
    public float getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     */
    public void setUnits(float value) {
        this.units = value;
    }

}
