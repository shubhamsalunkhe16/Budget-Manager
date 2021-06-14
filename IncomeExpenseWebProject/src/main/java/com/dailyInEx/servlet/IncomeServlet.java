package com.dailyInEx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyInEx.dao.IncomeDAO;
import com.dailyInEx.pojo.Income;
import com.dailyInEx.pojo.User;

/**
 * Servlet implementation class IncomeServlet
 */
@WebServlet("/IncomeServlet")
public class IncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Income inc = new Income();
	IncomeDAO incd = new IncomeDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IncomeServlet() {
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
		String id = request.getParameter("id");

		System.out.println(action + " " + id);

		if (action != null && action.equals("delete")) {
			int id1 = Integer.parseInt(id);
			boolean b = incd.deleteIncomeById(id1);
			if (b) {
				response.sendRedirect("IncomeServlet");
			} else {

			}

		} else if (action != null && action.equals("edit")) {
			int id1 = Integer.parseInt(id);
			session.setAttribute("incObj", incd.getdata(id1));

			response.sendRedirect("updateIncome.jsp");

		}

		else {
			User ulog = (User) session.getAttribute("ulog");

			List<Income> incl = incd.getIncomeList(ulog.getId());
			session.setAttribute("incomeList", incl);
			response.sendRedirect("incomeList.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String id1 = request.getParameter("id");
		System.out.println(action + " " + id1);

		if (action != null && action.equals("editForm")) {
			System.out.println("hello form edit form");
			int id = Integer.parseInt(id1);
			Income inco = new Income();
			double income = Double.parseDouble(request.getParameter("income"));
			String incomeType = request.getParameter("incomeType");
			String incomeDate = request.getParameter("incomeDate");
			String description = request.getParameter("description");
			int uid = Integer.parseInt(request.getParameter("uid"));
			System.out.println(
					income + " " + incomeType + " " + incomeDate + "  " + description + "  " + uid + "  " + id);
			inco.setId(id);
			inco.setIncome(income);
			inco.setIncomeType(incomeType);
			inco.setIncomeDate(incomeDate);
			inco.setDescription(description);
			inco.setUserId(uid);

			int b = incd.editIncome(inco);
			if (b > 0) {
				response.sendRedirect("IncomeServlet");
			} else {
				System.out.println("data not inserted");
			}

			// response.sendRedirect("updateIncome.jsp");

		}

		else {

			double income = Double.parseDouble(request.getParameter("income"));
			String incomeType = request.getParameter("incomeType");
			String incomeDate = request.getParameter("incomeDate");
			String description = request.getParameter("description");
			int uid = Integer.parseInt(request.getParameter("uid"));
			System.out.println(income + " " + incomeType + " " + incomeDate + "  " + description + "  " + uid);
			inc.setIncome(income);
			inc.setIncomeType(incomeType);
			inc.setIncomeDate(incomeDate);
			inc.setDescription(description);
			inc.setUserId(uid);

			int b = incd.addIncome(inc);
			System.out.println(b);
			if (b > 0) {
				response.sendRedirect("index.jsp");
			} else {
				System.out.println("data not inserted");
			}
		}
	}

}
