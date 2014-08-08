package com.codekata.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSorter {
	
	private List<String> anagrams;
	private Map<Integer, ArrayList<String>> anagramHash = new HashMap<>();
	private Map<Integer, Character> letterHash = new HashMap<>();

	public AnagramSorter(List<String> anagrams) {
		this.anagrams = anagrams;
	}
	
	public void loadHash() {
		for(String line : anagrams) {
			Integer lineKey = Integer.valueOf(line.length());
			if(anagramHash.containsKey(lineKey)) {
				ArrayList<String> wordList = anagramHash.get(lineKey);
				wordList.add(line);
			} else {
				ArrayList<String> wordList = new ArrayList<>();
				wordList.add(line);
				anagramHash.put(lineKey, wordList);
			}
		}
	}
	
	public void print() {
		for(Integer key : anagramHash.keySet()) {
			System.out.println(key.toString());
		}
	}
	
	public void getStrings() {
		for(Integer key : anagramHash.keySet()) {
			ArrayList<String> words = anagramHash.get(key);
			int length = words.size()-1;
			int position = 0;
			String s1;
			String s2;
			for(String word : words) {
				s1 = word;
				position++;
				for(int i = position; i < length; i++) {
					s2 = words.get(i);
					loadLetterHash(s1, s2);
				}
			}			
		}
	}
	
	public boolean isAnagram(String s1, String s2) {
		char[] s1Char = s1.toCharArray();
		char[] s2Char = s2.toCharArray();
		
		Arrays.sort(s1Char);
		Arrays.sort(s2Char);

		String sc1 = s1Char.toString();
		String sc2 = s2Char.toString();
		return sc1.equals(sc2);
	}
	
	public void loadLetterHash(String s1, String s2) {
		if (s1.length() != s2.length()) {
			char[] s1charArray = s1.toCharArray();
			char[] s2charArray = s2.toCharArray();
			int count = 0;
			for(char c : s1charArray) {
				Character character = Character.valueOf(c);
				if (letterHash.containsKey(character.hashCode())) {
					Integer hashCode = letterHash.get(character).hashCode();
					letterHash.put(hashCode, character);
					count++;
				} else {
					letterHash.put(character.hashCode(), c);
					count++;
				}
			}
			for(char ch: s2charArray) {
				if(letterHash.containsKey(ch)) {
					count--;
				}
			}		
			if (count == 0) {
				System.out.println(String.format("S1: %s S2 %s", s1, s2));
			}
		} 
	}
}
