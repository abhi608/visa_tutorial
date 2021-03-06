package com.visa.prj.client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Project;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.Utility;

public class ProductClient {
	public static void main(String[] args) {
		Project[] products = new Project[4];
		products[0] = new Mobile(124, "iPhone x", 120000.00, "4G"); // upcasting
		products[1] = new Tv(634, "Onida", 3500.00, "CRT");
		products[2] = new Mobile(611, "MotoG", 12999.00, "4G");
		products[3] = new Tv(72, "Sony Bravia", 103500.00, "LED");
		
		Utility.sort(products);
		for(Project p : products) {
			System.out.println(p); // this calls toString()
		}
		printExpensive(products);
	}
	
	// Open Close principle
	private static void printExpensive(Project[] products) {
		// TODO Auto-generated method stub
		
		for(int i=0; i < products.length; i++) {
//			System.out.println("LOL" + products.length);
			if(products[i].isExpensive()) {
				
				System.out.print(products[i].getName() + ", " + products[i].getPrice());
				printDetails(products[i]);
			}
		}

	}

//	Reflection API
	private static void printDetails(Project product) {
		// TODO Auto-generated method stub
		Method[] methods = product.getClass().getDeclaredMethods();
		for(Method m : methods) {
			if(m.getName().startsWith("get")) {
				try {
					Object ret = m.invoke(product);
					System.out.println(ret);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

//	private static void printDetails(Project product) {
//		// TODO Auto-generated method stub
//		if(product instanceof Mobile) {
//			Mobile m = (Mobile) product;
//			System.out.println(m.getConnectivity());
//		} else if(product instanceof Tv) {
//			Tv t = (Tv) product;
//			System.out.println(t.getScreenType());
//		}
//	}
}
