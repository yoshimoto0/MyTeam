package vo;

import static db.JdbcUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WordDAO {

	Connection conn;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	public int addNewWord(WordDTO word) {
		
		String sql = "insert into dog values(word_num.nextval, ?, ?, ?)";
		int res = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word.getWord());
			pstmt.setString(2, word.getMeaning());
			pstmt.setInt(3, word.getKind());
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return res;
	}
	
	public String getKind(int kind) {
		
		String sql = "select kind from kind where kind_id = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String res = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kind);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getString("kind");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return res;	
	}
	
	public ArrayList<KindDTO> getAllKind() {
		
		String sql = "select * from kind";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<KindDTO> kindList = null;
		KindDTO kind = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				kindList = new ArrayList<KindDTO>();
				
				while(rs.next()) {
					kindList.add(new KindDTO(rs.getInt("kind_id"), rs.getString("kind")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return kindList;	
	}
	
	
	/*public ArrayList<WordDTO> selectWordList() {
		
		String sql = "select * from word";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<WordDTO> wordList = null;
		
		try {
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
			close(rs);
			close(pstmt);
		}
		
		return wordList;
	}*/
	
	

}
