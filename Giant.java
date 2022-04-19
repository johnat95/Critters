//Programmer: Nathan Johnston
//This class contains variables and methods to provide color,
//display texts and movement behavior of the Giant Critter

import java.awt.*;

public class Giant extends Critter {

    private int stepCount;

    private int wordIndexCount;

    private String[] wordDisplayArray = {"fee","fie", "foe", "fum"};

    public Giant(){
        // init step count at -1 to accommodate call to
        //to string during simulation set up.
        this.stepCount = -1;
    }

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

        //change array every 6th step.
        if(stepCount % 6 == 0
                && stepCount != 0){

            //increment or resent indexCount if count
            //reaches the end of the word array
            if(wordIndexCount >= wordDisplayArray.length-1){

                wordIndexCount = 0;
            }else{
                wordIndexCount++;
            }

        }

        //reset step count once it gets to 6,
        //ensures int max value is never reached
        if(stepCount >=6){
            stepCount = 1;
        }else{
            stepCount++;
        }


        return wordDisplayArray[wordIndexCount];
    }


}
