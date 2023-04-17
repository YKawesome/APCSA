package NotBattleship;

import java.util.Random;

public class Submarine extends ScoutBoat implements Attacker{
    private int numOfTorpedoes;
    
    public Submarine(int team, Coordinates location, int direction, int numOfTorpedoes) {
        super(team, location, direction, 3, 2);
        this.numOfTorpedoes = numOfTorpedoes;
    }

    public String getID() {
        return "S";
    }

    public String getActions() {
        String temp = numOfTorpedoes > 0 ? " 5. Fire torpedoes" : "";
        return "Choose any of the following actions for the Submarine:\n 1. Move\n 2. Turn left\n 3. Turn right\n 4. Submerge\n" + temp;
    }

    public String act(int[] choices, World w) {
        StringBuilder bld = new StringBuilder();

        for(int i: choices) {
            if(i==1) bld.append(move(w)+"\n");
            else if(i==2) bld.append(turn(-1)+"\n");
            else if(i==3) bld.append(turn(1)+"\n");
            else if(i==4) bld.append(submerge(w)+"\n");
            else if(i==5) bld.append(attack(w)+"\n");
        }

        return bld.toString();
    }

    public String attack(World w) {
        if(numOfTorpedoes <= 0) return String.format("%s%d has no torpedoes remaining.", getID(), getTeam());
        else {
            Coordinates c = getLocation();
            for(int i = 0; i < getVision(); i++) {
                Random r = new Random();
                Boat occupant = w.isLocationValid(c) ? w.getOccupant(w.getAdjacentLocation(c, getDirectionInt())) : null;
                if(occupant != null && occupant.getTeam()!=getTeam()) {
                    numOfTorpedoes--;
                    return "Fire torpedoes!\n" + occupant.takeHit(r.nextInt(1,occupant.getHealth()+1), w);
                }
                else c = w.getAdjacentLocation(c, getDirectionInt());
            }

            return "There are no boats in range currently.";
        }
    }

    public String submerge(World w) {
        Random r = new Random();
        while(true) {
            int i = r.nextInt(8);
            int j = r.nextInt(8);

            if(Math.abs(i-j) == 4) continue;

            Coordinates testLoc = w.getAdjacentLocation(w.getAdjacentLocation(getLocation(), i), j);
            testLoc = w.isLocationValid(testLoc) ? testLoc : null;
            if(w.getOccupant(testLoc)==null) {
                Coordinates oldLoc = getLocation();
                w.clearOccupant(oldLoc);
                setLocation(testLoc);
                return String.format("%s%d moves from %s to %s.", getID(), getTeam(), oldLoc, getLocation());
            }
        }
    }
    

    
}
