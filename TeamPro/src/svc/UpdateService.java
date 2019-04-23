package svc;

import vo.MemberDAO;

public class UpdateService {

	public int execute(String id, String pass, String nickname, String email, String image, int favor) {
		MemberDAO dao = new MemberDAO();
		int res = dao.UpdateMember(id, pass, nickname, email, image, favor);
		return res;
	}

}
