package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.svc.AddKindService;
import admin.vo.ActionForward;

public class AddKindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward af = null;//체크박스를 통해 여러개의 값이 넘어올경우
		int res = 0;
		
		String kind_name = request.getParameter("kind_name");
		AddKindService svc = new AddKindService();
		res = svc.execute(kind_name);
		
		if(res > 0) {
			af = new ActionForward("#", false);	// 관리자 페이지 작성 필요
		}
		return af;	
	}

}
