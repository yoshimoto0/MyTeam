package word.svc;

import java.util.ArrayList;

import word.vo.KindDTO;
import word.vo.WordDAO;
import word.vo.WordDTO;

public class SearchWordService {

	public ArrayList<KindDTO> getKindList() {
		ArrayList<KindDTO> kindList = new ArrayList<KindDTO>();
		WordDAO dao = new WordDAO();
		kindList = dao.getAllKind();
		return kindList;
	}

	public ArrayList<WordDTO> getAllWord() {
		ArrayList<WordDTO> wordList = new ArrayList<WordDTO>();
		WordDAO dao = new WordDAO();
		wordList = dao.getAllWord();
		return wordList;
	}
}
