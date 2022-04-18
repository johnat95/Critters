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

        //If an Orca is moving along the wall clockwise, it turns around when it bumps into another ally
        } else if (info.getFront() != Neighbor.EMPTY &&
                   info.getLeft() == Neighbor.WALL) {
            return Action.RIGHT;
        } else if (info.getBack() == Neighbor.WALL &&
                   info.getLeft() == Neighbor.SAME &&
                   info.getRight() == Neighbor.EMPTY) {
            return Action.RIGHT;

        //If an Orca is moving along the wall counter-clockwise, it turns around when it bumps into another ally
        } else if (info.getFront() != Neighbor.EMPTY &&
                   info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getBack() == Neighbor.WALL &&
                   info.getRight() == Neighbor.SAME &&
                   info.getLeft() == Neighbor.EMPTY) {
            return Action.LEFT;

        //when an Orca meets with an ally or a wall, there is a 50% chance it will turn right
        } else if (info.getFront() == Neighbor.WALL ||
            info.getFront() == Neighbor.SAME) {
            if (heads)
                return Action.RIGHT;
            else
                return Action.LEFT;

        //Orca will hop
        } else {
            return Action.HOP;

        //good luck getting
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
