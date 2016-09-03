package com.giantis.boggle.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.giantis.boggle.Game;

public class BoggleTest {
	@Test
	public void foundWords() {
		Game.reset();
		
		Map<String, Integer> expected1 = new HashMap<String, Integer>();
		expected1.put("ABC", 2);
		
		Map<String, Integer> result1 = Game.play(new char[][]{{'A', 'G', 'T', 'H'},{'B', 'C', 'T', 'H'},{'A', 'X', 'O', 'H'},{'A', 'G', 'T', 'H'}});
		
		Assert.assertEquals(expected1, result1);
		
		Game.reset();
		
		Map<String, Integer> expected2 = new HashMap<String, Integer>();
		expected2.put("ABC", 2);
		expected2.put("ABCD", 2);
		
		Map<String, Integer> result2 = Game.play(new char[][]{{'A', 'G', 'T', 'H'},{'B', 'C', 'T', 'H'},{'A', 'D', 'D', 'H'},{'A', 'G', 'T', 'H'}});
		
		Assert.assertEquals(expected2, result2);
	}
	
	@Test
	public void gameSingleton() {
		Game.reset();
		Assert.assertNotNull(Game.getGame());
	}
	
	@Test
	public void boardInstance() {
		Game.reset();
		Game.play();
		
		Game game = Game.getGame();
		
		Assert.assertNotNull(game.getBoard());
		Assert.assertNotNull(game.getBoard().getBlock(0, 0));
	}
	
	@Test
	public void dictionarySingleton() {
		Game.reset();
		Game.getGame();
		
		HashMap<String, Integer> dictionary = Game.getDictionary();
		
		Assert.assertNotNull(dictionary);
		Assert.assertTrue(dictionary instanceof HashMap);
		Assert.assertFalse(dictionary.isEmpty());
	}
}
