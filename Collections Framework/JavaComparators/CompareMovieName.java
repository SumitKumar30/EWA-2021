package JavaComparators;

import java.util.Comparator;

public class CompareMovieName implements Comparator<Movies> {

	@Override
	public int compare(Movies m1, Movies m2) {
		// TODO Auto-generated method stub
		return m1.getMovieName().compareTo(m2.getMovieName());
	}
	
}
