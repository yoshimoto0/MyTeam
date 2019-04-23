package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import svc.CreateActionService;
import vo.ActionForward;
import vo.MemberDTO;

public class CreateAction implements Action{

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = (String) request.getAttribute("id");
		String pass = (String) request.getAttribute("pass");
		String nickname = (String) request.getAttribute("nickname");
		String email = (String) request.getAttribute("email");
		String image = (String) request.getAttribute("image");
		MultipartRequest multi = null;
		int favor = Integer.parseInt((String) request.getAttribute("favor"));
		int isAdmin = Integer.parseInt((String) request.getAttribute("isAdmin"));
		MemberDTO dto = new MemberDTO(id,pass,nickname,email,image,favor,isAdmin);
		CreateActionService svc = new CreateActionService();
		int res = svc.execute(dto);
		HttpSession session = request.getSession();
		
		
		ActionForward af = null;
		if(res>0) {
			af = new ActionForward("#",true);	
		session.setAttribute("succesemessage","가입이 성공적으로 처리되었습니다.");
		}else {
			af = new ActionForward("#",true);
			session.setAttribute("errormessage","가입이 실패하였습니다..");
		
		}return af;
	}

}
