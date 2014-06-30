package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.DBConn;

public class MemberDAO {
	private Connection conn = DBConn.getConnection();

	// 회원가입, 과제
	public int insertMember(MemberDTO dto) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		

		
		try {
			sb.append("INSERT INTO member(");
			sb.append("userId, userPwd, userName, enabled, creted_data, modify_date");
			sb.append(") VALUES (?, ?, 1, ?, 0, ?)");
			
	
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setString(5, dto.getModify_date());
						
			result=pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;

	}

	// 회원정보 수정 과제
	public int updateMember(MemberDTO dto) {	
	
		int result=0;
		StringBuffer sb=new StringBuffer();
		PreparedStatement pstmt=null;
		
		try {
			sb.append("update member set email=?,tel=?,question=?, answer=?,zip=? ,addr1=?,addr2=? where userId=?");
			pstmt=conn.prepareStatement(sb.toString());
			
			if (!dto.getUserPwd().equals(null)) {	
				sb.append("update member set userPwd=? where userId=?");
				pstmt.setString(1, dto.getUserPwd());				
			}
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getQuestion());
			pstmt.setString(4, dto.getAnswer());
			pstmt.setString(5, dto.getZip());
			pstmt.setString(6, dto.getAddr1());
			pstmt.setString(7, dto.getAddr2());
			
			result=pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}

	// 회원
	public MemberDTO readMember(String userId) {
		MemberDTO dto = new MemberDTO();

		return dto;
	}

}
