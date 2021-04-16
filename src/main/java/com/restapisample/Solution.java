package com.restapisample;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.StringUtils;

public class Solution {
	public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
		CursorPosition cursorPosition = CursorPosition.from(position);
		Board board = Board.from(fighters);
		LinkedList<String> result = new LinkedList<>();
		for(String move : moves){
			String currentFighter = "";
			switch (move){
				case "up":
					currentFighter = moveUp(cursorPosition,board);
					break;
				case "down":
					currentFighter = moveDown(cursorPosition,board);
					break;
				case "right":
					currentFighter = moveRight(cursorPosition,board);
					break;
				case "left":
					currentFighter = moveLeft(cursorPosition,board);
					break;
			}
			result.add(currentFighter);
		}

		return result.toArray(String[]::new);
	}

	private static String moveLeft(CursorPosition cursorPosition, Board board) {
		cursorPosition.left();
		if (cursorPosition.getPositionX() < board.getLeftLimit()){
			cursorPosition.setPositionX(board.getRightLimit());
		}
		if (StringUtils.isEmpty(board.getFighter(cursorPosition))) {
			return moveLeft(cursorPosition, board);
		}

		return board.getFighter(cursorPosition);
	}

	private static String moveRight(CursorPosition cursorPosition, Board board) {
		cursorPosition.right();
		if (cursorPosition.getPositionX() > board.getRightLimit()){
			cursorPosition.setPositionX(board.getLeftLimit());
		}
		if (StringUtils.isEmpty(board.getFighter(cursorPosition))) {
			return moveRight(cursorPosition, board);
		}

		return board.getFighter(cursorPosition);
	}

	private static String moveUp(CursorPosition cursorPosition, Board board) {
		cursorPosition.up();
		if (cursorPosition.getPositionY() < board.getTopLimit()){
			cursorPosition.setPositionY(board.getTopLimit());
		}
		if (StringUtils.isEmpty(board.getFighter(cursorPosition))) {
			cursorPosition.down();
			return board.getFighter(cursorPosition);
		}

		return board.getFighter(cursorPosition);
	}

	private static String moveDown(CursorPosition cursorPosition, Board board) {
		cursorPosition.down();
		if (cursorPosition.getPositionY() > board.getBottomLimit()){
			cursorPosition.setPositionY(board.getBottomLimit());
		}
		if (StringUtils.isEmpty(board.getFighter(cursorPosition))) {
			cursorPosition.up();
			return board.getFighter(cursorPosition);
		}

		return board.getFighter(cursorPosition);
	}


}
