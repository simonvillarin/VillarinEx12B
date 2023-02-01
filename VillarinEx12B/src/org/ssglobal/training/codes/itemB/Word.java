package org.ssglobal.training.codes.itemB;

public class Word implements Comparable<Word>{
	private String word;
	private Integer occurences;
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getOccurences() {
		return occurences;
	}
	
	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}

	@Override
	public int compareTo(Word o) {
		if (occurences.compareTo(o.getOccurences()) > 0) {
			return -1;
		} else if (occurences.compareTo(o.getOccurences()) < 0) {
			return 1;
		}
		return 0;
	}
}
