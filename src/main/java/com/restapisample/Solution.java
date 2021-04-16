package com.restapisample;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.StringUtils;

public class Solution {
	public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
		CursorPosition cursorPosition = CursorPosition.from(position);
		LinkedList<String> result = new LinkedList<>();
		for(String move : moves){
			String currentFighter = "";
			switch (move){
				case "up":
					currentFighter = moveUp(cursorPosition,fighters);
					break;
				case "down":
					currentFighter = moveDown(cursorPosition,fighters);
					break;
				case "right":
					currentFighter = moveRight(cursorPosition,fighters);
					break;
				case "left":
					currentFighter = moveLeft(cursorPosition,fighters);
					break;
			}
			result.add(currentFighter);
		}

		return result.toArray(String[]::new);
	}

	private static String getFighter(String[][]fighters, CursorPosition cursorPosition) {
		return fighters[cursorPosition.getPositionY()][cursorPosition.getPositionX()];
	}

	private static String moveLeft(CursorPosition cursorPosition, String[][]fighters) {
		cursorPosition.setPositionX(cursorPosition.getPositionX()-1);
		if (cursorPosition.getPositionX() < 0){
			cursorPosition.setPositionX(fighters[0].length -1);
		}
		if (StringUtils.isEmpty(getFighter(fighters, cursorPosition))) {
			return moveLeft(cursorPosition, fighters);
		}

		return getFighter(fighters, cursorPosition);
	}

	private static String moveRight(CursorPosition cursorPosition, String[][]fighters) {
		cursorPosition.setPositionX(cursorPosition.getPositionX()+1);
		if (cursorPosition.getPositionX() > fighters[0].length-1){
			cursorPosition.setPositionX(0);
		}
		if (StringUtils.isEmpty(getFighter(fighters, cursorPosition))) {
			return moveRight(cursorPosition, fighters);
		}

		return getFighter(fighters, cursorPosition);
	}

	private static String moveUp(CursorPosition cursorPosition, String[][]fighters) {
		cursorPosition.setPositionY(cursorPosition.getPositionY()-1);
		if (cursorPosition.getPositionY() < 0){
			cursorPosition.setPositionY(0);
		}
		if (StringUtils.isEmpty(getFighter(fighters, cursorPosition))) {
			cursorPosition.setPositionY(cursorPosition.getPositionY()+1);
			return getFighter(fighters, cursorPosition);
		}

		return getFighter(fighters, cursorPosition);
	}

	private static String moveDown(CursorPosition cursorPosition, String[][]fighters) {
		cursorPosition.setPositionY(cursorPosition.getPositionY()+1);
		if (cursorPosition.getPositionY() > fighters.length -1){
			cursorPosition.setPositionY(fighters.length -1);
		}
		if (StringUtils.isEmpty(getFighter(fighters, cursorPosition))) {
			cursorPosition.setPositionY(cursorPosition.getPositionY()-1);
			return getFighter(fighters, cursorPosition);
		}

		return getFighter(fighters, cursorPosition);
	}


}
