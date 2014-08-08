package com.codekata.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AnagramMain {

	public static void main(String [] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Usage: java -jar Anagram.jar <path to file>");
			return;
		}
		List<String> anagrams = readResultFile(args[0]);
		AnagramIdentifier.readAnagrams(anagrams);
		AnagramIdentifier.printResults();
	}
	
	private static List<String> readResultFile(String filePath) throws IOException {
		ArrayList<String> resultFileContents = new ArrayList<>();
		BufferedReader reader =  new BufferedReader(new FileReader(filePath));
		String line = null;
		while((line = reader.readLine()) != null) {
			resultFileContents.add(line);
		}
		reader.close();
		return resultFileContents;
	}
}
