package admin.svc;

import admin.vo.AdminDAO;

public class MemberUpgradeService {

	public int execute(String user_id) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.memberUpgrade(user_id);
		
		return res;
	}

}
