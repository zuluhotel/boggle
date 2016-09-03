package com.giantis.boggle;

import java.util.ArrayList;
import java.util.List;

public class Block {
	
	private char letter;
	private int x;
	private int y;
	
	public Block(char letter, int _x, int _y) {
		this.letter = letter;
		this.x = _x;
		this.y = _y;
	}
	
	private List<Block> adjacentUnusedBlocks() {
		List<Block> blocks = new ArrayList<Block>();
		Board board = Game.getGame().getBoard();
		Word currentWord = board.getCurrentWord();
		
		//LEFT
		if (x > 0 && !currentWord.containsLetter(board.getBlock(x - 1, y)))
			blocks.add(board.getBlock(x - 1, y));
		
		//RIGHT
		if (x < 3 && !currentWord.containsLetter(board.getBlock(x + 1, y)))
			blocks.add(board.getBlock(x + 1, y));
		
		//UP
		if (y > 0 && !currentWord.containsLetter(board.getBlock(x, y - 1)))
			blocks.add(board.getBlock(x, y - 1));
		
		//DOWN
		if (y < 3 && !currentWord.containsLetter(board.getBlock(x, y + 1)))
			blocks.add(board.getBlock(x, y + 1));
	
		return blocks;
	}
	
	public void startWord() {
		Game.getGame().getBoard().newWord();
		this.nextLetter();
	}
	
	public char getLetter() {
		return this.letter;
	}
	
	private void nextLetter() {
		List<Block> blocks = this.adjacentUnusedBlocks();
		Board board = Game.getGame().getBoard();
		
		Word currentWord = board.getCurrentWord();
		
		currentWord.addLetter(this);
		
		if (Game.getDictionary().containsKey(currentWord.toString())) {
			Game.getGame().found();
		}
				
		for (Block aBlock : blocks)
			aBlock.nextLetter();
		
		currentWord.getLetters().remove(currentWord.getLetters().size() - 1);
	}
	
	@Override
	public String toString() {
		return this.letter + " ";
	}
}
