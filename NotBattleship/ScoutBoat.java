package NotBattleship;

import java.util.Random;

public abstract class ScoutBoat extends Boat{
    protected ScoutBoat(int team, Coordinates location, int direction, int health, int vision) {
        super(team, location, direction, health, 1, vision);
    }

    @Override
    public String takeHit(int numAttacks, World w) {
        Random r = new Random();
        return r.nextInt(4) == 1 ? super.takeHit(numAttacks, w) : String.format("%s has avoided the attack!",this);
    }
}
