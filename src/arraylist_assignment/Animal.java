package arraylist_assignment;

public class Animal {

	String name, type, colour;
	int legs;

	//constructor
	Animal(String name, String type, String colour, int legs) {
		this.name = name;
		this.type = type;
		this.colour = colour;
		this.legs  = legs;

	}
	public String toString() {
		String s = "Name: " + name +"\nType: " + type + "\nColour: " + colour + "\n# of Legs: " + legs;
		return s;
	}
}



