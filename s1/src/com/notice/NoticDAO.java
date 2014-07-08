package com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBCPConn;

public class NoticDAO {
	private Connection conn = DBCPConn.getConnection();

	public int insertNotice(NoticeDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "insert into notice(num, userId, subject, content, hitCount, created)"
					+ " values(seq_bbs.NEXTVAL,?,?,?,0,TO_CHAR(created, 'yyyy-MM-dd'))";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());

			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
		}
		return result;
	}
}
