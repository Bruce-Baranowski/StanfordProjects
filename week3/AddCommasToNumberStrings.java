package week3;

import acm.program.ConsoleProgram;

public class AddCommasToNumberStrings extends ConsoleProgram {
	
	public void run() {
		String digits = readLine("Enter a numeric string:");
		println(addCommasToNumericString(digits));
	}
	
	private String addCommasToNumericString(String digits) {
		int strLength = digits.length();
		String withCommas;
		if (strLength>3) {
			int remainder = strLength%3;
			withCommas = digits.substring(0, remainder);
			for(int i = remainder; i<strLength; i+=3) {
				withCommas+= "," + digits.substring(i, i+3);
			}
		}
		else withCommas = digits;
		return withCommas;
	}
	
	private String addCommasToNumericStringEasy(String digits) {
		int tmp = Integer.parseInt(digits);
		return String.format("%,d", tmp);
	}
}
