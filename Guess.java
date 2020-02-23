//Name: Reid Moirn
//Class:	CS145
//Assignment: Lab	1
//Purpose: Guessing Game
import java.util.*;

public class Guess {
	public static final int MAX = 100; //This is the greatest the random number can be
   
	public static void main(String[] args) {
      intro();
      Scanner scan = new Scanner(System.in);
      String newGame = scan.nextLine();
         do {  //this allows the game to play while the user inputs y after they complete 1 game
		   Random x = new Random();
         int ngue = 0;
         int gue;
         Scanner player = new Scanner(System.in);
         int ans = x.nextInt(MAX);
            do { //this is the while loop for the actual game itself
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
            
      System.out.println("Congratulations! Here are your game stats!");
      System.out.println("Number of Guesses = " + ngue);
      System.out.println("Correct Guessing Number= " + ans);
      System.out.println("Would you like to play again? if so please enter Y"); //will run after every game, giv ng the user a scoreboard of sorts
      newGame = scan.nextLine();
            } while (newGame.equals("Y"));          
   
   System.out.println("Thank you for playing!");
   }
   public static void intro() { //states the rules of the game and asks to begin
      System.out.println("I'd like to play a game...");
      System.out.println("Think of a number between 1 and 100");
      System.out.println("You have as many guesses as you need!");
      System.out.println("To begin, please consent with a keyboard input of Y");
   }
}  