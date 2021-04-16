package com.restapisample;

import java.util.*;

public class Solution {
	public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
		CursorPosition cursorPosition = CursorPosition.from(position);
		Board board = Board.from(fighters, cursorPosition);
		LinkedList<String> result = new LinkedList<>();
		for(String move : moves){
			String currentFighter = "";
			switch (move){
				case "up":
					currentFighter = board.moveUp(cursorPosition);
					break;
				case "down":
					currentFighter = board.moveDown(cursorPosition);
					break;
				case "right":
					currentFighter = board.moveRight(cursorPosition);
					break;
				case "left":
					currentFighter = board.moveLeft(cursorPosition);
					break;
			}
			result.add(currentFighter);
		}

		return result.toArray(String[]::new);
	}


}
