package word.vo;

import static db.JdbcUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WordDAO {

	public int addNewWord(WordDTO word) {
		
		String sql = "insert into word values(word_num.nextval, ?, ?, ?)";
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word.getWord());
			pstmt.setString(2, word.getMeaning());
			pstmt.setInt(3, word.getKind());
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, null);
		}
		
		return res;
	}
	
	public String getKind(int kind) {
		
		String sql = "select kind from kind where kind_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String res = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kind);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getString("kind");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);
		}
		return res;	
	}
	
	public ArrayList<KindDTO> getAllKind() {
		
		String sql = "select * from kind";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<KindDTO> kindList = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				kindList = new ArrayList<KindDTO>();
				do {
					kindList.add(new KindDTO(rs.getInt("kind_id"), rs.getString("kind_name")));
				}while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, pstmt, rs);

		}
		return kindList;	
	}
	
	public ArrayList<WordDTO> getAllWord() {
		
		String sql = "select * from word";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<WordDTO> wordList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				wordList = new ArrayList<WordDTO>();
				do {
					wordList.add(new WordDTO(rs.getInt("num"),
											rs.getString("word"),
											rs.getString("meaning"),
											rs.getInt("kind")));
				}while(rs.next());
			}
						

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, rs);
		}
		
		return wordList;
	}

	public ArrayList<WordDTO> getWord(String word) {

		String sql = "select * from word where word like '%?%";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<WordDTO> wordList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				wordList = new ArrayList<WordDTO>();
				do {
					wordList.add(new WordDTO(rs.getInt("num"),
											rs.getString("word"),
											rs.getString("meaning"),
											rs.getInt("kind")));
				}while(rs.next());
			}
						

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, rs);
		}
		
		return wordList;
		
	}

	public ArrayList<WordDTO> allWord() {
		String sql = "select * from word";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<WordDTO> wordList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				wordList = new ArrayList<WordDTO>();
				do {
					wordList.add(new WordDTO(rs.getInt("num"),
											rs.getString("word"),
											rs.getString("meaning"),
											rs.getInt("kind")));
				}while(rs.next());
			}
						

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,pstmt, rs);
		}
		
		return wordList;
	}

}
