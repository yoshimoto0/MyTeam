package word.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.svc.DeleteWordBookService;
import word.vo.ActionForward;

public class DeleteWordBookAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		
		DeleteWordBookService svc = new DeleteWordBookService();
		svc.deleteWordBook(book_id);
		
		ActionForward af = new ActionForward("#", false);

		return af;
	}

}
