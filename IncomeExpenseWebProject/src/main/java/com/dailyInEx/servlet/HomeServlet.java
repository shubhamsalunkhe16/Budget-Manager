package com.dailyInEx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyInEx.dao.ExpenseDAO;
import com.dailyInEx.dao.IncomeDAO;
import com.dailyInEx.pojo.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
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
		HttpSession session = request.getSession();
		User ulog1 = (User) session.getAttribute("ulog");
		IncomeDAO inc = new IncomeDAO();
		ExpenseDAO exd = new ExpenseDAO();
		double totalIncome = inc.getIncome(ulog1.getId());
		double totalExpense = exd.getExpense(ulog1.getId());
		session.setAttribute("totalInc", totalIncome);
		session.setAttribute("totalEx", totalExpense);
		System.out.println(totalIncome + "  " + totalExpense);
		response.sendRedirect("index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
