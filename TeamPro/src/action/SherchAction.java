package action;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import svc.SherchService;
import vo.ActionForward;
import vo.MemberDTO;

public class SherchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		String email = request.getParameter("email");
		SherchService svc = new SherchService();
		MemberDTO dto = svc.execute(email);
		
		if(dto != null)
		af = new ActionForward("#", false);
		
		return af;
	}

}
