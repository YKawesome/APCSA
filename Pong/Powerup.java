package Pong;

import java.awt.Color;
import java.awt.Rectangle;

public class Powerup extends Rectangle{
	static int maxx = PongRunner.getMaxWindowX();
	static int maxy = PongRunner.getMaxWindowY();
	
	String powerupname;
	private boolean isShowing = false;
	int ilocation;
	
	public Powerup(int xloc, int yloc, String powerupname) {
		super(xloc, yloc, 25, 25);
		this.powerupname = powerupname;
		
	}
	
	public boolean getShowing() {
		return isShowing;
	}
	
	public void setShowing(boolean to) {
		isShowing = to;
	}
	
	public static int[] locgenerator(Paddle lPaddle, Paddle rPaddle) {
		int iloc = (int)(4*Math.random()) + 1;
		int xloc = 0, yloc = 0;
//		System.out.println(iloc);
		
		if(rPaddle.pcolor == Color.red && lPaddle.pcolor == Color.red) {
			int[] loc = {-100, -100, -1};
			return loc;
		}
		
		if((iloc == 1 || iloc == 4) && rPaddle.pcolor == Color.red) {
			return locgenerator(lPaddle, rPaddle);
		}
		
		if((iloc == 2 || iloc == 3) && lPaddle.pcolor == Color.red) {
			return locgenerator(lPaddle, rPaddle);
		}
		
		
		
		if(iloc == 1) {
			xloc = maxx-25;
			yloc = 0;
		}
		
		else if(iloc == 2) {
			xloc = 0;
			yloc = 0;
		}
		
		else if(iloc == 3) {
			xloc = 0;
			yloc = maxy - 25;
		}
		
		else if(iloc == 4) {
			xloc = maxx - 25;
			yloc = maxy - 25;
		}
		
		int[] loc = {xloc, yloc, iloc};
		
		return loc;
	}
	
	public String[] powerPaddle(Paddle lPaddle, Paddle rPaddle) {
		String status;
		String paddle = "";
		
		if(ilocation == 0) {
			String[] ppad = {"", "false"};
			return ppad;
		}
		
		else if(ilocation == 3) {
			paddle = "left";
			if (lPaddle.y+lPaddle.height >= y) {
				status = "true";
				isShowing = false;
			}
			else {
				status = "false";
			}
		}
		
		else if(ilocation == 2) {
			paddle = "left";
			if (lPaddle.y <= y + height) {
				status = "true";
				isShowing = false;
			}
			else {
				status = "false";
			}
		}
		
		else if(ilocation == 4) {
			paddle = "right";
			if (rPaddle.y+rPaddle.height >= y) {
				status = "true";
				isShowing = false;
			}
			else {
				status = "false";
			}
		}
		
		else if(ilocation == 1) {
			paddle = "right";
			if (rPaddle.y <= y + height) {
				status = "true";
				isShowing = false;
			}
			else {
				status = "false";
			}
		}
		
		else {
			status = "false";
		}
		
		String[] ppad = {paddle, status};
		return ppad;
		
		
	}
	
}
