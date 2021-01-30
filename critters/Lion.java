/*Reid Morin
Cs145
Lab 2: Critters
Lion*/

import java.awt.*;
public class Lion extends Critter {
   private int count;
   private Color initialColor;
   
   //constructor for the lion
   public Lion() {
      this.count = 0;
   }
   //returns the color
   public Color getColor() {
      this.count = this.count + 1;
      if ((this.count - 1) % 3 == 0) {
         Color randomColor = getRandomColor();
         this.initialColor = randomColor;
         return randomColor;
         } 
      else {
      return this.initialColor;
      }
   }
   //returns the string value
   public String toString() {
      return "L";
   }
     //always infect if an enemy is in front,
     // otherwise if a wall is in front or to the right, then turn left,
     // otherwise if a fellow Lion is in front, then turn right, otherwise hop.
    public Action getMove(CritterInfo info) {
        colorMoves++;
        if (info.getFront()==Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.WALL||info.getRight()==Neighbor.WALL){
            return Action.LEFT;
        } else if (info.getFront()==Neighbor.SAME){
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}