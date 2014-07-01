package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConn;

public class MemberDAO {
	private Connection conn=DBConn.getConnection();
	
	// 회원가입
	public int insertMember(MemberDTO dto) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("INSERT INTO join_basic(userId, userPwd, userName) VALUES (?, ?, ?)");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setString(3, dto.getUserName());
			result=pstmt.executeUpdate();
			pstmt.close();
			
			// sb=new StringBuffer();
			sb.delete(0, sb.length());
			
			sb.append("INSERT INTO join_detail(userId, birth, email, tel, question, answer, job, zip, addr1, addr2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getQuestion());
			pstmt.setString(6, dto.getAnswer());
			pstmt.setString(7, dto.getJob());
			pstmt.setString(8, dto.getZip());
			pstmt.setString(9, dto.getAddr1());
			pstmt.setString(10, dto.getAddr2());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}

	// 회원정보수정
	public int updateMember(MemberDTO dto) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("UPDATE join_basic SET userPwd=?, modify_date=SYSDATE WHERE userId=?");
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, dto.getUserPwd());
			pstmt.setString(2, dto.getUserId());
			
			result=pstmt.executeUpdate();
			pstmt.close();
			
			sb.delete(0, sb.length());
			
			sb.append("UPDATE join_detail SET birth=?, email=?, tel=?, question=?, answer=?, job=?, zip=?, addr1=?, addr2=? WHERE userId=?");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getBirth());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getQuestion());
			pstmt.setString(5, dto.getAnswer());
			pstmt.setString(6, dto.getJob());
			pstmt.setString(7, dto.getZip());
			pstmt.setString(8, dto.getAddr1());
			pstmt.setString(9, dto.getAddr2());
			pstmt.setString(10, dto.getUserId());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	// 회원 정보
	public MemberDTO readMember(String userId) {
		MemberDTO dto=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			// join_basic 과 join_detail 테이블을 LEFT OUTER JOIN
			sb.append("SELECT mb.userId, userPwd, userName");
			sb.append(", created_date, modify_date, enabled, TO_CHAR(birth, 'YYYY-MM-DD') birth, tel, email, job");
			sb.append(", zip, addr1, addr2");
			sb.append(", question, answer");
			sb.append("  FROM join_basic mb LEFT OUTER JOIN join_detail md");
			sb.append("       ON mb.userId = md.userId ");
			sb.append("  WHERE mb.userId = ?");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, userId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new MemberDTO();
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserPwd(rs.getString("userPwd"));
				dto.setCreated_date(rs.getString("created_date"));
				dto.setModify_date(rs.getString("modify_date"));
				dto.setEnabled(rs.getInt("enabled"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				dto.setJob(rs.getString("job"));
				dto.setQuestion(rs.getString("question"));
				dto.setAnswer(rs.getString("answer"));
				dto.setZip(rs.getString("zip"));
				dto.setAddr1(rs.getString("addr1"));
				dto.setAddr2(rs.getString("addr2"));
			}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}
	
}
