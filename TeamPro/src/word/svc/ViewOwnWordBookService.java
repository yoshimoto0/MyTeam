package word.svc;

import java.util.ArrayList;

import word.vo.BookDAO;
import word.vo.BookListDTO;

public class ViewOwnWordBookService {

	public ArrayList<BookListDTO> getWordBookById(String user_id) {

		BookDAO dao = new BookDAO();
		ArrayList<BookListDTO> bookList = new ArrayList<BookListDTO>();
		
		bookList = dao.viewOwnBookList(user_id);
		
		return bookList;
	}

}
