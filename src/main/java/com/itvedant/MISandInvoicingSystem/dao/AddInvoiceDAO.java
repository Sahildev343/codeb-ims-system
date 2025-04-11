package com.itvedant.MISandInvoicingSystem.dao;

import java.time.LocalDate;

public class AddInvoiceDAO {

	
	private String invoiceNumber;
	
	private Double amount;
	
	private Double gstAmount;
	
	private String status;
	
	private LocalDate issueDate;
	
	private LocalDate dueDate;
	
	private Integer estimateId;
	
	private Integer clientId;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(Double gstAmount) {
		this.gstAmount = gstAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getEstimateId() {
		return estimateId;
	}

	public void setEstimateId(Integer estimateId) {
		this.estimateId = estimateId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	
	
}
