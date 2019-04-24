package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminViewService;
import admin.vo.ActionForward;
import member.vo.MemberDTO;
import word.vo.WordDTO;


public class AdminViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward af = null;
		
		String table = request.getParameter("table");
		String attribute = request.getParameter("attribute");
		String keyword = request.getParameter("keyword");
		
		ArrayList list = null;
		HttpSession session = request.getSession();
		
		AdminViewService svc = new AdminViewService();
		list = svc.execute(table,attribute,keyword);
		
		if(list.get(0) instanceof MemberDTO) {
			session.setAttribute("list", list);
			af = new ActionForward("#", false);
		}else if(list.get(0) instanceof WordDTO) {
			session.setAttribute("list", list);
			af = new ActionForward("#", false);
		}else {
			session.setAttribute("errormessage", "정보를 불러오지 못했습니다.");
			af = new ActionForward("#", false);
		}
		
		return af;
	}

}
