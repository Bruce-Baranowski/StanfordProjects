package week4;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class UniqueNames extends ConsoleProgram {
	private ArrayList<String> names;
	public void run() {
		uniqueNames();
	}
	
	private void uniqueNames() {
		names = new ArrayList<String>();
		String name = readLine("Enter Name: ").trim();
		while (name.length()>0) {
			if (! names.contains(name)) {
				names.add(name);
			}
			name = readLine("Enter Name: ").trim();
		}
		printResults();
	}
	
	private void printResults() {
		for(String x: names) {
			System.out.println(x);
		}
	}
}
