package com.visa.prj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/msword"); // MIME 
		
		String accept = request.getHeader("accept");
		String lang = request.getHeader("accept-language");
		String browser = request.getHeader("user-agent");
		
		out.println("<html><body>");
		out.print("<table border=1>");
		out.println("<tr>");
			out.println("<th> Accept </th>" );
			out.println("<td>"  + accept + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
			out.println("<th> Language </th>" );
			out.println("<td>"  + lang + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
			out.println("<th> Browser </th>" );
			out.println("<td>"  + browser + "</td>");
		out.println("</tr>");
		out.println("</table></body></html>");
		
	}

}
