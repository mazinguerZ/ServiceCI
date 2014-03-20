//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.09 at 05:39:53 PM CEST 
//


package es.tid.neosdp.bluevia.schemas.payments.v2;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.tid.neosdp.bluevia.schemas.payments.v2 package. 
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

    private final static QName _PaymentList_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "paymentList");
    private final static QName _PaymentStatus_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "paymentStatus");
    private final static QName _PaymentRequest_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "paymentRequest");
    private final static QName _RefundList_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "refundList");
    private final static QName _Exception_QNAME = new QName("http://api.bluevia.com/schemas/v2/common", "exception");
    private final static QName _Refund_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "refund");
    private final static QName _Payment_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "payment");
    private final static QName _RefundStatus_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "refundStatus");
    private final static QName _RefundRequest_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "refundRequest");
    private final static QName _RefundRequestTypeCurrency_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "currency");
    private final static QName _RefundRequestTypeTransactionIdToRefund_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "transactionIdToRefund");
    private final static QName _RefundRequestTypeUserId_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "userId");
    private final static QName _RefundRequestTypeDescription_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "description");
    private final static QName _RefundRequestTypeReferenceCode_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "referenceCode");
    private final static QName _RefundRequestTypeAmount_QNAME = new QName("http://api.bluevia.com/schemas/v2/payment", "amount");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.tid.neosdp.bluevia.schemas.payments.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentRequestType }
     * 
     */
    public PaymentRequestType createPaymentRequestType() {
        return new PaymentRequestType();
    }

    /**
     * Create an instance of {@link RefundType }
     * 
     */
    public RefundType createRefundType() {
        return new RefundType();
    }

    /**
     * Create an instance of {@link RefundStatusType }
     * 
     */
    public RefundStatusType createRefundStatusType() {
        return new RefundStatusType();
    }

    /**
     * Create an instance of {@link RefundRequestType }
     * 
     */
    public RefundRequestType createRefundRequestType() {
        return new RefundRequestType();
    }

    /**
     * Create an instance of {@link PaymentListType }
     * 
     */
    public PaymentListType createPaymentListType() {
        return new PaymentListType();
    }

    /**
     * Create an instance of {@link RefundListType }
     * 
     */
    public RefundListType createRefundListType() {
        return new RefundListType();
    }

    /**
     * Create an instance of {@link PaymentType }
     * 
     */
    public PaymentType createPaymentType() {
        return new PaymentType();
    }

    /**
     * Create an instance of {@link NameValuePairType }
     * 
     */
    public NameValuePairType createNameValuePairType() {
        return new NameValuePairType();
    }

    /**
     * Create an instance of {@link PaymentStatusType }
     * 
     */
    public PaymentStatusType createPaymentStatusType() {
        return new PaymentStatusType();
    }

    /**
     * Create an instance of {@link ExceptionType }
     * 
     */
    public ExceptionType createExceptionType() {
        return new ExceptionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "paymentList")
    public JAXBElement<PaymentListType> createPaymentList(PaymentListType value) {
        return new JAXBElement<PaymentListType>(_PaymentList_QNAME, PaymentListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "paymentStatus")
    public JAXBElement<PaymentStatusType> createPaymentStatus(PaymentStatusType value) {
        return new JAXBElement<PaymentStatusType>(_PaymentStatus_QNAME, PaymentStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "paymentRequest")
    public JAXBElement<PaymentRequestType> createPaymentRequest(PaymentRequestType value) {
        return new JAXBElement<PaymentRequestType>(_PaymentRequest_QNAME, PaymentRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "refundList")
    public JAXBElement<RefundListType> createRefundList(RefundListType value) {
        return new JAXBElement<RefundListType>(_RefundList_QNAME, RefundListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/common", name = "exception")
    public JAXBElement<ExceptionType> createException(ExceptionType value) {
        return new JAXBElement<ExceptionType>(_Exception_QNAME, ExceptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "refund")
    public JAXBElement<RefundType> createRefund(RefundType value) {
        return new JAXBElement<RefundType>(_Refund_QNAME, RefundType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "payment")
    public JAXBElement<PaymentType> createPayment(PaymentType value) {
        return new JAXBElement<PaymentType>(_Payment_QNAME, PaymentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "refundStatus")
    public JAXBElement<RefundStatusType> createRefundStatus(RefundStatusType value) {
        return new JAXBElement<RefundStatusType>(_RefundStatus_QNAME, RefundStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "refundRequest")
    public JAXBElement<RefundRequestType> createRefundRequest(RefundRequestType value) {
        return new JAXBElement<RefundRequestType>(_RefundRequest_QNAME, RefundRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "currency", scope = RefundRequestType.class)
    public JAXBElement<String> createRefundRequestTypeCurrency(String value) {
        return new JAXBElement<String>(_RefundRequestTypeCurrency_QNAME, String.class, RefundRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "transactionIdToRefund", scope = RefundRequestType.class)
    public JAXBElement<String> createRefundRequestTypeTransactionIdToRefund(String value) {
        return new JAXBElement<String>(_RefundRequestTypeTransactionIdToRefund_QNAME, String.class, RefundRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "userId", scope = RefundRequestType.class)
    public JAXBElement<String> createRefundRequestTypeUserId(String value) {
        return new JAXBElement<String>(_RefundRequestTypeUserId_QNAME, String.class, RefundRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "description", scope = RefundRequestType.class)
    public JAXBElement<String> createRefundRequestTypeDescription(String value) {
        return new JAXBElement<String>(_RefundRequestTypeDescription_QNAME, String.class, RefundRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "referenceCode", scope = RefundRequestType.class)
    public JAXBElement<String> createRefundRequestTypeReferenceCode(String value) {
        return new JAXBElement<String>(_RefundRequestTypeReferenceCode_QNAME, String.class, RefundRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.bluevia.com/schemas/v2/payment", name = "amount", scope = RefundRequestType.class)
    public JAXBElement<BigDecimal> createRefundRequestTypeAmount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_RefundRequestTypeAmount_QNAME, BigDecimal.class, RefundRequestType.class, value);
    }

}
