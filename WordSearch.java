//Name: Reid Moirn
//Class:	CS145
//Assignment: Project 1: Word Search Generator
//Purpose: Creates a word search with a users inputs as search words

import java.util.*;

public class WordSearch {

//programs intergers declarations

  private static int width;
  private static int length;
  private static int wordC;
  private static  ArrayList<String> words;
  private static  int[] positions;
  private static char [][] key; 
  private static String input;
  
  //Begin main

  public static void main(String [] args){
     intro();
     printY();
   }
   
   public static void intro(){  //Also known as printIntro for the spec sheet
      System.out.println("RUNNING WORD SEARCH GENERATOR");
      System.out.println("This program will generate a word search puzzle. Please enter words to generate the puzzle.");
      System.out.println("WHEN FINISHED PLEASE ENTER: run"); //teehee I entered it in all caps to be like an old MSDOS pc :)
      userInput(); //Call all methods to make the puzzle
      size();
      rndm();
  }
//Like the nestedcalender program I made for CS140, we will generate the area of the puzzle with nested for loops
   public static void printY(){
      for(int i =0; i <width; i++){ 
         for(int ind =0; ind<length; ind ++){
            System.out.print(key[i][ind]+ " "); 
          }
       System.out.println(" "); 
    }
    for(int i =0; i<wordC; i++){
       System.out.println(words.get(i));
      }                    
   }
   //method for randomizing where the placement of the words and letters are
   public static void rndm(){
     int a, b;
     int x, y;
     positions = new int[wordC]; 
     for(int i =0; i < wordC; i++){ //this for loop is for every word
        b = words.get(i).length();
        a = width -b; 
        x = randomRange(0, a);  
        y = randomRange(0, length-5); 
        if(key(positions,  y) ){
           y++; 
         }
         positions[i] = y; 
        for(int ind =0; ind <b; ind++){   //for loop for every letter/char
           key[x][y] = words.get(i).charAt(ind); 
           x++;
         } 
      }
      for (int i =0; i <length; i ++){ //for loops searches for positions unoccupied by letters
         for (int ind =0; ind< width; ind++){
            if(key[ind][i] == 0){
               char t = (char) randomRange(97, 122); 
               key[ind][i] = t;
            }
         }
      }
   }
   //method for dictating the length of words for placement in the puzzle
   public static boolean key(int [ ] num, int lock) {
      for (int index = 0; index < num.length; index++){
         if (num[index] == lock ){ //if the key fits in the lock, then we are all good :)
            return true;
        }
     }
      return false;
  }
   
   //random char creator
   public static int randomRange(int min, int max){ 
      Random generator = new Random();
      return generator.nextInt(max-min+1) + min;
   } 
   //method for user input and menu navigation
   public static void userInput(){
      Scanner scan = new Scanner(System.in);
      wordC =0; 
      words= new ArrayList<String>(); 
      System.out.println("USER: PLEASE ENTER THE WORDS YOU WOULD LIKE IN THIS PUZZLE. ONLY ONE WORD PER LINE PLEASE." );
      System.out.println("WHEN USER HAS COMPLETED THIS TASK, ENTER THE WORD: run.");
      System.out.println("IF USER WOULD LIKE THE SOLUTION, ENTER WORD: solution");
      while (scan.hasNextLine()){
         input = scan.next(); 
         if(input.equals("run")){
            scan.close();
            break;
            }
         else if(input.equals("solution")){
            System.out.println("ADMIN MODE");
            System.out.println("The solution will always be verticaly lined, and will loop from the direct middle of the puzzle, from left to right, bottom to top");
            scan.close();
            break
            }
      wordC++;
      words.add(input);
      }
   }
   //this function 
   public static void size(){
      System.out.println("Generating word search");
      int i;
      for(i =0; i<words.size(); i++){
      if(words.get(i).length() > width){
         width = words.get(i).length();
         }
      }
      width = width *2; 
      length = width + (width/3);
      key = new char [width][length]; 
  }
   

}