package com.xonlabs.aes.daoimpl;

import java.sql.Connection;

import com.xonlabs.aes.util.MySQLUtility;

public class KeysDAOImpl {
	
	public void writeKey(String email, String key) throws Exception {
		Connection con = null;
		try {
			con = MySQLUtility.connect();
			con.createStatement().execute("insert into enckeys values ('','','') ");
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
