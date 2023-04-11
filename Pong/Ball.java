package Pong;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Ball extends Rectangle {
	int maxx = PongRunner.getMaxWindowX();
	int maxy = PongRunner.getMaxWindowY();
	
	int speed = 5;
	int speedx = speed;
	int speedy = speed;
	int m = 1;
	double smashc = 6.01;
	double kFast = 1.5;
	Color bcolor = Color.WHITE;
	
	int savespeedy = 0;
	int savespeedx = 0;
	
	boolean smashed = false;
	
	boolean pause = false;
	int i = 0;
	
	
	public Ball(int size) {
		super(800, 450, size, size);
	}
	
	public void resetBall() {
		
			y = 450;
			x = 800;
			speedx = 0;
			speedy = 0;
			pause = true; 
			i = 0;
			bcolor = Color.white;
			
		
	}
	
	public void wallBounce() {
		if(x >= maxx - width) {
			resetBall();
			PongRunner.lscore += 1;
			Draw.lpoint = true;
//			System.out.println(Draw.lpoint);
		}
		
		if(x<=0) {
			resetBall();
			PongRunner.rscore += 1;
			Draw.rpoint = true;
			
		}
		
		
		if(y >= maxy - height || y<=0) {
			speedy = -speedy;
		}
	}
	
	
	
	public void paddleBounce(Paddle lPaddle, Paddle rPaddle) {
		
		
		
		boolean lendx =  x < lPaddle.x + lPaddle.width - lPaddle.width/2 && (y < rPaddle.y + rPaddle.height - 2 && y > rPaddle.y + 2);
		boolean rendx =  x >= rPaddle.x - width + rPaddle.width/2 && (y < rPaddle.y + rPaddle.height - 2 && y > rPaddle.y + 2);
		
		
		//Reset if ball goes inside paddle
		if(lendx || rendx) {
			resetBall();
		}
//		
		
		boolean lcheckx = x <= lPaddle.x + lPaddle.width && (y <= lPaddle.y + lPaddle.height && y >= lPaddle.y);
		boolean rcheckx = x >= rPaddle.x - width && (y <= rPaddle.y + rPaddle.height && y >= rPaddle.y);
		
		//Bounce off Paddle from left/right
		if(lcheckx || rcheckx) {
			PongRunner.padhit = true;
			speedx = -speedx;
			
			if(smashed == true) {
//				speedy/=(smashc/5);
				smashed = false;
			}
		}
		
		
		
		boolean lchecky = (GDV5.collisionDirection(lPaddle, this, speedx, speedy) == 1 || GDV5.collisionDirection(lPaddle, this, speedx, speedy) == 3) && this.intersects(lPaddle);
		boolean rchecky = (GDV5.collisionDirection(rPaddle, this, speedx, speedy) == 1 || GDV5.collisionDirection(rPaddle, this, speedx, speedy) == 3) && this.intersects(rPaddle);
		
		boolean lkeyup = GDV5.KeysPressed[KeyEvent.VK_W];
		boolean lkeydown = GDV5.KeysPressed[KeyEvent.VK_S];
		boolean rkeyup = GDV5.KeysPressed[KeyEvent.VK_UP];
		boolean rkeydown = GDV5.KeysPressed[KeyEvent.VK_DOWN];
		


		
		
//		Powerups
		if((lcheckx || lchecky) && lPaddle.pcolor == Color.red) {
			speedx = (int)(kFast*speedx);
			speedy = (int)(kFast*speedy);
			bcolor = Color.red;
		}
		
		if((rcheckx || rchecky) && rPaddle.pcolor == Color.red) {
			speedx = (int)(kFast*speedx);
			speedy = (int)(kFast*speedy);
			bcolor = Color.red;
		}
		
		if((lcheckx || lchecky) && lPaddle.pcolor == Color.white) {
			bcolor = Color.white;
			
			if(speedx<0) {
				speedx = -speed;
			}
			else {
				speedx = speed;
			}
			
			if(speedy<0) {
				speedy = -speed;
			}
			else {
				speedy = speed;
			}
		}
		
		if((rcheckx || rchecky) && rPaddle.pcolor == Color.white) {
			bcolor = Color.white;
			if(speedx<0) {
				speedx = -speed;
			}
			else {
				speedx = speed;
			}
			
			if(speedy<0) {
				speedy = -speed;
			}
			else {
				speedy = speed;
			}
		}
		
//		Smash Ball
		if((lkeyup || rkeyup) && (lcheckx || rcheckx)) {
			if(speedy>0) speedy*=-1;
			
			speedy*=(smashc/5);
			speedx*=(smashc/5);
			smashed = true;
//			System.out.println("smashed");
		}
		
//		Smash Ball
		else if((lkeydown || rkeydown) && (lcheckx || rcheckx)) {
			if(speedy<0) speedy*=-1;
			
			speedy*=(smashc/5);
			speedx*=(smashc/5);
			smashed = true;
//			System.out.println("smashed");
		}
		
		
//		Bounce off Paddle from top/bottom
		else if(lchecky || rchecky) {
			speedy = -speedy;
		}
				
	}
	
	
	//Parameterize a y=mx line
	public void equationMove(int speedx, int speedy, int rise, int run) {
		translate(run*speedx, rise*speedy);
	}
	
	
	public void move(Paddle lPaddle, Paddle rPaddle) {
		//Move with current speed in y=mx format
		equationMove(speedx, speedy, 1, 1);
		
		//Reset Ball Supplements
		if(pause) {
			i++;
			if(i>=60) {
				pause = false;
				speedx = speed;
				speedy = speed;
			}
		}
		
		wallBounce();
		paddleBounce(lPaddle, rPaddle);
		
	}
	
	
}
