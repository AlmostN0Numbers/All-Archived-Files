//Name: Reid Moirn
//Class:	CS145
//Assignment: Lab	2
//Purpose: Critters simulation 
import java.awt.*;

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(60, 40);
        

        // uncomment each of these lines as you complete these classes
         frame.add(30, Bear.class);
         frame.add(30, Lion.class);
         frame.add(30, Giant.class);
        // frame.add(30, Orca.class);
        //frame.add(30, FlyTrap.class);
        //frame.add(30, Food.class);

        frame.start();
    }
    
   public class Bear extends Critter {
	
	   private boolean isNorth = true;
	   private boolean isGrizzly;
	
	   public Bear(boolean grizzly) {
	   	this.isGrizzly = grizzly;
	   }
	
	   public Direction getMove() {
	   	if (this.isNorth) {
	   		this.isNorth = !this.isNorth;
	   		return Direction.NORTH;
	   	} else {
	   		this.isNorth = !this.isNorth;
	   		return Direction.WEST;
	   	}
	   }

	   public Color getColor() {
	   	if (this.isGrizzly) {
	   		return new Color(190,110,50);
	   	} else {
	   		return Color.WHITE;
	   	}
	   }

	   public String toString() {
	   	return "/";
	   }
   }  
   //Lion method begins
   public class Lion extends Critter {
	
	   private int numMove = 0;
	   private boolean inFight = false;
	   
	   public Lion() {
	   }
	   
	   public Direction getMove() {
	   	if (this.numMove < 5) {
	   		this.numMove++;
	   		return Direction.SOUTH;
	   	} else if (this.numMove < 10) {
	   		this.numMove++;
	   		return Direction.EAST;
	   	} else if (this.numMove < 15) {
	   		this.numMove++;
	   		return Direction.WEST;
	   	} else if (this.numMove < 20) {
	   		this.numMove++;
	   		return Direction.NORTH;
	   	} 
	   }
   
	   public Color getColor() {
	   	return Color.RED;
	   }
   
	   public String toString() {
	   	return "L";
	   }
   }  
    //Giant critter method begins
      public class Giant extends Critter {
      
      private int numMove = 0;

	   public Giant () {
	   }
	
	   public Direction getMove() {
	   	if (this.numMove < 5) {
	   		this.numMove++;
	   		return Direction.NORTH;
         }
         else{
            return Direction.SOUTH;
	   }      
   }
	   public Color getColor() {
	      return Color.GRAY;
	   }

	   public String toString() {
	   	if (this.numMove <= 6){
            return "FEE";
	   }
         else{
            return "FO";
         }
      }     
   }
      //Orca Method begins   
      public class Orca extends Critter {
      
      private int numMove = 0;

	   public Orca () {
	   }
	
	   public Direction getMove() {
	      if (this.numMove < 1) {
	   	   this.numMove++;
	   		return Direction.EAST;
	    } else if (this.numMove < 2) {
	   		this.numMove++;
	   		return Direction.WEST;
	   } else if (this.numMove < 3) {
	   		this.numMove++;
	   		return Direction.NORTH;
	  	} else {
            this.numMove = 0;
            return Direction.SOUTH; 
      }
   }
	   
      public Color getColor() {
	      return Color.WHITE;
	   }

	   
      public String toString() {
         return "WHALENOISE";
      }     
   }  
}
