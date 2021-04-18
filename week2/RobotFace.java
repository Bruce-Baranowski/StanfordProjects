package week2;

import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class RobotFace extends GraphicsProgram {
	private final int HEAD_WIDTH = 100;
	private final int HEAD_HEIGHT = 150;
	private final int EYE_RADIUS = 20;
	private final int MOUTH_WIDTH = 60;
	private final int MOUTH_HEIGHT = 20;
	private int scrHeight;
	private int scrWidth;
	
	
	public void run() {
		this.scrHeight = getHeight();
		this.scrWidth = getWidth();
		addHead();
		addEyes();
		addMouth();
	}
	
	private void addHead() {
		double headOffsetX = (scrWidth/2.0) - (HEAD_WIDTH/2.0);
		double headOffsetY = (scrHeight/2.0) - (HEAD_HEIGHT/2.0);
		addRectangle(headOffsetX, headOffsetY, HEAD_WIDTH, HEAD_HEIGHT, Color.GRAY);
	}
	
	private void addEyes() {
		double eyeAOffsetX = (scrWidth/2.0) - (HEAD_WIDTH/4.0) - (EYE_RADIUS/2.0);
		double eyeBOffsetX = (scrWidth/2.0) + (HEAD_WIDTH/4.0) - (EYE_RADIUS/2.0);
		double eyeOffsetY = (scrHeight/2.0) - (HEAD_HEIGHT/4.0) - (EYE_RADIUS/2.0);
		addCircle(eyeAOffsetX, eyeOffsetY, EYE_RADIUS, Color.YELLOW);
		addCircle(eyeBOffsetX, eyeOffsetY, EYE_RADIUS, Color.YELLOW);
	}
	
	private void addMouth() {
		double mouthOffsetX = (scrWidth/2.0) - (MOUTH_WIDTH/2.0);
		double mouthOffsetY = (scrHeight/2.0) + (HEAD_HEIGHT/4.0) - (MOUTH_HEIGHT/2.0);
		addRectangle(mouthOffsetX, mouthOffsetY, MOUTH_WIDTH, MOUTH_HEIGHT, Color.WHITE);
		
	}
	
	private void addCircle(double x, double y, double radius, Color color) {
		GOval circle = new GOval(x, y, radius, radius);
		circle.setFillColor(color);
		circle.setFilled(true);
		add(circle);
		
	}
	
	private void addRectangle(double x, double y, double width, double height, Color color) {
		GRect rect = new GRect(x, y, width, height);
		rect.setFillColor(color);
		rect.setFilled(true);
		add(rect);
		
	}
	
}
