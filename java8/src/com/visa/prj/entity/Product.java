package com.visa.prj.entity;

public class Product implements Comparable<Product> {
	private int id;
	private String name;
	private double price;
	private String category;
	public Product() {
	}
	public Product(int id, String name, double price, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
//	public boolean isExpensive() {
//		return false;
//	}
	
	@Override
	public int compareTo(Product p) {
//		Project p = (Project) o;
		if(this.price > p.price) {
			return 1;
		} else if(p.price > this.price) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
