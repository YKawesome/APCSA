package NotBattleship;

public class World {
	private Boat[][] map;
	
	public static final int NORTH = 0;
	public static final int NORTHEAST = 1;
	public static final int EAST = 2;
	public static final int SOUTHEAST = 3;
	public static final int SOUTH = 4;
	public static final int SOUTHWEST = 5;
	public static final int WEST = 6;
	public static final int NORTHWEST = 7;
	
	public World(int width, int height) {
		width = width <=4 ? 4 : width;
		width = width >= 10 ? 10 : width;
		height = height <=4 ? 4 : height;
		height = height >= 10 ? 10 : height;
		
		map = new Boat[width][height];
	}
	
	public int getWidth() {
		return map.length;
	}
	
	public int getHeight() {
		return map[0].length;
	}
	
	public Boat getOccupant(Coordinates c) {
		return map[c.getX()][c.getY()];
	}
	
	public boolean isLocationValid(Coordinates c) {
		return c.getX() < getWidth() && c.getX() >= 0 && c.getY() < getHeight() && c.getY() >= 0;
	}
	
	public boolean isLocationOccupied(Coordinates c) {
		return getOccupant(c) != null;
	}
	
	public boolean setOccupant(Boat b, Coordinates c) {
		if(!isLocationOccupied(c) && isLocationValid(c)) {
			map[c.getX()][c.getY()] = b;
			System.out.println(String.format("Set %s at %s", b, c));
			return true;
		}
		else return false;
		
	}

	public void clearOccupant(Coordinates c) {
		map[c.getX()][c.getY()] = null;
	}
	
	public Coordinates getAdjacentLocation(Coordinates c, int i) {
		Coordinates returnC = null;
		if(i == 0) returnC = new Coordinates(c.getX(), c.getY()-1);
		if(i == 1) returnC = new Coordinates(c.getX()+1, c.getY()-1);
		if(i == 2) returnC = new Coordinates(c.getX()+1, c.getY());
		if(i == 3) returnC = new Coordinates(c.getX()+1, c.getY()+1);
		if(i == 4) returnC = new Coordinates(c.getX(), c.getY()+1);
		if(i == 5) returnC = new Coordinates(c.getX()-1, c.getY()+1);
		if(i == 6) returnC = new Coordinates(c.getX()-1, c.getY());
		if(i == 7) returnC = new Coordinates(c.getX()-1, c.getY()-1);

		
		return returnC;
	}



	public void viewOne(StringBuilder bld) {
		for(int i = 0; i < getHeight(); i++) bld.append(String.format("%s  %s%n",Coordinates.getAlpha(i), "###".repeat(getWidth())));
	}

	public void viewTwo(StringBuilder bld, Boat[] boats) {
		for(int i = 0; i < getHeight(); i++) {
			StringBuilder minibld = new StringBuilder(String.format("%s  ", Coordinates.getAlpha(i)));

			for(int j = 0; j < getWidth(); j++) {
				String cellContent = "###";
				for(Boat b: boats) {
					if(b.getLocation().getX()==j && b.getLocation().getY()==i) cellContent = String.format("%s%s", b.getDirection(), b.toString());
					else if(Math.abs(b.getLocation().getX() - j) <= b.getVision() && Math.abs(b.getLocation().getY() - i) <= b.getVision() && cellContent.equals("###")) cellContent = "~~~";
				}
				
				Boat temp = map[j][i];
				if(cellContent.equals("~~~") && temp != null) {
					cellContent = String.format("%s%s", temp.getDirection(), temp.toString());
				}
			
				minibld.append(cellContent);
			}
			bld.append(minibld.toString() + "\n");
		}
	}

	public void viewThree(StringBuilder bld, Boat[] boats) {
		for(int i = 0; i < getHeight(); i++) {
			StringBuilder minibld = new StringBuilder(String.format("%s  ", Coordinates.getAlpha(i)));

			for(int j = 0; j < getWidth(); j++) {
				String cellContent = "###";
				for(Boat b: boats) {
					if(b.getLocation().getX()==j && b.getLocation().getY()==i) cellContent = String.format("%s%s", b.getHealth(), b.toString());
					else if(Math.abs(b.getLocation().getX() - j) <= b.getVision() && Math.abs(b.getLocation().getY() - i) <= b.getVision() && cellContent.equals("###")) cellContent = "~~~";
				}
				
				Boat temp = map[j][i];
				if(cellContent.equals("~~~") && temp != null) {
					cellContent = String.format("%s%s", temp.getHealth(), temp.toString());
				}
			
				minibld.append(cellContent);
			}
			bld.append(minibld.toString() + "\n");
		}
	}
	
	public String drawTeamMap(Boat[] boats, int viewType) {
		StringBuilder bld = new StringBuilder("@ ");
		for(int i = 1; i <= getWidth(); i++) bld.append(String.format("  %d", i));
		bld.append("\n");

		if(viewType==1) viewOne(bld);

		else if(viewType==2) viewTwo(bld, boats);

		else if(viewType==3) viewThree(bld, boats);

		return bld.toString();
	}
}
