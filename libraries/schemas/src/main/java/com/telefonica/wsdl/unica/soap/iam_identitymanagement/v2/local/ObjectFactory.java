//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 12:38:21 PM CEST 
//


package com.telefonica.wsdl.unica.soap.iam_identitymanagement.v2.local;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.wsdl.unica.soap.iam_identitymanagement.v2.local package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.wsdl.unica.soap.iam_identitymanagement.v2.local
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsCustomerResponse }
     * 
     */
    public IsCustomerResponse createIsCustomerResponse() {
        return new IsCustomerResponse();
    }

    /**
     * Create an instance of {@link AuthenticateUserResponse }
     * 
     */
    public AuthenticateUserResponse createAuthenticateUserResponse() {
        return new AuthenticateUserResponse();
    }

    /**
     * Create an instance of {@link RememberUser }
     * 
     */
    public RememberUser createRememberUser() {
        return new RememberUser();
    }

    /**
     * Create an instance of {@link RememberPassword }
     * 
     */
    public RememberPassword createRememberPassword() {
        return new RememberPassword();
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link AuthenticateUser }
     * 
     */
    public AuthenticateUser createAuthenticateUser() {
        return new AuthenticateUser();
    }

    /**
     * Create an instance of {@link IsCustomer }
     * 
     */
    public IsCustomer createIsCustomer() {
        return new IsCustomer();
    }

}