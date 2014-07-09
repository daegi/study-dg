package com.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.board.BoardDTO;
import com.util.DBCPConn;

public class NoticDAO {
	private Connection conn = DBCPConn.getConnection();

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

	public List<NoticeDTO> getListNotice(int start, int end) {

		List<NoticeDTO> lists = new ArrayList<NoticeDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("");

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();

				dto.setNum(rs.getInt("num"));
				dto.setUserId(rs.getString("userId"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setCreated(rs.getString("Created"));

				lists.add(dto);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());

		}

		return lists;
	}

	public NoticeDTO readNotice(int num) {
		NoticeDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		sb.append("select num, userId, content, hicount, created from notice where num=?");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new NoticeDTO();
				dto.setNum(rs.getInt("num"));
				dto.setUserId(rs.getString("userId"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setCreated(rs.getString("Created"));
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

		sql = "update notice set hitCount = hitCount+1 where num?";

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

	public int dataCount(String start, String end) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select count(*) from notice ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, start);
			pstmt.setString(1, end);

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

}
