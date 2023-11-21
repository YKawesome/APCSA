package NotBattleship;

public class Cruiser extends ScoutBoat {

    public Cruiser(int team, Coordinates c, int direction) {
        super(team, c, direction, 3, 3);
    }

    public String getID() {
        return "C";
    }

    public String getActions() {
        return "Choose any of the following actions for the Cruiser:\n 1. Move\n 2. Turn left\n 3. Turn right";
    }

    public String act(int[] choices, World w) {
        StringBuilder bld = new StringBuilder();

        for(int i: choices) {
            if(i==1) bld.append(move(w)+"\n");
            else if(i==2) bld.append(turn(-1)+"\n");
            else if(i==3) bld.append(turn(1)+"\n");
        }

        return bld.toString();
    }
    
}
