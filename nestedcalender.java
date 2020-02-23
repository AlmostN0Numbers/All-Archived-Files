//Name: Reid Moirn
//Class:	CS140
//Assignment: Calender (Only with a For loop!)
//Purpose: Displays an ASCII Calender
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
public class nestedcalender {

   public static final int MAX = 5;
   public static final DateFormat sdf = new SimpleDateFormat("MM/dd");
   public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");

   public static void main(String[]args) {
      Scanner input = new Scanner(System.in);
      int statmonth = 1;
      int statday = 1;
      System.out.println("Welcome to Reid Morins nested calendar, please enter a command");
      System.out.println("1 to enter a date and display the corresponding calendar");
      System.out.println("2 to get todays date and display the today's calendar");
      System.out.println("3 to display the next month");
      System.out.println("4 to display the previous month");
      System.out.println("5 to quit the program");
      int choice = input.nextInt();
      String[] months = {
      " ",
      "January","Febuary","March",
      "Aril","May","June",
      "July","August","September",
      "October","November","December",
            };
      switch(choice){
         case 1:
            System.out.print("Enter The Month (in 1-12 format):  ");
            int getmonth = input.nextInt();
            System.out.print("Enter The Day (in 1-31 format):  ");
            int getday = input.nextInt();
            System.out.println("| MON | TUE | WEN | THR | FRI | SAT | SUN | ");
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
               int res = number;
               int next = 1;
               for (int a = 1; a <= MAX + 2; a++) { //Displays the border at the top
                  System.out.print("======");
   	         }
               System.out.println("==");
               for(int b = x + 1; b <= 1; b++) { //0 x values only
                  for(int q = y; q <= 7 ; q++){ //Dates 1-7
                     System.out.print ("| " + y);
                     y++;
                     for (int c = 1; c <= MAX - 2; c++){
                        System.out.print (" ");
                     }
                  }
                  for (int u = pk; u >= 1; u--){ //dates 8-14
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
               for (int newmo = y - 1; newmo <= next ; newmo++){
                   System.out.print (" ");
                  }         
               for(int end = y; y > 31; end++){
                  y = 1;
                  System.out.print ("   ");
                  }           
               res++;
               next++;
               int over = y - res;
               for (int c = over + 2; c >= MAX - 4; c--){
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
            System.out.println("DATE:   |"+ getday);
            System.out.println("1 to enter a date and display the corresponding calendar");
            System.out.println("2 to get todays date and display the today's calendar");
            System.out.println("3 to display the next month");
            System.out.println("4 to display the previous month");
            System.out.println("5 to quit the program");
            choice = input.nextInt();
         case 2:
            int cday = 11;
            int cmonth = 22;                                                                 //CASE 2{
            System.out.println("| MON | TUE | WEN | THR | FRI | SAT | SUN | ");
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
               int res = number;
               int next = 1;
               for (int a = 1; a <= MAX + 2; a++) { //Displays the border at the top
                  System.out.print("======");
   	         }
               System.out.println("==");
               for(int b = x + 1; b <= 1; b++) { //0 x values only
                  for(int q = y; q <= 7 ; q++){ //Dates 1-7
                     System.out.print ("| " + y);
                     y++;
                     for (int c = 1; c <= MAX - 2; c++){
                        System.out.print (" ");
                     }
                  }
                  for (int u = pk; u >= 1; u--){ //dates 8-14
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
               for (int newmo = y - 1; newmo <= next ; newmo++){
                   System.out.print (" ");
                  }         
               for(int end = y; y > 31; end++){
                  y = 1;
                  System.out.print ("   ");
                  }           
               res++;
               next++;
               int over = y - res;
               for (int c = over + 2; c >= MAX - 4; c--){
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
            System.out.println("TODAYS: |"+ months[cmonth] );                                                                                                                                                                                                                           
            System.out.println("DATE:   |"+ cday);
            System.out.println("1 to enter a date and display the corresponding calendar");
            System.out.println("2 to get todays date and display the today's calendar");
            System.out.println("3 to display the next month");
            System.out.println("4 to display the previous month");
            System.out.println("5 to quit the program");
            choice = input.nextInt();
           case 3:                                                                                    //CASE 3
            int fmonth = statmonth + 1;
            int fday = statday;
            String[] fmonths = {
            " ",
            "January","Febuary","March",
            "Aril","May","June",
            "July","August","September",
            "October","November","December",
            };
            System.out.println("| MON | TUE | WEN | THR | FRI | SAT | SUN | ");
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
               int res = number;
               int next = 1;
               for (int a = 1; a <= MAX + 2; a++) { //Displays the border at the top
                  System.out.print("======");
   	         }
               System.out.println("==");
               for(int b = x + 1; b <= 1; b++) { //0 x values only
                  for(int q = y; q <= 7 ; q++){ //Dates 1-7
                     System.out.print ("| " + y);
                     y++;
                     for (int c = 1; c <= MAX - 2; c++){
                        System.out.print (" ");
                     }
                  }
                  for (int u = pk; u >= 1; u--){ //dates 8-14
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
               for (int newmo = y - 1; newmo <= next ; newmo++){
                   System.out.print (" ");
                  }         
               for(int end = y; y > 31; end++){
                  y = 1;
                  System.out.print ("   ");
                  }           
               res++;
               next++;
               int over = y - res;
               for (int c = over + 2; c >= MAX - 4; c--){
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
            System.out.println("TODAYS: |"+ fmonths[fmonth] );                                                                                                                                                                                                                           
            System.out.println("DATE:   |"+ fday);
            System.out.println("1 to enter a date and display the corresponding calendar");
            System.out.println("2 to get todays date and display the today's calendar");
            System.out.println("3 to display the next month");
            System.out.println("4 to display the previous month");
            System.out.println("5 to quit the program");
            choice = input.nextInt();
         case 4:
            int bmonth = statmonth - 1;
            int bday = statday;
            String[] bmonths = {
            " ",
            "January","Febuary","March",
            "Aril","May","June",
            "July","August","September",
            "October","November","December",
            };
            System.out.println("| MON | TUE | WEN | THR | FRI | SAT | SUN | ");
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
               int res = number;
               int next = 1;
               for (int a = 1; a <= MAX + 2; a++) { //Displays the border at the top
                  System.out.print("======");
   	         }
               System.out.println("==");
               for(int b = x + 1; b <= 1; b++) { //0 x values only
                  for(int q = y; q <= 7 ; q++){ //Dates 1-7
                     System.out.print ("| " + y);
                     y++;
                     for (int c = 1; c <= MAX - 2; c++){
                        System.out.print (" ");
                     }
                  }
                  for (int u = pk; u >= 1; u--){ //dates 8-14
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
               for (int newmo = y - 1; newmo <= next ; newmo++){
                   System.out.print (" ");
                  }         
               for(int end = y; y > 31; end++){
                  y = 1;
                  System.out.print ("   ");
                  }           
               res++;
               next++;
               int over = y - res;
               for (int c = over + 2; c >= MAX - 4; c--){
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
            System.out.println("TODAYS: |"+ bmonths[bmonth] );                                                                                                                                                                                                                           
            System.out.println("DATE:   |"+ bday);
            System.out.println("1 to enter a date and display the corresponding calendar");
            System.out.println("2 to get todays date and display the today's calendar");
            System.out.println("3 to display the next month");
            System.out.println("4 to display the previous month");
            System.out.println("5 to quit the program");
            choice = input.nextInt();
         case 5:   
            System.out.println("That Input will now exit the program. Goodbye");
            System.exit(0);
            break;
         } 
      }
   }