package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class ProductClient {
	
	private static boolean isMobile(Product p) {
		return p.getCategory().equals("mobile");
	}
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(124, "iPhone x", 120000.00, "mobile"));
		products.add(new Product(634, "Onida", 3500.00, "tv"));
		products.add(new Product(611, "MotoG", 12999.00, "mobile"));
		products.add(new Product(72, "Sony Bravia", 103500.00, "computer"));
		
//		products.stream()
//		.filter(p -> p.getCategory().equals("mobile"))
//		.map(p -> p.getName())
//		.forEach(System.out::println);
		
//		products.stream()
//		.filter(ProductClient::isMobile)
//		.map(p -> p.getName())
//		.forEach(System.out::println);
		
		List<Product> mobiles = products.stream()
				.filter(ProductClient::isMobile)
				.collect(Collectors.toList());
		
		mobiles.forEach(m -> {
			System.out.println(m.getName() + " , " + m.getCategory() + " , " + m.getPrice());
		});
		
		double total = products.stream().map(p -> p.getPrice()).reduce(0.0, (v1, v2) -> v1 + v2);
		System.out.println(total);
		
		System.out.println("******************");
		
		Map<String, List<Product>> productMap = products.stream().
				collect(Collectors.groupingBy(p -> p.getCategory()));
		
		productMap.forEach((k,v) -> {
			System.out.println("Ctaegory: " + k);
			v.forEach(System.out::println);
		});
	}
	
}