/*
 * Ryanna Luo
 * Jan 12 2022
 * This program will take a string and for each digit in the string, increment it by one. 9 becomes 0 instead of 10.
 */
package string_programs;

import java.util.Scanner;

public class Numbers {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);  // Create a Scanner object

		String input = "";
		System.out.println("Enter: ");
		input = scanner.nextLine();  // Read user input

		String newString = "";


		for (int x = 0; x < input.length(); x ++) {

			char thisCharacter = input.charAt(x);

			if(Character.isDigit(thisCharacter)==true) {

				if (thisCharacter == '9') {
					thisCharacter = '0';
				}	
				else{
					thisCharacter++;	
				}		
			}

			newString = newString+thisCharacter;

		}

		System.out.println(newString);  // Output new string
	}
}
