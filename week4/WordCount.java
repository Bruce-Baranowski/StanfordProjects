package week4;

import java.io.*;

import acm.program.ConsoleProgram;

public class WordCount extends ConsoleProgram {
	private String file;
	private int lines;
	private int words;
	private int chars;
	
	public void run() {
		wordCount("week4//lear.txt");
	}
	
	public BufferedReader openFile(String file) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	public String getNextLine(BufferedReader in) {
		String nextLine = null;
		try {
			nextLine = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nextLine;
	}
	
	public void wordCount(String file) {
		BufferedReader in = openFile(file);
		String currentLine = getNextLine(in);
		this.file = file;
		lines = 0;
		words = 0;
		chars = 0;
		while (currentLine != null) {
			char[] charArray = currentLine.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				chars++;
				if ((!Character.isJavaLetterOrDigit(charArray[i]) 
						&& Character.isJavaLetterOrDigit(charArray[i-1]) ) 
						|| 
						(Character.isJavaLetterOrDigit(charArray[i]) 
								&& i+1 >= charArray.length) ) {
					words++;
				}
			}
			lines++;
			currentLine = getNextLine(in);
		}
		printResults();
		
	}
	
	public void printResults() {
		System.out.println("File: "+file);
		System.out.println("Lines: "+lines);
		System.out.println("Words: "+words);
		System.out.println("Chars: "+chars);
	}
}
