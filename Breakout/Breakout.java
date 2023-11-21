package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Breakout.SoundDriverHo;
import utilities.GDV5;

public class Breakout extends GDV5 {
	

	private static Brick[] bricks;
	private static Paddle paddle;
	private static Ball ball;
	private static Ball[] multiball;
	
	private static int gamestate = 0;
	
	
	private static String test = "hello";
	
	private static int colArrayIndex = 0;
	private static String[] colorStrings = {"Spring", "Summer", "Fall", "Winter"};
	
	private static int horizontalRectangles = 9;
	private static int verticalRectangles = 7;
	private static int totalRectangles = horizontalRectangles * verticalRectangles;
	
	private static boolean ai = false;
	
	private static int gSpeed = 10;
	
	private int addLevelTime = 0;
	
	private int i = 0;
	private int paletteElapsed = 0;
	private int aiElapsed = 0;
	private int fastpaddleTrack = 0;
	private int bigpaddleTrack = 0;
	
	private int powerupTime = 420;
	
	private static boolean padHit = false;
	private static boolean multiballActive = false;
	private static boolean fastpaddleActive = false;
	private static boolean bigpaddleActive = false;
	
	private static int score = 0;
	private static int lives = 0;
	
	
	
	String[] filenames = {"soundtrack.wav", "ponghit.wav"};
	
	SoundDriverHo s1 = new SoundDriverHo(filenames, this);
	
	//Constructor
	public Breakout() {
		super();
//		colArrayIndex = (int)(Brick.getColorArrayLength() * Math.random());
		
		
		s1.loop(0);
	}
	
	
	
	
	
	
	//Getters
	public static int getHorizontalRectangles() {
		return horizontalRectangles;
	}
	public static int getVerticalRectangles() {
		return verticalRectangles;
	}
	public static int getTotalRectangles() {
		return totalRectangles;
	}
	public static int getColArrayIndex() {
		return colArrayIndex;
	}
	public static boolean getAI() {
		return ai;
	}
	public static int getGSpeed() {
		return gSpeed;
	}
	public static boolean getMultiballActive() {
		return multiballActive;
	}
	public static boolean getFastpaddleActive() {
		return fastpaddleActive;
	}
	public static boolean getBigpaddleActive() {
		return bigpaddleActive;
	}
	public static String getCurrentPalette() {
		return colorStrings[colArrayIndex];
	}
	public static int getScore() {
		return score;
	}
//	public SoundDriverHo getSoundDriver() {
//		return s1;
//	}
	
	//Setters
	public static void setPadHit(boolean padHit) {
		Breakout.padHit = padHit;
	}
	
	public static void setMultiball(Ball[] multiball) {
		Breakout.multiball = multiball;
		Breakout.multiballActive  = true;
//		System.out.print("True");
	}
	
	public static void setFastpaddleActive(boolean bool) {
		fastpaddleActive = bool;
	}
	
	public static void setBigpaddleActive(boolean bool) {
		bigpaddleActive = bool;
	}
	
	public static void incScore() {
		score++;
	}
	
	public static void decLives() {
		lives--;
		if(lives < 0) gamestate = 3;
	}
	
	
	
	//Cooldowns
	public boolean checkLevelCooldown() {
		return i - addLevelTime >= 60;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Breakout myRunner = new Breakout();
//		s1.loop(0);
		myRunner.start();
	}

	//Abstractions
	
	public void moveBall() {
		ball.move(paddle, bricks);
	}
	
	public void moveMultiBall() {
		if(multiballActive) {
			int inactive = 0;
			
			for(Ball b: multiball) {
				
				
				b.move(paddle, bricks);
				if(!b.getAlive()) {
					inactive++;
				}
			}
			
			if(inactive==multiball.length) {
				multiballActive = false;
			}
		}
	}
	
	public void fastpaddle() {
		if(fastpaddleActive) {
			fastpaddleTrack++;
//			System.out.println(fastpaddleTrack);
		}
		
		if(fastpaddleTrack > powerupTime) {
			paddle.setColor(Color.white);
			paddle.resetSpeed();
			fastpaddleActive = false;
			fastpaddleTrack = 0;
		}
		
	}
	
	public void bigpaddle() {
		if(bigpaddleActive) {
			bigpaddleTrack++;
		}
		
		if(bigpaddleTrack > powerupTime) {
			paddle.resetSize();
			bigpaddleActive = false;
			bigpaddleTrack = 0;
			
		}
	}
	
	public void movePaddle() {
		if(!ai)
			paddle.checkPMove();
		else
			paddle.AIMove(ball);
	}
	
	public void moveParticles() {
		if(Brick.getParticleStatus()) {
			Particle.moveParticles(bricks);
		}
	}
	
	public void checkForLevels() {
		if(GDV5.KeysPressed[KeyEvent.VK_SPACE] && checkLevelCooldown() || i % 360 == 0 && i != 0) {
			bricks = Brick.addBricks(bricks); 
			addLevelTime = i;
		}
	}
	
	public void movePills() {
		for(Brick b: bricks) {
			Pill pill = b.getPill();
			if(pill.getStatus())
				pill.move(i);
			pill.paddleBounce(paddle);
		}
	}
	
	public void hitSound() {
		if(padHit) {
			s1.play(1);
			padHit = false;
		}
	}
	
	public void runPowerups() {
		moveMultiBall();
		fastpaddle();
		bigpaddle();
	}
	
	
	public void gamestate0() {
		if(gamestate == 0) {
			if(GDV5.KeysPressed[KeyEvent.VK_A] && aiElapsed > 30) {
				ai = !ai;
				aiElapsed = 0;
			}
			
			if(GDV5.KeysPressed[KeyEvent.VK_C] && paletteElapsed > 30) {
				colArrayIndex = colArrayIndex + 1 == colorStrings.length ? 0 : colArrayIndex + 1;
				paletteElapsed = 0;
			}
			
			if(GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
				bricks = Brick.makeBricks();
				paddle = new Paddle(25);
				ball = new Ball(25, true);
				
				gamestate = 1;
			}
			
			if(GDV5.KeysPressed[KeyEvent.VK_V]) {		
				gamestate = 2;
			}
			
			paletteElapsed++;
			aiElapsed++;
		}
	}
	
	public void gamestate1() {
		if(gamestate == 1) {
			
			if(i==0 || Ball.getResetBall()) {
				ball.resetBall();
			}
			
			moveBall();
			
			movePaddle();
			
			moveParticles();
			
			checkForLevels();
			
			movePills();
			
			hitSound();
			
			runPowerups();
			
			fastpaddle();
	
			i++;
		}
	}
	
	public void gamestate2() {
		if(gamestate == 2) {
			if(GDV5.KeysPressed[KeyEvent.VK_B]) {		
				gamestate = 0;
			}
		}
	}
	
	public void gamestate3() {
		if(gamestate == 3) {
			if(GDV5.KeysPressed[KeyEvent.VK_ENTER]) {		
				gamestate = 0;
			}
		}
	}
	
	
	
//	Gamestates:
//	0: Splash screen
//	1: Normal game (w or w/o AI)
//	2: Powerup Information screen
//	3: 	
//		
//		
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		gamestate0();
		gamestate1();
		gamestate2();
		gamestate3();
	}

	
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		win.setColor(Color.white);
		
		if(gamestate == 1) {
			
			Splash.score(win);
			
			//Draw Bricks
			Brick.drawBricks(win, bricks);
			
			//Draw Paddle
			paddle.draw(win);
			
			//Draw Ball
			ball.draw(win);
			
			if(multiballActive) {
				for(Ball b: multiball) {
					b.draw(win);
				}
			}
			
		}
		
		if(gamestate == 0) {
			Splash.drawSplash(win);
		}
		
		if(gamestate == 2) {
			Splash.drawPowers(win);
		}
		
		if(gamestate == 3) {
			Splash.drawEnd(win);
		}
		
		
		if(Ball.getResetBall() && gamestate == 1) {
			Splash.drawResetTimer(win);
		}
		
		
	}
	
}
