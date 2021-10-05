package random;

public class CharDemo {

	public static void main(String[] args) {
		char letter = 'A';
		
		System.out.println(letter);
		letter++;
		System.out.println(letter);
		
		//make the alphabet
		for (int i = 0; i <26; i++)
		{
			char c = (char)(i+65);
			System.out.print(c);
		}
		
			letter = 'a';
			int n = letter;
			System.out.println(n);
	}

}
