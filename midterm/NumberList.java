package midterm;

import acm.program.*;

public class NumberList extends ConsoleProgram {
	
	private int[] list = new int[0];
	private int highest = 0;
	private int secHighest = 0;


	public void run() {
		getNumbers();
		sortNumbers();
		outputResults();
	}
	
	private void sortNumbers() {
		for(int i: list) {
			if(i > highest) {
				secHighest = highest;
				highest = i;
			}
			else if (i > secHighest) secHighest = i;
		}
	}
	
	private void outputResults() {
		System.out.println("Highest number is: "+highest);
		System.out.println("Second highest number is: "+secHighest);
	}
	
	private void getNumbers() {
		boolean runCondition = true;
		while(runCondition) {
			int digit = Integer.parseInt(readLine("?:"));
			runCondition = addNumberToList(digit);
		}
	}
	
	private boolean addNumberToList(int addint) {
		if (addint==0) {
			return false;
		}
		int[] tmp = new int[list.length+1];
		for (int i = 0; i<list.length; i++) {
			tmp[i] = list[i];
		}
		tmp[list.length] = addint;
		list = tmp;
		return true;
	}
}
