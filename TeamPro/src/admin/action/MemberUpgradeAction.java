package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.MemberUpgradeService;
import admin.vo.ActionForward;

public class MemberUpgradeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		MemberUpgradeService svc = new MemberUpgradeService();
		int res = svc.execute(user_id);
		
		if(res>0) {
			af = new ActionForward("#", true);
			session.setAttribute("sussecemessage", user_id + "님의 계정을 관리자계정으로 업그레이드 했습니다.");
		}else {
			af = new ActionForward("#", true);
			session.setAttribute("errormessage", "계정을 찾지 못했습니다.");			
		}
		return af;
	}

}
