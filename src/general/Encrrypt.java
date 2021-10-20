package general;

import java.util.Scanner;

public class Encrrypt {

	private static final int OFFSET = 3;

	public static void main(String[] args) {
		String plaintext = getInput();
		plaintext = cleanText(plaintext);
		String cyphertext = encrypt(plaintext);
		output(cyphertext);

	}//end of main method

	static String getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your secret messege: ");
		String s= scan.nextLine();
		return s;

	}
	static String encrypt (String text) {
		String encoded ="";
		text = text.toUpperCase();

		for(int i = 0; i<text.length(); i++) {
			//grab each letter
			char c = text.charAt(i);


			c=(char)(c + OFFSET);

			//don't get numbers
			if (c>'Z')c-=26;
			encoded += c;
			continue;
		}
		return encoded;
	}

	static void output(String s) {
		System.out.println("Encoded messege follows: ");
		for (int i = 0; i<s.length(); i++) {

			//char c = s.charAt(i);
			System.out.print(s.charAt(i));

			//every 5 letters print a space
			if((i+1)%5==0) System.out.print(" ");;
		}

	}
	//remove punctuation in spaces
	static String cleanText(String s) {
		s = s.toUpperCase();
		String newstr = "";
		for (int i = 0; i <s.length(); i++) {
			char c = s.charAt(i);
			if (c>='A' && c<= 'Z') newstr = newstr + c;		
		}
		return newstr;
	}
}
