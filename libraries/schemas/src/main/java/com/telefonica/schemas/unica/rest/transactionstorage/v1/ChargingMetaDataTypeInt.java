package com.telefonica.schemas.unica.rest.transactionstorage.v1;

import javax.xml.datatype.XMLGregorianCalendar;

import com.telefonica.schemas.unica.rest.common.v2.ExtensionType;

public interface ChargingMetaDataTypeInt {

	/**
	 * Gets the value of the channel property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getChannel();

	/**
	 * Sets the value of the channel property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setChannel(String value);

	/**
	 * Gets the value of the serviceId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getServiceId();

	/**
	 * Sets the value of the serviceId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setServiceId(String value);

	/**
	 * Gets the value of the applicationId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getApplicationId();

	/**
	 * Sets the value of the applicationId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setApplicationId(String value);

	/**
	 * Gets the value of the productId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getProductId();

	/**
	 * Sets the value of the productId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setProductId(String value);

	/**
	 * Gets the value of the productClass property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getProductClass();

	/**
	 * Sets the value of the productClass property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setProductClass(String value);

	/**
	 * Gets the value of the merchantId property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getMerchantId();

	/**
	 * Sets the value of the merchantId property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setMerchantId(String value);

	/**
	 * Gets the value of the operationNature property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getOperationNature();

	/**
	 * Sets the value of the operationNature property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setOperationNature(String value);

	/**
	 * Gets the value of the clientDate property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public abstract XMLGregorianCalendar getClientDate();

	/**
	 * Sets the value of the clientDate property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link XMLGregorianCalendar }
	 *     
	 */
	public abstract void setClientDate(XMLGregorianCalendar value);

	/**
	 * Gets the value of the paymentMethod property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link PaymentMethodType }
	 *     
	 */
	//public abstract PaymentMethodType getPaymentMethod();

	/**
	 * Sets the value of the paymentMethod property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link PaymentMethodType }
	 *     
	 */
	//public abstract void setPaymentMethod(PaymentMethodType value);

	/**
	 * Gets the value of the additionalChargingMetaData property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link ExtensionType }
	 *     
	 */
	public abstract ExtensionType getAdditionalChargingMetaData();

	/**
	 * Sets the value of the additionalChargingMetaData property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link ExtensionType }
	 *     
	 */
	public abstract void setAdditionalChargingMetaData(ExtensionType value);

}