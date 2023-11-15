package com.pedroalberto.jdbc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.pedroalberto.jdbc.util.DataTransferObject;

public class Order implements DataTransferObject{

	private long orderId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	private Date creationDate;
	private BigDecimal totalDue;
	private String status;
	private String salespersonFirstName;
	private String salespersonLastName;
	private String salespersonEmail;
	private List<OrderLine> orderLines;
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customerFirstName
	 */
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	/**
	 * @param customerFirstName the customerFirstName to set
	 */
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	/**
	 * @return the customerLastName
	 */
	public String getCustomerLastName() {
		return customerLastName;
	}

	/**
	 * @param customerLastName the customerLastName to set
	 */
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the totalDue
	 */
	public BigDecimal getTotalDue() {
		return totalDue;
	}

	/**
	 * @param totalDue the totalDue to set
	 */
	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the salespersonFirstName
	 */
	public String getSalespersonFirstName() {
		return salespersonFirstName;
	}

	/**
	 * @param salespersonFirstName the salespersonFirstName to set
	 */
	public void setSalespersonFirstName(String salespersonFirstName) {
		this.salespersonFirstName = salespersonFirstName;
	}

	/**
	 * @return the salespersonLastName
	 */
	public String getSalespersonLastName() {
		return salespersonLastName;
	}

	/**
	 * @param salespersonLastName the salespersonLastName to set
	 */
	public void setSalespersonLastName(String salespersonLastName) {
		this.salespersonLastName = salespersonLastName;
	}

	/**
	 * @return the salespersonEmail
	 */
	public String getSalespersonEmail() {
		return salespersonEmail;
	}

	/**
	 * @param salespersonEmail the salespersonEmail to set
	 */
	public void setSalespersonEmail(String salespersonEmail) {
		this.salespersonEmail = salespersonEmail;
	}

	/**
	 * @return the orderLines
	 */
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	/**
	 * @param orderLines the orderLines to set
	 */
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerFirstName=" + customerFirstName + ", customerLastName="
				+ customerLastName + ", customerEmail=" + customerEmail + ", creationDate=" + creationDate
				+ ", totalDue=" + totalDue + ", status=" + status + ", salespersonFirstName=" + salespersonFirstName
				+ ", salespersonLastName=" + salespersonLastName + ", salespersonEmail=" + salespersonEmail
				+ ", orderLines=" + orderLines + "]";
	}
	
	

}
