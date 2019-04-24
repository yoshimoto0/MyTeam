package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.RequestRemoveService;
import admin.vo.ActionForward;

public class RequestRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		RequestRemoveService svc = new RequestRemoveService();
		int res = svc.execute(num);
		
		if(res>0) {
			af = new ActionForward("#", true);
			session.setAttribute("sussecemessage", "문의사항 삭제가 성공적으로 수행되었습니다.");
		
		}else {
			af = new ActionForward("#", true);
			session.setAttribute("sussecemessage", "문의사항이 삭제되지 않았습니다.");
		
		}
		
		
		return af;
	}

}
