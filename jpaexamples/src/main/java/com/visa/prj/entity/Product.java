package com.visa.prj.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // can't be given for a string, only works for integers == AUTO-INCREMENT
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	private String category;
	
	@Column(name="list_price")
	private double price;
	
	private boolean disconnected;
	
	@Lob
	private byte[] attachments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDisconnected() {
		return disconnected;
	}

	public void setDisconnected(boolean disconnected) {
		this.disconnected = disconnected;
	}

	public byte[] getAttachments() {
		return attachments;
	}

	public void setAttachments(byte[] attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", category=" + category + ", price=" + price
				+ ", disconnected=" + disconnected + ", attachments=" + Arrays.toString(attachments) + "]";
	}
	
	
}
