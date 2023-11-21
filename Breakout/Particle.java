package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Particle extends Rectangle{
	
	static Particle[] particles;
	
	private int speedx, speedy;
	
	private Color col;
	private int alphaIncrement = 1;
	
	private int pyspeed = 2;
	private int pxspeed = pyspeed*(Brick.getInitWidth()/Brick.getInitHeight());
	
	private int xtravelled = 0;
	private int ytravelled = 0;
	
	private boolean alive = true;
	
	private static int w;
	private static int h;
	
	
	public Particle(int x, int y, int width, int height, Color col) {
		super(x, y, width, height);
		this.col = col;
	}
	
	public static void makeParticles(Brick b) {
		int partPerRow = 8;
		int rowPerArr = 5;
		
		int pwidth = (int)(b.getWidth()/partPerRow);
		w = pwidth;
		int pheight = (int)(b.getHeight()/rowPerArr);
		h = pheight;
		
		int offset = (int)(b.getWidth() - (w * partPerRow))/2;
//		int offset = 0;
		
		particles = new Particle[partPerRow*rowPerArr];
		
		int x = (int)(b.getX()) + offset;
		int y = (int)(b.getY());
		
		
		
		Color bcol = b.getCol();
		
		
		
		
		
		for(int i = 0; i < particles.length; i++ ) {
			particles[i] = new Particle(x, y, pwidth, pheight, bcol);
			
			x+=pwidth;
			
			if(x+pwidth > b.getX() + b.getWidth()) {
				x = (int)(b.getX()) + offset;
				y += pheight;
			}
		}
		
		
	}
	
	
	public void move(Brick[] bricks) {
		speedx = Math.random() < 0.5 ? pxspeed : -pxspeed;
		speedy = Math.random() < 0.5 ? pyspeed : -pyspeed;
		
		for(Brick b: bricks) {
			if(intersects(b) && b.getStatus() || xtravelled > 25 || ytravelled > 25) {
				this.alive = false;
			}
		}
		
		translate(speedx,speedy);
		xtravelled+=speedx;
		ytravelled+=speedy;
		
	}
	
	public static void moveParticles(Brick[] bricks) {
		for(Particle p: particles) {
			if(p.alive) {
				p.move(bricks);
				
			}
			else {
				
			}
		}
	}
	
	
	
	
	public void draw(Graphics2D win) {
		col = col.getAlpha() >=2 ? new Color(col.getRed(), col.getGreen(), col.getBlue(), col.getAlpha()-alphaIncrement) : col;
		
		if(col.getAlpha()<=2) alive = false;
			
		win.setColor(col);
		win.fill(this);
	}
	
	public static void drawParticles(Graphics2D win) {
		for(Particle p: particles) {
			if(p.alive)
				p.draw(win);
		}
	}
}
