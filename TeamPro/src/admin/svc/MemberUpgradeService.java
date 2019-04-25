package admin.svc;

import admin.vo.AdminDAO;

public class MemberUpgradeService {

	public int execute(String id) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.memberUpgrade(id);
		
		return res;
	}

}
