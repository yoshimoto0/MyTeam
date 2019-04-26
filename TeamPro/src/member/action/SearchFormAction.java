package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.ActionForward;

public class SearchFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String dd = request.getParameter("dd");
		HttpSession session = request.getSession();
		ActionForward af = null;
		
			af = new ActionForward("searchForm.jsp",true);
		
		return af;
	}

}
