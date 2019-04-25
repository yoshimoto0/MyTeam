package word.vo;

public class KindDTO {
	
	private int kind_id;
	private String kind_name;
	
	public KindDTO() {
		
	}

	public KindDTO(int kind_id, String kind_name) {
		super();
		this.kind_id = kind_id;
		this.kind_name = kind_name;
		
	}

	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}

	public String getKind_name() {
		return kind_name;
	}

	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}

	
	
}
