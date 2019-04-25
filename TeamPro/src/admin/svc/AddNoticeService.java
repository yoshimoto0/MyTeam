package admin.svc;

import admin.vo.AdminDAO;
import admin.vo.NoticeDTO;

public class AddNoticeService {

	public int execute(NoticeDTO dto) {
		int res = 0;
		AdminDAO dao = new AdminDAO();
		res = dao.AddNotice(dto);
		return res;
	}

}
