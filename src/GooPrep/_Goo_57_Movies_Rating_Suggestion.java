/** 57  [Movies Rating Suggestion]
 ________________________________________________________________________________________________________________
  Implement a function to return top rated movies in the network of movies
  reachable from the current movie

  eg:             A(Rating 1.2)
                /   \
             B(2.4)  C(3.6)
               \     /
                 D(4.8)

  In the above example edges represent similarity and the number is rating.
  getMovieRecommendations(A,2) should return C and D (sorting order doesn't matter so it can also return D and C)
  getMovieRecommendations(A,4) should return A, B, C, D (it can also return these in any order eg: B,C,D,A)
  getMovieRecommendations(A,1) should return D. Note distance from A to D doesn't matter, return the highest rated.
 */
package GooPrep;
import java.util.*;

    class Movie{
        final int movieId;
        Float rating;
        final List<Movie> similarMovies;

        Movie(int movieId, Float rating) {
            this.movieId = movieId;
            this.rating = rating;
            similarMovies = new ArrayList<Movie>();
        }

        public void addSimilarMovies(Movie movie){
            similarMovies.add(movie);
            movie.similarMovies.add(this);
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }

public class _Goo_57_Movies_Rating_Suggestion {

    public static List<Integer> getMovieRecommendation(Movie movie, int numTopRatedSimilarMovies){
        if(movie == null)
                return null;

        Set<Movie> visited = new HashSet<>();
        PriorityQueue<Movie> pq = new PriorityQueue<>(new Comparator<Movie>() {
            @Override
            public int compare(Movie a, Movie b) {
                return b.rating.compareTo(a.rating);
            }
        });

        List<Integer> result = new ArrayList<>();

        dfs(movie, visited, pq);

        while(!pq.isEmpty() && numTopRatedSimilarMovies >0){
            result.add(pq.poll().movieId);
            numTopRatedSimilarMovies--;
        }
        return result;
    }

    public static void dfs(Movie givenMovie, Set<Movie> visited, PriorityQueue<Movie> pq){
        if(visited.contains(givenMovie))
            return;

        visited.add(givenMovie);
        List<Movie> similar = givenMovie.getSimilarMovies();
        for(Movie m : similar){
            if(!visited.contains(m)){
                pq.offer(m);
            }
            dfs(m, visited, pq);
        }
    }

    public static void main(String args[]) {
        Movie a = new Movie(1, 1.2F);
        Movie b = new Movie(2, 2.4F);
        Movie c = new Movie(3, 3.6F);
        Movie d = new Movie(4, 4.2F);
        Movie e = new Movie(5, 4.3F);
/**
 * eg:            A(Rating 1.2)
                /   \
            B(2.4)   C(3.6)
            /         \
          D(4.2)<----- E(4.3)

*/
        a.addSimilarMovies(b);
        a.addSimilarMovies(c);
        b.addSimilarMovies(d);
        c.addSimilarMovies(e);

        List<Integer> similar = getMovieRecommendation(a, 2);
        for (Integer s : similar) {
            System.out.println(s);
        }
    }
}

