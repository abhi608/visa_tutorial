package com.visa.prj.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
//@Inheritance(strategy=InheritanceType.JOINED) // different tables for base, and child classes where child class only contain their own attributes
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // no table for base class, only for child classes
@DiscriminatorColumn(name="type") //single table
public class Item { // Note: No query on JOINED needs innerJoin, it is needed by Table_per_class and single table 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	private String name;
	
	private double price;

	public Item() {
	}

	public Item(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
