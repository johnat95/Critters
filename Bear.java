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

    @Override
    public Color getColor() {
        return isPolar ? Color.WHITE : Color.BLACK;
    }

//ternary here?
    @Override
    public String toString() {
        String walkSymbol = null;

        if (walkState) {
            walkSymbol = "/";
            walkState = false;
        } else if (!walkState) {
            walkSymbol = "\\";
            walkState = true;
        }
        return walkSymbol;
    }
}
