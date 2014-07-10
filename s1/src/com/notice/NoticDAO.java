package com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.DBCPConn;

public class NoticDAO {
	private Connection conn = DBCPConn.getConnection();
	//private Connection conn = DBConn.getConnection();

	public int insertNotice(NoticeDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "insert into notice(num, userId, subject, content, hitCount)"
					+ " values(seq_notice.NEXTVAL,?,?,?,0)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());

			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
		}
		return result;
	}

	// 데이터 개수 구하기
	public int dataCount(String searchKey, String searchValue) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			if (searchValue.length() == 0)
				sql = "SELECT NVL(COUNT(*), 0) FROM notice n JOIN join_basic m ON n.userId=m.userId ";
			else
				sql = "SELECT NVL(COUNT(*), 0) FROM notice n JOIN join_basic m ON n.userId=m.userId WHERE "
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

	// 글 리스트
	public List<NoticeDTO> getListBoard(int start, int end, String searchKey,
			String searchValue) {
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("SELECT * FROM (");
			sb.append("    SELECT ROW_NUMBER() OVER(ORDER BY num DESC) rnum, ");
			sb.append("       num, n.userId, userName, subject, hitCount, TO_CHAR(n.created, 'yyyy-mm-dd') as created ");
			sb.append("              FROM notice n JOIN join_basic m ON n.userId= m.userId");

			if (searchValue.length() != 0)
				sb.append("                WHERE " + searchKey
						+ " LIKE '%' || ? || '%' ");

			sb.append(" ) WHERE rnum>=? AND rnum <=? ORDER BY  num DESC");

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
				NoticeDTO dto = new NoticeDTO();

				dto.setNum(rs.getInt("num"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setSubject(rs.getString("subject"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setCreated(rs.getString("created"));

				list.add(dto);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	// 해당 게시물 읽기
	public NoticeDTO readNotice(int num) {
		NoticeDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT num, n.userId, userName, subject, content, hitCount, n.created ");
		sb.append("    FROM notice n JOIN join_basic m ON n.userId = m.userId");
		sb.append("      WHERE num = ?");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new NoticeDTO();
				dto.setNum(rs.getInt("num"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setCreated(rs.getString("created"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dto;
	}

	// 조회수 증가하기
	public int updateHitCount(int num) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		sql = "UPDATE notice SET hitCount=hitCount+1 WHERE num=?";

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

}
