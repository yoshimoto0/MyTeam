package word.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.svc.createWordBookService;
import word.vo.ActionForward;
import word.vo.BookListDTO;
import word.vo.WordDTO;

public class createWordBookAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		createWordBookService ws = new createWordBookService();
		
		String book_name = request.getParameter("book_name");
		String user_id = request.getParameter("user_id");
		int kind_id = Integer.parseInt(request.getParameter("kind_id"));
		
		BookListDTO dto = new BookListDTO(0,book_name, user_id, kind_id, 0);
		
		int res = ws.addNewBook(dto);
		
		ActionForward af = null;				

		if(res > 0) {
			af = new ActionForward("#", true);
		}else {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('새 단어장 만들기에 실패하였습니다.');");
			out.print("history.back();");
			out.print("</script>");			
		}
		
		return af;
	}

}
