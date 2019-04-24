package word.svc;

import word.vo.WordDAO;
import word.vo.WordDTO;

public class AddNewWordService {
	
	public int addNewWord(WordDTO dto) {
		
		WordDAO dao = new WordDAO();
		int res = dao.addNewWord(dto);
		
		return res;
	}

}
