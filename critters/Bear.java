/*Reid Morin
Cs145
Lab 2: Critters
Bear*/

import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int moves;

   //Contsructor of the bear
    public Bear(boolean polar){
        this.polar=polar;
        getColor();
    }
   //returns color
    public Color getColor() {
        if (this.polar){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }
   //returns the string value
    public String toString(){
        if (moves%2==0){
            return "/";
        } else {
            return "\\";
        }

    }
   //always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
    public Action getMove(CritterInfo info){
        moves++;
        if(info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}