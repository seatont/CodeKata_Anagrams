package com.codekata.anagrams;

public class Counter {
	
	private int count = 0;
	
	public Counter(int startingCount) {
		count = startingCount;
	}
	
	public void incrementCount() {
		++count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter other = (Counter) obj;
		if (count != other.count)
			return false;
		return true;
	}

}
