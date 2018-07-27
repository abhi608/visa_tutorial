package com.visa.prj.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.visa.prj.entity.Item;
import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.JPAUtil;

public class InheritanceClient {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
//			Mobile m = new Mobile(1, "OnePlus 5t", 45000.00, "4G");
//			Tv t = new Tv(2, "Sony Bravia", 120000.00, "OLED");
//			em.persist(m);
//			em.persist(t);
			
			Query query = em.createQuery("from Item");
			List<Item> items = query.getResultList();
			for(Item i : items) {
				System.out.println(i.getName());
				if( i instanceof Mobile) {
					Mobile m = (Mobile) i;
					System.out.println(m.getConnectivity());
				}
			}
		em.getTransaction().commit();
	}
}
