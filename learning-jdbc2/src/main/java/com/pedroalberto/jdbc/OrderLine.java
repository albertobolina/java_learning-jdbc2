package com.pedroalberto.jdbc;

import java.math.BigDecimal;

public class OrderLine {
	
	private long productQuantity;
	private String productCode;
	private String productName;
	private long productSize;
	private String productVariety;
	private BigDecimal productPrice;
	/**
	 * @return the productQuantity
	 */
	public long getProductQuantity() {
		return productQuantity;
	}
	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productSize
	 */
	public long getProductSize() {
		return productSize;
	}
	/**
	 * @param productSize the productSize to set
	 */
	public void setProductSize(long productSize) {
		this.productSize = productSize;
	}
	/**
	 * @return the productVariety
	 */
	public String getProductVariety() {
		return productVariety;
	}
	/**
	 * @param productVariety the productVariety to set
	 */
	public void setProductVariety(String productVariety) {
		this.productVariety = productVariety;
	}
	/**
	 * @return the productPrice
	 */
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
