package general;
import java.io.*;
import java.util.Arrays;
public class WeirdSplittingDigits {

	public static void main(String[] args) throws IOException{
		DataInputStream input= new DataInputStream (System.in);
		
		int num, first, second;
		
		System.out.print("Enter a two digit number: ");
		num = Integer.parseInt(input.readLine());
		
		if( num >= 10 && num<100) {
			
			String num1 = String.valueOf(num);
			
			char[] digits1 = num1.toCharArray();
					
			System.out.println("The first digit is " + digits1[0]);
			System.out.println("The second digit is " + digits1[1]);
			}
		
		}
		}
	


