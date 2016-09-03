package com.giantis.boggle;import java.util.ArrayList;
import java.util.List;

public class Word {
	
	public Word() {
		super();
	}

	public Word(List<Block> letters) {
		this.letters = letters;
	}

	private List<Block> letters;
	
	public List<Block> getLetters() {
		if (letters == null) 
			this.letters = new ArrayList<Block>();
		
		return this.letters;
	}
	
	public void addLetter(Block aLetter) {
		this.getLetters().add(aLetter);
	}
	
	@Override
	public String toString() {
		char[] simple = new char[this.getLetters().size()];
		
		for (int i = 0; i < simple.length; i++) {
			simple[i] = this.getLetters().get(i).getLetter();
		}
		
		return new String(simple);
	}
	
	public boolean containsLetter(Block aLetter) {
		for (Block currentLetter: this.getLetters()) {
			if (currentLetter.equals(aLetter))
				return true;
		}
		
		return false;
	}
	
}
