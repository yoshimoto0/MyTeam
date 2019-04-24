package word.vo;

public class BookListDTO {
  
	private int book_id;
	private String book_name;	
	private String userId;
	private int hit;
	    
	public BookListDTO(){  }	

	public BookListDTO(int book_id, String book_name, String userId, int hit) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.userId = userId;
		this.hit = hit;
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
