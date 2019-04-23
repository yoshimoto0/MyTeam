package word.vo;

import static db.JdbcUtils.close;
import static db.JdbcUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
  
	public void createWordBook(BookDTO book) {	// 새 단어장 만들기
		
		String sql = "insert into book values(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getUserId());
			pstmt.setInt(2, book.getWordNum());
			pstmt.setInt(3, book.getBook_id());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
	}
	
	public void addWordToBook(BookDTO book) { // 단어장에 단어 등록
		
		String sql = "insert into book values(?,?,?,0)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getUserId());
			pstmt.setInt(2, book.getWordNum());
			pstmt.setInt(3, book.getBook_id());
			pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
	}
	
//	public ArrayList<>
	
	public ArrayList<WordBookDTO> viewWordBook(String userID, String BookName){
		
		String sql = "select book.wordNum, word, meaning, star from book, word where user_id = ? and name = ? and word.num = (select wordnum from book where ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection conn = null;
		ArrayList<WordBookDTO> list = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, BookName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list = new  ArrayList<WordBookDTO> ();
				while(rs.next()) {
//					list.add(new WordBookDTO())
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	  
}
