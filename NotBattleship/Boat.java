package NotBattleship;

public abstract class Boat {
	private int team;
	private Coordinates location;
	private int direction;
	private int health;
	private int strength;
	private int vision;
	
	protected Boat(int team, Coordinates location, int direction, int health, int strength, int vision) {
		this.team = team;
		this.location = location;
		this.direction = direction;
		this.health = health;
		this.strength = strength;
		this.vision = vision;
	}
	
	public int getTeam() {
	    return team;
	}

	public Coordinates getLocation() {
	    return location;
	}

	public String getDirection() {
		String letter = null;
		if (direction == 0) letter = "↑";
		if (direction == 1) letter = "↗";
		if (direction == 2) letter = "→";
		if (direction == 3) letter = "↘";
		if (direction == 4) letter = "↓";
		if (direction == 5) letter = "↙";
		if (direction == 6) letter = "←";
		if (direction == 7) letter = "↖";
		return letter;

	}

	public int getDirectionInt() {
		return direction;
	}

	public int getHealth() {
	    return health;
	}

	public int getStrength() {
	    return strength;
	}

	public int getVision() {
	    return vision;
	}
	
	public abstract String getID();
	
	public abstract String act(int[] choices, World w);
	
	public abstract String getActions();
	
	public String move(World w) {
		if(!w.isLocationValid(w.getAdjacentLocation(location, direction))) return String.format("%s cannot move off the map.", this);
		else if(w.isLocationOccupied(w.getAdjacentLocation(location, direction))) return String.format("%s cannot move to %s as it is occupied.", this, w.getAdjacentLocation(location, direction));
		else {
			String oldLoc = location.toString();
			w.clearOccupant(location);
			location = w.getAdjacentLocation(location, direction);
			w.setOccupant(this, location);
			return String.format("%s moves from %s to %s.",this,oldLoc,location);
			
		}
	}
	
	public String turn(int i) {
		
		if(i==1) {
			if(direction<7) direction++;
			else direction = 0;
		}
		else if(i==-1) {
			if(direction>0) direction--;
			else direction = 7;
		}

		return String.format("%s turned %s, now facing %s", this, i == 1 ? "right" : "left", getDirection());
	}
	
	public String takeHit(int attackStrength, World w) {
		health = health-attackStrength <= 0 ? 0 : health - attackStrength;
		
		if(health==0) {
			w.clearOccupant(location);
			return String.format("%s has been sunk!",this);
		}
		else return String.format("%s takes %d damage.",this,attackStrength);
		
	}
	
	public void setLocation(Coordinates c) {
		location = c;
	}
	
	public String toString() {
		return String.format("%s%d", getID(),team);
	}
	
}
