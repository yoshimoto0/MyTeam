package admin.svc;

import admin.vo.AdminDAO;

public class AddKindService {

	public int execute(String kind_name) {
		
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.addKind(kind_name);
		
		return res;
	}

}
