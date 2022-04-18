import java.awt.*;

public class Bear extends Critter {

    private boolean isPolar;
    private boolean walkState = true;

    public Bear(boolean polar) {
        this.isPolar = polar;
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.LEFT;
    }

    //used a ternary operation here to save space
    @Override
    public Color getColor() {
        return isPolar ? Color.WHITE : Color.BLACK;
    }

    @Override
    public String toString() {
        String walkSymbol = null;

        if (walkState) {
            walkSymbol = "/";
            walkState = false;
        } else {
            walkSymbol = "\\";
            walkState = true;
        }
        return walkSymbol;
    }
}
