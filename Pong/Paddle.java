package Pong;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Paddle extends Rectangle{	
	int j = 0;
	int randospeed;
	Color pcolor = Color.WHITE;
	double kFast = 1.5;
	int aiheight;
	
	public Paddle(int size, int location) {
		super(location, (PongRunner.getMaxWindowY())/2 - 2*size, size, 6*size);
		aiheight = 12*size;
	}
	
	
	
	public void rCheckMove(int speed) {

		if(pcolor == Color.red) {
			speed*=kFast;
		}
		
		if (GDV5.KeysPressed[KeyEvent.VK_DOWN] && y<=PongRunner.getMaxWindowY()-this.height) {
			this.translate(0, speed);
		}
		
		else if (GDV5.KeysPressed[KeyEvent.VK_UP] && y>=0) {
			this.translate(0, -speed);
		}
	
		
	}
	
	public void lCheckMove(int speed) {
		
		if(pcolor == Color.red) {
			speed*=kFast;
		}
		
		if (GDV5.KeysPressed[KeyEvent.VK_S] && y<=PongRunner.getMaxWindowY()-this.height) {
			this.translate(0, speed);
		}
		
		else if (GDV5.KeysPressed[KeyEvent.VK_W] && y>=0) {
			this.translate(0, -speed);
		}
	
		
	}
	
	public void AIMove(int speed, Ball ball) {
		height = aiheight;
		
		if(pcolor == Color.red) {
			speed*=kFast;
		}
		
		if(ball.speedx > 0) {
			if (this.getCenterY() >= ball.getCenterY() && y>=0 ) {
//				System.out.println("Going Up");
				this.translate(0, -speed);
			}
			
			else if (this.getCenterY() < ball.getCenterY() && y<=PongRunner.getMaxWindowY()-this.height) {
				this.translate(0, speed);
//				System.out.println("Going Down");
			}
			
			
		}
		else if (y>=0 && y<=PongRunner.getMaxWindowY()-this.height){
//			System.out.print("randomizing");
			if(j%30 == 0) {
				randospeed = ((int)(Math.random()*speed) - speed/2)*2;
			}
			this.translate(0, randospeed);
			
			j++;
		}
		
	}
	
	
	
}
