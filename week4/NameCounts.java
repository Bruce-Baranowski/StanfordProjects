package week4;

import java.util.HashMap;

import acm.program.ConsoleProgram;

public class NameCounts extends ConsoleProgram {
	private HashMap<String, Integer> dict;
	public void run() {
		countNames();
	}
	
	private void countNames() {
		dict = new HashMap<String, Integer>();
		String name = readLine("Enter Name: ").trim();
		while (name.length()>0) {
			int count = 0;
			if (dict.containsKey(name)) {
				count = dict.get(name);
			}
			dict.put(name, ++count);
			name = readLine("Enter Name: ").trim();
		}
		printResults();
	}
	
	private void printResults() {
		for(String x: dict.keySet()) {
			String out = String.format("Entry [%s] has count %d", x, dict.get(x));
			System.out.println(out);
		}
	}
}
