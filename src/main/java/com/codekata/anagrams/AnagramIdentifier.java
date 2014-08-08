package com.codekata.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramIdentifier {
	
	private static Map<AnagramKey,List<String>> anagramMap = new HashMap<>(); 
	
	public static void readAnagrams(List<String> anagrams) {
		for(String word : anagrams) {
			if (word.length() == 1) {
				continue;
			}
			AnagramKey anagramKey = new AnagramKey(word);
			List<String> anagramList = anagramMap.get(anagramKey);
			if (anagramList == null) {
				anagramList = new ArrayList<String>();
				anagramMap.put(anagramKey, anagramList);
			} 
			anagramList.add(word);
		}
	}
	
	public static void printResults() {
		for(Map.Entry<AnagramKey, List<String>> anagrams : anagramMap.entrySet()) {
			if (anagrams.getValue().size() <= 1) {
				continue;
			}
			for(String word : anagrams.getValue()) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
	}

}
