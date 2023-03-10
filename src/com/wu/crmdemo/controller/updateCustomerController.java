package com.wu.crmdemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wu.crmdemo.dao.CustomerDAO;

/**
 * Servlet implementation class updateCustomerController
 */
@WebServlet("/updateCustomerController")
public class updateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  fristName = request.getParameter("fname");
		String  lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String lastName1 = request.getParameter("lname1");
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.updateCustomer(fristName,lastName,email,lastName1);
		response.sendRedirect("displayCustomerServlet");
	}

}
