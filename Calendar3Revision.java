//Name: Reid Moirn
//Class:	CS140
//Assignment: Calender Revision 3
//Purpose: Displays an ASCII Calender


import java.io.*;
import java.util.*;

public class Calendar3Revision{
   public static final int SIZE = 12;
   public static final int MAX_DAYS_IN_CAL = 31;
   public static String[] [] eventArray;
   public static void main (String[] args) throws FileNotFoundException{
      Scanner console = new Scanner (System.in); 
      intro(); 
      String options = input(console);
      int month = -1;
      int day = -1; 
      loadEventsFromFile ("calendarEvents.txt"); 
      while (!options.equals("q")){ 
         if(options.equals ("e")){
            System.out.println("Please type Date: ");
            String date = console.nextLine();
            month = monthFromDate(date);
            day = dayFromDate (date); 
            drawMonth (month, day); 
            displayDate (month, day); 
            System.out.println (); 
        }   else if (options.equals("ev")){
            System.out.println ("Please type in the date followed by the event (mm/dd event)");
            String dateOfEvent = console.next();
            String event = console.next();
            month = monthFromDate (dateOfEvent);
            day = dayFromDate (dateOfEvent); 
            eventArray [month-1] [day-1] = event;
         }
         else if (options.equals ("t")){
            String calDate = getCalDate();
            month = monthFromDate(calDate); 
            day = dayFromDate(calDate); 
            drawMonth(month, day); 
            displayDate(month, day) ;
            System.out.println();
         }  else if (options.equals ("n")){
               if (month == -1){
               System.out.println ("ERROR! ERROR! PLEASE PRESS \"e\" TO ENTER DATE! !");
           }   else if (month == 12){
               month = 1; 
          }    else{ 
               month++; 
          }
           drawMonth (month, day); 
           displayDate (month, day);
           System.out.println ();
          }   else if (options.equals("p")){ 
              if (month == -1){
               System.out.println("ERROR! ERROR! PLEASE PRESS\"e\" TOo ENTER DATE!!");
           }   else if (month == 1){ 
               month = 12; 
           }   else{ 
               month--; 
           }   
           drawMonth (month, day); 
           displayDate (month, day);
           System.out.println (); 
       }   else { 
           System.out.println("ERROR! ERROR! PLEASE TYPE APPROPRIATE COMMAND! !");
              System.out.println(); 
           }
           options = input(console); 
       }
    }
    public static void intro(){ 
       System.out.println ("Welcome to my Calendar program!!"); 
       System.out.println ("The program will display the different options, "); 
       System.out.println ("and pick the date you have chosen."); 
       System.out.println ("Please pick your options:"); 
       }
       public static String input (Scanner console){ 
          System.out.println ("\"e\" to enter a date and dislay the corresponding calendar");
          System.out.println("\"ev\" to enter an event."); 
          System.out.println ("\"fp\" to print calendar to file"); 
          System.out.println("\"t\" to get today's date and to display todays calendar"); 
          System.out.println ("\"n\" to display next month"); 
          System.out.println ("\"p\" to previous month");
          System.out.println("\"q\" to quit program"); 
          String x = console.nextLine(); 
          return x.toLowerCase (); 
       }  
       public static String getCalDate (){
          String x = ""; 
          Calendar cal = Calendar.getInstance(); 
          x += cal.get(Calendar.MONTH) + 1; 
          x += "/" + cal.get (Calendar. DATE); 
          return x; 
       } 
       public static void drawMonth (int month, int day){ 
          int startingDay = mstartDay(month); 
          int maxDaysInMonth = mDaysInMonth (month); 
          for (int space = 1; space <= SIZE * 7 / 2 - 1; space++){
          System.out.print(" "); 
          }
          System.out.print(" " + month); 
          for(int i = 0; i < 7; i++) {
             for (int j = 0; j < SIZE / 2 - 2; j++) { 
                System.out.print(" "); 
            }   if(i == 0){ 
                   System.out.print ("SUN"); 
              } else if(i == 1){
                   System.out.print ("MON");
              } else if(i == 2){ 
                   System.out.print ("TUE"); 
              } else if(i == 3){
                   System.out.print ("WED"); 
              } else if(i == 4){
                   System.out.print("THU"); 
              } else if(i == 5){
                   System.out.print ("FRI"); 
              } else if(i == 6){
                   System.out.print ("SAT");
              } 
              for (int j = 0; j < SIZE / 2 - 1; j++) { 
                 System.out.print(" "); 
              }
           }
           System.out.println(); 
           int row = 0; 
           while (row * 7 - startingDay + 2 <= maxDaysInMonth){ 
           drawRow (row, startingDay, maxDaysInMonth, day, month); 
           row++; 
           }
           equal (); 
           System.out.println (); 
        }
        public static void drawRow (int row, int startingDay, int maxDaysInMonth,int day, int month){ 
           equal(); 
           System.out.println (); 
           System.out.print("|"); 
           if (row == 0){  
              int noRow = 1; 
              for (int i = 0; i < 7 - (7 - startingDay + 1); i++) { 
                 for (int k = 0; k < SIZE- 1; k++){ 
                    System.out.print(" "); 
                 }
                 System.out.print("|"); 
              }
              for (int j = 0; j < 7 - startingDay + 1; j++) { 
                 System.out.print(" " + noRow +"  "); 
                 int numLength = (noRow + "").length(); 
                 for (int k = 0; k < SIZE - numLength - 3; k++) { 
                    if(noRow == day) { 
                       System.out.print("*"); 
                }   else { 
                       System.out.print(" "); 
                }
            }
            System.out.print("|"); 
            noRow++;  
         }
      }  else {
           int noRow = row * 7 - startingDay + 2; 
           for (int no = 1; no <= 7; no++){ 
              int numLength = 0; 
              if (noRow <= maxDaysInMonth){ 
                 System.out.print (noRow); 
                 numLength = (noRow + "").length(); 
            }  else {
               numLength = 0; 
            }  for (int i = 0; i < SIZE - numLength - 1; i++) {
                  if (noRow == day && noRow <= maxDaysInMonth) { 
                     System.out.print("*"); 
              }   else {
                  System.out.print(" "); 
              }
           }
           System.out.print("|"); 
           noRow++; 
        }
    }
     System.out.println(); 
     for (int line = 1; line <= SIZE / 3; line++){
        System.out.print("|"); 
        for (int bar = 1; bar <= 7; bar++){ 
           for (int space = 1; space <= SIZE - 1; space++){ 
              System.out.print(" "); 
           }
           System.out.print("|"); 
        }
        System.out.println(); 
     }
   }
      public static void equal(){ 
         for (int equal = 1; equal <= SIZE * 7; equal++){ 
            System.out.print("="); 
         }
      }   
      public static int monthFromDate (String date){ 
         String x = date.substring (0, date. indexOf("/")); 
         return Integer.parseInt(x); 
      }
      public static int dayFromDate (String date){ 
         String x = date.substring ((date.indexOf ("/")+1)); 
         return Integer.parseInt (x); 
      }
      public static void displayDate (int month, int day){ 
         System.out.println ("Month: " + month); 
         System.out.println ("Day: " + day); 
      }
      public static int mDaysInMonth (int month) { 
         if (month == 4 || month == 6 || month == 9 || month == 11){ 
            return 30;
         }  else if (month == 2){  
               return 28; 
         }  else {
               return 31; 
         }
      }
      public static int mstartDay (int month){ 
         int day = 2; 
         for (int i = 1; i < month; i++) {
            day = (day + mDaysInMonth (i) % 7) % 7; 
         }
         if (day == 0){ 
            day = 7; 
         }
         return day; 
         }
         public static void loadEventsFromFile (String filename) throws FileNotFoundException { 
            eventArray = new String [12][]; 
            for(int i = 0; i < 12; i++){ 
               eventArray[i] = new String[mDaysInMonth (i)]; 
            }
            Scanner input = new Scanner (new File (filename)); 
            while (input.hasNext()){
               String date = input.next(); 
               String event = input.next(); 
               int day = dayFromDate (date); 
               int month = monthFromDate (date); 
               eventArray [month - 1] [day - 1] = event; 
               }
            }
         }