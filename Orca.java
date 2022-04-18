import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.util.Random;

public class Orca extends Critter{
    private int stepCount;
    private int colorIndexCount;
    private Color directionalColor;

    private int podFailCount;

    //moveAction is static to allow all instances of Orca to
    //make the same move.
    private static Action moveAction = null;

    //Programmer: Joey
    @Override
    public Action getMove(CritterInfo info) {

        Random rand = new Random();
        boolean heads = rand.nextBoolean();

        //infects the neighbor in front
        if (info.getFront() == Neighbor.OTHER) {
            moveAction = Action.INFECT;
            //if an orca is backed against a wall by a flytrap, this else/if will help break it up
        } else if (info.getRight() == Neighbor.OTHER &&
                info.getBack() == Neighbor.WALL) {
            moveAction = Action.RIGHT;
            //this if/else has a 50% chance of making orcas move together in a "pod"
            //if orcas get too conjested looping endlessly around the map, this if/else breaks them up
        } else if (info.getFront() == Neighbor.WALL ||
                info.getFront() != Neighbor.EMPTY &&
                        info.getBack() != Neighbor.EMPTY) {
            moveAction = Action.LEFT;
            //this if/else keeps orcas moving forward
        } else if (info.getFront() == Neighbor.EMPTY) {
            moveAction = Action.HOP;
            //whenever a lone orca hits a wall, they will turn left
        } else {
            moveAction = Action.LEFT;
        }

        setDirectionalColor(info.getDirection());
        return moveAction;
    }

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

    private boolean ifInPod(CritterInfo info){
        Neighbor[] neighbors = {info.getFront(), info.getBack(), info.getLeft(), info.getRight()};

        for(int i = 0; i<neighbors.length; i++){
            if(neighbors[i].equals(Neighbor.SAME)){
                return true;
            }
        }
        podFailCount++;
        return false;
    }
}
