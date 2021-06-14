package com.dailyInEx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailyInEx.dao.UserDAO;
import com.dailyInEx.pojo.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO ud = new UserDAO();

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User ulog2 = (User) session.getAttribute("ulog");
		User u = ud.allData(ulog2.getId());
		System.out.println(ulog2.getId());
		System.out.println(u.getEmail());
		session.setAttribute("allData", ud.allData(ulog2.getId()));
		User allData = (User) session.getAttribute("allData");
		System.out.print(allData.getAddress() + " " + allData.getId());
		response.sendRedirect("editProfile.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		UserDAO usd = new UserDAO();
		// int id = Integer.parseInt(request.getParameter("id"));

		if (action != null && action.equals("edit")) {

			User uedit1 = new User();
			System.out.println("hello from edit profile");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String contact = request.getParameter("contact");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			int age = Integer.parseInt(request.getParameter("age"));
			String id1 = request.getParameter("id");
			System.out.println(
					fname + " " + lname + " " + contact + " " + address + " " + gender + " " + age + " " + id1);
			int id = Integer.parseInt(id1);
			uedit1.setId(id);
			uedit1.setAddress(address);
			uedit1.setAge(age);
			uedit1.setContact(contact);
			uedit1.setFname(fname);
			uedit1.setGender(gender);
			uedit1.setLname(lname);

			boolean b = ud.editProfile(uedit1, id);
			System.out.println(b);
			if (b) {
				response.sendRedirect("index.jsp");
			} else {
				out.println("data not inserted to DB");
			}

		} else if (action != null && action.equals("register"))

		{

			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			String cpassword = request.getParameter("cpass");
			System.out.println(password + " " + email);

			if (password != null && password.equals(cpassword) && cpassword != null) {
				boolean b = ud.addUser(email, password);
				System.out.println(b);
				if (b) {
					response.sendRedirect("index.jsp");
				} else {
					out.println("data not inserted to DB");
				}

			} else {
				out.println("password not matching");

			}
		}

	}

}
