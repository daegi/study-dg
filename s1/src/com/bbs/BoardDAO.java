package com.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class BoardDAO {
	private Connection conn=DBConn.getConnection();
	
	public int insertBoard(BoardDTO dto) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("INSERT INTO bbs(");
			sb.append("num, name, subject, content, pwd, hitCount, ipAddr");
			sb.append(") VALUES (seq_bbs.NEXTVAL, ?, ?, ?, ?, 0, ?)");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPwd());
			pstmt.setString(5, dto.getIpAddr());
			
			result=pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	// 데이터 개수 구하기
	public int dataCount(String searchKey, String searchValue) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql;
		try {
			
			sql="SELECT NVL(COUNT(*), 0) FROM bbs";
			if(searchValue!=null && searchValue.length()!=0) {
				if(searchKey.equals("created")) {
					sql += "   WHERE TO_CHAR(created, 'YYYY-MM-DD') = ?";
				} else {
					sql +="   WHERE "+searchKey+"  LIKE '%' || ? || '%' ";
				}
			}
			
			pstmt=conn.prepareStatement(sql);
			if(searchValue!=null && searchValue.length()!=0) {
				pstmt.setString(1, searchValue);
			}
			
			rs=pstmt.executeQuery();
			if(rs.next())
				result=rs.getInt(1);
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public List<BoardDTO> listBoard(int start, int end, String searchKey, String searchValue) {
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT * FROM (");
			sb.append("  SELECT ROW_NUMBER() OVER(ORDER BY num DESC) rnum, ");
			sb.append("     num, name, subject, ");
			sb.append("     TO_CHAR(created, 'YYYY-MM-DD') created, ");
			sb.append("     hitCount FROM bbs ");
			
			if(searchValue!=null && searchValue.length()!=0) {
				if(searchKey.equals("created")) {
					sb.append("   WHERE TO_CHAR(created, 'YYYY-MM-DD') = ?");
				} else {
					sb.append("   WHERE "+searchKey+"  LIKE '%' || ? || '%' ");
				}
			}
			
			sb.append(")  WHERE rnum>=? AND rnum <= ? ");
			sb.append("   ORDER BY num DESC");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			if(searchValue!=null && searchValue.length()!=0) {
				pstmt.setString(1, searchValue);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} else {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto=new BoardDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setCreated(rs.getString("created"));
				dto.setHitCount(rs.getInt("hitCount"));
				
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
		BoardDTO dto=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT num, name, subject, ");
			sb.append("  content, created, ipAddr, hitCount, pwd");
			sb.append("     FROM bbs");
			sb.append("     WHERE num=?");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new BoardDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setCreated(rs.getString("created"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setIpAddr(rs.getString("ipAddr"));
			}
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	public void updateHitCount(int num) {
		PreparedStatement pstmt=null;
		String sql;
		
		try {
			sql="UPDATE bbs SET hitCount=hitCount+1 WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public int updateBoard(BoardDTO dto) {
		int result=0;
		StringBuffer sb=new StringBuffer();
		PreparedStatement pstmt=null;
		
		try {
			sb.append("UPDATE bbs SET name=?, subject=?, content=?, pwd=? WHERE num=?");
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPwd());
			pstmt.setInt(5, dto.getNum());
			
			result=pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public int deleteBoard(int num) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql;
		
		try {
			sql="DELETE FROM bbs WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
}
