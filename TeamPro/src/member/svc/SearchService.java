package member.svc;

import member.vo.MemberDAO;
import member.vo.MemberDTO;

public class SearchService {

	public MemberDTO execute(String email) {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.seachMember(email);
		return dto;
	}
	
}
