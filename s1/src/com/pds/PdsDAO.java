package com.pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConn;

public class PdsDAO {
	private Connection conn=DBConn.getConnection();

	public int insertPds(PdsDTO dto) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("INSERT INTO pds(num, category, gubun, os, userId, subject, content, imageFileName, saveFileName, originalFileName, fileSize)");
			sb.append(" VALUES ( seq_pds.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getGubun());
			pstmt.setString(3, dto.getOs());
			pstmt.setString(4, dto.getUserId());
			pstmt.setString(5, dto.getSubject());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getImageFileName());
			pstmt.setString(8, dto.getSaveFileName());
			pstmt.setString(9, dto.getOriginalFileName());
			pstmt.setLong(10, dto.getFileSize());
			
			result=pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public List<PdsDTO> listPds(int start, int end, String category, String searchKey, String searchValue) {
		List<PdsDTO> lists=new ArrayList<PdsDTO>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT * FROM (");
			sb.append("      SELECT ROW_NUMBER() OVER(ORDER BY num DESC) rnum, num, category, gubun, os, p.userId, userName");
			sb.append("         ,subject, content");
			sb.append("         ,imageFileName");
			sb.append("         ,saveFileName, originalFileName");
			sb.append("         ,TO_CHAR(p.created, 'YYYY-MM-DD') created, downCount, fileSize");
			sb.append("         FROM pds p JOIN join_basic m ON p.userId=m.userId");
			
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
				PdsDTO dto=new PdsDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setGubun(rs.getString("gubun"));
				dto.setOs(rs.getString("os"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setImageFileName(rs.getString("imageFileName"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				dto.setOriginalFileName(rs.getString("originalFileName"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setFileSize(rs.getLong("fileSize"));
				dto.setDownCount(rs.getInt("downCount"));
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
			sql="SELECT NVL(COUNT(*), 0) FROM pds ";
			sql+=" JOIN join_basic ON pds.userId = join_basic.userId ";
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
	
	public PdsDTO readPds(int num) {
		PdsDTO dto=null;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("SELECT num, category, gubun, os, p.userId, userName");
			sb.append("  ,imageFileName, saveFileName, originalFileName");
			sb.append("  ,subject, content, p.created, fileSize, downCount");
			sb.append("  FROM pds p JOIN join_basic m ON p.userId=m.userId");
			sb.append("  WHERE num=? ");
			
			pstmt=conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new PdsDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setGubun(rs.getString("gubun"));
				dto.setOs(rs.getString("os"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setImageFileName(rs.getString("imageFileName"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				dto.setOriginalFileName(rs.getString("originalFileName"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setFileSize(rs.getLong("fileSize"));
				dto.setDownCount(rs.getInt("downCount"));
				dto.setCreated(rs.getString("created"));
			}
			rs.close();
			pstmt.close();
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	public int updatePds(PdsDTO dto) {
		int result=0;
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			sb.append("UPDATE pds SET category=?, gubun=?, os=?, subject=?, content=?, imageFileName=?, saveFileName=?, originalFileName=?, fileSize=? ");
			sb.append("   WHERE num=?");
			
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getGubun());
			pstmt.setString(3, dto.getOs());
			pstmt.setString(4, dto.getSubject());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getImageFileName());
			pstmt.setString(7, dto.getSaveFileName());
			pstmt.setString(8, dto.getOriginalFileName());
			pstmt.setLong(9, dto.getFileSize());
			pstmt.setInt(10, dto.getNum());
			
			result=pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	public int deletePds(int num) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql;
		
		try {
			sql="DELETE FROM pds WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}
	
	public int updateDownCount(int num) {
		int result=0;
		
		PreparedStatement pstmt=null;
		String sql;
		
		try {
			sql="UPDATE pds SET downCount=downCount+1 WHERE num=?";
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
