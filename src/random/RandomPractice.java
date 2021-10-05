package random;

import java.util.Arrays;

public class RandomPractice {

	static int[] marks = {5,11,15,0,10,9,18};

	public static void main(String[] args) {

		System.out.println(Arrays.toString(marks));

		rotate();
		rotate();
	}

	//method
	static void rotate(){
		int temp = marks[0];

		for(int i=0; i<6; i++){
			marks[i]=marks[i+1];
		}

		marks[6]=temp;

		System.out.println(Arrays.toString(marks));
	}
}



