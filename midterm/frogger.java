package midterm;

import acm.program.*;

import java.awt.event.MouseEvent;

import acm.graphics.*;

public class frogger extends GraphicsProgram {
	public static final int SQSIZE = 75;
	public static final int NCOLS = 7;
	public static final int NROWS = 3;
	public static final int APPLICATION_WIDTH = SQSIZE * NCOLS;
	public static final int APPLICATION_HEIGHT = SQSIZE * NROWS;
	private int fcol = 3;
	private int frow = 2;
	private GImage frog;

	public void run() {
		addMouseListeners();
		
		frog = new GImage("midterm//frog.png");
		frog.setLocation(fcol*SQSIZE, frow*SQSIZE);
		add(frog);
	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		moveFrog(x,y);
	}
	
	private void moveFrog(int x2, int y2) {
		int x1 = (int) frog.getX() + SQSIZE / 2;
		int y1 = (int) frog.getY() + SQSIZE / 2;
		calculateMove(x1, y1, x2, y2);
		frog.setLocation(fcol*SQSIZE, frow*SQSIZE);
	}
	
	private void calculateMove(int x1, int y1, int x2, int y2) {
		int xdiff = x1-x2;
		int ydiff = y1-y2;

		if (Math.abs(xdiff) > Math.abs(ydiff)) {
			if (xdiff > 0 && fcol>0) fcol--;
			else if (fcol<NCOLS-1) fcol++;
		}
		else {
			if (ydiff > 0 && frow>0) frow--;
			else if (frow<NROWS-1) frow++;
		}
	}
}
