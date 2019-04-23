package svc;

import vo.MemberDAO;
import vo.MemberDTO;

public class SherchService {

	public MemberDTO execute(String email) {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.shechMember(email);
		return dto;
	}
	
}
