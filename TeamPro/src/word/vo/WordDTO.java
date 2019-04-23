package word.vo;

public class WordDTO {
	
	private int num;
	private String word;
	private String meaning;
	private int kind;
	
	public WordDTO() {
		
	}

	public WordDTO(int num, String word, String meaning, int kind) {
		super();
		this.num = num;
		this.word = word;
		this.meaning = meaning;
		this.kind = kind;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}
	
	
	
}
