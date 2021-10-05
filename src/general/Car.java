package general;
class Car{

	// -- instance variables --
	final String make; //final = once set cannot be changed
	private int odometer = 12; //all cars have gone this far (12km)

	// -- constructor -- 
	Car(String make, int odo){
		this.make = make;
		odometer = odo;
	}

	Car(String make){
		this.make = make;
	}

	//prevent anyone from accessing this
	private Car(){
		make = "unknown";
	}

	void drive(int distance) {
		this.odometer += Math.abs(distance);
	}

	int getOdometer() {return odometer;}

	void setOdometer (int n) {
		//check for master password
		// then reset odometer to n
	}

	@Override
	public String toString () {

		//return on line
		String s = "Make: " + make + "\tOdometer: " + odometer;
		return s;
	}
}


