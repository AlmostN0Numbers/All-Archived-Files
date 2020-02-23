import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class fuckingaround {
   public static final DateFormat sdf = new SimpleDateFormat("MM/dd");
   public static void main(String[]args) {
      Date date = new Date();
      System.out.println(sdf.format(date));
   }

}