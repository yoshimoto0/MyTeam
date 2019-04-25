package word.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberDTO;
import word.svc.WordBookDetailService;
import word.vo.ActionForward;
import word.vo.WordBookDTO;

public class WordBookDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int book_id = Integer.parseInt(request.getParameter("book_id"));
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login_user");
		
		WordBookDetailService svc = new WordBookDetailService(); 
		
		ArrayList<WordBookDTO> WordBook = new ArrayList<WordBookDTO>();
		WordBook = svc.getWordInBook(dto.getUser_id(), book_id);
		session.setAttribute("WordBook", WordBook);
		
		ActionForward af = new ActionForward("WordBookDetail.jsp", false);		
		return af;
	}

}
