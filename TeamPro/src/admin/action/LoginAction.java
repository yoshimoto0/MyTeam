package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.svc.LoginService;
import member.vo.ActionForward;
import member.vo.MemberDTO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("username");
		String user_pass = request.getParameter("password");
		LoginService svc = new LoginService();
		HttpSession session = request.getSession();
		ActionForward af = null;
		MemberDTO dto = svc.execute(user_id);
		if(dto == null) {
			session.setAttribute("ErrorMessage", "일치하는 아이디를 찾지 못하였습니다.");
			af = new ActionForward("home.jsp",false);//아이디x실패
		}else if(dto.getUser_pass().equals(user_pass)) {
			session.setAttribute("login_user", dto);
			af = new ActionForward("home.jsp",false);//로그인성공
		}else {
			session.setAttribute("ErrorMessage", "비밀번호가 일치하지 않습니다.");
			af = new ActionForward("home.jsp",false);//비번x실패
		}
		return af;
	}

}
