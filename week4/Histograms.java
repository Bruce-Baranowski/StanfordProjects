package week4;

import java.io.*;
import java.util.stream.IntStream;

import acm.program.ConsoleProgram;

public class Histograms extends ConsoleProgram {
	
	private int[] scores;
	
	public void run() {
		histograms("week4//MidtermScores.txt");
	}
	
	public void histograms(String file) {
		scores = new int[11];
		BufferedReader in = openFile(file);
		String currentLine = getNextLine(in);
		while (currentLine != null) {
			currentLine = currentLine.trim();
			int score = Integer.parseInt(currentLine);
			scores[score/10]++;
			currentLine = getNextLine(in);
		}
		printResults();
	}
	
	private BufferedReader openFile(String file) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
	
	private String getNextLine(BufferedReader in) {
		String nextLine = null;
		try {
			nextLine = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nextLine;
	}
	
	private void printResults() {
		String out;
		for(int i = 0; i<scores.length; i++) {
			String asterisks = "";
			for(int j = 0; j<scores[i]; j++) asterisks+="*";
			if(i<10) out = String.format("%d0-%d9: %s",i,i,asterisks); 
			else out = String.format("  100: %s",asterisks); 
			System.out.println(out);
		}
	}
}
