/*Reid Morin
Cs145
Lab 2: Critters
Giant
*/
import java.awt.*;
public class Giant extends Critter {
   private int moves;
   
   //constructor of the giant
   public Giant() {
      moves=1;
      getColor();
   }
   //returns the color
   public Color getColor() {
      return Color.GRAY;
   }
   //returns the string value
   public String toString() {
   if (moves<=6){
            return "fee";
        } else if (moves<=12){
            return "fie";
        } else if (moves<=18){
            return "foe";
        } else {
            return "fum";
        }
    }
     public Action getMove(CritterInfo info) {
        //always infect if an enemy is in front, otherwise hop if possible, otherwise turn right
        if (info.getFront()==Neighbor.OTHER){
            countMoves();
            return Action.INFECT;
        } else if(info.getFront()==Neighbor.EMPTY){
            countMoves();
            return Action.HOP;
        } else {
            countMoves();
            return Action.RIGHT;
        }
    }

    public void countMoves(){
        if (moves==24){
            moves=1;
        } 
        else {
            moves++;
        }
    }
}