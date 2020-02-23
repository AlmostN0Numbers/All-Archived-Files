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
