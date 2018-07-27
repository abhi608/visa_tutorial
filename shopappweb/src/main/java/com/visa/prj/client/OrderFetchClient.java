package com.visa.prj.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.visa.prj.entity.Order;
import com.visa.prj.util.JPAUtil;

public class OrderFetchClient {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
//		Order order = em.find(Order.class, 1);
//		System.out.println("order Details:");
//		System.out.println("Total: " + order.getTotal());
//		System.out.println("Date: " + order.getOrderDate());
//		System.out.println("Customer: " + order.getCustomer());
//		System.out.println("Items ");
//		order.getItems().forEach(item -> {
//			System.out.println(item.getProduct().getName() + ", " + item.getQuantity() + ", " + item.getAmount());
//		});
		
		String q ="select o.orderDate, o.total, c.firstName, p.name, i.quantity "
				+ " from Order o inner join o.items i inner join i.product p inner join o.customer c";
		Query query = em.createQuery(q);
		List<Object[]> info = query.getResultList();
		for(int i = 0 ; i < info.size(); i++) {
			Object[] elems = info.get(i);
			for (int j = 0; j < elems.length; j++) {
				System.out.print(elems[j] + " ");
			}
			System.out.println();
		}
	}
}
