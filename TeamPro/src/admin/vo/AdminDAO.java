package admin.vo;
import static db.JdbcUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.vo.MemberDTO;
import word.vo.WordDTO;

public class AdminDAO {

	public int AddNotice(NoticeDTO dto) {
		
		String sql = "insert into notice values(notice_num_seq.nextval,?,?,sysdate,?)";
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}					
		return res;
	}

	public int RemoveNotice(int notice_num) {
		
		String sql = "delete from notice where notice_num = ?";
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}					
		
		return res;
	}

	public int RemoveWord(int num) {
		
		String sql = "delete from word where num = ?";
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}					
		
		return res;
	}

	public int addKind(String kind_name) {
		
		String sql = "insert into kind values(kind_id_seq.nextval,?)";
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind_name);
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}					
		
		return res;
	}

	public int removeKind(String kind_name) {
		
		String sql = "delete from kind where kind_name = ?";
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind_name);
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}				
		
		return res;
	}

	public ArrayList adminView(String table, String attribute,String keyword) {		// ArrayList<?> 
		String sql = "select * from ? where ? like '%?%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList list = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, table);
			pstmt.setString(2, attribute);
			pstmt.setString(3, keyword);
			rs = pstmt.executeQuery();
			if(table.equals("member")) {
				while(rs.next()) {
					MemberDTO dto = new MemberDTO(rs.getString("user_id"),
							rs.getString("user_pass"),
							rs.getString("user_name"),
							rs.getString("image"),
							rs.getString("email"),
							rs.getInt("kind"),
							rs.getInt("isAdmin"));
					list.add(dto);
				}			
			}else if(table.equals("word")) {
				while(rs.next()) {
					WordDTO dto = new WordDTO(rs.getInt("num"),
							rs.getString("word"),
							rs.getString("meaning"),
							rs.getInt("kind_id"));
					list.add(dto);
				}			
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, rs);
		}
		
		return list;
		
	}

	public ArrayList<QnADTO> viewRequest() {
		
		String sql = "select * from qna";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<QnADTO> qnaList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			/*
			while(rs.next()) {
				QnADTO dto = new QnADTO(rs.getInt("qna_num"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("w_date"),
						rs.getString("writer"),
						rs.getString("ans"),
						rs.getInt("read"));
				list.add(dto);
			}
			*/
			if(rs.next()) {
				qnaList = new ArrayList<QnADTO>();
				do {
					qnaList.add(new QnADTO(rs.getInt("qna_num"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("w_date"),
							rs.getString("writer"),
							rs.getString("ans"),
							rs.getInt("read")));
				}while(rs.next());				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, rs);
		}
		
		return qnaList;		
	}

	public int removeRequest(int qna_num) {
		
		String sql = "delete from qna where qna_num = ?";
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}					
		
		return res;
	}

	public int memberUpgrade(String user_id) {

		String sql = "update member set isadmin = 1 where user_id = ?";
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			res = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, null);
		}					
		
		return res;
	}
	
}
