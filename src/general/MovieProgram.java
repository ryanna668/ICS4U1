package general;
import java.util.ArrayList;

public class MovieProgram {

	//global variables
	static ArrayList<Movie> movielist = new ArrayList<Movie>();

	public static void main(String[] args) {

		Movie m = new Movie("The Avengers", 2015, 5); // 'new' makes an object
		m.year = 2000; //should we be allowed to change the value?
		movielist.add(m);

		m = new Movie("Jurrasic park", 1997, 4);
		movielist.add(m);

		movielist.add (new Movie("Gone with the wind", 1937, 3));

		System.out.println(movielist.size());

		printList();
	}
	static void printList() {
		for (int i = 0; i < movielist.size(); i++) {
			Movie movie = movielist.get(i);

			System.out.println(movie.title + "\t" + "year: " + movie.year + " stars = " + movie.rating);
		}
	}
	static void printList2() {
		for (Movie movie : movielist) {
			System.out.println(movie.title + "\t" + "year: " + movie.year + " stars = " + movie.rating);
		}
	
	}

}
