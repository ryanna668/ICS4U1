package general;

public class Modulus2 {

	public static void main(String[] args) {
		int [] num = new int [200];

		for(int i=13; i<num.length; i++) {
			num [i] = i+1;
			if (i%13==0) {
				System.out.print(i+" ");
			}
		}
	}
}
