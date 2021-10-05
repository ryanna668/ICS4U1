package arraylist_assignment;
/* Ryanna Luo
 * 22/09/21
 * This program makes an arraylist, prints it, deletes some items (animals with 4 legs), prints it, 
 * deletes the first one and then prints out the list again.
 */

import java.util.ArrayList;

public class AnimalsList {

	static ArrayList<Animal> animalslist = new ArrayList<Animal>();

	public static void main(String[] args) {

		animalslist.add (new Animal("Dog", "Mammal", "Brown", 4));
		animalslist.add (new Animal("Lizard", "Reptile", "Green", 4));
		animalslist.add (new Animal("Salmon", "Fish", "Pink", 0));
		animalslist.add (new Animal("Human", "Mammal", "Varying", 2));
		animalslist.add (new Animal("Cardinal", "Bird", "Red", 2));

		//System.out.println(animalslist.size());

		System.out.println("---All Animals---\n");
		printList();

		delete4();
		printList();

		delete1();
		printList();
	}

	//methods
	static void printList() {
		for (Animal animal : animalslist) {
			System.out.println(animal + "\n");
		}
	}
	static void delete4() {
		System.out.println("---Deleted all animals with 4 legs---\n");
		for (int i = 0; i < animalslist.size(); i++) {
			Animal animal = animalslist.get(i);	
			if (animal.legs == 4) {
				animalslist.remove(i);
				i--;
			}
		}
	}

	static void delete1() {
		System.out.println("---Deleted first animal---\n");
		animalslist.remove(0);
	}
}



