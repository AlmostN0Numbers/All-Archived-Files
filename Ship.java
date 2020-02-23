//Name: Reid Moirn
//Class:	CS140
//Assignment: Lab	2
//Purpose: Displays a Rocket Ship

public class Ship	{
      public static final int SET = 3;
      //this sets an int to be a static size
      public static void main(String[]args) {
         cone();
         sub();
         bodytop();
         bodybot();
         sub();
         bodybot();
         bodytop();
         sub();
         cone();
      }
      //main prints out listed loops in order to make a ship
      public static void cone() {
         for (int i = 1; i <= (SET * 2 - 1) - i; i++) {
            System.out.print(" ");
            for (int j = 1; j <= (SET * 2 - 1) - i; j++){
				System.out.print(" ");
			}
			for (int n = 1; n <= i; n++) {
				System.out.print("/");
			}
			System.out.print("**");
			for (int n = 1; n <= i; n++) {
				System.out.print("\\");
			}
			System.out.println(" ");
		}
	}
	//cone loop set
	public static void sub() {
		System.out.print("+");
		for (int i = 1; i <= SET * 2; i++) {
			System.out.print("=*");
		}
		System.out.println("+");
	}
	//sub is between any cone loop
	public static void bodytop() {
		for (int i = 1; i <= SET; i++) {
			System.out.print("|");
			for (int a = 1; a <= 2; a++) {
				for (int j = 1; j <= SET - i; j++) {
					System.out.print(".");
				}
				for (int n = 1; n <= i; n++) {
					System.out.print("/\\");
				}
				for (int j = 1; j <= SET - i; j++) {
					System.out.print(".");
				}
			}
			System.out.println("|");
		}
	}
	//bodytop and body bodybot are inverse 
	public static void bodybot() {
		for (int i = SET; i >= 1; i--) {
			System.out.print("|");
			for (int a = 1; a <= 2; a++) {
				for (int j = 1; j <= SET - i; j++) {
					System.out.print(".");
				}
				for (int n = 1; n <= i; n++) {
					System.out.print("\\/");
				}
				for (int j = 1; j <= SET - i; j++) {
					System.out.print(".");
				}
			}
			System.out.println("|");
		}
	}
}