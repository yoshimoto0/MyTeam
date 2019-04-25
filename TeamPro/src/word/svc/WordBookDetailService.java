package word.svc;

import java.util.ArrayList;

import word.vo.BookDAO;
import word.vo.WordBookDTO;

public class WordBookDetailService {

	public ArrayList<WordBookDTO> getWordInBook(String user_id, int book_id) {
		
		BookDAO dao = new BookDAO();
		ArrayList<WordBookDTO> WordBook = new ArrayList<WordBookDTO>();
		
		WordBook = dao.viewWordBook(user_id, book_id);
		
		return WordBook;
	}
	
	

}
