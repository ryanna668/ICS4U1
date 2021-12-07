package general;
/*
 * Ryanna Luo 
 * 21/09/2021
 * This program makes an int array of size 25, fills it with random numbers that range from 1 to 1000,
 * prints out the whole array, sorts the array from smallest to largest, then prints out the array after it is sorted.
*/

import java.util.Arrays;

public class Sorting1 {
	static int [] num = new int [25]; //global variables
	static int hold=0;

	public static void main(String[] args) {

		printarray();

		//sort();
		
		ameliaSort();

		printsorted();

	}
	//main end

	//methods
	static void printarray() {
		for (int i=0; i<num.length; i++)
		{
			num[i] = (int) (Math.random()*1000 + 1);
		}

		System.out.println(Arrays.toString(num));
	}

	static void sort() {
		for (int i=0; i < num.length; i++) {
			for(int k=0; k < i; k++) {
				if (num[k] > num[i]) {

					hold = num[i];
					num[i] = num[k];
					num[k]= hold;
				}
			}
		}
	}
	
	static void ameliaSort () {
		for (int i = 0; i < num.length - 1; i++) {
			for(int k = 0; k < num.length - 1; k++) {
				if (num[k] > num[k + 1]) {

					hold = num[k];
					num[k] = num[k + 1];
					num[k + 1]= hold;
				}
			}
		}
	}
	
	static void sort2() {
		for (int i=0; i<num.length; i++) {
			for(int k=0; k<i; k++) {
				if (num[k] > num[i]) {

					hold = num[i];
					num[i] = num[k];
					num[k]= hold;
				}
			}
		}
	}	

	static void printsorted() {
		System.out.println(Arrays.toString(num));
	}

}





