package com.dailyInEx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyInEx.dao.ExpenseDAO;
import com.dailyInEx.dao.UserDAO;
import com.dailyInEx.pojo.Expense;
import com.dailyInEx.pojo.User;

/**
 * Servlet implementation class ExpenseServlet
 */
@WebServlet("/ExpenseServlet")
public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Expense ex = new Expense();
	ExpenseDAO exd = new ExpenseDAO();
	UserDAO usd = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExpenseServlet() {
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
		String action = request.getParameter("action");
		User ulog = (User) session.getAttribute("ulog");
		String id1 = request.getParameter("id");
		session.setAttribute("ulist", usd.getUserEmailList());
		session.setAttribute("exList", exd.getList(ulog.getId()));

		// System.out.println(action);
		if (action != null && action.equals("getlist")) {

			// User ulog1 = (User) session.getAttribute("ulog");

			session.setAttribute("exList", exd.getList(ulog.getId()));
			response.sendRedirect("expenseList.jsp");

		} else if (action != null && action.equals("delete")) {
			int id = Integer.parseInt(id1);
			// System.out.println(id + " " + action);

			boolean b = exd.deleteById(id);
			if (b) {
				response.sendRedirect("ExpenseServlet?action=getlist");
			} else {

			}

		}

		else if (action != null && action.equals("edit")) {
			int id = Integer.parseInt(id1);
			// System.out.println(id);

			System.out.println(id + "helllooo " + action);
			session.setAttribute("expObj", exd.getdata(id));
			response.sendRedirect("updateExpense.jsp");

		} else {
			session.setAttribute("ulist", usd.getUserEmailList());
			response.sendRedirect("addexpense.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		// String id1 = request.getParameter("id");
		System.out.println(action);
		// System.out.println(id1);

		if (action != null && action.equals("editForm")) {
			// int id = Integer.parseInt(id1);
			// System.out.println(id);
			System.out.println("hello from editForm");

			Expense exx = new Expense();
			int id = Integer.parseInt(request.getParameter("id"));
			double expense = Double.parseDouble(request.getParameter("expense"));
			String expenseType = request.getParameter("expenseType");
			String expenseDate = request.getParameter("expenseDate");
			String description = request.getParameter("description");
			int uid = Integer.parseInt(request.getParameter("uid"));
			System.out.println(
					uid + " " + description + " " + expense + " " + expenseType + " " + expenseDate + "  " + id);

			exx.setId(id);
			exx.setExpense(expense);
			exx.setExpenseType(expenseType);
			exx.setExpenseDate(expenseDate);
			exx.setDescription(description);
			exx.setUserId(uid);

			int n = exd.editExpense(exx);
			if (n > 0) {
				response.sendRedirect("ExpenseServlet?action=getlist");
			} else {

			}

		} else {

			double expense = Double.parseDouble(request.getParameter("expense"));
			String expenseType = request.getParameter("expenseType");
			String expenseDate = request.getParameter("expenseDate");
			String description = request.getParameter("description");
			int uid = Integer.parseInt(request.getParameter("uid"));
			System.out.println(uid + " " + description + " " + expense + " " + expenseType + " " + expenseDate);
			ex.setId(uid);
			ex.setExpense(expense);
			ex.setExpenseType(expenseType);
			ex.setExpenseDate(expenseDate);
			ex.setDescription(description);
			ex.setUserId(uid);

			int n = exd.addExpense(ex);

			if (n > 0) {
				response.sendRedirect("index.jsp");
			} else {
				System.out.println("Data Not Inserted To DB");
			}
		}
	}

}
