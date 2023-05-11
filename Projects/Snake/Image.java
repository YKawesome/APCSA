package Snake;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	
	static BufferedImage title; {
		try {
			File file = new File("images/gSnake.png");
			FileInputStream fis = new FileInputStream(file);
			title = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	static BufferedImage controls; {
		try {
			File file = new File("images/Controls.png");
			FileInputStream fis = new FileInputStream(file);
			controls = ImageIO.read(fis);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
//	static BufferedImage apple; {
//		try {
//			File file = new File("images/applepixel.png");
//			FileInputStream fis = new FileInputStream(file);
//			apple = ImageIO.read(fis);
//			
//			
//		} catch (IOException e) {
//			System.err.println(e);
//		}
//	}
	
//	static BufferedImage orange; {
//		try {
//			File file = new File("images/orangepixel.png");
//			FileInputStream fis = new FileInputStream(file);
//			orange = ImageIO.read(fis);
//			
//			
//		} catch (IOException e) {
//			System.err.println(e);
//		}
//	}
//	
//	static BufferedImage lemon; {
//		try {
//			File file = new File("images/lemonpixel.png");
//			FileInputStream fis = new FileInputStream(file);
//			lemon = ImageIO.read(fis);
//			
//			
//		} catch (IOException e) {
//			System.err.println(e);
//		}
//	}
}
