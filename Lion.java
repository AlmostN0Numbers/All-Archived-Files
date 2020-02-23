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