package NotBattleship;

public class Battleship extends Boat implements Attacker {

    public Battleship(int team, Coordinates location, int direction) {
        super(team, location, direction, 4, 3, 1);
        //TODO Auto-generated constructor stub
    }

    public String getID() {
        return "B";
    }

    public String getActions() {
        return "Choose any of the following actions for the Battleship:\n 1. Move\n 2. Turn left\n 3. Turn right\n 4. Attack\n";
    }

    public String act(int[] choices, World w) {
        StringBuilder bld = new StringBuilder();

        for(int i: choices) {
            if(i==1) bld.append(move(w)+"\n");
            else if(i==2) bld.append(turn(-1)+"\n");
            else if(i==3) bld.append(turn(1)+"\n");
            else if(i==4) bld.append(attack(w)+"\n");
        }

        return bld.toString();
    }

    public String attack(World w) {
        Boat occupant = w.getOccupant(w.getAdjacentLocation(getLocation(), getDirectionInt()));
        if(occupant != null && occupant.getTeam()!=getTeam()) {

            return String.format("Fire cannons!%n%s%n%s", occupant.takeHit(getStrength(), w), occupant.takeHit(getStrength(), w));
        }
        else return "There are no boats in range currently.";
    }
    
}
