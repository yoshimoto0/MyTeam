package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.svc.SearchService;
import member.vo.ActionForward;
import member.vo.MemberDTO;

public class SearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		String email = request.getParameter("email");
		SearchService svc = new SearchService();
		MemberDTO dto = svc.execute(email);
		
		if(dto != null)
		af = new ActionForward("#", false);
		
		return af;
	}
}
