import java.awt.*;
import java.util.Random;

public class Orca extends Critter {

    //skin and direction give the orca a different pattern dependant on the direction it moves
    private String skin;
    private String[] direction = {"<","^",">","v"};
    private static int reset;

    public Orca() {
        this.skin = direction[0];
    }

    @Override
    public Action getMove(CritterInfo info) {
        Random rand = new Random();
        boolean heads = rand.nextBoolean();

        //infects the neighbor in front
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        //if an orca is backed against a wall by a flytrap, this else/if will help break it up
        } else if (info.getRight() == Neighbor.OTHER &&
                   info.getBack() == Neighbor.WALL) {
            return Action.RIGHT;
        //this if/else has a 50% chance of making orcas move together in a "pod"
        //if orcas get too conjested looping endlessly around the map, this if/else breaks them up
        } else if (info.getFront() == Neighbor.WALL ||
                info.getFront() != Neighbor.EMPTY &&
                info.getBack() != Neighbor.EMPTY) {
            return Action.LEFT;
        //this if/else keeps orcas moving forward
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        //whenever a lone orca hits a wall, they will turn left
        } else {
            return Action.LEFT;
        }
    }


    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }

    public String toString() {
        return "O";
        /*
        Tried to implement directional skins here

        if(info.getFront() == Neighbor.OTHER)
            return "!";
        else if(info.getDirection() == Direction.NORTH)
            return "^";
        else if(info.getDirection() == Direction.WEST)
            return "<";
        else if(info.getDirection() == Direction.EAST)
            return ">";
        else
            return "v";*/
    }
}
