/*
 * Ryanna Luo
 * Jan 12 2022
 * ElevTest.java is a class which has the main() method. 
 * This class will create the elevators and make them do things.
 * The elevator can move up and down, add and remove people, power on and off...
 * 
 * 1. make two elevators, call them south and east. make east start on the 5th floor
 * 
 * 2. have 10 people get on south at the ground floor
 * 
 * 3. 3 get out on floor 4 and the rest get out on the top floor. 
 * 
 * 4. have 8 get into east on the 5th floor.
 * 
 * 5. try and add 30 more on the 8th floor
 * 
 * 6. try to go above the top floor; try to go to a negative floor
 * 
 * 7. move both elevators to the second floor. open the doors on east
 * 
 * 8. have a power failure
 * 
 * 9. then test to make sure that your elevators can't move or close or open doors
 * 
 * 10. restore the power (you should see a message)
 * 
 * 11. restore the power again (no message, the power is already on)
 * 
 * 12. make elevator south move up one floor at a time from the ground floor to floor 10, 
 * stopping on each floor and opening and closing doors
 * 
 */


package elevator;

public class ElevTest {

	public static void main(String[] args) {

		//1. make elevators (east starts on floor 5)
		Elevator south = new Elevator(1);
		Elevator east = new Elevator(5);

		//name elevators
		south.setElevatorName("South");
		east.setElevatorName("East");

		//1. print
		System.out.println("1");
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//2. have 10 people get on south at the ground floor
		south.openDoors();
		south.addPeople(10);
		south.closeDoors();

		//2. print
		System.out.println("2");
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//3. 3 get out on floor 4 and the rest get out on the top floor
		south.up(3); //go up to floor 4
		south.openDoors(); 
		south.removePeople(3); // 3 people leave
		south.closeDoors();

		//3. print
		System.out.println("3");
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//still on 3!
		south.up(15); //go to top floor (25)
		south.openDoors();
		south.removePeople(7); //everyone leaves
		south.closeDoors();

		//3. print
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//4. have 8 get into east on the 5th floor.
		east.openDoors();
		east.addPeople(8);
		east.closeDoors();

		//print
		System.out.println("4");
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//5. try and add 30 more on the 8th floor
		System.out.println("5");
		east.up(3);
		east.openDoors();
		east.addPeople(30);
		east.closeDoors();
		System.out.println("");

		//6. try to go above the top floor; try to go to a negative floor
		System.out.println("6");
		east.up(100);
		east.down(100);
		System.out.println("");

		//7. move both elevators to the second floor, open the doors on east
		east.goToFloor(2);
		south.goToFloor(2);
		east.openDoors();

		//7. print
		System.out.println("7");
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//8. have a power failure
		System.out.println("8");
		Elevator.setPowerState(false); 
		System.out.println("");

		//9. then test to make sure that your elevators can't move or close or open doors
		System.out.println("9");
		east.openDoors();
		east.closeDoors();
		east.up(9);
		south.openDoors();
		south.closeDoors();
		south.up(1);
		System.out.println("");

		//10. restore the power (you should see a message)
		System.out.println("10");
		Elevator.setPowerState(true);
		System.out.println("");

		//11.restore the power again (no message, the power is already on)
		System.out.println("11" + "\n");
		Elevator.setPowerState(true);


		//12. make elevator south move up one floor at a time from the ground floor to floor 10, 
		//stopping on each floor and opening and closing doors

		System.out.println("12");

		for(int x=1; x<=10; x++)	{
			south.goToFloor(x);
			south.openDoors();
			south.closeDoors();
			System.out.println(south.toString());
		}

	}

}
