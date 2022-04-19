//In this class, we are making a bear critter that can be
//either a polar bear (white) or a black bear

import java.awt.*;

public class Bear extends Critter {

    private boolean isPolar;
    private boolean walkState = true;

    private String currentSymbol;

    public Bear(boolean polar) {
        this.isPolar = polar;
    }

    @Override
    public Action getMove(CritterInfo info) {

        toggleCurrentSymbol();

        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.LEFT;
    }

    //programmer: Nathan
    //this method uses a ternary conditional operation to
    //return the color black or white based on the isPoloar boolean
    @Override
    public Color getColor() {

        return isPolar ? Color.WHITE : Color.BLACK;
    }

    //programmer: Nathan
    //This method alternates walkState between true and false
    //and currentSymbol between "/" and "\". It takes no parameters
    // and returns nothing;
    @Override
    public String toString() {
        return currentSymbol;
    }

    private void toggleCurrentSymbol(){
        if(walkState){
            walkState = false;
            currentSymbol = "/";
        }
        walkState = true;
        currentSymbol = "\\";
    }
}
