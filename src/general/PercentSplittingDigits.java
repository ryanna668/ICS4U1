package general;
import java.io.*;
public class PercentSplittingDigits {

	public static void main(String[] args) throws IOException{
		DataInputStream input= new DataInputStream (System.in);
		
		int num, first, second;
		
		System.out.print("Enter a two digit number: ");
		num = Integer.parseInt(input.readLine());
		
		if( num >= 10 && num<100) {
			first = num/10 ;
			second = num%10;
			
			System.out.println("Your number is " + num);
			System.out.println("The first digit is: " + first);
			System.out.println("The second digit is: " + second);
			
			
			}
			
			
			
		}
	}



