package com.restapisample;

import java.util.*;
import org.springframework.util.StringUtils;

public class Solution {
	public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
		Integer positionX = position[0];
		Integer positionY = position[1];
		LinkedList<String> result = new LinkedList<>();
		for(String move : moves){
			String currentFighter = "";
			switch (move){
				case "up":
					currentFighter = moveUp(positionX,positionY,fighters);
					break;
				case "down":
					currentFighter = moveDown(positionX,positionY,fighters);
					break;
				case "right":
					currentFighter = moveRight(positionX,positionY,fighters);
					break;
				case "left":
					currentFighter = moveLeft(positionX,positionY,fighters);
					break;
			}
			result.add(currentFighter);
		}

		return result.toArray(String[]::new);
	}

	private static String moveLeft(Integer positionX, Integer positionY, String[][]fighters) {
		positionX --;
		if (positionX < 0){
			positionX = fighters[0].length -1;
		}
		if (StringUtils.isEmpty(fighters[positionY][positionX])) {
			return moveLeft(positionX, positionY, fighters);
		}

		return fighters[positionY][positionX];
	}

	private static String moveRight(Integer positionX, Integer positionY, String[][]fighters) {
		positionX ++;
		if (positionX < fighters[0].length-1){
			positionX = 0;
		}
		if (StringUtils.isEmpty(fighters[positionY][positionX])) {
			return moveRight(positionX, positionY, fighters);
		}

		return fighters[positionY][positionX];
	}

	private static String moveUp(Integer positionX, Integer positionY, String[][]fighters) {
		final Integer initialPositionY = positionY;
		positionY --;
		if (positionY < 0){
			positionY = 0;
		}
		if (StringUtils.isEmpty(fighters[positionY][positionX])) {
			return fighters[initialPositionY][positionX];
		}

		return fighters[positionY][positionX];
	}

	private static String moveDown(Integer positionX, Integer positionY, String[][]fighters) {
		final Integer initialPositionY = positionY;
		positionY ++;
		if (positionY > fighters.length -1){
			positionY = fighters.length -1;
		}
		if (StringUtils.isEmpty(fighters[positionY][positionX])) {
			return fighters[initialPositionY][positionX];
		}

		return fighters[positionY][positionX];
	}


}
