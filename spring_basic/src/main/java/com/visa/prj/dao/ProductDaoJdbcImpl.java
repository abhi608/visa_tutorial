package com.visa.prj.dao;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void addProduct() {
		System.out.println("Product stored using JDBC!!!");
	}

}
