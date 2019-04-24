package word.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.svc.SearchWordService;
import word.vo.ActionForward;
import word.vo.KindDTO;
import word.vo.WordDTO;

public class SearchWordAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SearchWordService svc = new SearchWordService(); 
		
		ArrayList<KindDTO> kindList = new ArrayList<KindDTO>();
		kindList = svc.getKindList();

		ArrayList<WordDTO> wordList = new ArrayList<WordDTO>();
		wordList = svc.getAllWord();
		
		request.setAttribute("kindList", kindList);
		request.setAttribute("wordList", wordList);
		
		ActionForward af = new ActionForward("#", true);
		return af;
	}

}
