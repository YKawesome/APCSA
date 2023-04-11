package NotBattleship;

import java.util.Random;

public class AircraftCarrier extends Boat implements Attacker{
    private boolean hasPlanes;

    public AircraftCarrier(int team, Coordinates location, int direction) {
        super(team, location, direction, 5, 1, 1);
    }

    public String getID() {
        return "A";
    }

    public String getActions() {
        String temp = hasPlanes ? " 4. Launch planes" : "";
        return "Choose any of the following actions for the Aircraft Carrier:\n 1. Move\n 2. Turn left\n 3. Turn right\n" + temp;
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
        StringBuilder result = new StringBuilder();
        Random r = new Random();
        double successRate = 1;
        if(hasPlanes) {
            for(int i = 0; i < 8; i++) {
                Boat occupant = w.getOccupant(w.getAdjacentLocation(getLocation(), i));
                if(occupant!=null && occupant.getTeam()!=getTeam()) {
                    if(successRate == 1) result.append("Air Raid!\n");
                    result.append(occupant.takeHit(getStrength(), w) + "\n");
                    successRate*=0.8;
                    if(r.nextDouble()>successRate) {
                        hasPlanes=false;
                        result.append("The planes have been destroyed.");
                        break;
                    }
                }
            }

        }
        else result.append("A1 has no planes remaining.");

        if(successRate==1) result.append("There are no boats in range currently.");

        return result.toString();
    }
}
