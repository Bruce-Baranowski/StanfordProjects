package week2;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	private final int MAX_TERM_VALUE = 10000;
	
	public void run() {
		System.out.println("This Program lists the Fibonacci Sequence, up to terms less than 10,000");
		int fibA = 0;
		int fibB = 1;
		while (fibA < MAX_TERM_VALUE) {
			System.out.println(fibA);
			int fibTMP = fibB;
			fibB+=fibA;
			fibA=fibTMP;
		}
	}

}
