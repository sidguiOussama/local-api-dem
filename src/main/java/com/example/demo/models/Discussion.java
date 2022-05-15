package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Discussion implements Serializable {

	@Id @GeneratedValue
	private int id;
	private String subject;
    private String orderReference;
    private String offerId;
    private String productId;
    private String subTypologyCode;
    private String typologyCode;
    private String salesChannel;
    private String externalReference;
    private String sellerId;
    private String customerId;
    
    @ManyToOne
    @JoinColumn
    private Message message;
    
    
    
	public Discussion() {
		super();
	}
	public Discussion(int id,String subject, String orderReference, String offerId, String productId, String subTypologyCode,
			String typologyCode, String salesChannel, String externalReference, String sellerId, String customerId,
			Message message) {
		super();
		this.id = id;
		this.subject = subject;
		this.orderReference = orderReference;
		this.offerId = offerId;
		this.productId = productId;
		this.subTypologyCode = subTypologyCode;
		this.typologyCode = typologyCode;
		this.salesChannel = salesChannel;
		this.externalReference = externalReference;
		this.sellerId = sellerId;
		this.customerId = customerId;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getOrderReference() {
		return orderReference;
	}
	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getSubTypologyCode() {
		return subTypologyCode;
	}
	public void setSubTypologyCode(String subTypologyCode) {
		this.subTypologyCode = subTypologyCode;
	}
	public String getTypologyCode() {
		return typologyCode;
	}
	public void setTypologyCode(String typologyCode) {
		this.typologyCode = typologyCode;
	}
	public String getSalesChannel() {
		return salesChannel;
	}
	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}
	public String getExternalReference() {
		return externalReference;
	}
	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Discussion [id=" + id + ", subject=" + subject + ", orderReference=" + orderReference + ", offerId="
				+ offerId + ", productId=" + productId + ", subTypologyCode=" + subTypologyCode + ", typologyCode="
				+ typologyCode + ", salesChannel=" + salesChannel + ", externalReference=" + externalReference
				+ ", sellerId=" + sellerId + ", customerId=" + customerId + ", message=" + message + "]";
	}
    
    
    
}
