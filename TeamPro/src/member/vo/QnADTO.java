package member.vo;

public class QnADTO {
	
	private int qna_num;
	private String title;   
	private String content;
	private String w_date;
	private String writer;
	private String ans;
	private int read;
	
	public QnADTO() {
		
	}

	public QnADTO(int qna_num, String title, String content, String w_date, String writer, String ans, int read) {
		super();
		this.qna_num = qna_num;
		this.title = title;
		this.content = content;
		this.w_date = w_date;
		this.writer = writer;
		this.ans = ans;
		this.read = read;
	}

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
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

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public int getRead() {
		return read;
	}

	public void setRead(int read) {
		this.read = read;
	}
	
	
}
