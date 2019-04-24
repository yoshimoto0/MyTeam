package admin.svc;

import admin.vo.AdminDAO;

public class RemoveKindService {

	public int execute(String kind) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.removeKind(kind);
		
		return 0;
	}

}
