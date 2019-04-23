package member.svc;

import member.vo.MemberDAO;
import member.vo.MemberDTO;

public class UpdateService {

	public int execute(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		int res = dao.UpdateMember(dto);
		return res;
	}

}
