package member.svc;

import member.vo.MemberDAO;
import member.vo.MemberDTO;

public class CreateActionService {
	public int execute(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		int res = dao.createMember(dto);
		
		return res;
		
	}
}
