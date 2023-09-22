package com.clickncash.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "myOrders")
public class MyOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private String orderId;
	private Integer amount;
	private String status;
	private String receiptId;
	private String paymentId;
	private Timestamp createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public MyOrders(Long id, Long userId, String orderId, Integer amount, String status, String receiptId,
			String paymentId, Timestamp createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderId = orderId;
		this.amount = amount;
		this.status = status;
		this.receiptId = receiptId;
		this.paymentId = paymentId;
		this.createdAt = createdAt;
	}
	public MyOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
