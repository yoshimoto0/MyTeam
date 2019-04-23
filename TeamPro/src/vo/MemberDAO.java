package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtils.*;
public class MemberDAO {

	public int createMember(MemberDTO dto) {
		String sql = "interte into member value(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getImage());
			pstmt.setInt(6, dto.getFavor());
			pstmt.setInt(7, dto.getIsAdmin());
			res = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt,null);
		}
		
		return res;
	}
	
	public MemberDTO shechMember(String email) {
		String sql = "select * from member where email == ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) 
				dto = new MemberDTO(rs.getString("id"),
						rs.getString("pass"),
						rs.getString("nickname"),
						rs.getString("email"),
						rs.getString("image"),
						rs.getInt("favol"),
						rs.getInt("isAdmin"));
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt,rs);
		}		
		return dto;		
	}
	public ArrayList<MemberDTO> AdminShowMember(String kind,String keyword) {
		String sql = "select * from member where ? like '%?%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO>list = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();
			while(rs.next())
				list.add(new MemberDTO(rs.getString("id"),
						rs.getString("pass"),
						rs.getString("nickname"),
						rs.getString("email"),
						rs.getString("image"),
						rs.getInt("favol"),
						rs.getInt("isAdmin")));
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt,rs);
		}		
		return list;		
	}
	
	public int UpdateMember(String id,String pass,String nickname,String email,String image,int favor) {
		String sql = "update member set pass = ?,nickname = ?,email = ?,image = ?,favor = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, nickname);
			pstmt.setString(3, email);
			pstmt.setString(4, image);
			pstmt.setInt(5, favor);
			pstmt.setString(6, id);
			res = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt,null);
		}
		
		return res;
	}
	public MemberDTO Login(String id) {
		String sql = "select * from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
			
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO(rs.getString("id"),
						rs.getString("pass"),
						rs.getString("nickname"),
						rs.getString("email"),
						rs.getString("image"),
						rs.getInt("favol"),
						rs.getInt("isAdmin"));
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt,rs);
		}		
		return dto;
	}
	
	
	
}
