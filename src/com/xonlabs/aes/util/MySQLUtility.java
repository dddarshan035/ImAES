package com.xonlabs.aes.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLUtility {

	public static Connection connect () throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/AESDB", "root", "root");
	}
}
