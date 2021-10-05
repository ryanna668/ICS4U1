package general;
/* Ryanna Luo
 * 22/09/21
 * This program is for practicing printf 
 */
public class Printf {

	public static void main(String[] args) {
		String name = "Bessy";
		String colour = "brown";
		int weight = 1200;
		double num= (100000/7)/100000.0;

		System.out.printf("%.5f", num);
		System.out.println("");

		System.out.printf("The cow's name is %s. She is %s and weighs %d kg. %n", name, colour, weight);
		System.out.println("");

		int xx = 123;
		System.out.println("| 12345678 |");
		System.out.println("| ======== |");
		System.out.printf("| %8d |%n", xx);
		System.out.printf("| %08d |%n", xx);
		System.out.printf("| %+8d |%n", xx);
		System.out.printf("| %-8d |%n", xx);
		System.out.printf("| %8.1f |%n", (double)xx);
	}

}
