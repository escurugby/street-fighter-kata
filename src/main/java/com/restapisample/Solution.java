package com.restapisample;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.util.StringUtils;

public class Solution {
	public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
		AtomicReference<CursorPosition> currentCursorPosition = CursorPosition.from(position);
		Board fightersBoard = Board.from(fighters);
		LinkedList<String> result = new LinkedList<>();
		for(String move : moves){
			result.add(fightersBoard.move(currentCursorPosition, move));
		}

		return result.toArray(String[]::new);
	}






}
