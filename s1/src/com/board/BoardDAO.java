package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class BoardDAO {

	private Connection conn = DBConn.getConnection();
	BoardDTO dto=new BoardDTO();
	

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
					+ " DEPTH, orderNo, parent, saveFileName, originalFileName)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,? ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxNum);
			pstmt.setString(2, dto.getUserId());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, maxNum);
			pstmt.setInt(6, dto.getDepth());
			pstmt.setInt(7, dto.getOrderNo());
			pstmt.setInt(8, dto.getParent());		
			pstmt.setString(9, dto.getSaveFileName());
			pstmt.setString(10, dto.getOriginalFileName());
			

			result = pstmt.executeUpdate();

			rs.close();
			pstmt.close();
			
			

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}
	
	
	public List<BoardDTO> listBoard(int start, int end, String category, String searchKey, String searchValue) {
		List<BoardDTO> lists=new ArrayList<BoardDTO>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT * FROM (");
			sb.append("      SELECT ROW_NUMBER() OVER(ORDER BY groupNum desc, orderNo asc) rnum, ");
			sb.append("         num, category, p.userId, userName,subject, content");
			sb.append("         ,saveFileName, originalFileName");
			sb.append("         ,TO_CHAR(p.created, 'YYYY-MM-DD') created,");
			sb.append("         FROM board p JOIN join_basic m ON p.userId=m.userId");
			
			if(category.length()!=0)
				sb.append("  WHERE category = ? ");
			if(searchValue.length()!=0) {
				if(category.length()==0)
					sb.append("  WHERE "+ searchKey + " LIKE '%'||?||'%' ");
				else
					sb.append("  AND " + searchKey +"  LIKE '%'||?||'%' ");
			}
			
			sb.append(") WHERE rnum>=? AND rnum <=? ORDER BY num DESC");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			if(category.length()!=0)
				pstmt.setString(1, category);
			if(searchValue.length()!=0) {
				if(category.length()==0) {
					pstmt.setString(1, searchValue);
				} else {
					pstmt.setString(2, searchValue);
				}
			}
			
			if(category.length()==0 && searchValue.length()==0) {
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			} else if(category.length()!=0 && searchValue.length()==0) {
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}else if(category.length()==0 && searchValue.length()!=0) {
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			} else {
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				dto.setOriginalFileName(rs.getString("originalFileName"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setCreated(rs.getString("created"));
				
				lists.add(dto);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return lists;
	}
	
	
	
	
	
	
	
	
	
	public int dataCount(String category, String searchKey, String searchValue) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql;
		
		try {
			sql="SELECT NVL(COUNT(*), 0) FROM board ";
			sql+=" JOIN join_basic ON board.userId = join_basic.userId ";
			if(category.length()!=0)
				sql+="  WHERE category = ? ";
			if(searchValue.length()!=0) {
				if(category.length()==0)
					sql+="  WHERE "+ searchKey + " LIKE '%'||?||'%' ";
				else
					sql+="  AND " + searchKey +"  LIKE '%'||?||'%' ";
			}
			pstmt=conn.prepareStatement(sql);
			
			if(category.length()!=0)
				pstmt.setString(1, category);
			if(searchValue.length()!=0) {
				if(category.length()==0) {
					pstmt.setString(1, searchValue);
				} else {
					pstmt.setString(2, searchValue);
				}
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
	
	
}
