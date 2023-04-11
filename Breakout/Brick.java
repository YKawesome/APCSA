package Breakout;

import utilities.GDV5;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick extends Rectangle {

	private Color col;
	
	private static Color[] springcolors = {Color.decode("#D3E5CF"), Color.decode("#D0E69E"),Color.decode("#E0F1BB"), Color.decode("#FEFFE2"), Color.decode("#FDE4DE"), Color.decode("#FFC2C3"), Color.decode("#FA92B1")};
	private static Color[] summercolors = {Color.decode("#FC8585"), Color.decode("#F7BFB8"),Color.decode("#FFC86D"), Color.decode("#FBDBA2"), Color.decode("#F6EADB"), Color.decode("#85CBD9"), Color.decode("#48BCD7")};
	private static Color[] fallcolors = {Color.decode("#6DAB55"), Color.decode("#585123"), Color.decode("#EEC170"), Color.decode("#F2A65A"), Color.decode("#F58549"), Color.decode("#772F1A"), Color.decode("#9E2A2B")};
	private static Color[] wintercolors = {Color.decode("#A66CFF"), Color.decode("#9C9EFE"), Color.decode("#AFB4FF"), Color.decode("#B1E1FF"), Color.decode("#7DE5ED"), Color.decode("#81C6E8"), Color.decode("#5DA7DB")};
	
	private static Color[][] colors = {springcolors, summercolors, fallcolors, wintercolors};
	
	private static int maxx = GDV5.getMaxWindowX();
	private static int maxy = GDV5.getMaxWindowY();
	
	private static int horizontalRectangles = Breakout.getHorizontalRectangles();
	private static int verticalRectangles = Breakout.getVerticalRectangles();
	private static int totalRectangles = Breakout.getTotalRectangles();
	
	private static int wPadding = 10;
	private static int hPadding = wPadding;
	
	private static int initHeight = 25;
	private static int initWidth = (maxx - (horizontalRectangles+1)*wPadding) / horizontalRectangles;
	
	private static int offset = (maxx - (initWidth * horizontalRectangles + wPadding * (horizontalRectangles - 1)))/2;
	
	private boolean alive = true;
	private static boolean particulates = false;
	
	private Pill pill;
	
//	private static SoundDriverHo s1;
	
//	private Particle[] particles = new Particle[40];
	
	
	public Brick(int x, int y, Color c) {
		super(x, y, initWidth, initHeight);
		col = c;
		
	}
	
//	public Brick(SoundDriverHo s1) {
//		Brick.s1 = s1;
//	}
	
	
	public static Brick[] makeBricks() {
		Brick[] bricks = new Brick[totalRectangles];
		
		Color col;
		int colArrayIndex = Breakout.getColArrayIndex();
				
		
		int x = offset;
		int y = x;
		int colinc = 0;
		
		int width = initWidth;
		int height = initHeight;
		
//		System.out.print(bricks.length);
		
		
		for (int i = 0; i < bricks.length; i++) {
			
//			bricks[i] = new Brick(x, y, Color.white);
			bricks[i] = new Brick(x, y, colors[colArrayIndex][colinc]);
			bricks[i].pill = new Pill(x + bricks[i].width - (5*(bricks[i].width) / 8), y, bricks[i].width / 4, bricks[i].height, bricks[i].col);
			
			x += width + wPadding;
			
			if(x + width >= maxx) {
				y += height + hPadding;
				x = offset;
				colinc++;
			}
			
		}
		
		return bricks;
	}
	
	public static Brick[] addBricks(Brick[] bricks) {
		Brick[] finBricks = new Brick[bricks.length + horizontalRectangles];
		
		Color col;
		int colArrayIndex = Breakout.getColArrayIndex();
				
		
		int x = offset;
		int y = x;
		int colinc = (colors[colArrayIndex].length - ((finBricks.length / horizontalRectangles) % colors[colArrayIndex].length)) % colors[colArrayIndex].length;
		
		int width = initWidth;
		int height = initHeight;
		
//		System.out.print(bricks.length);
		
		
		for (int i = 0; i < horizontalRectangles; i++) {
//			System.out.println(colinc);
 			finBricks[i] = new Brick(x, y, colors[colArrayIndex][colinc]);
 			finBricks[i].pill = new Pill(x + bricks[i].width - (5*(bricks[i].width) / 8), y, bricks[i].width / 4, bricks[i].height, bricks[i].col);
 						
			x += width + wPadding;
			
		}
		
		
		
		int indexer = horizontalRectangles;
		
		for(Brick b:bricks) {
			b.translate(0, initHeight + hPadding);
			b.pill.translate(0, initHeight + hPadding);
			finBricks[indexer] = b;
			
			
			indexer++;
		}
		
		
		return finBricks;
	}
	
	
	
	
	
	public void hit() {
		Particle.makeParticles(this);
		
		alive = false;
		particulates = true;
		
		boolean multicheck = pill.getType().equals("Multiball") && Breakout.getMultiballActive();
		boolean fastpaddlecheck = pill.getType().equals("Fastpaddle") && Breakout.getFastpaddleActive();
		boolean bigpaddlecheck = pill.getType().equals("Bigpaddle") && Breakout.getBigpaddleActive();
		
		if(!(multicheck || fastpaddlecheck || bigpaddlecheck))
			pill.setStatus(Math.random() > 0);
		
		Breakout.setPadHit(true);
		
		Breakout.incScore();
		
	}
	
	
	
	public Color getCol() {
		return col;
	}
	
	public static int getColorArrayLength() {
		return colors.length;
	}
	
	public boolean getStatus() {
		return alive;
	}
	
	public static boolean getParticleStatus() {
		return particulates;
	}
	
	public static int getInitHeight() {
		return initHeight;
	}
	
	public static int getInitWidth() {
		return initWidth;
	}
	
	public Pill getPill() {
		return pill;
	}
	
	public static Color[][] getColArray() {
		return colors;
	}
	
	
	public void draw(Graphics2D win) {
		win.setColor(col);
			
		win.fill(this);
	}
	
	public static void drawBricks(Graphics2D win, Brick[] bricks) {
		for (Brick b:bricks) {
			if(b.alive) {
				b.draw(win);
			}
			
			if(b.pill.getStatus()) {
				b.pill.draw(win);
			}
			
		}
		if(particulates) {
			Particle.drawParticles(win);
		}
	}
}
