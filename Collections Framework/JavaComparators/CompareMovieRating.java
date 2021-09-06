package JavaComparators;

import java.util.Comparator;

public class CompareMovieRating implements Comparator<Movies>{

	@Override
	public int compare(Movies m1, Movies m2) {
		// TODO Auto-generated method stub
		if(m1.getMovieRating() < m2.getMovieRating()) {
			return -1;
		}
		else if(m1.getMovieRating() > m2.getMovieRating()) {
			return 1;
		}
		else
			return 0;
	}

}
