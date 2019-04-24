package word.svc;

import word.vo.BookDAO;
import word.vo.BookDTO;

public class addWordToBookService {

	public void addWordToBook(BookDTO dto) {

		BookDAO dao = new BookDAO();
		dao.addWordToBook(dto);
		
	}

}
