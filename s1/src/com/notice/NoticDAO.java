package com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBCPConn;

public class NoticDAO {
	private Connection conn = DBCPConn.getConnection();

	public int insertNotice(NoticeDTO dto, String mode) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "insert into notice(num, userId, subject, content, hitCount, created)"
				+" values(seq_bbs.NEXTVAL,?,?,?,0,TO_CHAR(b.created, 'yyyy-MM-dd') as created)";
			
			pstmt.setString(1, dto.getSubject());
	;
			
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
		}
		return result;

	}

}
