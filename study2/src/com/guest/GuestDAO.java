package com.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class GuestDAO {
	private Connection conn = DBConn.getConnection();

	public int insertBoard(GuestDTO dto) {
		int result = 0;
		PreparedStatement pstmt = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("insert into guest(");
			sb.append(" num, name, content,pwd,hitCount,ipAddr)");
			sb.append(" values(seq_bbs.nextval,?,?,?,0,?)");

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPwd());
			pstmt.setString(5, dto.getIpAddr());

			// 쿼리 실행(insert 한 개수 리턴)
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());

		}

		return result;
	}

	public List<GuestDTO> listBoard() {
		List<GuestDTO> list = new ArrayList<GuestDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("select num, name, subject,");
			sb.append(" TO_CHAR(created, 'yyyy-MM-dd') created,");
			sb.append(" hitCount from guest");
			sb.append(" order by num desc");

			pstmt = conn.prepareStatement(sb.toString());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestDTO dto = new GuestDTO();

				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setCreated(rs.getString("Created"));

				list.add(dto);

			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}

	public GuestDTO readBoard(int num) {
		GuestDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();

		try {
			sb.append("select num, name, subject,");
			sb.append(" content, created, ipAddr, hitCount, pwd");
			sb.append(" from bbs where num=?");

			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();

			if (rs.next()) {
				dto = new GuestDTO();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setCreated(rs.getString("created"));
				dto.setContent(rs.getString("content"));
				dto.setIpAddr(rs.getString("ipaddr"));
				dto.setPwd(rs.getString("pwd"));
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
		
	}
}
