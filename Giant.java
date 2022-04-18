import java.awt.*;

public class Giant extends Critter {

    private int stepCount;

    private int wordIndexCount;

    private String[] wordDisplayArray = {"fee","fie", "foe", "fum"};


    @Override
    public Action getMove(CritterInfo info) {

        if(info.getFront().equals(Neighbor.OTHER)){
            return Action.INFECT;
        }

       if(info.getFront().equals(Neighbor.EMPTY)){
           return Action.HOP;
       }

        return Action.RIGHT;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {
        stepCount++;
        //change array every third step.
        if(stepCount % 6 == 0
                && stepCount != 0){

            if(wordIndexCount >= 6){

                wordIndexCount = 0;
            }else{
                wordIndexCount++;
            }

        }

        //reset step count once it gets to 6,
        //ensures int max value is never reached
        if(stepCount >=6){
            stepCount = 0;
        }


        return wordDisplayArray[wordIndexCount];
    }


}
