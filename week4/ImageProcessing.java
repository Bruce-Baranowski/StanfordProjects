package week4;

import acm.graphics.*;

import acm.program.GraphicsProgram;

public class ImageProcessing extends GraphicsProgram {

	
	public void run() {
		GImage image = new GImage("week4//MilkMaid.jpg");
		
		GImage flippedImage = flipHorizontal(image);

		add(image, 10, 50);
		add(flippedImage, 250, 50);
		
	}
	
	public GImage flipHorizontal(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width/2; j++) {
				int tmp = array[i][j];
				array[i][j] = array[i][width-1-j];
				array[i][width-1-j] = tmp;
			}
		}
		return new GImage(array);
	}
	
}
