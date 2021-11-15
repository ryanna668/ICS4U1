package presentations;

public class EnumTest2 {
	public enum Company{
		MCDONALDS(40), WEDNDYS(50), SUBWYA(60), BURGERKING(70), PIZZAHUT(8);
		
		int rank;
		Company(int rank){
			this.rank=rank;
		}
	}

	public static void main(String[] args) {
		for (Company name: Company.values()) {
			System.out.println("Company rank: " + name.rank + " Comapany name: " + name);
			System.out.println(name.ordinal());
			//System.out.println(name.valueOf("WENDYS"));
		}
	}

}
