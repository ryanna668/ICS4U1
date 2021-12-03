package elevator;

public class ElevTest {

	public static void main(String[] args) {

		//make elevators (east starts on floor 5)
		Elevator south = new Elevator(1);
		Elevator east = new Elevator(5);

		//name elevators
		south.elevator("South");
		east.elevator("East");

		//print
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//have 10 people get on south at the ground floor
		south.openDoors();
		south.addPeople(10);
		south.closeDoors();

		//print
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//3 get out on floor 4 and the rest get out on the top floor
		south.up(3); //go up to floor 4
		south.openDoors(); 
		south.removePeople(3); // 3 people leave

		//print
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		south.closeDoors();
		south.up(15); //go to top floor (25)
		south.openDoors();
		south.removePeople(7); //everyone leaves
		south.closeDoors();

		//print
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//have 8 get into east on the 5th floor.
		east.openDoors();
		east.addPeople(8);
		east.closeDoors();

		//print
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");

		//try and add 30 more on the 8th floor
		east.up(3);
		east.openDoors();
		east.addPeople(30);
		east.closeDoors();
		System.out.println("");

		//try to go above the top floor; try to go to a negative floor
		east.up(100);
		east.down(100);
		System.out.println("");

		//move both elevators to the second floor, open the doors on east
		east.goToFloor(2);
		south.goToFloor(2);
		east.openDoors();

		//print
		System.out.println(south.toString());
		System.out.println(east.toString());
		System.out.println("");
	
		//have a power failure
		Elevator.setPowerState(false);
		System.out.println("");
		
		//then test to make sure that your elevators can't move or close or open doors
		east.openDoors();
		east.closeDoors();
		east.up(9);
		south.openDoors();
		south.closeDoors();
		south.up(1);
		System.out.println("");
		
		//restore the power (you should see a message)
		Elevator.setPowerState(true);
		System.out.println("");
		
		//restore the power again (no message, the power is already on)
		Elevator.setPowerState(true);
		
		//make elevator south move up one floor at a time from the ground floor to floor 10, 
		//stopping on each floor and opening and closing doors
		for(int x=1; x<=10; x++)	{
			south.goToFloor(x);
			south.openDoors();
			south.closeDoors();
			System.out.println(south.toString());
		}


	}

}
