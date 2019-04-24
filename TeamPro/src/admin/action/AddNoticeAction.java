package admin.action;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AddNoticeService;
import admin.vo.ActionForward;
import admin.vo.NoticeDTO;

public class AddNoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward af = null;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		NoticeDTO dto = new NoticeDTO(0,title,content,
				null,writer);
		HttpSession session = request.getSession();
		AddNoticeService svc = new AddNoticeService();
		int res = svc.execute(dto);
		
		if(res > 0) {
			af = new ActionForward("#", true);
			session.setAttribute("SecceseMessage", "등록이 성공하셨습니다.");
		}else {
			af = new ActionForward("#", true);
			session.setAttribute("ErrorMassege", "등록이 실패하였습니다.");
		}
		return af;
	}

}
