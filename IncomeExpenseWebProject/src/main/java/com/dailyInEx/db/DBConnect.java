package com.dailyInEx.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnect() {
		Connection con = null;
		String uname = "root";
		String password = "";
		String driver = "com.mysql.cj.jdbc.Driver";
		String dbname = "adv_daily";
		String url = "jdbc:mysql://localhost:3306/" + dbname;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uname, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

}
