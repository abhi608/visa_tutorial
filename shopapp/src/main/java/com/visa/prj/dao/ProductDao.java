package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Product;


public interface ProductDao {
	List<Product> getProducts() throws DaoException;
	void addProduct(Product p) throws DaoException;
	Product getProduct(int id) throws DaoException;
	void deleteProduct(int id) throws DaoException;
	void updateProduct(Product p) throws DaoException;
	List<Product> getProductsByPrice(double price) throws DaoException;
}
