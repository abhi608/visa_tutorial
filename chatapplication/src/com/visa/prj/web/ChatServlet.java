package com.visa.prj.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession();
		if(ses != null) {
			String user = (String) ses.getAttribute("user");
			String msg = request.getParameter("msg");
			ServletContext ctx = request.getServletContext();
			if(ctx.getAttribute("messages") == null) {
				ctx.setAttribute("messages", new ArrayList<String>());
			}
			
			List<String> msgs = (List<String>) ctx.getAttribute("messages");
			msgs.add("@" + user + ":" + msg);
			ctx.setAttribute("messages", msgs);
			response.sendRedirect("chat.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
