package vo;

import static db.JdbcUtils.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
  
	Connection conn;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public void createWordBook(BookDTO book) {
		
		String sql = "insert into word_book values(?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getUserId());
			pstmt.setInt(2, book.getWordNum());
			pstmt.setInt(3, book.getSheet());
			pstmt.setString(4, book.getBookName());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	}
	
	public ArrayList<WordBookDTO> viewWordBook(String userID, String BookName){
		
		String sql = "select word_book.wordNum, word, meaning, star from word_book, word where user_id = ? and name = ?"
				+ "and word.num = (select wordnum from word_book where ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<WordBookDTO> list = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, BookName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list = 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs);
			close(pstmt);
		}
		return;
	}
	  
}
