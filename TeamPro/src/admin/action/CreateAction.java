package member.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.svc.CreateActionService;
import member.vo.ActionForward;
import member.vo.MemberDTO;

public class CreateAction implements Action{

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = (String) request.getAttribute("username");
		String pass = (String) request.getAttribute("password");
		String nickname = (String) request.getAttribute("nickname");
		String email = (String) request.getAttribute("e-mail");
		ServletContext ctx = request.getServletContext();
		String path = "/images";
		String savePath = ctx.getRealPath(path);
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
		
		String image = multi.getFilesystemName("image");

		int favor = Integer.parseInt((String) request.getAttribute("favor"));
		int isAdmin = Integer.parseInt((String) request.getAttribute("isAdmin"));
		MemberDTO dto = new MemberDTO(id,pass,nickname,email,image,favor,isAdmin);
		CreateActionService svc = new CreateActionService();
		int res = svc.execute(dto);
		HttpSession session = request.getSession();
		
		
		ActionForward af = null;
		if(res>0) {
			af = new ActionForward("index.jsp",true);	
		session.setAttribute("succesemessage","가입이 성공적으로 처리되었습니다.");
		}else {
			af = new ActionForward("index.jsp",true);
			session.setAttribute("errormessage","가입이 실패하였습니다..");
		
		}return af;
	}

}
