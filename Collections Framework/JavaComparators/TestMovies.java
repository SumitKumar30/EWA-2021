package JavaComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestMovies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		list.add("Godfather");
		list.add("The Dark Knight");
		list.add("The Dark Knight Rises");
		list.add("Shawshank Redemption");
		list.add("Inception");
		list.add("Joker");
		list.add("Interstaller");
		list.add("Parasite");
		
		// sort the movie names
		Collections.sort(list);
		
		System.out.println("List of sorted movie names: "+list);
		
		List<Double> list2 = new ArrayList<>();
		list2.add(9.5);
		list2.add(8.8);
		list2.add(8.4);
		list2.add(9.1);
		list2.add(8.9);
		list2.add(9.2);
		list2.add(8.5);
		list2.add(8.1);
		
		// sort the movie ratings
		Collections.sort(list2);
		System.out.println("List of sorted movie ratings:"+ list2);
		
		
		Movies movie1 = new Movies("Godfather", 9.5, 80);
		Movies movie2 = new Movies("The Dark Knight", 8.8, 90);
		Movies movie3 = new Movies("The Dark Knight Rises", 8.5, 70);
		Movies movie4 = new Movies("Inception", 8.9, 85);
		Movies movie5 = new Movies("Parasite", 8.2, 95);
		Movies movie6 = new Movies("Shawshank Redemption", 9.2, 78);
		Movies movie7 = new Movies("Joker", 8.6, 82);
		Movies movie8 = new Movies("Interstellar", 8.4, 74);
		
		
		List<Movies> movieList = new ArrayList<>();
		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);
		movieList.add(movie4);
		movieList.add(movie5);
		movieList.add(movie6);
		movieList.add(movie7);
		movieList.add(movie8);
		
		System.out.println("List of Movie Info: "+movieList);
		
		Collections.sort(movieList);
		
//		Collections.sort(movieList);
		
//		System.out.println("Movies sorted acc. to cirtics score...");
//		
//		Iterator<Movies> itr = movieList.iterator();
//		
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		CompareMovieName name = new CompareMovieName();
		CompareMovieRating rating = new CompareMovieRating();
		CompareMovieScore score = new CompareMovieScore();
		
		Collections.sort(movieList, name);
		
		System.out.println("Movies sorted according to names: "+movieList);
		
		Collections.sort(movieList, rating);
		
		System.out.println("Movies sorted according to ratings: "+movieList);
		
		Collections.sort(movieList, score);
		
		System.out.println("Movies sorted according to critics score: "+movieList);
	}

}
