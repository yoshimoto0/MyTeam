package word.vo;

import static db.JdbcUtils.close;
import static db.JdbcUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
  
	public int createWordBook(BookListDTO book) {	// 새 단어장 만들기
		
		String sql = "insert into book_list values(book_id.nextval,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBook_name());
			pstmt.setString(2, book.getUserId());
			pstmt.setInt(3, book.getHit());
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		return res;
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
	
	public ArrayList<BookListDTO> viewAllBookList(){	// 단어장 목록 보기
		
		String sql = "select * form book-list";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookListDTO> bookList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bookList = new ArrayList<BookListDTO>();
				while(rs.next()) {
					bookList.add(new BookListDTO(rs.getInt("book_id"),
												rs.getString("book_name"), 
												rs.getString("user_id"), 
												rs.getInt("kind"),
												rs.getInt("hit")));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		
		return bookList;
	}
	
	public ArrayList<BookListDTO> viewOwnBookList(String user_id){	// 유저가 가지고 있는 단어장 보기
		
		String sql = "select * form book-list where user_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookListDTO> bookList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bookList = new ArrayList<BookListDTO>();
				while(rs.next()) {
					bookList.add(new BookListDTO(rs.getInt("book_id"),
												rs.getString("book_name"), 
												rs.getString("user_id"), 
												rs.getInt("kind"),
												rs.getInt("hit")));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		
		return bookList;
	}
	
	public int updateHit(int book_id) {	// 조회수 증가
		
		String sql = "update book_list set hit = hit + 1 where user_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
		return res;
	}

	public ArrayList<WordBookDTO> viewWordBook(String userID, int book_id){ 	// 단어장 보기
		
		String sql = "select book.wordNum, word, meaning, star from book, word where user_id = ? and book_id = ? and book.wordnum = word.wordnum";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection conn = null;
		ArrayList<WordBookDTO> wordbook = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setInt(2, book_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				wordbook = new ArrayList<WordBookDTO>();
				while(rs.next()) {
					wordbook.add(new WordBookDTO(rs.getInt("wordNum"), 
											rs.getString("word"), 
											rs.getString("meaning"), 
											rs.getInt("star")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		
		return wordbook;
	}
/*	
	public void deleteWordBook(int book_id) {
		
		String sql = " delete from book where book_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
	}
*/	
	public void deleteBook(int book_id) {
		
		String sql = " delete from book_list where book_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
	}	  
	
	
}
