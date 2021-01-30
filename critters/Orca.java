/*Reid Morin
Cs145
Lab 2: Critters
Orca
*/

import java.awt.*;

//Orca Constructor
public class Orca extends Critter {
   public Orca() {
   } 
   //returns string value
   public String toString() {
      return "whale noise";
      }
   //returns color   
   public Color getColor() {
      return Color.BLACK;
      }
    //returns infect in front, or else go backwards, otherswise hop
    public Action getMove(CritterInfo info){
        moves++;
        if(info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.EMPTY){
            return Action.BACK;
        } else {
            return Action.HOP;
        }
    }
}

