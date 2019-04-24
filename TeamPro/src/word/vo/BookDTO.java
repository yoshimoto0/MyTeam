package word.vo;

public class BookDTO {
  
	private String userId;
	private int wordNum;
	private int book_id;
	private int star;
	    
	public BookDTO(){  }
	  
	public BookDTO(String userId, int wordNum, int book_id, int star){
		this.userId = userId;
		this.wordNum = wordNum;
		this.book_id = book_id;
		this.star = star;
	}		

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getWordNum() {
		return wordNum;
	}

	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

}
