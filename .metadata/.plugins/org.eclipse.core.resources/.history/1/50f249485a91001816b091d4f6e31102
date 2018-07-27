package com.visa.prj.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.prj.dao.RentalDao;
import com.visa.prj.dao.RentalDaoJpaImpl;
import com.visa.prj.dao.VehicleDao;
import com.visa.prj.dao.VehicleDaoJpaImpl;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Rental;
import com.visa.prj.entity.Vehicle;

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
		String page = "index.jsp";
		String uri = request.getRequestURI();
		if(uri != null) {
			if(uri.endsWith("addVehicle.do")){
				VehicleDao vehicleDao = new VehicleDaoJpaImpl();
				Vehicle v = new Vehicle();
				v.setRegistrationNumber(request.getParameter("regNo"));
				v.setFuelType(request.getParameter("fuelType"));
				v.setType(request.getParameter("vehicleType"));
				v.setCostPerKm(Double.parseDouble(request.getParameter("cost")));
				vehicleDao.addVehicle(v);
				
				//client side redirection
				response.sendRedirect(page + "?msg=Vehicle added successfully!!!");
			} else if(uri.endsWith("rentalForm.do")){
				VehicleDao vehicleDao = new VehicleDaoJpaImpl();
				List<String> regNos = vehicleDao.getRegNos();
				request.setAttribute("regNos", regNos);
				// server side redirection
				request.getRequestDispatcher("rentalForm2.jsp").forward(request, response);
			} else if(uri.endsWith("hireVehicle.do")) {
				String regNo = request.getParameter("vehicle");
				String customerId = request.getParameter("customerId");
				String rentalAmount = request.getParameter("rentalAmount");
				
				Vehicle vehicle = new Vehicle();
				vehicle.setRegistrationNumber(regNo);
				
				Customer customer = new Customer();
				customer.setCustomerId(Integer.parseInt(customerId));
				Rental rental = new Rental();
				rental.setCustomer(customer);
				rental.setVehicle(vehicle);
				rental.setRentalAmount(Double.parseDouble(rentalAmount));
				rental.setRentalDate(new Date());
				
				RentalDao rentalDao = new RentalDaoJpaImpl();
				rentalDao.addRental(rental);
				
				response.sendRedirect(page + "?msg=Rental details saved!!!");
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
