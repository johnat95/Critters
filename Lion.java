import java.awt.*;
import java.util.Random;

public class Lion extends Critter {

    private int step;
    private Object[] colorArray = {Color.BLUE, Color.RED, Color.GREEN};
    private Color initialColor;
    private boolean isPolar;

    public Lion() {
        this.step = 0;
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if(info.getFront() == Neighbor.WALL ||
                info.getRight() == Neighbor.WALL)
            return Action.LEFT;
        else if(info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }

    @Override
    public Color getColor() {
        Random rand = new Random();
        if((this.step % 3) == 0) {
            this.step++;
            Color newColor = (Color) colorArray[rand.nextInt(3)];
            this.initialColor = newColor;
        }
        step++;
        return initialColor;
    }

    @Override
    public String toString() {
        return "L";
    }
}