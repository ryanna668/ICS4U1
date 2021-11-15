package presentations;

public class EnumTest {

	enum Cards{
		DIAMONDS, HEARTS, SAPDES, CLUBS;
	}


	public static void main(String[] args) {
		for (Cards e:Cards.values()){
			System.out.println(e);
		}


	}

}

