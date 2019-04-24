package admin.svc;

import admin.vo.AdminDAO;

public class RequestRemoveService {

	public int execute(int num) {
		AdminDAO dao = new AdminDAO();
		int res = dao.removeRequest(num);
		
		return res;
	}

}
