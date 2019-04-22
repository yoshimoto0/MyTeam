package vo;

public class MemberDTO {
	
	private String id;
	private String pass;
	private String userName;
	private String email;
	private String image;
	private int favor;
	private int isAdmin;
	
	public MemberDTO(){}
	
	public MemberDTO(String id, String pass, String userName, String email, String image, int favor, int isAdmin){
		this.id = id;
		this.pass = pass;
		this.userName = userName;
		this.email = email;
		this.image = image;
		this.favor = favor;
		this.isAdmin = isAdmin;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
