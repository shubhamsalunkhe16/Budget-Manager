package com.dailyInEx.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyInEx.dao.UserDAO;
import com.dailyInEx.pojo.User;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		System.out.println(email + " " + password);
		UserDAO usd = new UserDAO();
		User ulog = usd.getLogin(email, password);
		System.out.println(ulog.getEmail() + " " + ulog.getPassword() + "  " + ulog.getId());
		// if (u1 != null && u1.getEmail().equals(email) &&
		// u1.getPassword().equals(password)) {
		if (ulog != null && ulog.getEmail().equals(email) && ulog.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("ulog", ulog);

			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("msg", "Invalid User....Please Try Again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

			rd.forward(request, response);
		}
	}

}
