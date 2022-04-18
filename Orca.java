//In this class, we are making an Orca critter that can overcome the other
//critters (except for flytrap). Initially, we planned on making orcas
//move together in pods, but because of how chaotic as these simulations can get,
//they will inevitably do that without the need to program that into their
//behavior
//
//For extra credit, we also Programmed the orcas to change colors
//depending on their direction (black/white)

import java.awt.*;
import java.util.Random;

public class Orca extends Critter{

    private Color directionalColor;
    private Action moveAction = null;

    //Programmer: Joey
    @Override
    public Action getMove(CritterInfo info) {

        Random rand = new Random();
        boolean heads = rand.nextBoolean();

        //infects the neighbor in front
        if (info.getFront() == Neighbor.OTHER) {
            moveAction = Action.INFECT;

        //If an Orca is moving along the wall clockwise,
            // it turns around when it bumps into another ally
        } else if (info.getFront() != Neighbor.EMPTY &&
                   info.getLeft() == Neighbor.WALL) {
            moveAction = Action.RIGHT;
        } else if (info.getBack() == Neighbor.WALL &&
                   info.getLeft() == Neighbor.SAME &&
                   info.getRight() == Neighbor.EMPTY) {
            moveAction = Action.RIGHT;

        //If an Orca is moving along the wall counter-clockwise,
            // it turns around when it bumps into another ally
        } else if (info.getFront() != Neighbor.EMPTY &&
                   info.getRight() == Neighbor.WALL) {
            moveAction = Action.LEFT;
        } else if (info.getBack() == Neighbor.WALL &&
                   info.getRight() == Neighbor.SAME &&
                   info.getLeft() == Neighbor.EMPTY) {
            moveAction = Action.LEFT;

        //when an Orca meets with an ally or a wall,
            // there is a 50% chance it will turn right
        } else if (info.getFront() == Neighbor.WALL ||
            info.getFront() == Neighbor.SAME) {
            if (heads)
                moveAction = Action.RIGHT;
            else
                moveAction = Action.LEFT;

        //Orca will hop
        } else {
            moveAction = Action.HOP;
        }
        // Programmer: Nathan
        // by returning moveAction at the end of the statement rather
        // than returning after every if/else, we can also modify the color
        // of the Orcas depending on their direction
        setDirectionalColor(info.getDirection());
        return moveAction;
    }

    //Programmer: Nathan
    @Override
    public Color getColor() {
        return directionalColor;
    }

    @Override
    public String toString() {
        return "O";
    }

    private void setDirectionalColor(Direction direction){
        if(direction.equals(Direction.NORTH)
                || direction.equals(Direction.EAST)){
            directionalColor = Color.WHITE;
        }else{
            directionalColor = Color.BLACK;
        }
    }
}
