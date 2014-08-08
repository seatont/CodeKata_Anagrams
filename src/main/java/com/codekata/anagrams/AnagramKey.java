package com.codekata.anagrams;

import java.util.HashMap;
import java.util.Map;

public class AnagramKey {
	
	private Map<Character, Integer> keyMap = new HashMap<>();
	
	public AnagramKey(String word) {
		loadMap(word);
	}
	
	 private void loadMap(String word) {
		 for(Character c: word.toCharArray()) {
			 Integer count = keyMap.get(c);
			 if (count == null) {
				 keyMap.put(c, new Integer(1));
			 } else {
				 keyMap.put(c, ++count);
			 }
		 }
	 }

	@Override
	public int hashCode() {
		return keyMap.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnagramKey other = (AnagramKey) obj;
		if (keyMap == null) {
			if (other.keyMap != null)
				return false;
		} else if (!keyMap.equals(other.keyMap))
			return false;
		return true;
	}
	

}
