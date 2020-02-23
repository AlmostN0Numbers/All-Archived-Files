//Name: Reid Moirn
//Class:	CS140
//Assignment: Calender (Only with a For loop!)
//Purpose: Displays an ASCII Calender
import java.util.Scanner;
public class calendarpart1 {

   public static final int MAX = 5;
   
   public static void main(String[]args) {
      drawMonth();
   }
   public static void drawMonth() {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter The Month (in 1-12 format):  ");
      int getmonth = input.nextInt();
      System.out.print("Enter The Day (in 1-31 format):  ");
      int day = input.nextInt();
      String[] months = {
         " ",
         "January","Febuary","March",
         "Aril","May","June",
         "July","August","September",
         "October","November","December",
      };
	   for (int drawRow = MAX; drawRow >= 1; drawRow--) {  
         int x = 1;
         int number = 1;
         int g = 1;
         number = (MAX - drawRow) * 7;    //A WHOLE lot of math
         int y = number + 1;
         g = (number / 7);
         int multi = g - 1;
         multi = multi < 0? 0 : multi;
         x = multi * 7;         
         int psi = (drawRow - 3) * 7;
         psi = psi < 0? 0 : psi;
         int pk = g * 7;
         for (int a = 1; a <= MAX + 2; a++) { //Displays the border at the top
            System.out.print("======");
   	   }
         System.out.println("==");
         for(int b = x + 1; b <= 1; b++) { //0 x values only
            for(int q = y; q <= 7 ; q++){ //Dates 1-7
               System.out.print ("|0" + y);
               y++;
               for (int c = 1; c <= MAX - 2; c++){
                  System.out.print (" ");
               }
            }
            for (int u = pk; u >= 1; u--){ //dates 8-114
               System.out.print ("|" + y);
               y++;
               for (int z = 1; z <= MAX - 2; z++){
                  System.out.print (" ");
                  }
               for (int bs = y; bs <= 10; bs++){
                  System.out.print (" ");
                  bs = bs + 2;
                  }
               }    
            }                
         for(int o = psi + 1; o <= 7; o++){ //multiple char dates 15-35
         System.out.print ("|" + y);
         y++;
         for (int c = 1; c <= MAX - 2; c++){
            System.out.print (" ");
            }   
         }  
         System.out.println ("|"); //Null value of 3rd row
         for(int d = 1; d <= MAX + 2; d++){
            System.out.print ("| ");
            for(int e = 1; e <= MAX - 3; e++){
                System.out.print ("  ");
            } 
         }
         System.out.println ("|");
   	   }   
      System.out.println("============================================");
      System.out.println("TODAYS: |"+ months[getmonth] );                                                                                                                                                                                                                           
      System.out.println("DATE:   |"+ day);
   }
}