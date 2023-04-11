package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import utilities.GDV5;

public class Tile extends Rectangle{
	//og {Color.decode("#AAD750"), Color.decode("#A2D148"), Color.decode("#588934"), Color.decode("#4A752C")};
	
//	private static Color[] colArr = {ColorGen.generatePair(currCol)[0], ColorGen.generatePair(currCol)[1], Color.decode("#588934"), Color.decode("#4A752C")};
	//og AAD750
	
	private static String currCol = "#aad750";
	private static Color[] colArr = ColorGen.generateColors(currCol);
	
	private static Tile topRectangle = new Tile(0, 0, GDV5.getMaxWindowX(), 2*SnakeRunner.getBorder(), colArr[3]);
	private static Tile borderRectangle = new Tile(0, topRectangle.height, GDV5.getMaxWindowX(), colArr[2]);
	
	private static int tilesSide = 25;
	private static int tileSize = (GDV5.getMaxWindowX()-2*SnakeRunner.getBorder()) / tilesSide;

	private static Tile[] tileArr = new Tile[tilesSide * tilesSide];
	
	Color col = Color.white;
	private int alphaIncrementer = 4;
	
	private boolean status = true;
	
	private Particle[] particles;
	
	
	
	public Tile(int x, int y, int size, Color col) {
		super(x, y, size, size);
		this.col = col;
	}
	
	public Tile(int x, int y, int xsize, int ysize, Color col) {
		super(x, y, xsize, ysize);
		this.col = col;
	}
	
	public static int getTileSize() {
		return tileSize;
	}
	public static int getTilesSide() {
		return tilesSide;
	}
	public Color getCol() {
		return col;
	}
	public static Tile[] getTiles() {
		return tileArr;
	}
	public boolean getStatus() {
		return status;
	}
	public static Tile getTopRectangle() {
		return topRectangle;
	}
	public static Tile getBorderRectangle() {
		return borderRectangle;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public static void makeTiles() {
		int x = SnakeRunner.getBorder();
		int y = topRectangle.height + SnakeRunner.getBorder();
		
		topRectangle = new Tile(0, 0, GDV5.getMaxWindowX(), 2*SnakeRunner.getBorder(), colArr[3]);
		borderRectangle = new Tile(0, topRectangle.height, GDV5.getMaxWindowX(), colArr[2]);
		
		for(int i = 0; i < tileArr.length; i++) {
			
			if(i!=0 && i%tilesSide == 0) {
				x = SnakeRunner.getBorder();
				y += tileSize;
			}
			
			tileArr[i] = new Tile(x, y, tileSize, colArr[i%2]); 
			x+=tileSize;
			
			
		}
	}
	
	public void moveParticles() {
		if(particles == null) particles = Particle.makeParticles(this);
		for(Particle p: particles) {
			p.move();
		}
	}
	
	public void fade() {
		col = col.getAlpha() >=4 ? new Color(col.getRed(), col.getGreen(), col.getBlue(), col.getAlpha()-alphaIncrementer) : Color.black;
		
	}
	
	public void draw(Graphics2D win, Color col) {
		win.setColor(col);
		win.draw(this);
		win.fill(this);
	}
	
	public static void drawAll(Graphics2D win) {
//		System.out.println(tileSize);
		borderRectangle.draw(win, borderRectangle.col);
		topRectangle.draw(win, topRectangle.col);
		
		for(Tile t: tileArr) {
			
			if(t.status) {
				t.draw(win, t.col);
			}
			else {
				for(Particle p: t.particles) {
					win.setColor(p.getCol());
					if(p.getStatus()) {
						p.draw(win);
					}
				}
			}
		
		
		}
		
		
		
	}
	
}
