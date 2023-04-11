package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;



import utilities.GDV5;

public class PongRunner extends GDV5 {

	int maxx = PongRunner.getMaxWindowX();
	int maxy = PongRunner.getMaxWindowY();
	
	//Gameplay objects
	Ball ball = new Ball(25);
	
	Paddle lPaddle = new Paddle(25, 0);
	Paddle rPaddle = new Paddle(25, maxx-25);
	
	int wDivider = 10;
	Rectangle Divider = new Rectangle(maxx/2 - wDivider/2, 0, wDivider, maxy);
	
	Powerup fast;
	
	int iloc;
	int xloc;
	int yloc;
	
	//Timekeeper
	static int i = 0;
	int lcool = 0;
	int rcool = 0;
	
	//Paddle Speeds
	int lPaddleSpeed = 5;
	int rPaddleSpeed = 5;
	
	//win score
	int wscore = 2;
	
	String[] filenames = {"soundtrack.wav", "padhit.wav"};
	
	//Gameplay boolean
	static int gamestate = 4;
	
	//Powerup cooldown
	int powercd = 10;
	
	//Score
	
	static int lscore = 0;
	static int rscore = 0;
	static int winner = 0;
	
	SoundDriverHo s1 = new SoundDriverHo(filenames, this);
//	s1.setVolumeAll(1);
	static boolean padhit = false;
	int padhitcd = 0;
//	String[] filenames = new String[] {"one", "two", "three"};
	
	
//	s1 = new SoundDriverHo(filenames);
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PongRunner myRunner = new PongRunner();
		myRunner.start();
		
//		s1.loop(0);
		
	}
	
	public void timesecond(int thing) {
		if(i%60==0) {
			System.out.println(thing);
		}
	}
	
	public void initPower(String powerupname) {
		if(powerupname.equals("fast")) {
			
			int[] locs = Powerup.locgenerator(lPaddle, rPaddle);
			
			fast = new Powerup(locs[0], locs[1], "fast");
			fast.ilocation = locs[2];
		}
	}
	
	public void spawnPower(Powerup powerup) {
		powerup.setShowing(true);
		
	}
	
	public void generatePowers() {
		int thresh;
		if(lPaddle.pcolor == Color.red || rPaddle.pcolor == Color.red) {
			thresh = 400;
		}
		else {
			thresh = 900;
		}
		if(i%thresh == 0) {
			initPower("fast");
			spawnPower(fast);
		}
	}
	
	public void checkPowers(Powerup fast) {
		
		if(fast != null) {
			String[] sfast = fast.powerPaddle(lPaddle, rPaddle);
			if (sfast[1].equals("true")) {
				
				if(sfast[0].equals("left")) {
					lPaddle.pcolor = Color.red;
//					fast.setShowing(false);
					lcool = i;
				}
				
				else if(sfast[0].equals("right")) {
					rPaddle.pcolor = Color.red;
//					fast.setShowing(false);
					rcool = i;
				}
				
				
			}
		}
	}
	
	public void coolDown() {
//		timesecond(lcool);
//		if(i%60 == 0) {
//			System.out.println("i = " + i);
//			System.out.println("rcool = " + rcool);
//		}
		
		if(i - lcool > powercd*60) {
			lPaddle.pcolor = Color.white;
			lcool = 0;
		}
		
		if(i - rcool > powercd*60) {
			rPaddle.pcolor = Color.white;
			rcool = 0;
		}
	}
	
	public void restart() {
		lscore = 0;
		rscore = 0;
		winner = 0;
	}
	
	
	public void gamePlay() {
		i++;
		
//		if(i%60 == 0) {
//		s1.p(0);
//		}
		
		if(gamestate==2) {
			
			ball.move(lPaddle, rPaddle);
			
			lPaddle.lCheckMove(lPaddleSpeed);
			rPaddle.rCheckMove(rPaddleSpeed);
		}
		
		else if(gamestate==1) {
			ball.move(lPaddle, rPaddle);
			
			lPaddle.lCheckMove(lPaddleSpeed);
			rPaddle.AIMove(rPaddleSpeed, ball);
		}
	}
	
	public void setState() {
		if(GDV5.KeysPressed[KeyEvent.VK_2] && gamestate == 0) {
			gamestate = 2;
		}
		else if(GDV5.KeysPressed[KeyEvent.VK_1] && gamestate == 0) {
			gamestate = 1;
		}
		
		if((lscore >= wscore || rscore >= wscore ) && gamestate == 2) {
			gamestate = 3;
		}
		
		if(GDV5.KeysPressed[KeyEvent.VK_M] && gamestate == 3) {
			gamestate = 0;
			restart();
		}
		
		if(GDV5.KeysPressed[KeyEvent.VK_ENTER] && gamestate == 4) {
			gamestate = 0;
		}
	}
	
	public void checkWinner() {
		if(lscore>=wscore) {
			winner = 1;
		}
		
		if(rscore>=wscore) {
			winner = 2;
		}
	}
	
	
//	public void hitsound() {
//		if(padhit) {
//			padhitcd = i;
//			if(i==padhitcd) {
//				s1.play(1);
//			}
//			if(i - padhitcd % 60 == 0) {
//				padhit = false;
//			}
//		}
//		
//		
//	}
	
	@Override
	public void update() { //60 frames per second
		// TODO Auto-generated method stub
		
		if(i==1) {
			s1.loop(0);
		}
		setState(); 
		
//		Gameplay Loop
		gamePlay();
		
		generatePowers();
		checkPowers(fast);
		coolDown();
		
		checkWinner();
		
		
	}
	
	
	
	@Override
	public void draw(Graphics2D win) { //at the processor speed = approx 3000 frames per second
		// TODO Auto-generated method stub
		win.setColor(Color.white);
		
		if(gamestate == 0) {
			Draw.splash(win);
		}
		
		
		
		
		
		
		
		
		
		
		
		if(gamestate == 1 || gamestate == 2) {
			Draw.gamedraw(win, ball, lPaddle, rPaddle, Divider, fast);
		}
		
		if(gamestate == 3) {
			Draw.enddraw(win);
		}
		
		if(gamestate == 4) {
			Draw.instructions(win);
		}
		
		
//		Circles
//		win.drawOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
//		win.fillOval((int)ball.getX(), (int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
		
		
	}

}
