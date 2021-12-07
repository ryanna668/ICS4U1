package general;

import java.util.Arrays;
import java.io.*;

public class SortA {

	public static void main(String[] args) throws IOException {
		DataInputStream input = new DataInputStream(System.in);
		
		int num[] = new int [4]; //global variables
		int hold=0;

		for (int i=0; i<num.length; i++) {
			num[i] = Integer.parseInt(input.readLine());
		}


		for (int i = 0; i < num.length - 1; i++) {
			for(int k = 0; k < num.length - 1; k++) {
				if (num[k] > num[k + 1]) {

					hold = num[k];
					num[k] = num[k + 1];
					num[k + 1]= hold;
				}
			}
		}
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + ", ");
		}
	}
}



