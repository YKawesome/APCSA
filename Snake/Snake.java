package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

//import com.sun.tools.javac.util.ArrayUtils;

public class Snake {
	private ArrayList<Body> bodyArr = new ArrayList<Body>();
	int x;
	int y;
	Color col;
	
	boolean status;
	
	public Snake(int startBody, int x, int y, Color col) {
		this.x = x;
		this.y = y;
		this.col = col;
		
		for(int i = 0; i < startBody; i++) {
//			Color tempCol = i == startBody-1 ? Color.white : col;
//			Color tempCol = col;
//			System.out.println(tempCol);
			bodyArr.add(new Body(x + i*Tile.getTileSize(), y, col));
		}
		
		status = true;
	}
	
	public ArrayList<Body> getBodyArr() {
		return bodyArr;
	}
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public void move() {
		for(Body b: bodyArr) {
			b.move();
		}
		
	}
	
	public boolean eat(Consumable c) {
		if((int)bodyArr.get(bodyArr.size()-1).getCenterX() == (int)c.getCenterX() && (int)bodyArr.get(bodyArr.size()-1).getCenterY() == (int)c.getCenterY()) {
//			System.out.print(status);
			
			
			
			int index = Arrays.asList(Consumable.getTypes()).indexOf(SnakeRunner.getConsumable().getType()) + 1;
//			System.out.println(index);
			//			if(SnakeRunner.getConsumable().getType().equals("Apple")) {
//				i = 1;
//			}
//			else if(SnakeRunner.getConsumable().getType().equals("Apple"))
//			
			for(int i = 0; i < index; i++) {
				Body tail = bodyArr.get(0);
				if(tail.getDir() == 0) bodyArr.add(0, new Body((int)tail.getX() - Tile.getTileSize(), (int)tail.getY(), Consumable.getColors()[index-1], 0));
				else if(tail.getDir() == 1) bodyArr.add(0, new Body((int)tail.getX(), (int)tail.getY() + Tile.getTileSize(), Consumable.getColors()[index-1], 1));
				else if(tail.getDir() == 2) bodyArr.add(0, new Body((int)tail.getX() + Tile.getTileSize(), (int)tail.getY(), Consumable.getColors()[index-1], 2));
				else if(tail.getDir() == 3) bodyArr.add(0, new Body((int)tail.getX(), (int)tail.getY() - Tile.getTileSize(), Consumable.getColors()[index-1], 3));
			}
			
			SnakeRunner.setConsumable(c.eaten(this));
			SnakeRunner.increaseScore(index);
			
			return true;
		}
		return false;
	}
	
	
	
	public void draw(Graphics2D win) {
		for(Body b: bodyArr) {
			b.draw(win, b.getCol());
		}
	}
}
