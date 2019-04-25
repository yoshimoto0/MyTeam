package word.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.vo.ActionForward;
import word.vo.WordDAO;
import word.vo.WordDTO;

public class AllWordAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		WordDAO dao = new WordDAO();
		ArrayList<WordDTO> wordList = new ArrayList<WordDTO>();
		wordList = dao.allWord();
		
		request.setAttribute("wordList", wordList);	

		ActionForward af = new ActionForward("/search.jsp", false);
		return af;
	}

}
