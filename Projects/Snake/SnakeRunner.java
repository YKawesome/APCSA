package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import utilities.GDV5;

public class SnakeRunner extends GDV5 {
	
	private static int gamestate = 0;
	private static boolean gameover = false;
	private static int border = 25;
	
	private static int initBody = 5;
	
	private Snake snake = new Snake(initBody, border + Tile.getTileSize(), 3*border + Tile.getTileSize()*(Tile.getTilesSide()-1)/2, Color.decode("#4775EB"));
	
	private static Consumable consumable = new Consumable(border + (Tile.getTilesSide()-2)*Tile.getTileSize(), 3*border + Tile.getTileSize()*(Tile.getTilesSide()-1)/2, Tile.getTileSize(), "Apple");
	
	private int i = 0;
	
	private static int tickSpeed = 10;
	
	private static int score = 0;
	
	String[] filenames = {"gdays.wav", "nomnom.wav", "poptart.wav", "mmmorange.wav", "ohno.wav"};
	
	SoundDriverHo s1 = new SoundDriverHo(filenames, this);
	
	private Image image = new Image();
	
	//Settings
	private static boolean ouroboros = false;
	private static boolean aiControl = false;
	private static boolean autonomousFood = false;
	
	
	
	
	//Constructor
	public SnakeRunner() {
		super();
		
		s1.loop(0);
	}
	
	
	
	
	
	
	//Getters
	public static int getBorder() {
		return border;
	}
	public int getNewDir() {
		return newDir;
	}
	public static Consumable getConsumable() {
		return consumable;
	}
	public static int getScore() {
		return score;
	}
	public static boolean getOuroboros() {
		return ouroboros;
	}
	public static boolean getAIControl() {
		return aiControl;
	}
	public static boolean getAutomomousFood() {
		return autonomousFood;
	}
	//Setters
	public static void setConsumable(Consumable c) {
		consumable = c;
	}
	
	public static void increaseScore(int j) {
		for(int k = 0; k < j; k++) {
			score++;
			if(score%5==0 && tickSpeed>=1.1) tickSpeed=(int)(tickSpeed-1);
		}
	}
	
	//Cooldowns
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeRunner myRunner = new SnakeRunner();
//		s1.loop(0);
		myRunner.start();
		
		Tile.makeTiles();
		
		
		
//		Color[] cols = ColorGen.generatePair("#AAD750");
//		
//		for(Color c: cols) {
//			System.out.println(c);
//		}
	}

	//Abstractions	
	private int newDir = 0;
	private boolean directionChosen = false;
	
	public void tick() {
		
		if(!directionChosen) {
			
			directionChosen = true;
			
			if(!aiControl) {
				if((GDV5.KeysPressed[KeyEvent.VK_RIGHT] || GDV5.KeysPressed[KeyEvent.VK_D]) && newDir != 2) newDir = 0;
				else if((GDV5.KeysPressed[KeyEvent.VK_UP] || GDV5.KeysPressed[KeyEvent.VK_W]) && newDir != 3) newDir = 1;
				else if((GDV5.KeysPressed[KeyEvent.VK_LEFT] || GDV5.KeysPressed[KeyEvent.VK_A]) && newDir != 0) newDir = 2;
				else if((GDV5.KeysPressed[KeyEvent.VK_DOWN] || GDV5.KeysPressed[KeyEvent.VK_S]) && newDir != 1) newDir = 3;
				else directionChosen = false;
			}
			else {
				if(consumable.getCenterX() > snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterX() && newDir != 2) newDir = 0;
				else if(consumable.getCenterY() < snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterY() && newDir != 3) newDir = 1;
				else if(consumable.getCenterX() < snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterX() && newDir != 0) newDir = 2;
				else if(consumable.getCenterY() > snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterY() && newDir != 1) newDir = 3;
				//If moving opposite direction and same row/column
				else if(newDir==0 && consumable.getCenterX() < snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterX()) newDir = Tile.getTiles()[0].getCenterY() == consumable.getCenterY() ? 3 : 1;
				else if(newDir==1 && consumable.getCenterY() > snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterY()) newDir = Tile.getTiles()[0].getCenterX() == consumable.getCenterX() ? 0 : 2;
				else if(newDir==2 && consumable.getCenterX() > snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterX()) newDir = Tile.getTiles()[0].getCenterY() == consumable.getCenterY() ? 3 : 1;
				else if(newDir==3 && consumable.getCenterY() < snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterY()) newDir = Tile.getTiles()[0].getCenterX() == consumable.getCenterX() ? 0 : 2;
				
				
				else directionChosen = false;
//				System.out.println(newDir);
			}
			
		}
		
		if(i%tickSpeed == 0) {
						
			ArrayList<Body> bodyArr = snake.getBodyArr();
			ArrayList<Integer> indices = new ArrayList<Integer>();
			if(newDir == 0) {
				bodyArr.get(bodyArr.size()-1).setDir(0);
			}
			else if(newDir == 1) {
				bodyArr.get(bodyArr.size()-1).setDir(1);
			}
			else if(newDir == 2) {
				bodyArr.get(bodyArr.size()-1).setDir(2);
			}
			else if(newDir == 3) {
				bodyArr.get(bodyArr.size()-1).setDir(3);
			}
			
			
			checkWall();
			if(ouroboros) ouroboros();
			
			if(snake.getStatus()) {
				snake.move();
			}
			
//			ArrayList<Integer> indices = new ArrayList<Integer>();
			for(int i = bodyArr.size() - 2; i >= 0; i--) {
				if(bodyArr.get(i).getDir() != bodyArr.get(i+1).getDir()) {
					
//					System.out.println(i);
//					break;
//					i--;
					indices.add(0,i);
				}
			}
			
			for(int i: indices) {
				bodyArr.get(i).setDir(bodyArr.get(i+1).getDir());
			}
			
//			System.out.println(indices);
			directionChosen = false;
			
			
		}
	}

	private boolean headColored;
	private boolean deathSoundPlayed = false;
	private int z = 0;
	public void deathTick() {
		if(i%(tickSpeed) == 0 && !snake.getStatus()) {
			if(headColored) {
				for(int j = 0; j < snake.getBodyArr().size()-1; j++) {
					if(!snake.getBodyArr().get(j).getCol().equals(snake.getBodyArr().get(j+1).getCol())) {
						snake.getBodyArr().get(j).setCol(snake.getBodyArr().get(j+1).getCol());
					}
				}
				
				
				
				int k = 0;
				for(Body b: snake.getBodyArr()) {
					if(b.getCol().equals(Color.decode("#E7471C"))) {
						k++;
					}
				}
				
				if(k == snake.getBodyArr().size()) {
					for(Body b: snake.getBodyArr()) {
						b.setStatus(false);
//						b.moveParticles();
						consumable.setStatus(false);
						if(!deathSoundPlayed) {
							gameover = true;
							s1.play(4);
							deathSoundPlayed = true;
						}
					}
					
					
					if(i-z > 80) {
						for(Tile t: Tile.getTiles()) {
							t.setStatus(false);
						}
					}
					
					if(i-z > 100) {
						Tile.getBorderRectangle().setStatus(false);
						Tile.getTopRectangle().setStatus(false);
					}
					
					if(z==0) {
						z=i;
					}
				}
				
				
				
				
			}
			else {
				snake.getBodyArr().get(snake.getBodyArr().size()-1).setCol(Color.decode("#E7471C"));
				headColored = true;
			}
			
		}
	}
	
	public void checkWall() {
		boolean rightStatus = snake.getBodyArr().get(snake.getBodyArr().size()-1).getDir() == 0 && (int)snake.getBodyArr().get(snake.getBodyArr().size()-1).getX() == border + (Tile.getTilesSide()-1)*Tile.getTileSize();
		boolean upStatus = snake.getBodyArr().get(snake.getBodyArr().size()-1).getDir() == 1 && (int)snake.getBodyArr().get(snake.getBodyArr().size()-1).getY() == 3*border;
		boolean leftStatus = snake.getBodyArr().get(snake.getBodyArr().size()-1).getDir() == 2 && (int)snake.getBodyArr().get(snake.getBodyArr().size()-1).getX() == border;
		boolean downStatus = snake.getBodyArr().get(snake.getBodyArr().size()-1).getDir() == 3 && (int)snake.getBodyArr().get(snake.getBodyArr().size()-1).getY() == 3*border + (Tile.getTilesSide()-1)*Tile.getTileSize();
		if(rightStatus || leftStatus || upStatus || downStatus) snake.setStatus(false);
	}
	
	public void ouroboros() {
		boolean xCheck;
		boolean yCheck;
		boolean sameCheck;
		
		for(Body b: snake.getBodyArr()) {
			xCheck = (int)b.getCenterX() == (int)snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterX();
			yCheck = (int)b.getCenterY() == (int)snake.getBodyArr().get(snake.getBodyArr().size()-1).getCenterY();
			sameCheck = b!=snake.getBodyArr().get(snake.getBodyArr().size()-1);
			
			if(xCheck && yCheck && sameCheck) snake.setStatus(false);
//			System.out.printlna("" + xCheck + yCheck);
		}
	}
	
	public void moveParticles() {
		for(Body b: snake.getBodyArr()) {
			if(!b.getStatus()) b.moveParticles();
		}
		
		for(Tile t: Tile.getTiles()) {
			if(!t.getStatus()) t.moveParticles();
		}
	}
	
	public void fade() {
		if(!Tile.getBorderRectangle().getStatus()) Tile.getBorderRectangle().fade();
		if(!Tile.getTopRectangle().getStatus()) Tile.getTopRectangle().fade();
	}
	
	public void eatCheck() {
		int j = consumable.getType().equals("Apple") ? 2 : consumable.getType().equals("Orange") ? 3 : 1;
		if(snake.eat(consumable)) s1.play(j);
	}
	
	public void moveConsumable() {
		if(i!=0 && i%(tickSpeed*5)==0 && autonomousFood) consumable.move();
	}
	public void increment() {
		i++;
	}
	
	public void reset() {
		snake = new Snake(initBody, border + Tile.getTileSize(), 3*border + Tile.getTileSize()*(Tile.getTilesSide()-1)/2, Color.decode("#4775EB"));
		
		consumable = new Consumable(border + (Tile.getTilesSide()-2)*Tile.getTileSize(), 3*border + Tile.getTileSize()*(Tile.getTilesSide()-1)/2, Tile.getTileSize(), "Apple");
		
		i = 0;
		
		tickSpeed = 10;
		
		Tile.makeTiles();
		
		headColored = false;
		deathSoundPlayed = false;
		z = 0;
		
		score = 0;
	}
	
	//Gamestates
	public void gameStateSwitcher() {
		if(gamestate==0 && GDV5.KeysPressed[KeyEvent.VK_SPACE]) gamestate = 1;
		if(gamestate==1 && GDV5.KeysPressed[KeyEvent.VK_P]) gamestate = 2;
	}
	
	public void gameStateOne() {
		if(gamestate==1) {
			if(GDV5.KeysPressed[KeyEvent.VK_O]) ouroboros = !ouroboros;
			if(GDV5.KeysPressed[KeyEvent.VK_I]) aiControl = !aiControl;
			if(GDV5.KeysPressed[KeyEvent.VK_F]) autonomousFood = !autonomousFood;
		}
	}
	
	public void gameStateTwo() {
		if(gamestate==2) {
			eatCheck();
			tick();
			deathTick();
			moveConsumable();
			moveParticles();
			fade();
			increment();
			
			if(gameover && GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				gameover = false;
				gamestate=0;
				reset();
			}
		}
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		gameStateSwitcher();
		gameStateOne();
		gameStateTwo();
		
	}

	
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
//		win.setColor(Color.white);
		if(gamestate==0) {
			win.drawImage(image.title, null, 0, 0);
		}
		
		if(gamestate==1) {
			win.drawImage(image.controls, null, 0, 0);
			Splash.drawControls(win);
		}
		
		if(gamestate==2) {
			Splash.drawGameOver(win);
			
			Tile.drawAll(win);
			snake.draw(win);
			
			if(consumable!=null) consumable.draw(win);
			
			Splash.drawScore(win);
		}
		
		
	}
	
}
