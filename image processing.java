// Java program to demonstrate
// colored to grayscale conversion

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Grayscale {
	public static void main(String args[])
		throws IOException
	{
		BufferedImage img = null;
		File f = null;

		// read image
		try {
			f = new File(
				"C:/Users/hp/Desktop/Image Processing in Java/gfg-logo.png");
			img = ImageIO.read(f);
		}
		catch (IOException e) {
			System.out.println(e);
		}

		// get image's width and height
		int width = img.getWidth();
		int height = img.getHeight();

		// convert to grayscale
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				// Here (x,y)denotes the coordinate of image
				// for modifying the pixel value.
				int p = img.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;

				// calculate average
				int avg = (r + g + b) / 3;

				// replace RGB value with avg
				p = (a << 24) | (avg << 16) | (avg << 8)
					| avg;

				img.setRGB(x, y, p);
			}
		}

		// write image
		try {
			f = new File(
				"C:/Users/hp/Desktop/Image Processing in Java/GFG.png");
			ImageIO.write(img, "png", f);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
