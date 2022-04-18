import java.awt.*;


public class Bear extends Critter{

    private boolean isPolar;
    private boolean walkState = true;
    private String currentSymbol = "/";

    public Bear(boolean polar){
        this.isPolar = polar;
    }

    @Override
    public Action getMove(CritterInfo info) {

        toggleCurrentSymbol();

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
        return currentSymbol;
    }

    //This method alternates walkState between true and false
    //and currentSymbol between "/" and "\". It takes no parameters
    // and returns nothing;
    private void toggleCurrentSymbol(){
        if(walkState){
            walkState = false;
            currentSymbol = "/";
        }
        walkState = true;
        currentSymbol = "\\";
    }


}
