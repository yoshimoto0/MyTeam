package word.svc;

import java.util.ArrayList;

import word.vo.BookListDTO;
import word.vo.WordDAO;
import word.vo.WordDTO;

public class SearchMainWordService {

	public ArrayList<WordDTO> getWordList(String word) {

		ArrayList<WordDTO> wordList = new ArrayList<WordDTO>(); 
		WordDAO dao = new WordDAO();
		wordList = dao.getWord(word);
		
		return wordList;
	}

	public ArrayList<BookListDTO> getWordBookList(ArrayList<WordDTO> wordList) {

		ArrayList<BookListDTO> BookList = new ArrayList<BookListDTO>(); 
		
		for(int i = 0; i < wordList.size(); i++) {
			int num = wordList.get(i).getNum();
		}
		
		return BookList;
	}

}
