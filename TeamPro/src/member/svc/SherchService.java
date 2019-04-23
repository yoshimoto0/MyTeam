package member.svc;

import member.vo.MemberDAO;
import member.vo.MemberDTO;

public class SherchService {

	public MemberDTO execute(String email) {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.shechMember(email);
		return dto;
	}
	
}
