package com.itvedant.MISandInvoicingSystem.dao;

public class UpdateEstimateDAO {

	private Double amount;
	private String status;
	private Integer clientId;
	private Integer chainId;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getChainId() {
		return chainId;
	}
	public void setChainId(Integer chainId) {
		this.chainId = chainId;
	}
	
	
}
