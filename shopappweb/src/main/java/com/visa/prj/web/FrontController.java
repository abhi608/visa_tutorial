package com.visa.prj.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.CustomerDaoJpaImpl;
import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJpaImpl;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.LineItem;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri != null) {
			if(uri.endsWith("login.do")) {
				String email = request.getParameter("email");
				CustomerDao customerDao = new CustomerDaoJpaImpl();
				try {
					Customer customer = customerDao.getCustomer(email);
					if(customer != null) {
						HttpSession ses = request.getSession();
						ses.setAttribute("user", email);
						response.sendRedirect("index.jsp?msg=Logged in");
					} else {
						response.sendRedirect("index.jsp?msg=User not found");
					}
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("index.jsp?msg=Some problem occured");
				}
			} else if(uri.endsWith("logout.do")) {
				HttpSession ses = request.getSession(false);
				if(ses != null) {
					ses.invalidate(); // terminate the session
				}
			} else if(uri.endsWith("productAdd.do")) {
				String name = request.getParameter("name");
				Double price = Double.parseDouble(request.getParameter("price"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				Product p = new Product(0, name, price, quantity);
				ProductDao productDao = new ProductDaoJpaImpl();
				try {
					productDao.addProduct(p);
					response.sendRedirect("index.jsp?msg=Product added successfully");
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("index.jsp?msg=Product addition failed");
				}
			} else if(uri.endsWith("listProduct.do")) {
				ProductDao productDao = new ProductDaoJpaImpl();
				try {
					List<Product> p1 = productDao.getProducts();
					List<Product> products = new ArrayList<>();
					for(Product p : p1) {
						if(p.getQuantity() > 0) {
							products.add(p);
						}
					}
					request.setAttribute("products", products);
					request.getRequestDispatcher("productList.jsp").forward(request, response);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("index.jsp?msg=Some problem occured");
				}
			} else if(uri.endsWith("cartAdd.do")) {
				String[] productIds = request.getParameterValues("id");
				HttpSession ses = request.getSession(false);
				ses.setAttribute("product_ids", productIds);
				response.sendRedirect("checkoutCart.jsp");
			} else if(uri.endsWith("checkout.do")) {
				String[] productIds = request.getParameterValues("id");
				ProductDao productDao = new ProductDaoJpaImpl();
				HttpSession ses = request.getSession(false);
				EntityManager em = JPAUtil.getEntityManager();
				
				em.getTransaction().begin();
					Order order = new Order();
					Customer c = em.find(Customer.class, ses.getAttribute("user"));
					order.setCustomer(c);
					double totalAmount = 0.0;
					for(String s : productIds) {
						int id = Integer.parseInt(s);
						Product p1 = em.find(Product.class, id);
						LineItem l1 = new LineItem();
						l1.setProduct(p1);
						l1.setQuantity(1);
						p1.setQuantity(p1.getQuantity() - 1);
						l1.setAmount(p1.getPrice() * l1.getQuantity());
						order.getItems().add(l1);
						totalAmount += l1.getAmount();
					}
					order.setTotal(totalAmount);
					em.persist(order);
				em.getTransaction().commit();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
