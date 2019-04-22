package vo;

public class BookDTO {
  
	private String userId;
	private int wordNum;
	private int sheet;
	private String bookName;
	private int star;
	  
	  
	public BookDTO(){  }
	  
	public BookDTO(String userId, int wordNum, int sheet, String bookName, int star){
		this.userId = userId;
		this.wordNum = wordNum;
		this.sheet = sheet;
		this.bookName = bookName;
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
	
	public int getSheet() {
		return sheet;
	}
	
	public void setSheet(int sheet) {
		this.sheet = sheet;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getStar() {
		return star;
	}
	
	public void setStar(int star) {
		this.star = star;
	}
	  
}
