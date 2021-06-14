package com.dailyInEx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dailyInEx.db.DBConnect;
import com.dailyInEx.pojo.Income;

public class IncomeDAO {
	Connection con = DBConnect.getConnect();
	Income inc = new Income();

	public int addIncome(Income inc) {
		String sql = "insert into income(income,income_type,income_date,description,user_id)values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, inc.getIncome());
			ps.setString(2, inc.getIncomeType());
			ps.setString(3, inc.getIncomeDate());
			ps.setString(4, inc.getDescription());
			ps.setInt(5, inc.getUserId());

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

	public List<Income> getIncomeList(int id) {
		List<Income> inli = new ArrayList<Income>();
		String sql = "select * from income where user_id=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Income inco = new Income();
				inco.setId(rs.getInt(1));
				inco.setIncome(rs.getDouble(2));
				inco.setIncomeType(rs.getString(3));
				inco.setIncomeDate(rs.getString(4));
				inco.setDescription(rs.getString(5));
				inco.setUserId(rs.getInt(6));
				inli.add(inco);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return inli;

	}

	public boolean deleteIncomeById(int id) {
		String sql = "delete from income where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

	public Income getdata(int id) {
		Income inc1 = new Income();
		String sql = "select * from income where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				inc1.setId(rs.getInt(1));
				inc1.setIncome(rs.getDouble(2));
				inc1.setIncomeType(rs.getString(3));
				inc1.setIncomeDate(rs.getString(4));
				inc1.setDescription(rs.getString(5));
				inc1.setUserId(rs.getInt(6));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inc1;

	}

	public int editIncome(Income inco) {
		String sql = "update income set income=?,income_type=?,income_date=?,description=?,user_id=?  where id =? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, inco.getIncome());
			ps.setString(2, inco.getIncomeType());
			ps.setString(3, inco.getIncomeDate());
			ps.setString(4, inco.getDescription());
			ps.setInt(5, inco.getUserId());
			ps.setInt(6, inco.getId());

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

	public double getIncome(int id) {
		double totalIncome = 0;
		String sql = "select income from income where user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				totalIncome += rs.getDouble(1);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return totalIncome;

	}

}
