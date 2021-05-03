package midterm;

import stanford.karel.SuperKarel;

import stanford.karel.*;

public class Outline extends SuperKarel {
	
	public void run() {
		turnLeft();
		move();
		turnRight();
		move();
		
		for(int i = 0; i < 4; i++) {
			placeUntilWallOrBeeper();
			turnLeft();
			turnLeft();
			move();
			turnRight();
			move();
		}
		
	}
	
	private void placeUntilWallOrBeeper() {
		
		while(frontIsClear() && noBeepersPresent()) {
			putBeeper();
			move();
		}
		
	}
}
