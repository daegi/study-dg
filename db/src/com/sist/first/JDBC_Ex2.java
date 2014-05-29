package com.sist.first;

import java.sql.*;

public class JDBC_Ex2 {

	/*
	 * JDBC 6단계 1) 드라이버 로딩 2) 컨넥션 얻기 3) 쿼리준비 4) 쿼리실행 5) 결과얻기 6) 닫기
	 */

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 1) 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1/6 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 로드 실패");
			e.printStackTrace();
		}

		// 2) 컨넥션 얻기

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "12";

		try {

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2/6 컨넥션 얻기 성공");

			// 3) 쿼리 준비
			String sql = "SELECT employee_id, FIRST_NAME, LAST_NAME FROM employees";
			pstmt = conn.prepareStatement(sql);
			System.out.println("3/6 쿼리준비 성공");

			// 4) 쿼리실행

			rs = pstmt.executeQuery();
			System.out.println("3/6 쿼리 성공");

			// 5) 결과 얻기
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t " + rs.getString(2)
						+ "\t" + rs.getString(3) + "\n");
			}
			System.out.println("5/6 결과 얻기 성공");

		} catch (SQLException e) {
			System.out.println("2/6 컨넥션 얻기 성공");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				System.out.println("6/6 닫기 성공");

			} catch (SQLException e) {
				System.out.println("6/6 닫기 실패");
				e.printStackTrace();
			}
		}

	}
}
