//Name: Reid Moirn
//Class:	CS145
//Assignment: Lab	1
//Purpose: Guessing Game
import java.util.*;

public class Game {
	public static final int MAX = 100;
   
	public static void main(String[] args) {
      intro();
      Scanner input = new Scanner(System.in);
      String newGame = input.nextLine();
         if (newGame.equals("yes" ,"Y" ,"y")) {
		   Random x = new Random();
         int ngue = 0;
         int gue;
         int ans = x.nextInt(MAX);
            do {
               ngue++;
               System.out.print("Your number?");
               gue = player.nextInt();
               if (gue < ans){
                  System.out.println("You guessed too low!");
               }
               else if (gue > ans){
                  System.out.println("You guessed too high!");
               }   
            } while (gue != ans);   
         }
         else {
            System.out.println("Thank you for playing!");
            }
            
      System.out.println("Congratulations! Here are your game stats!");
      System.out.println("Number of Guesses =" + ngue);
      System.out.println("Correct Guessing Number=" + ans);
      System.out.println("Would you like to play again?");
      }
            
   public static void intro() {
      System.out.println("I'd like to play a game...");
      System.out.println("Think of a number between 1 and 100");
      System.out.println("You have as many guesses as you need!");
      System.out.println("To begin, please consent with a keyboard input of Y");
      
   }  
}  