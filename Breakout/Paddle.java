package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Paddle extends Rectangle {
	
	private static int maxx = GDV5.getMaxWindowX();
	private static int maxy = GDV5.getMaxWindowY();
	
	private static int lhratio = maxx / 80;
	
	private Color pColor = Color.white;
	
	private int speed = (int)1.5*Breakout.getGSpeed();
	private int initSpeed = speed;
	
	private int initWidth;
	
	public Paddle(int size) {
		super(GDV5.getMaxWindowX() / 2 - lhratio*size / 2, GDV5.getMaxWindowY() - size, lhratio*size, size);
		initWidth = lhratio*size;
	}
	
	public void setColor(Color col) {
		pColor = col;
	}
	
	public void resetSpeed() {
		speed = initSpeed;
	}
	
	public void resetSize() {
		int wDiff = width - initWidth;
		x += wDiff / 2;
		width = initWidth;
		
	}
	
	
	public void checkPMove() {
		
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT] && x<=maxx-width) {
			
			if(speed<0) {
				speed=-speed;
			}
			
			this.translate(speed, 0);
		}
		
		else if (GDV5.KeysPressed[KeyEvent.VK_LEFT] && x>=0) {
			
			if(speed>0) {
				speed=-speed;
			}
			
			this.translate(speed, 0);
		}
	
		
	}
	
	public void AIMove(Ball ball) {
		
			if (getCenterX() >= ball.getCenterX() && x>=0 ) {
				translate(-speed, 0);
			}
			
			else if (getCenterX() < ball.getCenterX() && x<=maxx-width) {
				translate(speed, 0);
			}
			
			
		}
	
	
	
	
	public void hit(Pill pill) {
//		System.out.print("TRUE");
		if(pill.getType().equals("Multiball") && !Breakout.getMultiballActive()) {
			Ball[] multiball = new Ball[(int)(10*Math.random() + 1)];
//			Ball[] multiball = new Ball[100];
			
			for(int i = 0; i < multiball.length; i++) {
				multiball[i] = new Ball(25, false);
			}
			
			Breakout.setMultiball(multiball);
		}
		
		if(pill.getType().equals("Fastpaddle") && !Breakout.getFastpaddleActive()) {
			speed *= 2;
			pColor = Brick.getColArray()[Breakout.getColArrayIndex()][(int)(Brick.getColArray()[Breakout.getColArrayIndex()].length*Math.random())];
					
			Breakout.setFastpaddleActive(true);
			
		}
		
		if(pill.getType().equals("Bigpaddle") && !Breakout.getBigpaddleActive()) {
			width *= 1.5;
			int wDiff = width - initWidth;
			x -= wDiff / 2;
			
			Breakout.setBigpaddleActive(true);
		}
	}
	
	
	
	
	
	
	public int getSpeed() {
		return speed;
	}
	
	
	
	
	
	public void draw(Graphics2D win) {
		win.setColor(pColor);
		win.fill(this);
	}

	
	
	
	
}
