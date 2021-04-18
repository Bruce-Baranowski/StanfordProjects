package week2;

import acm.program.GraphicsProgram;
import java.awt.event.*;
import acm.graphics.*;

public class DrawingLines extends GraphicsProgram {
	private GLine currentLine;

	public void run() {
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		currentLine = new GLine(x, y, x, y);
		add(currentLine);
	}
	
	public void mouseDragged(MouseEvent e) {
		if (currentLine != null) {
			currentLine.setEndPoint(e.getX(), e.getY());
		}
	}
}
