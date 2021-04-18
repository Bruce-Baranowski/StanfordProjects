package week2;

import acm.util.RandomGenerator;
import java.awt.Color;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class RandomCircles extends GraphicsProgram {
	private RandomGenerator rand = new RandomGenerator();
	private int scrHeight;
	private int scrWidth;
	
	public void run() {
		this.scrHeight = getHeight();
		this.scrWidth = getWidth();
		
		for(int i = 0; i < 10; i++) {
			addRandomCircle();
		}
		
	}
	
	private void addRandomCircle() {
		int circleRadius = rand.nextInt(5, 50);
		Color circleColor = rand.nextColor();
		int circleX = rand.nextInt(scrWidth - circleRadius);
		int circleY = rand.nextInt(scrHeight - circleRadius);
		
		GOval circle = new GOval(circleX, circleY, circleRadius, circleRadius);
		circle.setColor(circleColor);
		circle.setFillColor(circleColor);
		circle.setFilled(true);
		add(circle);
	}
	
	
}
