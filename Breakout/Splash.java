package Breakout;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import utilities.GDV5;

public class Splash {
	
	private static int maxx = GDV5.getMaxWindowX();
	private static int maxy = GDV5.getMaxWindowY();

	
	
	public static void drawSplash(Graphics2D win) {
		int adv, height;
		
		Font titlef = new Font("Comic Sans MS", Font.PLAIN, 100);
		FontMetrics titlemetric = win.getFontMetrics(titlef);
		
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 50);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		Font playerrun = new Font("Comic Sans MS", Font.ITALIC, 25);
		FontMetrics playermetric = win.getFontMetrics(playerrun);
		
		String title = "[Breakout]";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(title);
		height = titlemetric.getMaxAscent();
		win.drawString(title, (float)(maxx/2 - adv/2), ((float)(1.0/6)) * maxy);
		
		String subtitle = "Yousef Khan";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(subtitle);
		height = subtitlemetric.getMaxAscent();
		win.drawString(subtitle, (float)(maxx/2 - adv/2), ((float)(1.0/6) * maxy + titlemetric.getMaxAscent()));
		
		String curr = "[A] AI: " + Breakout.getAI();
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(2.0/6) * maxy + titlemetric.getMaxAscent()));
		
		curr = "[C] Color Palette: " + Breakout.getCurrentPalette();
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(3.0/6) * maxy + titlemetric.getMaxAscent()));
		
		curr = "[V] View Powerups";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(4.2/6) * maxy + titlemetric.getMaxAscent()));

		
		curr = "[Space] START";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(4.8/6) * maxy + titlemetric.getMaxAscent()));
		
		
		
	}
	
	public static void drawPowers(Graphics2D win) {
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 40);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		int adv, height;
		
		String curr = "On occasion, bricks will drop a pill.";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(1.0/6) * maxy));
		
		curr = "Some pills will start Multiball (1-10).";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(2.0/6) * maxy));
		
		curr = "Some will increase paddle length.";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(3.0/6) * maxy));
		
		curr = "Some will make your paddle faster.";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(4.0/6) * maxy));
		
		curr = "They will expire after about 7 seconds.";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(5.0/6) * maxy));
		
		curr = "[B] Back";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(5.5/6) * maxy));
		
		
	}
	
	public static void drawResetTimer(Graphics2D win) {
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 50);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		int adv, height;
		
		String curr = "" + (3 - Ball.getResetTimer());
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(4.0/6) * maxy));
		
	}
	
	public static void score(Graphics2D win) {
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 200);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		int adv, height;
		
		String curr = "" + Breakout.getScore();
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(3.25/6) * maxy));
	}
	
	public static void drawEnd(Graphics2D win) {
int adv, height;
		
		Font titlef = new Font("Comic Sans MS", Font.PLAIN, 100);
		FontMetrics titlemetric = win.getFontMetrics(titlef);
		
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 50);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		Font playerrun = new Font("Comic Sans MS", Font.ITALIC, 25);
		FontMetrics playermetric = win.getFontMetrics(playerrun);
		
		String title = "Game Over!";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(title);
		height = titlemetric.getMaxAscent();
		win.drawString(title, (float)(maxx/2 - adv/2), ((float)(2.0/6)) * maxy);
		
		String subtitle = "Final Score: " + Breakout.getScore();
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(subtitle);
		height = subtitlemetric.getMaxAscent();
		win.drawString(subtitle, (float)(maxx/2 - adv/2), ((float)(3.0/6) * maxy + titlemetric.getMaxAscent()));
		
		
		String curr = "[Enter] Restart";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(curr);
		height = subtitlemetric.getMaxAscent();
		win.drawString(curr, (float)(maxx/2 - adv/2), ((float)(5.5/6) * maxy));
		
	}
}
