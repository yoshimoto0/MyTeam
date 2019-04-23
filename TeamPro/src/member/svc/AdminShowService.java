package member.svc;

import java.util.ArrayList;

import member.vo.MemberDAO;
import member.vo.MemberDTO;

public class AdminShowService {

	public ArrayList<MemberDTO> execute(String kind,String keyword) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.AdminShowMember(kind,keyword);
		
		
		return list;
	}

}
