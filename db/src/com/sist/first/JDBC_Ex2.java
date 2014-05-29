package com.sist.first;

import java.sql.*;

public class JDBC_Ex2 {

	/*
	 * JDBC 6�ܰ� 1) ����̹� �ε� 2) ���ؼ� ��� 3) �����غ� 4) �������� 5) ������ 6) �ݱ�
	 */

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 1) ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1/6 ����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc ����̹� �ε� ����");
			e.printStackTrace();
		}

		// 2) ���ؼ� ���

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "12";

		try {

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2/6 ���ؼ� ��� ����");

			// 3) ���� �غ�
			String sql = "SELECT employee_id, FIRST_NAME, LAST_NAME FROM employees";
			pstmt = conn.prepareStatement(sql);
			System.out.println("3/6 �����غ� ����");

			// 4) ��������

			rs = pstmt.executeQuery();
			System.out.println("3/6 ���� ����");

			// 5) ��� ���
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t " + rs.getString(2)
						+ "\t" + rs.getString(3) + "\n");
			}
			System.out.println("5/6 ��� ��� ����");

		} catch (SQLException e) {
			System.out.println("2/6 ���ؼ� ��� ����");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				System.out.println("6/6 �ݱ� ����");

			} catch (SQLException e) {
				System.out.println("6/6 �ݱ� ����");
				e.printStackTrace();
			}
		}

	}
}
