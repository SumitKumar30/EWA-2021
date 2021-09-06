package JavaComparators;

public class Movies implements Comparable<Movies>{
	String movieName;
	double movieRating;
	int criticScore;
	
	Movies(String name, double rating, int score){
		this.movieName = name;
		this.movieRating = rating;
		this.criticScore = score;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}

	public int getCriticScore() {
		return criticScore;
	}

	public void setCriticScore(int criticScore) {
		this.criticScore = criticScore;
	}

	@Override
	public String toString() {
		return "Movies [movieName=" + movieName + ", movieRating=" + movieRating + ", criticScore=" + criticScore + "]";
	}
	
	
	// compare the movie object based on different criterias 
	public int compareTo(Movies obj) {
		if(this.getMovieRating() < obj.getMovieRating()) {
			return -1;
		}
		else 
			if(this.getMovieRating() > obj.getMovieRating()) {
				return 1;
			}
		else {
			return 0;
		}
		
	}
	
}
	