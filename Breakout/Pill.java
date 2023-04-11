package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import utilities.GDV5;

public class Pill extends Rectangle{
	
	private static String[] powerupTypes = {"Multiball", "Fastpaddle", "Bigpaddle"};
	
	private Color col;
	
	private boolean status;
	
	private String type;
	
	private int ay = 1;
	private int vy = 0;
	private int vx = 0;
	
	public Pill(int x, int y, int width, int height, Color col) {
		super(x, y, width, height);
		this.col = col;
		this.type = powerupTypes[(int)((powerupTypes.length) * Math.random())];
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public String[] getPowerupTypes() {
		return powerupTypes;
	}
	
	public String getType() {
		return type;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	public void paddleBounce(Paddle paddle) {		
		int coldir = GDV5.collisionDirection(paddle, this, vx, vy);
//			Right = 0
//			Left = 2
//			Top = 1
//			Bottom = 3
		
		if(intersects(paddle)) {
			if(status)
				paddle.hit(this);
			
			status = false;
		}
	}
	
	
	
	
	
	
	
	
	
	public void move(int i) {
		translate(0, vy);
		if(i%5 == 0)
			vy+=ay;
	}
	
	
	public void draw(Graphics2D win) {
		win.setColor(col);
			
		win.fill(this);
	}
}
