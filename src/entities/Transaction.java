package entities;

import java.util.Date;

public class Transaction {

	private Integer transactionId;

	private Integer productId;

	private Integer userId;

	private Date dateTransaction;

	private String transactionType;

	private Integer quantity;

	private Double unityValue;

	private Double totalValue;

	public Transaction(Integer transactionId, Integer productId, Integer userId, Date dateTransaction,
			String transactionType, Integer quantity, Double unityValue, Double totalValue) {
		this.transactionId = transactionId;
		this.productId = productId;
		this.userId = userId;
		this.dateTransaction = dateTransaction;
		this.transactionType = transactionType;
		this.quantity = quantity;
		this.unityValue = unityValue;
		this.totalValue = totalValue;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnityValue() {
		return unityValue;
	}

	public void setUnityValue(Double unityValue) {
		this.unityValue = unityValue;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

}