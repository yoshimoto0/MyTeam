package word.vo;

public class BookListDTO {
  
	private int book_id;
	private String book_name;	
	private String userId;
	private int kind_id;
	private int hit;
	    
	public BookListDTO(){  }	

	public BookListDTO(int book_id, String book_name, String userId, int kind_id, int hit) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.userId = userId;
		this.kind_id = kind_id;
		this.hit = hit;
	}

	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}	
 
}
