package com.telefonica.schemas.unica.rest.transactionstorage.v2_1;

import java.math.BigDecimal;
import java.util.List;

public interface ChargingInformationTypeInt {

	/**
	 * Gets the value of the description property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the description property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getDescription().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link String }
	 * 
	 * 
	 */
	public abstract List<String> getDescription();

	/**
	 * Gets the value of the amount property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *     
	 */
	public abstract BigDecimal getAmount();

	/**
	 * Sets the value of the amount property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *     
	 */
	public abstract void setAmount(BigDecimal value);

	/**
	 * Gets the value of the taxAmount property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *     
	 */
	public abstract BigDecimal getTaxAmount();

	/**
	 * Sets the value of the taxAmount property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *     
	 */
	public abstract void setTaxAmount(BigDecimal value);

	/**
	 * Gets the value of the totalAmount property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *     
	 */
	public abstract BigDecimal getTotalAmount();

	/**
	 * Sets the value of the totalAmount property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *     
	 */
	public abstract void setTotalAmount(BigDecimal value);

	/**
	 * Gets the value of the currency property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getCurrency();

	/**
	 * Sets the value of the currency property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setCurrency(String value);

	/**
	 * Gets the value of the code property.
	 * 
	 * @return
	 *     possible object is
	 *     {@link String }
	 *     
	 */
	public abstract String getCode();

	/**
	 * Sets the value of the code property.
	 * 
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *     
	 */
	public abstract void setCode(String value);
}