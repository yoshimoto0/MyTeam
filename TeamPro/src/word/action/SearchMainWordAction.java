package word.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.svc.SearchMainWordService;
import word.vo.ActionForward;
import word.vo.BookListDTO;
import word.vo.WordDTO;

public class SearchMainWordAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SearchMainWordService svc = new SearchMainWordService();
		
		String word = request.getParameter("word");
		
		ArrayList<WordDTO> wordList = new ArrayList<WordDTO>();
		wordList = svc.getWordList(word);
		
		ArrayList<BookListDTO> wordBookList = new ArrayList<BookListDTO>();
		wordBookList = svc.getWordBookList(wordList);
		request.setAttribute("wordList", wordList);
		request.setAttribute("wordBookList", wordBookList);
		ActionForward af = new ActionForward("#", true);
		return null;
	}

}
