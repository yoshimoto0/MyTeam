package svc;

import vo.MemberDAO;
import vo.MemberDTO;

public class CreateActionService {
	public int execute(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		int res = dao.createMember(dto);
		
		return res;
		
	}
}
