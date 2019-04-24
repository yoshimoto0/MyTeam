package word.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import word.vo.ActionForward;
import word.vo.BookDTO;

public class addWordToBookAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int wordnum = Integer.parseInt("wordNum");
		
//		BookDTO dto = new BookDTO((String)session.getAttribute("user_id"), wordnum, (String)session.getAttribute("book_id"),0);
		
//		return ;
	}

}
