package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDaoImpl implements GuestbookDao {

	@Override
	public List<GuestbookDto> gbList() {
		List<GuestbookDto> list 
			= new ArrayList<GuestbookDto>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			conn = DBConn.getConn(); 
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from guestbook order by idx desc ");
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while( rs.next() ) {
				String name = rs.getString("name");
				name = name.replace("<", "&lt;");
				name = name.replace(">", "&gt;");
				String content = rs.getString("content");
				content = content.replace("<", "&lt;");
				content = content.replace(">", "&gt;");
				GuestbookDto dto = new GuestbookDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setName(name);
				dto.setEmail(rs.getString("email"));
				dto.setContent(content);
				dto.setPost_date(rs.getDate("post_date"));
				list.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{ 
			try{
				if( rs != null ) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if( stmt != null ) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if( conn != null ) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}

}
