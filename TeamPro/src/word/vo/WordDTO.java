package word.vo;

public class WordDTO {
	
	private int word_num;
	private String word;
	private String meaning;
	private int kind_id;
	
	public WordDTO() {
		
	}

	public WordDTO(int word_num, String word, String meaning, int kind_id) {
		super();
		this.word_num = word_num;
		this.word = word;
		this.meaning = meaning;
		this.kind_id = kind_id;
	}

	public int getWord_num() {
		return word_num;
	}

	public void setWord_num(int word_num) {
		this.word_num = word_num;
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

	public int getKind_id() {
		return kind_id;
	}

	public void setKind_id(int kind_id) {
		this.kind_id = kind_id;
	}
	
	
	
}
