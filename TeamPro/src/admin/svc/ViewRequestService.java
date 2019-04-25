package admin.svc;

import java.util.ArrayList;

import admin.vo.AdminDAO;
import admin.vo.QnADTO;

public class ViewRequestService {

	public ArrayList<QnADTO> execute() {
		AdminDAO dao = new AdminDAO();
		ArrayList<QnADTO> list = dao.viewRequest();
		return list;
	}

}
