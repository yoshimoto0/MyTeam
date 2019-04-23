package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UpdateService;
import vo.ActionForward;
import vo.MemberDTO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UpdateService svc = new UpdateService();
		HttpSession session = request.getSession();
		
		ActionForward af = null;
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		int res = svc.execute(dto.getId(),dto.getPass(),dto.getUserName(),dto.getEmail(),dto.getImage(),dto.getFavor());
		
		if(res > 0) {
			af = new ActionForward("#", false);
			session.removeAttribute("member");
			session.setAttribute("member", dto);
		}
		return null;
	}

}
