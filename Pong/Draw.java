package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Draw {
	static boolean rpoint = false;
	static boolean lpoint = false;
	static int maxx = PongRunner.getMaxWindowX();
	static int maxy = PongRunner.getMaxWindowY();
	
	static int lpc = 0;
	static int rpc = 0;
	
	static int cool = 2;
	
	public static void drill(Graphics2D win, Rectangle thing) {
		win.draw(thing);
		win.fill(thing);
	}
	
	public static void splash(Graphics2D win) {
		
		int adv, height;
		
		
		Font titlef = new Font("Comic Sans MS", Font.PLAIN, 100);
		FontMetrics titlemetric = win.getFontMetrics(titlef);
		
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 50);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		Font playerrun = new Font("Comic Sans MS", Font.ITALIC, 25);
		FontMetrics playermetric = win.getFontMetrics(playerrun);
		
		String title = "RPongG";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(title);
		height = titlemetric.getMaxAscent();
		win.drawString(title, (float)(maxx/2 - adv/2), ((float)(1.0/6)) * maxy);
		
		String subtitle = "Yousef Khan";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(subtitle);
		height = subtitlemetric.getMaxAscent();
		win.drawString(subtitle, (float)(maxx/2 - adv/2), ((float)(1.0/6) * maxy + titlemetric.getMaxAscent()));
		
		String Player = "Single Player";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(Player);
		height = subtitlemetric.getMaxAscent();
		win.drawString(Player, (float)(maxx/4 - adv/2), ((float)(5.0/8) * maxy));
		
		Player = "Two Player";
		adv = subtitlemetric.stringWidth(Player);
		height = subtitlemetric.getMaxAscent();
		win.drawString(Player, (float)((3*maxx)/4 - adv/2), ((float)(5.0/8) * maxy));
		
		
		String PlayerRun = "Press 1 to Start";
		win.setFont(playerrun);
		adv = playermetric.stringWidth(PlayerRun);
		height = playermetric.getMaxAscent();
		win.drawString(PlayerRun, (float)(maxx/4 -  adv/2), ((float)(5.0/8) * maxy + subtitlemetric.getMaxAscent()));
		
		PlayerRun = "Press 2 to Start";
		adv = playermetric.stringWidth(PlayerRun);
		height = playermetric.getMaxAscent();
		win.drawString(PlayerRun, (float)(3*maxx/4 - adv/2), ((float)(5.0/8) * maxy + subtitlemetric.getMaxAscent()));
	}
	
	public static void watermark(Graphics2D win) {
		int maxx = PongRunner.getMaxWindowX();
		int maxy = PongRunner.getMaxWindowY();
		int adv, height;
		
		
		Font titlef = new Font("Comic Sans MS", Font.PLAIN, 200);
		FontMetrics titlemetric = win.getFontMetrics(titlef);
		
		String title = "RPongG";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(title);
		height = titlemetric.getMaxAscent();
		win.drawString(title, (float)(maxx/2 - adv/2), ((float)(1.0/2)) * maxy + height/2);
		
		Font copyf = new Font("Comic Sans MS", Font.ITALIC, 25);
		FontMetrics copymetric = win.getFontMetrics(copyf);
		
		String copy = "©2022 Yousef Khan";
		win.setFont(copyf);
		adv = copymetric.stringWidth(copy);
		height = copymetric.getMaxAscent();
		win.drawString(copy, (float)(maxx - 1.2*adv), (float)(maxy - 30));
	}
	
	public static void scoreboard(Graphics2D win) {
		int adv, height;
		win.setColor(Color.LIGHT_GRAY);
		
		Font scoref = new Font(Font.MONOSPACED, Font.PLAIN, 150);
		FontMetrics scoremetric = win.getFontMetrics(scoref);
		
		Font scoredf = new Font(Font.MONOSPACED, Font.PLAIN, 75);
		FontMetrics scoredmetric = win.getFontMetrics(scoredf);
		
		String lScoreDraw = "" + PongRunner.lscore;
		win.setFont(scoref);
		adv = scoremetric.stringWidth(lScoreDraw);
		height = scoremetric.getMaxAscent();
		win.drawString(lScoreDraw, maxx/2 - adv/2 - maxx/8, ((float)(1.0/4)) * maxy + height/2);
		
		String rScoreDraw = "" + PongRunner.rscore;
		win.setFont(scoref);
		adv = scoremetric.stringWidth(rScoreDraw);
		height = scoremetric.getMaxAscent();
		win.drawString(rScoreDraw, maxx/2 - adv/2 + maxx/8, ((float)(1.0/4)) * maxy + height/2);
		
		String dash = "-";
		win.setFont(scoref);
		adv = scoremetric.stringWidth(dash);
		height = scoremetric.getMaxAscent();
		win.drawString(dash, maxx/2 - adv/2, ((float)(1.0/4)) * maxy + height/2);
		
		if(lpoint) {
			String p1win = String.format("Player %s gets a point!", "1");
			win.setFont(scoredf);
			adv = scoredmetric.stringWidth(p1win);
			height = scoredmetric.getMaxAscent();
			if(PongRunner.gamestate != 3) {
				win.drawString(p1win, maxx/2 - adv/2 , ((float)(3.0/4)) * maxy);
			}
			if(lpc==0) {
				lpc = PongRunner.i;
			}
			
		}
		
		if(rpoint) {
			String p2win = String.format("Player %s gets a point!", "2");
			win.setFont(scoredf);
			adv = scoredmetric.stringWidth(p2win);
			height = scoredmetric.getMaxAscent();
			if(PongRunner.gamestate != 3) {
				win.drawString(p2win, maxx/2 - adv/2 , ((float)(3.0/4)) * maxy);
			}
//			rpc = PongRunner.i;
			if(rpc==0) {
				rpc = PongRunner.i;
			}
		}
		
//		if(PongRunner.i % 60 == 0) {
//			System.out.println("Right Point Cool = " + rpc);
//			System.out.println("Rpoint boolean = " + rpoint);
			
//		}
		
		if(PongRunner.i - lpc > 60*cool) {
			lpoint = false;
			lpc = 0;
		}
//		
		if(PongRunner.i - rpc > 60*cool) {
			rpoint = false;
			rpc = 0;
		}
		
		
		
		
	}
	
	public static void checkPowers(Graphics2D win, Powerup fast) {
		if(fast != null && fast.getShowing()) {
			win.setColor(Color.RED);
			drill(win, fast);
		}
	}
	
	public static void gamedraw(Graphics2D win, Ball ball, Paddle lPaddle, Paddle rPaddle, Rectangle Divider, Powerup fast) {
		
		win.setColor(Color.DARK_GRAY);
		
		watermark(win);
		scoreboard(win);
		
		
		win.setColor(ball.bcolor);
		drill(win, ball);
		
		win.setColor(lPaddle.pcolor);
		drill(win, lPaddle);
		
		win.setColor(rPaddle.pcolor);
		drill(win, rPaddle);
		
		
		checkPowers(win, fast);
//		drill(win, Divider);
		
		
		
		
		
		
	}
	
	public static void enddraw(Graphics2D win) {
		int adv, height;
		
		
		Font titlef = new Font("Comic Sans MS", Font.PLAIN, 100);
		FontMetrics titlemetric = win.getFontMetrics(titlef);
		
		String title = String.format("PLAYER %d WINS!", PongRunner.winner);
		win.setFont(titlef);
		adv = titlemetric.stringWidth(title);
		height = titlemetric.getMaxAscent();
		win.drawString(title, maxx/2 - adv/2, maxy/2 + height/2);
		
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 50);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		String subtitle = "Press M to restart";
		win.setFont(subtitlef);
		adv = subtitlemetric.stringWidth(subtitle);
//		height = subtitlemetric.getMaxAscent();
		win.drawString(subtitle, maxx/2 - adv/2, maxy/2 + 2*height);
		
		
	}
	
	public static void instructions(Graphics2D win) {
		int adv, height;
		
		Font titlef = new Font("Comic Sans MS", Font.PLAIN, 50);
		FontMetrics titlemetric = win.getFontMetrics(titlef);
		
		Font actitlef = new Font("Comic Sans MS", Font.BOLD, 100);
		FontMetrics actitlemetric = win.getFontMetrics(actitlef);
		
		
		String actitle = "RPongG";
		win.setFont(actitlef);
		adv = actitlemetric.stringWidth(actitle);
		height = actitlemetric.getMaxAscent();
		win.drawString(actitle, maxx/2 - adv/2, maxy/4 + height/4 - 1*height);
		
		
		String onepins = "1P: Use W and S to move the paddle.";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(onepins);
		height = titlemetric.getMaxAscent();
		win.drawString(onepins, maxx/2 - adv/2, maxy/4 + height/2);
		
		String twopins = "2P: Use W/S or Up/Down to move the paddles.";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(twopins);
//		height = titlemetric.getMaxAscent();
		win.drawString(twopins, maxx/2 - adv/2, maxy/4 + height/2 + 2*height);
		
		win.setColor(Color.red);
		String powers = "Collect red powerups to hit the ball faster.";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(powers);
//		height = titlemetric.getMaxAscent();
		win.drawString(powers, maxx/2 - adv/2, maxy/4 + height/2 + 4*height);
		
		win.setColor(Color.cyan);
		String smash = "Move the paddle up/down while hitting to smash ball.";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(smash);
//		height = titlemetric.getMaxAscent();
		win.drawString(smash, maxx/2 - adv/2, maxy/4 + height/2 + 6*height);
		
		win.setColor(Color.white);
		String wincon = "1P: Unlimited, 2P: First to 5 wins";
		win.setFont(titlef);
		adv = titlemetric.stringWidth(wincon);
//		height = titlemetric.getMaxAscent();
		win.drawString(wincon, maxx/2 - adv/2, maxy/4 + height/2 + 8*height);
		
		Font subtitlef = new Font("Comic Sans MS", Font.PLAIN, 25);
		FontMetrics subtitlemetric = win.getFontMetrics(subtitlef);
		
		String startit = "Press Enter to start.";
		win.setFont(subtitlef);
		adv = titlemetric.stringWidth(startit);
//		height = titlemetric.getMaxAscent();
		win.drawString(startit, maxx/2 - adv/4, maxy/4 + height/2 + 10*height);
		
		
	}
}

