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
