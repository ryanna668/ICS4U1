package string_programs;

import java.util.Scanner;

public class RandomWord {
	
	static char[] vowels = new char[] {'a','e','i','o','u'};

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("How many words would you like? ");
		int inputNum = scanner.nextInt();
		
		//runs as many times as the person wants
		for(int i = 1; i <= inputNum; i++)
		{
			System.out.println("#" + i + ") " + makeWord());
		}
	}
	
	static String makeWord(){
		//grab either one or two vowels
		int vowelCount = (int) (Math.random() * 2) + 1;
		String word = "";
		//loop to create random letters that arent vowels
		for(int i = 0; i < 6 - vowelCount; i++)
		{
			while(true)
			{
				char letter = (char) ('a'+(int) (Math.random() * 26));
				//if the letter isnt a vowel: add to the word and then break. 
				if(!isVowel(letter))
				{
					word += letter;
					break;
				}
			}
		}
		//add our vowels in random places
		while(word.length() < 6)
		{
			int index = (int) (Math.random() * 5);
			char vowel = vowels[(int) (Math.random() * 5)];
			//split the string and shove our vowel in at a random position
			word = word.substring(0,index) + vowel + word.substring(index, word.length());
		}
		return word;
	}
		
	static boolean isVowel(char c) {
		for(char v: vowels)
		{
			if(c == v)
				return true;
		}
		return false;
	}
}