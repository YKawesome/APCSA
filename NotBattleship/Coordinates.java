package NotBattleship;

public class Coordinates {
	private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	private int x;
	private int y;
	
	public Coordinates() {
		this.x = 0;
		this.y = 0;
	}
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public static String getAlpha(int i) {
		return String.valueOf(alphabet[i]);
	}
	
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return String.format("%c%d", alphabet[y], x+1); // x = x, y = y]
	}
}
