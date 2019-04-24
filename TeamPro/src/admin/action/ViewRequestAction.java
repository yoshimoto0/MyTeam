package admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.ViewRequestService;
import admin.vo.ActionForward;
import admin.vo.QnADTO;

public class ViewRequestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		ViewRequestService svc = new ViewRequestService();
		ArrayList<QnADTO> list = svc.execute();
		HttpSession session = request.getSession();
		
		if(list != null) {
			af = new ActionForward("#", false);
			session.setAttribute("list", list);
			
		}else {
			af = new ActionForward("#", false);
			session.setAttribute("errormessage", "문의사항이 존재하지 않습니다.");
			
		}
		
		
		return af;
	}

}
