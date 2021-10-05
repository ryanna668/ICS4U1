package general;

public class Modulus3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] num = new int [200];
		for (int i=1; i<num.length; i++) {
			num [i] = i;
			if (i%12!=0) {
				System.out.printf("%4d", num[i]);
			}
			if (i%12==0) {
				System.out.printf("%4d%n", num[i]);
			}

		}

	}

}
