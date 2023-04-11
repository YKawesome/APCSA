package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Body extends Rectangle{
	private static int size = Tile.getTileSize();
	
	private Color col = Color.blue;
	
	private Particle[] particles; 
	
	private int direction = 0;
	
	private boolean status = true;
	/*
	 * Directions
	 * 0: Right
	 * 1: Up
	 * 2: Left
	 * 3: Down
	 */
	
	public Body(int x, int y, Color col) {
		super(x, y, size, size);
		
		this.col = col;
	}
	
	public Body(int x, int y, Color col, int dir) {
		super(x, y, size, size);
		
		this.col = col;
		this.direction = dir;
	}
	
	public Color getCol() {
		return col;
	}
	public int getDir() {
		return direction;
	}
	public boolean getStatus() {
		return status;
	}
	
	public void setDir(int dir) {
		direction = dir;
	}
	public void setCol(Color col) {
		this.col = col;
	}
	public void setParticleArray(Particle[] particles) {
		this.particles = particles;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void move() {
		if(direction==0) {
			translate(Tile.getTileSize(), 0);
		}
		else if(direction==1) {
			translate(0, -Tile.getTileSize());
		}
		else if(direction==2) {
			translate(-Tile.getTileSize(), 0);
		}
		else if(direction==3) {
			translate(0, Tile.getTileSize());
		}
		
	}
	
	public void moveParticles() {
		if(particles == null) particles = Particle.makeParticles(this);
		for(Particle p: particles) {
			p.move();
		}
	}
	
	
	
	public void draw(Graphics2D win, Color col) {
		if(status) {
			win.setColor(col);
			win.draw(this);
			win.fill(this);
		}
		else {
			for(Particle p: particles) {
				win.setColor(p.getCol());
				if(p.getStatus()) {
					p.draw(win);
				}
			}
		}
		
		
	}
}
