package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.vo.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		
		af = new ActionForward("#",true);
		
		return af;
	}

}
