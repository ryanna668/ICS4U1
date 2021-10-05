package general;

import java.util.Scanner;

public class WhileLoops {

	public static void main(String[] args) {

		int x = getInt();
		int y = getInt();

		System.out.println(x + y);
	}


	static int getInt() {
		Scanner keyb = new Scanner(System.in);
		int x = 0;
		
		while(true) {
			System.out.print("Enter an interger: ");

			if(keyb.hasNextInt()) {
				x = keyb.nextInt();
				break;
			}
			else {
				keyb.next(); //clear whatever was typed from the keyb buffer
				System.out.print("That was not an int. Type an int please: ");
			}
		}
		return x;
	}
}
