package com.visa.prj.entity;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="order_id")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="customer_fk") // required to create a foreign key
	private Customer customer;
	
	private double total;
	
	@Column(name="order_date")
	@Temporal(TemporalType.TIMESTAMP) // takes epoch as timestamp, not specifying this takes Date object
	private Date orderDate = new Date();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_fk") // in this case, foreign key is created in LineItem table(Foreign key always created in "Many" item)
	private List<LineItem> items = new ArrayList<>();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}
}
