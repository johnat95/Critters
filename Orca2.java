import java.awt.*;


public class Orca2 extends Critter{

    private Color directionalColor;

    //moveAction is static to allow all instances of Orca to
    //make the same move.
    private static Action moveAction = null;

    //Programmer: Joey
    @Override
    public Action getMove(CritterInfo info) {

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

    //Programmer: Nathan
    @Override
    public Color getColor() {

        return directionalColor;
    }

    @Override
    public String toString() {
        return "O";
    }

    //Programmer: Nathan
    private void setDirectionalColor(Direction direction){
        if(direction.equals(Direction.NORTH)
                || direction.equals(Direction.EAST)){
            directionalColor = Color.WHITE;
        }else{
            directionalColor = Color.BLACK;
        }
    }

}