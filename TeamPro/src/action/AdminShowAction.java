package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminShowService;

import vo.ActionForward;
import vo.MemberDTO;

public class AdminShowAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminShowService svc = new AdminShowService();
		String kind = request.getParameter("kind");
		String keyword = request.getParameter("keyword");
		ArrayList<MemberDTO> list = svc.execute(kind,keyword);
		ActionForward af = null;
		HttpSession session = request.getSession();
		
		if(list!=null) {
			af = new ActionForward("#",false);
			session.setAttribute("list",list);
		}else {
			session.setAttribute("errormessage","정보를 불러오는데 실패하였습니다.");	
		}
		return af;
	}

}
