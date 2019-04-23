package member.svc;

import member.vo.MemberDAO;
import member.vo.MemberDTO;

public class LoginService {

	public MemberDTO execute(String id) {
		MemberDTO dto = null;
		MemberDAO dao = new MemberDAO();
		dto = dao.Login(id);
		
		return dto;
		
	}
	
}
