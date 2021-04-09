package com.restapisample;

import java.util.*;
public class Solution {
	public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
		int initialPositionX = position[0];
		int initialPositionY = position[1];
		int height = fighters.length;
		int width = fighters[0].length;
		LinkedList<String> result = new LinkedList<>();
		for(String move : moves){
			switch (move){
				case "up":
					initialPositionY -= 1;
					if (initialPositionY < 0){
						initialPositionY = 0;
					}
					break;
				case "down":
					initialPositionY += 1;
					if(initialPositionY > height-1){
						initialPositionY = height-1;
					}
					break;
				case "right":
					initialPositionX += 1;
					if(initialPositionX > width-1){
						initialPositionX = 0;
					}
					break;
				case "left":
					initialPositionX -= 1;
					if(initialPositionX < 0){
						initialPositionX = width -1;
					}
					break;
			}
			result.add(fighters[initialPositionY][initialPositionX]);
		}



		return result.toArray(String[]::new);
	}
}
