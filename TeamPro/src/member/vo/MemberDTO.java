package member.vo;

public class MemberDTO {
	
	private String user_id;
	private String user_pass;
	private String user_name;
	private String email;
	private String image;
	private int favor;
	private int isAdmin;
	
	public MemberDTO(){}
	
	public MemberDTO(String id, String pass, String userName, String image, String email, int favor, int isAdmin){
		this.user_id = id;
		this.user_pass = pass;
		this.user_name = userName;
		this.image = image;
		this.email = email;
		this.favor = favor;
		this.isAdmin = isAdmin;
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getFavor() {
		return favor;
	}

	public void setFavor(int favor) {
		this.favor = favor;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
}
	