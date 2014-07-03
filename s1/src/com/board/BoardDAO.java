package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;

public class BoardDAO {

	private Connection conn = DBConn.getConnection();

	public int insertBoard(BoardDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			// num의 최대값을 구한다.
			sql = "select nvl(max(num),0 )from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxNum = 0;
			if (rs.next())
				maxNum = rs.getInt(1);
			rs.close();
			pstmt.close();

			maxNum++;
			// 위에서 구한 num의 최대값을+1로 num, groupNum을 설정 추가한다.

			sql = "INSERT INTO board (num, userId, subject, content, groupNum,"
					+ " DEPTH, orderNo, parent, saveFileName, originalFileName, hitCount, created)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,? ); ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, dto.getUserId());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, maxNum);

			/*
			 * if (dto.getDepth()== dto.getDepth()) {
			 * 
			 * pstmt.setInt(7, dto.getDepth()); }else{ pstmt.setInt(7,
			 * dto.getDepth()+1);
			 * 
			 * pstmt.setString(8, );
			 */

			pstmt.setInt(7, maxNum);
			pstmt.setInt(8, maxNum);
			pstmt.setString(9, dto.getSaveFileName());
			pstmt.setString(10, dto.getOriginalFileName());
			pstmt.setString(11, dto.getCreated());

			rs = pstmt.executeQuery();

			rs.close();
			pstmt.close();
			
			
			sql = "select groupNum from board";
			pstmt = conn.prepareStatement(sql);
			int selectNum=0;
			if (rs.next() == depth 값) {
				pstmt.setInt(6, dto.getDepth());
			}else{
				for(int i=1 ; 0 < depth값; i++)
					pstmt.setInt(6, dto.getDepth()+i);
			}
			
			
			rs = pstmt.executeQuery();
			rs.close();
			pstmt.close();
			
			
			

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}
}
