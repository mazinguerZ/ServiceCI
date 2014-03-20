//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.22 at 08:53:40 AM CET 
//


package es.tid.neosdp.bluevia.schemas.location.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.tid.neosdp.bluevia.schemas.location.v2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LocationInfo_QNAME = new QName("http://api.bluevia.com/schemas/v2/location", "locationInfo");
    private final static QName _Exception_QNAME = new QName("http://api.bluevia.com/schemas/v2/common", "exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.tid.neosdp.bluevia.schemas.location.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NameValuePairType }
     * 
     */
    public NameValuePairType createNameValuePairType() {
        return new NameValuePairType();
    }

    /**
     * Create an instance of {@link LocationInfoType }
     * 
     */
    public LocationInfoType createLocationInfoType() {
        return new LocationInfoType();
    }

    /**
     * Create an instance of {@link ExceptionType }
     * 
     */
    public ExceptionType createExceptionType() {
        return new ExceptionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/location", name = "locationInfo")
    public JAXBElement<LocationInfoType> createLocationInfo(LocationInfoType value) {
        return new JAXBElement<LocationInfoType>(_LocationInfo_QNAME, LocationInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/common", name = "exception")
    public JAXBElement<ExceptionType> createException(ExceptionType value) {
        return new JAXBElement<ExceptionType>(_Exception_QNAME, ExceptionType.class, null, value);
    }

}
