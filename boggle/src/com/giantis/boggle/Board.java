package com.giantis.boggle;

import java.util.Random;

public class Board {
	
	private Block[][] blocks; 
	private Word currentWord;
	
	private static String letters = "AAAABBBBCCCCDDDEFGHIJKLMNOPQRSTUVWXYZ";
	
	
	public Board() {
		blocks = new Block[4][4];
	}

	public void setBlock(int x, int y, Block aBlock) {
		this.blocks[x][y] = aBlock;
	}
	
	public void setBoard(char[][] anArbitraryBoard) {
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				this.setBlock(x, y, new Block(anArbitraryBoard[x][y], x, y));
	}
	
	public Block getBlock(int x, int y) {
		return this.blocks[x][y];
	}
	
	public Word getCurrentWord() {
		if (currentWord == null)
			this.currentWord = new Word();
		
		return this.currentWord;
	}
	

	

	
	public Word newWord() {
		this.currentWord = new Word();
		
		return this.currentWord;
	}
	
	public void intialize() {
		Random rand = new Random();

		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				this.setBlock(x, y, new Block(letters.charAt(rand.nextInt(letters.length())), x, y));
}
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				output.append(this.getBlock(x, y) + " ");
			}
			output.append("\n");
		}
		return output.toString();
	}
}
