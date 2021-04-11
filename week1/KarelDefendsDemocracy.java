package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		while(frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				clearBallot();
			}
			move();
		}
		
	}
	
	public void clearBallot() {
		turnLeft();
		move();
		pickAllBeepers();
		turnAround();
		move();
		move();
		pickAllBeepers();
		turnAround();
		move();
		turnRight();
	}
	
	public void pickAllBeepers() {
		while (beepersPresent()) {
			pickBeeper();
		}
	}
		
}
