package member.vo;



import static db.JdbcUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

	public int createMember(MemberDTO dto) {
		String sql = "insert into member values(?,?,?,?,?,?,0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_pass());
			pstmt.setString(3, dto.getUser_name());
			pstmt.setString(4, dto.getImage());
			pstmt.setString(5, dto.getEmail());
			pstmt.setInt(6, dto.getFavor());
//			pstmt.setInt(7, dto.getIsAdmin());
			res = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}
		
		return res;
	}
	public MemberDTO searchMember(String email) {
		
		String sql = "select * from member where email = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				dto = new MemberDTO(rs.getString("user_id"),
						rs.getString("user_pass"),
						rs.getString("user_name"),
						rs.getString("image"),
						rs.getString("email"),
						rs.getInt("favor"),
						rs.getInt("isadmin"));
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}		
		
		return dto;		
	}
	
	
	public int Update(MemberDTO dto) {
		String sql = "update member set user_pass = ?,user_name = ?,email = ?,image = ?,favor = ? where user_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_pass());
			pstmt.setString(2, dto.getUser_name());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getImage());
			pstmt.setInt(5, dto.getFavor());
			pstmt.setString(6, dto.getUser_id());
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}
		
		return res;
	}
	
	public MemberDTO Login(String user_id) {
		
		String sql = "select * from member where user_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDTO dto = null;
		System.out.print(user_id);
			
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDTO(rs.getString("user_id"),
						rs.getString("user_pass"),
						rs.getString("user_name"),
						rs.getString("image"),
						rs.getString("email"),
						rs.getInt("favor"),
						rs.getInt("isAdmin"));
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, rs);
		}	
			
		return dto;
		
	}
	
}
