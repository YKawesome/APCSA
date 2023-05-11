package NotBattleship;

import java.util.Random;

public class Destroyer extends Boat implements Attacker {

    public Destroyer(int team, Coordinates location, int direction) {
        super(team, location, direction, 2, 2, 1);
    }

    public String getID() {
        return "D";
    }

    public String getActions() {
        return "Choose any of the following actions for the Destroyer:\n 1. Move\n 2. Turn left\n 3. Turn right\n 4. Attack\n";
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
            return occupant.takeHit(getStrength(), w);
        }
        else return "There are no boats in range currently.";
    }
    
    @Override
    public String takeHit(int strength, World w) {
        Random r = new Random();

        if(r.nextInt(2) == 1) return String.format("%s%d avoids the attack!", getID(), getTeam());
        else return super.takeHit(strength, w);
    }
}
