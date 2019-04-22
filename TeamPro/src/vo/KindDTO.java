package vo;

public class KindDTO {
	
	private int kind_id;
	private String kind;
	
	public KindDTO() {
		
	}

	public KindDTO(int kind_id, String kind) {
		super();
		this.kind_id = kind_id;
		this.kind = kind;
		
	}

	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	
	
}
