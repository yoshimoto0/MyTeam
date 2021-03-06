package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.RemoveKindService;
import admin.vo.ActionForward;

public class RemoveKindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;//체크박스를 통해 여러개의 값이 넘어올경우
		int res = 0;
		String kind = request.getParameter("kind");
		RemoveKindService svc = new RemoveKindService();
		res = svc.execute(kind);
		
		if(res > 0) {
			af = new ActionForward("#", false);
		}
		return af;
	
	}

}
