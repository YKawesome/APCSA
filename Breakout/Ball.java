package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import utilities.GDV5;

public class Ball extends Rectangle{
	private boolean isMainBall = false;
	
	private static int maxx = GDV5.getMaxWindowX();
	private static int maxy = GDV5.getMaxWindowY();
	
	private int speed = Breakout.getGSpeed();
	
	private double frac = Math.random() + 0.5;
	
	private int speedx;
	private int speedy;
	
	private Color bColor;
	
	private boolean alive = false;
	
	private static int resetTimer = 0;
	private static boolean resetBall = true;
	
	private static int j = 1;
	
	public Ball(int size, boolean isMainBall) {
		super(maxx/2 - size/2, 3*maxy/4, size, size);
		this.isMainBall = isMainBall;
		bColor = isMainBall ? Color.white : Brick.getColArray()[Breakout.getColArrayIndex()][(int)(Brick.getColArray()[Breakout.getColArrayIndex()].length*Math.random())];
		alive = true;
		
		speedx = isMainBall ? 0 : (int)(frac*speed);
		speedy = isMainBall ? 0 : -(int)((1.0/frac)*speed);
		
		if(Math.random() > .5) {
			speedx=-speedx;
		}
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public static int getResetTimer() {
		return resetTimer;
	}
	
	public static boolean getResetBall() {
		return resetBall;
	}
	public void resetBall() {
		if(j % 120 == 0) {
			resetTimer++;
		}

		if(resetTimer >= 3) {
			resetTimer = 0;
			j = 0;
			resetBall = false;
			speedx = speed;
			speedy = speed;
			
		}
		
		j++;
	}
	
	public void wallBounce() {
		
		if(y<=0) {
			speedy=-speedy;
		}
		
		if(y >= maxy - height && isMainBall) {
			x = maxx/2 - width/2;
			y = 3*maxy/4;
			speedy = 0;
			speedx = 0;
			resetBall = true;
			Breakout.decLives();
			
		}
		
		if(x >= maxx - width || x<=0) {
			speedx=-speedx;
		}
		
		if(y >= maxy - height && !isMainBall) {
			speedx = 0;
			speedy = 0;
			if(bColor.getAlpha() > 3) {
				bColor = new Color(bColor.getRed(), bColor.getGreen(), bColor.getBlue(), bColor.getAlpha() - 4);
			}
			else {
				alive = false;
			}
		}
		
		if(resetBall) {
			resetBall();
		}
		
	}
	
	public void paddleBounce(Paddle paddle) {
		
		int coldir = GDV5.collisionDirection(paddle, this, speedx, speedy);
//		Right = 0
//		Left = 2
//		Top = 1
//		Bottom = 3
		
		if(intersects(paddle) && coldir == 1) {
			if(!isMainBall) {
//				System.out.println("true");
			}
			
			speedy=-speedy;
			
//			smash ball
			if(((paddle.getSpeed() > 0 && speedx < 0) || (paddle.getSpeed() < 0 && speedx > 0)) && !Breakout.getAI()) {
				speedx=-speedx;
			}
		}
		
		if(intersects(paddle) && (coldir == 2 || coldir == 0)) {
			speedx=-speedx;
		}

		
	}
	
	public void brickBounce(Brick[] bricks) {
		for(Brick b:bricks) {
			
			int coldir = GDV5.collisionDirection(b, this, speedx, speedy);
//			Right = 0
//			Left = 2
//			Top = 1
//			Bottom = 3
			
			if(intersects(b) && b.getStatus()) {
				if(coldir == 1 || coldir == 3) {
					speedy=-speedy;
				}
				
				if(coldir == 0 || coldir == 2) {
					speedx=-speedx;
				}
				
				b.hit();
				
			}
		}
	}
	
	
	
	public void move(Paddle paddle, Brick[] bricks) {
		
		translate(speedx, speedy);
		
		wallBounce();
		paddleBounce(paddle);
		brickBounce(bricks);
		
	}
	
//	public void move(Paddle paddle, Brick[] bricks, double xfrac, double yfrac) {
//		
//		translate(speedx, speedy);
//		
////		wallBounce(true);
//		wallBounce(false);
//		
//		paddleBounce(paddle);
//		brickBounce(bricks);
//		
//	}
	
	
	public void draw(Graphics2D win) {
		if(getAlive()) {
			win.setColor(bColor);
			win.fillOval(x, y, width, height);
		}
	}
	
}
