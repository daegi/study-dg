package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class BoardDAO {
	private Connection conn = DBConn.getConnection();

	public int insertBoard(BoardDTO dto, String mode) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			// num의 최대값
			sql = "SELECT NVL(MAX(num), 0) FROM board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxNum = 0;
			if (rs.next())
				maxNum = rs.getInt(1);
			rs.close();
			pstmt.close();

			maxNum++;

			String fields = "num, userId, subject, content, groupNum, depth, orderNo, parent, saveFileName, originalFileName ";
			sql = "INSERT INTO board (" + fields
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, maxNum);
			pstmt.setString(2, dto.getUserId());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			
			if (mode.equals("created")) {
				pstmt.setInt(5, maxNum);				
			}else
				pstmt.setInt(5, dto.getGroupNum());
			pstmt.setInt(6, dto.getDepth());
			pstmt.setInt(7, dto.getOrderNo());
			pstmt.setInt(8, dto.getParent());
			pstmt.setString(9, dto.getSaveFileName());
			pstmt.setString(10, dto.getOriginalFileName());

			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	public int dataCount(String searchKey, String searchValue) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			if (searchValue.length() == 0)
				sql = "SELECT NVL(COUNT(*), 0) FROM board b JOIN join_basic m ON b.userId=m.userId ";
			else
				sql = "SELECT NVL(COUNT(*), 0) FROM board b JOIN join_basic m ON b.userId=m.userId WHERE "
						+ searchKey + " LIKE '%' || ? || '%' ";

			pstmt = conn.prepareStatement(sql);

			if (searchValue.length() != 0)
				pstmt.setString(1, searchValue);

			rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	// 리스트
	public List<BoardDTO> getListBoard(int start, int end, String searchKey,
			String searchValue) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("SELECT * FROM (");
			sb.append("    SELECT ROW_NUMBER() OVER(ORDER BY groupNum DESC, orderNo ASC) rnum, ");
			sb.append("       num, b.userId, userName, subject, groupNum, orderNo, depth, parent,  hitCount, TO_CHAR(b.created, 'yyyy-mm-dd') as created ");
			sb.append("        ,saveFileName ");
			sb.append("              FROM board b JOIN join_basic m ON b.userId=m.userId");

			if (searchValue.length() != 0)
				sb.append("                WHERE " + searchKey
						+ " LIKE '%' || ? || '%' ");

			sb.append(" ) WHERE rnum>=? AND rnum <=? ORDER BY groupNum DESC, orderNo ASC");

			pstmt = conn.prepareStatement(sb.toString());

			if (searchValue.length() == 0) {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else {
				pstmt.setString(1, searchValue);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setSubject(rs.getString("subject"));
				dto.setDepth(rs.getInt("depth"));
				dto.setParent(rs.getInt("parent"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setCreated(rs.getString("created"));
				dto.setSaveFileName(rs.getString("saveFileName"));

				list.add(dto);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	public BoardDTO readBoard(int num) {
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT num, b.userId, userName, subject, content, groupNum, depth, orderNo, parent, hitCount, b.created, saveFilename, originalFilename ");
		sb.append("    FROM board b JOIN join_basic m ON b.userId=m.userId");
		sb.append("    WHERE num=? ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setGroupNum(rs.getInt("groupNum"));
				dto.setDepth(rs.getInt("depth"));
				dto.setOrderNo(rs.getInt("orderNo"));
				dto.setParent(rs.getInt("parent"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setCreated(rs.getString("created"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				dto.setOriginalFileName(rs.getString("originalFileName"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dto;
	}

	public int updateHitCount(int num) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		sql = "UPDATE board SET hitCount=hitCount+1 WHERE num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	public int updateBoard(BoardDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("UPDATE board SET subject=?, content=?, saveFileName=?, originalFileName=? ");
			sb.append("   WHERE num=?");

			pstmt = conn.prepareStatement(sb.toString());
	
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getSaveFileName());
			pstmt.setString(4, dto.getOriginalFileName());
			pstmt.setInt(5, dto.getNum());

			result = pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	public int deleteBoard(int num) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "DELETE FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	public int updateDownCount(int num) {
		int result = 0;

		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "UPDATE board SET downCount=downCount+1 WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}
	
	
	public void updateOrderNo(int groupNum, int orderNo){
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			sql = "update board set orderNo = orderNo+1";
			sql+="where groupNum=? and orderNo >?";
			
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, groupNum);
			pstmt.setInt(2, orderNo);
					
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
