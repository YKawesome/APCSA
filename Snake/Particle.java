package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Particle extends Rectangle{
	private static int particlesSide = 10;
	
	private Color col;
	private int alphaIncrementer = 3;
	
	private int speedx;
	private int speedy;
	
	private int pspeed = 2;
	
	private int xtravelled = 0;
	private int ytravelled = 0;
	
	private boolean status;
	
	
//	private int i = 0;
	
	public Particle(int x, int y, int size, Color col) {
		super(x, y, size, size);
		
		this.col = col;
		
		status = true;
	}
	
	public Color getCol() {
		return col;
	}
	public boolean getStatus() {
		return status;
	}
	
	public static Particle[] makeParticles(Body b) {
		Particle[] particles = new Particle[particlesSide*particlesSide];
		int offX = 0;
		int offY = 0;
		
		for(int i = 0; i < particles.length; i++) {
			if(i%particlesSide == 0 && i!=0) {
				offY+=(int)(b.getHeight()/particlesSide);
				offX = 0;
			}
			particles[i] = new Particle((int)b.getX()+offX, (int)b.getY()+offY, (int)(b.getHeight()/particlesSide), b.getCol());
			
			offX+=(int)(b.getHeight()/particlesSide);
			
			
			

		}
		
		return particles;
		
	}
	public static Particle[] makeParticles(Tile b) {
		Particle[] particles = new Particle[particlesSide*particlesSide];
		int offX = 0;
		int offY = 0;
		
		for(int i = 0; i < particles.length; i++) {
			if(i%particlesSide == 0 && i!=0) {
				offY+=(int)(b.getHeight()/particlesSide);
				offX = 0;
			}
			particles[i] = new Particle((int)b.getX()+offX, (int)b.getY()+offY, (int)(b.getHeight()/particlesSide), b.getCol());
			
			offX+=(int)(b.getHeight()/particlesSide);
			
			
			

		}
		
		return particles;
		
	}
	
	public void move() {
		col = col.getAlpha() >=4 ? new Color(col.getRed(), col.getGreen(), col.getBlue(), col.getAlpha()-alphaIncrementer) : col;
		
		if(col.getAlpha()<=4) status = false;
		
		speedx = Math.random() < 0.5 ? pspeed : -pspeed;
		speedy = Math.random() < 0.5 ? pspeed : -pspeed;
		
		if(xtravelled > 25 || ytravelled > 25 || y < 3*SnakeRunner.getBorder() || y > 3*SnakeRunner.getBorder() + Tile.getTileSize()*Tile.getTilesSide() || x < SnakeRunner.getBorder() || x > SnakeRunner.getBorder() + Tile.getTileSize()*Tile.getTilesSide()) {
			status = false;
		}
		
		translate(speedx,speedy);
		
		xtravelled+=speedx;
		ytravelled+=speedy;
		
	}
	
	public void fade() {
		col = col.getAlpha() >=4 ? new Color(col.getRed(), col.getGreen(), col.getBlue(), col.getAlpha()-alphaIncrementer) : col;
		
		if(col.getAlpha()<=4) status = false;
		
		speedx = Math.random() < 0.5 ? pspeed : -pspeed;
		speedy = Math.random() < 0.5 ? pspeed : -pspeed;
		
		if(xtravelled > 25 || ytravelled > 25 || y < 3*SnakeRunner.getBorder() || y > 3*SnakeRunner.getBorder() + Tile.getTileSize()*Tile.getTilesSide() || x < SnakeRunner.getBorder() || x > SnakeRunner.getBorder() + Tile.getTileSize()*Tile.getTilesSide()) {
			status = false;
		}
		
//		translate(speedx,speedy);
		
//		xtravelled+=speedx;
//		ytravelled+=speedy;
		
	}
	
	public void draw(Graphics2D win) {
		win.setColor(col);
		win.draw(this);
		win.fill(this);
	}
	
}
