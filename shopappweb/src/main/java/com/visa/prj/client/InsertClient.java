package com.visa.prj.client;

import java.util.List;

import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJpaImpl;
import com.visa.prj.entity.Product;

public class InsertClient {
	public static void main(String[] args) {
		ProductDao dao = new ProductDaoJpaImpl();
		Product p = new Product(0, "HP Spectre Laptop", 135000.00, 200);
		
		try {
			dao.addProduct(p);
			
			List<Product> products = dao.getProducts();
			for(Product prd : products) {
				System.out.println(prd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
