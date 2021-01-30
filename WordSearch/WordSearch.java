//Name: Reid Moirn
//Class:	CS145
//Assignment: Project 1: Word Search Generator
import java.util.*;
import java.io.*;  

public class WordSearch{
   private char[][] y;
   private boolean[][] PSI;
   private String[] userWords;

   //recieves paamater then creates a word search from given array
    public void create(String[] wor){
      for(int i = 0 ; i < wor.length ; i++){
         wor[i] = wor[i].toLowerCase();
      }
      this.userWords = wor;
      char[][] userChars = genPuzzle();
      for(int i = 0 ; i < userChars.length ; i++){
         arngeUserWord(userChars, i);
      }
      randomGenGrid();
   }

   public String toString(){
      String result = "";
      for(int i = 0 ; i < y.length ; i++){
         for(int x = 0 ; x < y[i].length ; x++){
            result += " " + y[i][x] + " ";
         }
         result += "\r\n";
      }
      return result;
   }
   public String toSolution(){
   String result = "";
      for(int i = 0 ; i < y.length ; i++){
         for(int x = 0 ; x < y[i].length ; x++){
            if(PSI[i][x]){
               result += " " + y[i][x] + " ";
            }
            else{
               result += " X ";//places an x where non user words aren't at
            }
         }
         result += "\r\n";
      }
      return result;
   }
   //places a word in grid after the direction; then finds the appropriate place
   private void arngeUserWord(char[][] userChars, int iter){
      Random rand = new Random();
      int direction = rand.nextInt(3);
      int[] pos = {0,0};
      if(direction == 0){ //horizontal (vertical and diagonal are copy pastes of most of this)
         boolean placed = false;
         int tries = 0;
         while(!placed && tries < 100){
            pos[0] = rand.nextInt((y.length-1) - userChars[iter].length);
            pos[1] = rand.nextInt((y.length-1) - userChars[iter].length);
            placed = true;
            //fills the grid of random letters where there isnt user words
            for(int u = 0 ; u < userChars[iter].length ; u++){
               if(y[pos[0] + u][pos[1]] != '\u0000' && y[pos[0] + u][pos[1]] != userChars[iter][u]){//math unique to each direction
                  placed = false;
                  break;
               }
            }
            tries++;
         }
         if(placed){
            for(int x = 0 ; x < userChars[iter].length ; x++){
               y[pos[0]][pos[1]] = userChars[iter][x];
               PSI[pos[0]][pos[1]] = true;//continuatioun of math unique to each direction
               pos[0]++;
            }
         }
      }
      else if(direction == 1){ //vertical
         boolean placed = false;
         int tries = 0;
         while(!placed && tries < 100){
            pos[0] = rand.nextInt((y.length-1) - userChars[iter].length);
            pos[1] = rand.nextInt((y.length-1) - userChars[iter].length);
            placed = true;
            for(int u = 0 ; u < userChars[iter].length ; u++){
               if(y[pos[0]][pos[1] + u] != '\u0000' && y[pos[0]][pos[1] + u] != userChars[iter][u]){
                  placed = false;
                  break;
               }
            }
            tries++;
         }
         if(placed){
            for(int x = 0 ; x < userChars[iter].length ; x++){
               y[pos[0]][pos[1]] = userChars[iter][x];
               PSI[pos[0]][pos[1]] = true;
               pos[1]++;
            }
         }
      }
      else if(direction == 2){ //diagonal
         boolean placed = false;
         int tries = 0;
         while(!placed && tries < 100){
            pos[0] = rand.nextInt((y.length-1) - userChars[iter].length);
            pos[1] = rand.nextInt((y.length-1) - userChars[iter].length);
            placed = true;
            for(int u = 0 ; u < userChars[iter].length ; u++){
               if(y[pos[0] + u][pos[1] + u] != '\u0000' && y[pos[0] + u][pos[1] + u] != userChars[iter][u]){
                  placed = false;
                  break;
               }
            }
            tries++;
         }
         if(placed){
            for(int x = 0 ; x < userChars[iter].length ; x++){
               y[pos[0]][pos[1]] = userChars[iter][x];
               PSI[pos[0]][pos[1]] = true;
               pos[1]++;
               pos[0]++;
            }
         }
      }
   }
//dissasembles string array into a char,  then generates grid from userWords length and numbers
   private char[][] genPuzzle(){
      char[][] userChars = new char[userWords.length][];
      int longest = 8;
      for(int i = 0 ; i < userWords.length ; i++){
         userChars[i] = userWords[i].toCharArray();
         if(userChars[i].length > longest){
            longest = userChars[i].length;
         }
      }
      if(userWords.length > longest){
         longest = userWords.length;
      }
      this.y = new char[longest + 4][longest + 4];
      this.PSI = new boolean[longest + 4][longest + 4];
      return userChars;
   }

//fills empty parts of the grid with random gibberish where void spaces are present
   private void randomGenGrid(){
      for(int i = 0 ; i < y.length ; i++){
         for(int x = 0 ; x < y[i].length ; x++){
            Random rand = new Random();
            if(y[i][x] == '\u0000'){
               y[i][x] = (char)(rand.nextInt(26)+97);
            }
         }
      }
   }
   public void print(String[][] x){
      for(int i = 0 ; i < x.length; i++){
         for(int j = 0 ; j < x[i].length ; j++){
            System.out.println(x[i][j]);
            }
         }
      }
}