package org.ssglobal.training.codes.itemA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
	
	private Map<Character, List<Integer>> concordance = new HashMap<>();
	
	public Map<Character, List<Integer>> concord(String str) {
		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			
			if (character != ' ') {
				if (concordance.containsKey(character)) {
					List<Integer> indexes = concordance.get(character);				
					indexes.add(i);
					concordance.replace(character, indexes);
				} else {
					List<Integer> indexes = new ArrayList<>();
					indexes.add(i);
					concordance.put(character, indexes);
				}
			}
		}
		return concordance;
	}
}
