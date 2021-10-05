package general;

public class Movie {

	String title;
	int year = 2020; //default value
	int rating; //0-5

	//constructor
	Movie(String t, int y, int rating) {
		title = t;
		year = y;
		this.rating = rating;
		
		if (rating > 5 || rating < 0) rating = 1;
		this.rating = rating;
	}
}

