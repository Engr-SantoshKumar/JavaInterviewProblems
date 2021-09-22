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
package PrepSetOne;
import java.util.*;

    class Movie{
        final char movieId;
        Float rating;
        final List<Movie> similarMovies;
        //constructor
        Movie(char movieId, Float rating) {
            this.movieId = movieId;
            this.rating = rating;
            similarMovies = new ArrayList<Movie>();
        }

        public void addSimilarMovies(Movie mov){
            similarMovies.add(mov);
            mov.similarMovies.add(this);
        }

        public List<Movie> getSimilarMovies() {
            return similarMovies;
        }
    }

public class _Goo_57_Movies_Rating_Suggestion {

    public static List<Character> getMovieRecommendation(Movie movie, int numTopRatedSimilarMovies){
        if(movie == null)
                return null;

        Set<Movie> visited = new HashSet<>();
        PriorityQueue<Movie> pq = new PriorityQueue<>((a,b) -> (b.rating.compareTo(a.rating)));

        List<Character> result = new ArrayList<>();

        pq = dfs(movie, visited, pq);

        while(!pq.isEmpty() && numTopRatedSimilarMovies >0){
            result.add(pq.poll().movieId);
            numTopRatedSimilarMovies--;
        }
        return result;
    }

    public static PriorityQueue<Movie> dfs(Movie givenMovie, Set<Movie> visited, PriorityQueue<Movie> pq){
        if(visited.contains(givenMovie))
            return pq;

        visited.add(givenMovie);
        List<Movie> similar = givenMovie.getSimilarMovies();
        for(Movie m : similar){
            if(!visited.contains(m)){
                pq.offer(m);
            }
            dfs(m, visited, pq);
        }
        return pq;
    }

    public static void main(String args[]) {
        Movie a = new Movie('A', 1.2F);
        Movie b = new Movie('B', 2.4F);
        Movie c = new Movie('C', 5.6F);
        Movie d = new Movie('D', 4.2F);
        Movie e = new Movie('E', 4.0F);
/**
 * eg:            A(Rating 1.2)
                /   \
            B(2.4)   C(5.6)
            /         \
          D(4.2)<----- E(4.0)

*/
        a.addSimilarMovies(b);
        a.addSimilarMovies(c);
        b.addSimilarMovies(d);
        c.addSimilarMovies(e);

        List<Character> similar = getMovieRecommendation(a, 2);
        for (char s : similar) {
            System.out.println(s);
        }
    }
}

