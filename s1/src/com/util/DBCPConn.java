package com.util;

import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.naming.Context;

public class DBCPConn {
	private static Connection conn = null;

	private DBCPConn() {
	}

	public static Connection getConnection() {
		try {
			if (conn == null) {
				// 이름 객체로 바인딩
				Context ctx = new InitialContext();
				// 이름으로 객체를 찾음
				Context context = (Context) ctx.lookup("java:/comp/env");
				// 이름으로 찾은 객체를 리턴 받음
				DataSource ds = (DataSource) context.lookup("jdbc/myoracle");
				// DataSource ds = (DataSource) ctx.lookup(
				// "java:comp/env/jdbc/myoracle");

				conn = ds.getConnection();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return conn;
	}

	public static void close() {
		if (conn == null)
			return;

		try {
			if (!conn.isClosed())
				conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		conn = null;
	}
}
