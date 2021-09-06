package JavaComparators;

import java.util.Comparator;

public class CompareMovieScore implements Comparator<Movies>{

	@Override
	public int compare(Movies m1, Movies m2) {
		// TODO Auto-generated method stub
		if(m1.getCriticScore() < m2.getCriticScore()) {
			return -1;
		}
		else if(m1.getCriticScore() > m2.getCriticScore()) {
			return 1;
		}
		else
			return 0;
	}

}
