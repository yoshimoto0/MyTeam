package word.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.svc.SearchWordService;
import word.vo.ActionForward;
import word.vo.KindDTO;

public class openMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SearchWordService svc = new SearchWordService();
		
		ArrayList<KindDTO> kindList = new ArrayList<KindDTO>();
		kindList = svc.getKindList();
		
		request.setAttribute("kindList", kindList);
		
		ActionForward af = new ActionForward("index.html", true);
		
		return af;
	}

}
