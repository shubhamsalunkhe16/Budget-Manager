package com.dailyInEx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dailyInEx.db.DBConnect;
import com.dailyInEx.pojo.User;

public class UserDAO {

	public boolean addUser(String email, String password) {
		Connection con = DBConnect.getConnect();
		String sql = "insert into adduser(email,password) values(?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			int i = ps.executeUpdate();
			con.close();
			System.out.println(i);
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<User> getUserEmailList() {
		Connection con = DBConnect.getConnect();
		String sql = "select id,email from adduser";
		List<User> ul = new ArrayList<User>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u1 = new User();
				u1.setId(rs.getInt(1));
				u1.setEmail(rs.getString(2));
				ul.add(u1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ul;

	}

	public User getLogin(String email, String password) {
		Connection con = DBConnect.getConnect();
		User ulog = new User();
		String sql = "select id,email,password from adduser where email=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ulog.setId(rs.getInt(1));
				ulog.setEmail(rs.getString(2));
				ulog.setPassword(rs.getString(3));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ulog;

	}

	public User allData(int id) {
		Connection con = DBConnect.getConnect();
		User uedit = new User();
		String sql = "select * from adduser where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				uedit.setId(rs.getInt(1));
				uedit.setFname(rs.getString(2));
				uedit.setLname(rs.getString(3));
				uedit.setEmail(rs.getString(4));
				uedit.setContact(rs.getString(5));
				uedit.setGender(rs.getString(6));
				uedit.setAge(rs.getInt(7));
				uedit.setAddress(rs.getString(8));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return uedit;

	}

	public boolean editProfile(User u, int id) {
		Connection con = DBConnect.getConnect();
		String sql = "update adduser set fname=?,lname=?,contact=?,gender=?,age=?,address=?  where id =? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getGender());
			ps.setInt(5, u.getAge());
			ps.setString(6, u.getAddress());
			ps.setInt(7, id);
			int i = ps.executeUpdate();
			con.close();
			System.out.println(i);
			if (i > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
