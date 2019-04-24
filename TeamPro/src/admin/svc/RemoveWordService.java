package admin.svc;

import admin.vo.AdminDAO;

public class RemoveWordService {

	public int execute(int num) {
		
		int res = 0;
		AdminDAO dao = new AdminDAO(); 
		res = dao.RemoveWord(num);
		
		
		
		
		
		return res;
	}

}
