package word.vo;

public class GradeDTO {

	private int id;
	private String t_date;   
	private String user_id;
	private String name;
	private int crr;
	private int incrr;
	
	public GradeDTO() {
		
	}

	public GradeDTO(int id, String t_date, String user_id, String name, int crr, int incrr) {
		super();
		this.id = id;
		this.t_date = t_date;
		this.user_id = user_id;
		this.name = name;
		this.crr = crr;
		this.incrr = incrr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getT_date() {
		return t_date;
	}

	public void setT_date(String t_date) {
		this.t_date = t_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCrr() {
		return crr;
	}

	public void setCrr(int crr) {
		this.crr = crr;
	}

	public int getIncrr() {
		return incrr;
	}

	public void setIncrr(int incrr) {
		this.incrr = incrr;
	}
	
}
