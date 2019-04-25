package member.vo;

public class NoticeDTO {
	
	private int notice_num;
	private String title;   
	private String content;
	private String w_date;
	private String writer;
	
	public NoticeDTO() {
		
	}

	public NoticeDTO(int notice_num, String title, String content, String w_date, String writer) {
		super();
		this.notice_num = notice_num;
		this.title = title;
		this.content = content;
		this.w_date = w_date;
		this.writer = writer;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getW_date() {
		return w_date;
	}

	public void setW_date(String w_date) {
		this.w_date = w_date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
