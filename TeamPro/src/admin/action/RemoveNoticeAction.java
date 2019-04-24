package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.RemoveNoticeService;
import admin.vo.ActionForward;


public class RemoveNoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		HttpSession session = request.getSession();
		int num = Integer.parseInt((String) session.getAttribute("num"));
		RemoveNoticeService svc = new RemoveNoticeService();
		int res = svc.execute(num);
		
		if(res > 0) {
			af = new ActionForward("#", true);
			session.setAttribute("SecceseMessage", "삭제가 성공하셨습니다.");
		}else {
			af = new ActionForward("#", true);
			session.setAttribute("ErrorMassege", "삭제가 실패하였습니다.");
		}
		return af;
	}
	
}
