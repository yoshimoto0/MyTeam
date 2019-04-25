package word.svc;

import word.vo.BookDAO;

public class DeleteWordBookService {

	public void deleteWordBook(int book_id) {
		
		BookDAO dao = new BookDAO();
		dao.deleteBook(book_id);
	}
	
}
