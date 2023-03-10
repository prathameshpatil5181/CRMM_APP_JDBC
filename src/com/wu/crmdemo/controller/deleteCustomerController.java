package com.wu.crmdemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wu.crmdemo.dao.CustomerDAO;

/**
 * Servlet implementation class deleteCustomerController
 */
@WebServlet("/deleteCustomerController")
public class deleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  lastName = request.getParameter("lname");
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.deleteCustomer(lastName);
		response.sendRedirect("displayCustomerServlet");
	}


		
}
