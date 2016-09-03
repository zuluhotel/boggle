package com.giantis.boggle;

import java.util.HashMap;
import java.util.Map;
 
public class Game {
	
	private Board board;
	private Map<String, Integer> foundWords;
	
	private static HashMap<String, Integer> dictionary;
	private static Game game;
	
	public static void main(String[] args) {
		Map<String, Integer> found = play(new char[][]{{'A', 'G', 'T', 'H'},{'B', 'C', 'T', 'H'},{'A', 'G', 'T', 'H'},{'A', 'G', 'T', 'H'}});
		System.out.println(found);
	}
	public static Map<String, Integer> play() {
		return play(null);
	}
	
	public static Map<String, Integer> play(char[][] aBoard) {
		Game game = Game.getGame();
		Board board = game.getBoard();
		HashMap<String, Integer> dictionary = Game.getDictionary();
		
//		dictionary.put("BC", 0);
		dictionary.put("ABC", 0);
		dictionary.put("ABCD", 0);

		if (aBoard != null)
			board.setBoard(aBoard);
		else
			board.intialize(); //random
			
		System.out.println(board.toString());
		
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++) {
				
				Block block = board.getBlock(x, y);

				System.out.println("Starting Word with..." + block);
				block.startWord();
			}
		
		return game.getFoundWords();
	}
	
	public Board getBoard() {
		if (board == null)
			board = new Board();
		
		return board;
	}
	
	public void found() {
		Word foundWord = this.getBoard().getCurrentWord();
		
		System.out.println("FOUND - " + foundWord);

		if (!this.getFoundWords().containsKey(foundWord.toString()))
			this.getFoundWords().put(foundWord.toString(), 0);
		
		this.getFoundWords().put(foundWord.toString(), this.getFoundWords().get(foundWord.toString()) + 1);
	}
	
	public Map<String, Integer> getFoundWords() {
		if (this.foundWords == null)
			this.foundWords = new HashMap<String, Integer>();
		
		return this.foundWords;
	}
	
	public static HashMap<String, Integer> getDictionary() {
		if (dictionary == null)
			dictionary = new HashMap<String, Integer>();
		
		return dictionary;
	}
	
	public static Game getGame() {
		if (game == null)
			game = new Game();
		
		return game;
	}
	
	public static void reset() {
		game = null;
	}

}
