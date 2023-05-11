package Snake;

import java.awt.Color;

public class ColorGen {
	
	public static Color[] generateColors(String s) {
		Color[] cols = new Color[4];
		
		cols[0] = Color.decode(s);
		cols[1] = new Color((int)(cols[0].getRed()*.9530), (int)(cols[0].getGreen()*0.9721), (int)(cols[0].getBlue()*.9));
		cols[2] = new Color((int)(cols[0].getRed()*.5177), (int)(cols[0].getGreen()*0.6373), (int)(cols[0].getBlue()*.65));
		cols[3] = new Color((int)(cols[0].getRed()*.4353), (int)(cols[0].getGreen()*0.5442), (int)(cols[0].getBlue()*.55));
		
		
		return cols;
	}
}
