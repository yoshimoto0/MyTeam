package word.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import word.vo.ActionForward;

public interface Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
