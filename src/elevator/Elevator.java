/*
 * Ryanna Luo
 * Dec 1, 2021
 * Elevator.java contains all of the properties and methods that create 
 * and control the elevator.
 */

package elevator;

class Elevator {
	private final static String MANUFACTURER = "Ryanna's Elevators";
	private final static int TOPFLOOR = 19;
	private final static int MAXOCCUPANTS = 25;

	static boolean powerOn = true; 

	private int floor = 1;
	private int people = 0;
	private boolean doorsOpen = false;
	private String name;


	//constructors

	Elevator(int floor){
		this.floor = floor;
	}


	static void setPowerState(boolean power){
		if(power!=powerOn) {

			if (powerOn) {
				System.out.println("Power: OFF");
				powerOn = false;
			}
			else {
				System.out.println("Power: ON");
				powerOn = true;
			}
		}

	}


	void elevator(String name){
		this.name = name;
	}


	void up (int n) {
		if(floor + n > TOPFLOOR) {
			System.out.println("Error: cannot go above top floor.");
			return;
		}
		if(!powerOn) {
			System.out.println("Error: power is not on");
			return;
		}
		if(doorsOpen) {
			System.out.println("Error: door is not closed");
			return;
		}
		floor +=n;
	}

	void down(int n) {
		if (floor - n < 0) {
			System.out.println("Error: cannot go below bottom floor.");
			return;
		}
		if(!powerOn) {
			System.out.println("Error: power is not on");
			return;
		}
		if(doorsOpen) {
			System.out.println("Error: door is not closed");
			return;
		}
		floor-=n;
	}

	//GO TO FLOOR N
	void goToFloor (int n) {
		if(n> TOPFLOOR) {
			System.out.println("Error: cannot go above top floor.");
			return;
		}
		if(n<0) {
			System.out.println("Error: cannot go below bottom floor.");
			return;
		}
		if(!powerOn) {
			System.out.println("Error: power is not on");
			return;
		}
		if(doorsOpen) {
			System.out.println("Error: door is not closed");
			return;
		}

		floor=n;
	}

	void openDoors(){
		if(!powerOn) {
			System.out.println("Error: power is not on");
			return;
		}
		doorsOpen = true;
	}

	void closeDoors() {
		if(!powerOn) {
			System.out.println("Error: power is not on");	
			return;
		}

		doorsOpen = false;
	}

	void addPeople(int n) {

		//make sure that doors are open
		if(!doorsOpen) {
			System.out.println("Error: doors are not open");	
			return;
		}

		//make sure people do not go above max capacity
		if(n+people > MAXOCCUPANTS) {
			System.out.println("Error: you cannot have that many people in the elevator");
			return;
		}
		//make sure n is positive
		if(n<0) {
			System.out.println("Error: floor number must be positive");	
			return;
		}

		people+=n;

	}
	void removePeople(int n) {

		//make sure that doors are open
		if(!doorsOpen) {
			System.out.println("Error: doors are not open");	
			return;
		}

		//make sure people do not go below 0
		if(n>people) {
			System.out.println("Error: you cannot have less than 0 people");
			return;
		}
		//make sure n is positive
		if(n<0) {
			System.out.println("Error: floor number must be positive");	
			return;
		}
		people-=n;
	}
	public String toString() {
		//the name, manufacturer, floor, number of people, and whether the doors are open or closed
		return "Name: " + name + "\t" 
		+ "Manufacturer: " + MANUFACTURER + "\t" 
		+ "Floor: " + floor + "\t" 
		+ "People: " + people  + "\t" 
		+ "Doors Opened: " + doorsOpen;


	}

}
