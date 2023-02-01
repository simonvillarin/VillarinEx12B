package org.ssglobal.training.codes.itemB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordFinder {
	private Map<String, Integer> wordMap = new HashMap<>();
	private List<Word> wordList = new ArrayList<>();
	
	public void tabulateWords() {
		try (Scanner sc = new Scanner(new File("./src/files/hamlet.txt"))) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine().toLowerCase();
				String[] lineWords = line.split("[^a-zA-Z']+");
				
				for (String word: lineWords) {
					if (wordMap.containsKey(word) && !word.equals("")) {
						int count = wordMap.get(word);
						count += 1;
						wordMap.replace(word, count);
					} else if (!word.equals("")){
						wordMap.put(word, 1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		for (Entry<String, Integer> lookup: wordMap.entrySet()) {
			Word word = new Word();
			word.setWord(lookup.getKey());
			word.setOccurences(lookup.getValue());
			wordList.add(word);
		}
		
		Collections.sort(wordList);
		for (Word lookup: wordList) {
			System.out.println("%-15s%d".formatted(lookup.getWord(), lookup.getOccurences()));
		}
	}
}
