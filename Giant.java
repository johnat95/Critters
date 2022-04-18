//In this class, we are making a giant critter that is a 3 charecter
//string repeating the phrase "fee, fie, foe fum"

import java.awt.*;
import java.util.Random;

public class Giant extends Critter {

    private int step;
    private Object[] giantArray = {"fee","fie","foe","fum"};
    private int wordCount;
    private String word;

    public Giant() {
        this.word = "fee";
        this.step = 0;
        this.wordCount = 0;
    }

    @Override
    public Action getMove(CritterInfo info) {
        if(info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if(info.getFront() == Neighbor.WALL ||
                info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {
        if((this.step % 6) == 0) {
            this.wordCount %= 4;
            this.word = (String) giantArray[wordCount];
            this.wordCount++;
        }
        step++;
        return word;
    }
}

