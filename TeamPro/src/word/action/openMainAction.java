package word.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import word.svc.SearchWordService;
import word.vo.ActionForward;
import word.vo.KindDTO;

public class openMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SearchWordService svc = new SearchWordService();
		
		ArrayList<KindDTO> kindList = new ArrayList<KindDTO>();
		kindList = svc.getKindList();
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("kindList", kindList);
		
		ActionForward af = new ActionForward("home.jsp", false);
		
		return af;
	}

}
