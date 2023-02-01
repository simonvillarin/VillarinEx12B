package org.ssglobal.training.codes.itemA;

import java.util.ArrayList;

public class Uniquely {
	private ArrayList<String> arrList = new ArrayList<>();

	public int createUniques(String str) {
		if (arrList.contains(str)) {
			int count = 0;
			ArrayList<Character> charList = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != ' ' && !charList.contains(str.charAt(i))) {
					count++;
					charList.add(str.charAt(i));
				}
			}
			return count;
		}

		int count = 0;
		ArrayList<Character> charList = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ' && !charList.contains(str.charAt(i))) {
				count++;
				charList.add(str.charAt(i));
			}
		}
		arrList.add(str);
		return count;
	}
}
