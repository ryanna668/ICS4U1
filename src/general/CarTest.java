package general;
public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car("Tesla");
		Car car2 = new Car ("Dodge", 5000);

		System.out.println(car1.toString());
		System.out.println(car2.toString());

		car1.drive(100);
		System.out.println(car1.toString());
		//car1.odometer = 1; //won't work because odometer is private

		//car2.make = "Porche"; // bad bad bad
		//fixed using "final"
	}

}
