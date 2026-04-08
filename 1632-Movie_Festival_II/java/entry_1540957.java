import java.util.*;
import java.io.*;

public class entry_1540957 {
  static StreamTokenizer in;

  static int nextInt() throws IOException {
    in.nextToken();
    return (int) in.nval;
  }

  public static void main(String[] args) throws IOException {
    in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    int n = nextInt();
    int k = nextInt();
    ArrayList <Movie> movies = new ArrayList <Movie> ();
    for (int i = 0; i < n; i++) {
      movies.add(new Movie(nextInt(), nextInt()));
    }
    Collections.sort(movies, new Comparator <Movie> () {
      public int compare(Movie a, Movie b) {
        return (a.end - b.end != 0) ? a.end - b.end : a.start - b.start;
      }
    });
    TreeSet <Movie> s = new TreeSet <Movie> (new Comparator <Movie> () {
      // These are not movies; I'm justing using the Movie class as a way to make pairs
      public int compare(Movie a, Movie b) {
        return (a.start - b.start != 0) ? a.start - b.start : a.end - b.end;
      }
    });
    s.add(new Movie(movies.get(0).end, 0));
    int watched = 1;
    for (int i = 1; i < n; i++) {
      int tmp1 = s.first().start;
      int tmp2 = movies.get(i).start;
      if (tmp2 >= tmp1) {
        s.remove(s.lower(new Movie(tmp2, n + 1)));
        s.add(new Movie(movies.get(i).end, i));
        watched++;
      } else if (s.size() < k) {
        s.add(new Movie(movies.get(i).end, i));
        watched++;
      }
    }
    System.out.println(watched);
  }

  static class Movie {
    public int start;
    public int end;

    public Movie (int a, int b) {
      start = a;
      end = b;
    }

    public String toString() {
      return (start + " " + end + " ");
    }
  }
}