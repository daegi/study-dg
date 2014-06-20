package model;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 오라클에 접속하여 Connection 객체를 리턴하는 클래스
public class DBConn {
	public static Connection getConn(){
		DataSource ds=null;
		Connection conn = null;
		try{
			Context context = new InitialContext(); 
			ds = (DataSource)context.lookup(
					"java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
