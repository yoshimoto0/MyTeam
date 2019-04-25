package word.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.svc.AddNewWordService;
import word.vo.ActionForward;
import word.vo.WordDTO;

public class AddNewWordAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AddNewWordService ws = new AddNewWordService();
		
		String word = request.getParameter("word");
		String meaning = request.getParameter("meaning");
		int kind = Integer.parseInt(request.getParameter("kind_id"));
		
		WordDTO dto = new WordDTO(0,word, meaning, kind);
		
		int res = ws.addNewWord(dto);
		
		ActionForward af = null;				

		if(res > 0) {
			af = new ActionForward("search.jsp", true);
		}else {
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('새 단어 등록이 실패하였습니다.');");
			out.print("history.back();");
			out.print("</script>");			
		}
		
		return af;
		
	}

}
