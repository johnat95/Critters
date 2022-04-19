//Programmer: Nathan Johnston
//This class contains variables and methods to provide color,
//display texts and movement behavior of the Lion Critter
import java.awt.*;
import java.lang.reflect.Type;
import java.util.Random;
import java.util.function.Predicate;

public class Lion extends Critter {

    private int stepCount;
    private int indexCount;
    private final String critterSymbol = "L";


    Random rand = new Random();

    Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN};

    public Lion(){
        // init step count at -1 to accommodate call to
        //to string during simulation set up.
        this.stepCount = -1;
        indexCount = rand.nextInt(3);
    }

    @Override
    public Action getMove(CritterInfo info) {

        if(info.getFront().equals(Neighbor.OTHER)){
            return Action.INFECT;
        }

        if(info.getFront().equals(Neighbor.SAME)){
            return Action.RIGHT;
        }

        if(info.getFront().equals(Neighbor.WALL)
                || info.getLeft().equals(Neighbor.WALL)){
            return Action.LEFT;
        }

        return Action.HOP;


    }

    @Override
    public Color getColor() {

        //randomly change index every third step.
        if(stepCount % 3 == 0
                && stepCount != 0){

            indexCount = rand.nextInt(3);
        }


        //reset step count once it gets to 3,
        //ensures int max value is never reached
        if(stepCount >=3){
            stepCount = 0;
        }else{
            stepCount++;
        }


        return colorArray[indexCount];
    }

    @Override
    public String toString() {
        return critterSymbol;
    }




}
