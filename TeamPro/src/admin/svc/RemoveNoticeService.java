package admin.svc;

import admin.vo.AdminDAO;

public class RemoveNoticeService {

	public int execute(int num) {
		int res = 0;
		AdminDAO dao = new AdminDAO(); 
		res = dao.RemoveNotice(num);
		
		
		return res;
		
	}

}
