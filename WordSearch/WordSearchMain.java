//Name: Reid Moirn
//Class:	CS145
//Assignment: Project 1: Word Search Generator
//Purpose: Creates a word search with a users inputs as search userInput
import java.util.*;
import java.io.*;

public class WordSearchMain{ 
   public static void main(String [] args) throws FileNotFoundException{ //for when the WordSearch isnt found
       printIntro();
       Scanner console = new Scanner (System.in);
       boolean generated = false;
       String choice;
       choice = console.next();
       WordSearch search = new WordSearch();
       while(!choice.equals("exit")){
         if(choice.equals("run")){//Initializes word search
            System.out.println("ENTER EACH WORD LINE BY LINE, WHEN THE USER IS SATISFIED, FINISH BY INPUTTING: end");
            String x = console.next();
            ArrayList<String> wordGrid = new ArrayList<String>();
            while(!x.equals("end")) {
               wordGrid.add(x);
               x = console.next();
            }
           System.out.println("WORDSEARCH GENERATED, ENTER THE LISTED COMMANDS TO CONTINUE");
           //When the end is inputted
               String[] userInput = new String[wordGrid.size()];
               wordGrid.toArray(userInput);
               search.create(userInput);
               generated = true;
               
            }
            else if(choice.equals("print")){
               if(generated){
                  print(search);
               }
            System.out.println("WORDSEARCH DISPLAYED, ENTER THE LISTED COMMANDS TO CONTINUE");   
            }
            else if(choice.equals("solution")){
               if(generated){
                  showSolution(search);
               }
            System.out.println("SOLUTION DISPLAYED, ENTER THE LISTED COMMANDS TO CONTINUE");
            }
         choice = console.next();
         }
      }
    public static void printIntro(){
      System.out.println("RUNNING WORD SEARCH GENERATOR");
      System.out.println("USER: SELECT LISTED OPTION");
      System.out.println("GENERATE WORD SEARCH (run)");
      System.out.println("PRINT USERS WORD SEARCH (print)");
      System.out.println("SHOW USERS SOLUTION TO WORDSEARCH (solution)");      
      System.out.println("EXIT WORDSEARCH.EXE (exit)");
      }
      public static void print(WordSearch ws){
      System.out.println(ws);
   }

   //Prints out the solution to the word search.
   public static void showSolution(WordSearch ws){
      System.out.println(ws.toSolution());
   }

}