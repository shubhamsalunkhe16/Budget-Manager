package com.dailyInEx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dailyInEx.db.DBConnect;
import com.dailyInEx.pojo.Expense;

public class ExpenseDAO {
	Connection con = DBConnect.getConnect();

	public int addExpense(Expense ex) {

		String sql = "insert into expense (expense,expense_type,expense_date,description,user_id) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, ex.getExpense());
			ps.setString(2, ex.getExpenseType());
			ps.setString(3, ex.getExpenseDate());
			ps.setString(4, ex.getDescription());
			ps.setInt(5, ex.getUserId());

			int i = ps.executeUpdate();

			if (i > 0) {
				return 1;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public List<Expense> getList(int id) {
		List<Expense> exl = new ArrayList<Expense>();

		try {
			String sql = "select * from expense where user_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expense ex1 = new Expense();
				ex1.setId(rs.getInt(1));
				ex1.setExpense(rs.getDouble(2));
				ex1.setExpenseType(rs.getString(3));
				ex1.setExpenseDate(rs.getString(4));
				ex1.setDescription(rs.getString(5));
				ex1.setUserId(rs.getInt(6));

				exl.add(ex1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exl;

	}

	public boolean deleteById(int id) {
		String sql = "delete from expense where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

	public Expense getdata(int id) {
		Expense exp = new Expense();
		String sql = "select * from expense where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				exp.setId(rs.getInt(1));
				exp.setExpense(rs.getDouble(2));
				exp.setExpenseType(rs.getString(3));
				exp.setExpenseDate(rs.getString(4));
				exp.setDescription(rs.getString(5));
				exp.setUserId(rs.getInt(6));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return exp;

	}

	public int editExpense(Expense exx) {
		String sql = "update expense set expense=?,expense_type=?,expense_date=?,description=?,user_id=?  where id =? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, exx.getExpense());
			ps.setString(2, exx.getExpenseType());
			ps.setString(3, exx.getExpenseDate());
			ps.setString(4, exx.getDescription());
			ps.setInt(5, exx.getUserId());
			ps.setInt(6, exx.getId());

			int i = ps.executeUpdate();
			System.out.println(i);
			if (i > 0) {
				return 1;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public double getExpense(int id) {
		double totalExpense = 0;
		String sql = "select expense from expense where user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalExpense += rs.getDouble(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return totalExpense;

	}

}
