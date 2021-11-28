package dmoj;

import java.util.Scanner;

public class WhoHasSeenTheWind {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Numerical input
		int h = scanner.nextInt();
		int M = scanner.nextInt();
		//	    //Output input by user
		//	    System.out.println("h: " + h + " M: " + M);

		int A = 1;
		int t = 0;

		while(A>0 && t<=M) {
			t++;
			A = (int) (-6*Math.pow(t, 4) + h*Math.pow(t, 3) + 2*Math.pow(t, 2) + t);

		}

		if(A>0 || t>M) {
			System.out.print("The balloon does not touch ground in the given time.");
		}

		else {
			System.out.print("The balloon first touches ground at hour: \n"+ t);
		}
	}


}









