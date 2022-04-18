import java.awt.*;
import java.util.Random;

public class Orca extends Critter {

    private String skin;
    private String[] direction = {"<","^",">","v"};
    private static int reset;

    public Orca() {
        this.skin = direction[0];
        this.reset = 0;
    }

    @Override
    public Action getMove(CritterInfo info) {
        Random rand = new Random();
        boolean heads = rand.nextBoolean();
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.SAME &&
                    info.getRight() != Neighbor.WALL) {
            if (heads)
                return Action.RIGHT;
            else
                return Action.LEFT;
        } else if (info.getFront() == Neighbor.WALL ||
                info.getFront() != Neighbor.EMPTY &&
                info.getBack() != Neighbor.EMPTY) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }


    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    public String toString() {
        return this.skin;
        /*if(info.getFront() == Neighbor.OTHER)
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
