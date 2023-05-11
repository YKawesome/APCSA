package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Consumable extends Rectangle{
	private static String[] types = {"Apple", "Orange", "Lemon"};
	private static Color[] colors = {Color.decode("#E7471C"), Color.decode("#FF6600"), Color.decode("#E5DE00")};
	private String type;
	private Color col;
	
	private boolean status = true;
	
	
	public Consumable(int x, int y, int size, String type) {
		super(x, y, size, size);
		
		int i = 0;
		//Initialize consumable type
		boolean temp = false;
		for(String s: types) {
			temp = s.equals(type);
			if(temp) break;
			i++;
		}
		this.type = temp ? type : "Apple";
		this.col = colors[i];
		
		
	}
	
	public String getType() {
		return type;
	}
	public static String[] getTypes() {
		return types;
	}
	public static Color[] getColors() {
		return colors;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Consumable eaten(Snake snake) {
		
		Consumable con;
		boolean accept = true;
		while(true) {
			con = new Consumable(SnakeRunner.getBorder() + (int)(Tile.getTilesSide()*Math.random())*Tile.getTileSize(), 3*SnakeRunner.getBorder() + (int)(Tile.getTilesSide()*Math.random())*Tile.getTileSize(), Tile.getTileSize(), types[(int)(types.length*Math.random())]);
			for(Body b: snake.getBodyArr()) {
				if((int)b.getCenterX() == (int)con.getCenterX() && (int)b.getCenterY() == (int)con.getCenterY()) accept = false;
			}
			
			
			if(accept) break;
			accept = true;
		}
		
		return con;
	}
	
	public void move() {
		int direction = (int)(Math.random()*4);
		if(direction==0 && !(Tile.getTiles()[Tile.getTiles().length-1].getX()==x)) {
			translate(Tile.getTileSize(), 0);
		}
		else if(direction==1 && !(Tile.getTiles()[0].getY()==y)) {
			translate(0, -Tile.getTileSize());
		}
		else if(direction==2 && !(Tile.getTiles()[0].getX()==x)) {
			translate(-Tile.getTileSize(), 0);
		}
		else if(direction==3 && !(Tile.getTiles()[Tile.getTiles().length-1].getY()==y)) {
			translate(0, Tile.getTileSize());
		}
	}
	
	public void draw(Graphics2D win) {
		if(status) {
			win.setColor(col);
			win.draw(this);
			win.fill(this);
		}
	}
	
	
	
}
