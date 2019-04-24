package word.svc;

import word.vo.BookDAO;
import word.vo.BookListDTO;

public class createWordBookService {

	public int addNewBook(BookListDTO dto) {

		BookDAO dao = new BookDAO();
		int res = dao.createWordBook(dto);
		
		return res;
	}

}
