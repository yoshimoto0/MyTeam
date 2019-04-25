package word.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.MemberDTO;
import word.svc.ViewOwnWordBookService;
import word.vo.ActionForward;
import word.vo.BookListDTO;

public class ViewOwnWordBookAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		HttpSession session = request.getSession();
		int kind_id = Integer.parseInt(request.getParameter("kind_id"));
		ArrayList<BookListDTO> bookList = new ArrayList<BookListDTO>();  
		
		MemberDTO dto = new MemberDTO();
		dto = (MemberDTO)session.getAttribute("login_user");		
		String user_id = dto.getId();
		
		ViewOwnWordBookService svc = new ViewOwnWordBookService();
		
		bookList = svc.getWordBookById(user_id);
		session.setAttribute("bookList", bookList);
		
		ActionForward af = new ActionForward("",false);
		return af;
	}

}
