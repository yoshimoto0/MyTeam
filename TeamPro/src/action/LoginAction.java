package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.ActionForward;
import vo.MemberDTO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		LoginService svc = new LoginService();
		HttpSession session = request.getSession();
		ActionForward af = null;
		MemberDTO dto = svc.execute(id);
		if(dto == null) {
			session.setAttribute("ErrorMessage", "일치하는 아이디를 찾지 못하였습니다.");
			af = new ActionForward("#",false);//아이디x실패
		}else if(dto.getPass().equals(pass)) {
			session.setAttribute("member", dto);
			af = new ActionForward("#",false);//로그인성공
		}else {
			session.setAttribute("ErrorMessage", "비밀번호가 일치하지 않습니다.");
			af = new ActionForward("#",false);//비번x실패
		}
		return af;
	}

}
