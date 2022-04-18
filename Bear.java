import java.awt.*;
import java.util.Random;

public class Bear extends Critter{

    private boolean isPolar;
    private boolean walkState = true;

    public Bear(boolean polar){
        this.isPolar = polar;
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.getFront().equals(Neighbor.OTHER)){
            return Action.INFECT;
        }

        if(info.getFront().equals(Neighbor.EMPTY)){
            return Action.HOP;
        }


        return Action.LEFT;
    }

    @Override
    public Color getColor() {

        return isPolar ? Color.WHITE:Color.BLACK;
    }

    @Override
    public String toString() {
    //This method alternates walkState between true and false
    //and returning "/" and "\". It takes no parameters
    // and returns a string.

     if(walkState){
            return  "/";
        }
        walkState = true;
        return "\\";
    }
}
