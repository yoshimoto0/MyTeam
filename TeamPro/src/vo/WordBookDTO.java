package vo;

public class WordBookDTO {

	
	private int wordNum; 
	private String word;
	private String meaning;
	private int star;
	
	public WordBookDTO() {
		
	}

	public WordBookDTO(int wordNum, String word, String meaning, int star) {
		super();
		this.wordNum = wordNum;
		this.word = word;
		this.meaning = meaning;
		this.star = star;
	}

	public int getWordNum() {
		return wordNum;
	}

	public void setWordNum(int wordNum) {
		this.wordNum = wordNum;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	
}
