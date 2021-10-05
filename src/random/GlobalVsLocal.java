package random;

public class GlobalVsLocal {
	
	static int x = 5;

	public static void main(String[] args) {
		//int x = 5;
		x ++;
		//printme(x, "yes", 99);
		printx();
		}
		
		//static void printme(int animal, String a, int z) {
		//System.out.println("***" + animal + a + z + "***");
	
		static void printx() {
		System.out.println(x);
		}


	}

// CTRL F11 -- run

