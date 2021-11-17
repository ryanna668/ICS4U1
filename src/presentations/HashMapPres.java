package presentations;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapPres {

	public static void main(String[] args) {
		HashMap<Character, String> dictionary = new HashMap<Character, String>() {{

			put('h', "hij");
			put ('e', "e");
			put ('l', "lim");
			put ('o', "o");
		}};
		
		System.out.println("Type in a word: ");
		Scanner input = new Scanner(System.in);
			String word = input.nextLine();
			
			char letter;
			for (int i=0; i < word.length(); i++) {
				letter = word.charAt(i);
						System.out.print(dictionary.get(letter));
		
		
		}

	}
}

