import java.awt.*;

public class Orca extends Critter{
    private  int stepCount;
    private  int colorIndexCount;

    //moveAction is static to allow all instances of Orca to
    //make the same move.
    private static Action moveAction = null;

    private Color[] colorArray ={Color.BLACK, Color.BLACK, Color.WHITE};

    @Override
    public Action getMove(CritterInfo info) {
        return super.getMove(info);
    }

    @Override
    public Color getColor() {
        if(stepCount >=3){
            stepCount = 0;
        }else {
            stepCount++;
        }

        if(stepCount% 3 == 0){
            System.out.println(stepCount);

            if(colorIndexCount >= 2){
                System.out.println(colorIndexCount);
                colorIndexCount = 0;
            }else{
                colorIndexCount++;
            }

        }

        return colorArray[colorIndexCount];
    }

    @Override
    public String toString() {
        return "O";
    }
}
