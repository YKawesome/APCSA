package Snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import utilities.GDV5;

public class Splash {
	
	
	public static void drawControls(Graphics2D win) {
		win.setColor(Color.black);
		
		Font subtitlef = new Font("Canva Sans", Font.PLAIN, 45);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		int adv, height;
		
		String curr = "Settings";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr,(GDV5.getMaxWindowX()/2)-adv/2,375);
		
		Font textf = new Font("Canva Sans", Font.PLAIN, 30);
		FontMetrics textmetric = win.getFontMetrics(textf);
		
		Color currCol;
		
		currCol = SnakeRunner.getOuroboros() ? Color.green : Color.red;
		win.setColor(currCol);
		curr = "Ouroboros";
		win.setFont(textf);
		adv = textmetric.stringWidth(curr);
		height = textmetric.getMaxAscent();
		win.drawString(curr,(5*GDV5.getMaxWindowX()/6)-5*adv/6,440);
		
		currCol = SnakeRunner.getAIControl() ? Color.green : Color.red;
		win.setColor(currCol);
		curr = "AI";
		win.setFont(textf);
		adv = textmetric.stringWidth(curr);
		height = textmetric.getMaxAscent();
		win.drawString(curr,(5*GDV5.getMaxWindowX()/6)-5*adv/6,490);
		
		currCol = SnakeRunner.getAutomomousFood() ? Color.green : Color.red;
		win.setColor(currCol);
		curr = "Moving Food";
		win.setFont(textf);
		adv = textmetric.stringWidth(curr);
		height = textmetric.getMaxAscent();
		win.drawString(curr,(5*GDV5.getMaxWindowX()/6)-5*adv/6,540);
		
		
	}
	
	
	public static void drawScore(Graphics2D win) {
		win.setColor(Color.white);
		
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 25);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		int adv, height;
		
		String curr = "Score: " + SnakeRunner.getScore();
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr,25,37);
	}
	
	public static void drawGameOver(Graphics2D win) {
		win.setColor(Color.white);
		
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 60);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		int adv, height;
		
		String curr = "[Space] Start Over?";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr,(GDV5.getMaxWindowX())/2-adv/2,(GDV5.getMaxWindowY()/2)-height/2);
	}
}
