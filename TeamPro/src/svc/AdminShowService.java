package svc;

import java.util.ArrayList;

import vo.MemberDAO;
import vo.MemberDTO;

public class AdminShowService {

	public ArrayList<MemberDTO> execute(String kind,String keyword) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.AdminShowMember(kind,keyword);
		
		
		return list;
	}

}
