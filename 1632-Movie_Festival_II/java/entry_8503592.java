import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class entry_8503592 {
    static class Movie {
        int starting, ending;
        Movie(int starting, int ending) {
            this.starting = starting; this.ending = ending;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "starting=" + starting +
                    ", ending=" + ending +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int K = io.nextInt();
        Movie[] movies = new Movie[N];
        for (int i = 0; i < N; i++) movies[i] = new Movie(io.nextInt(), io.nextInt());

        Arrays.sort(movies, Comparator.comparingInt(m -> m.ending));

        // sort by ending times, allow duplicate ending times
        TreeSet<Movie> lastMovieWatched = new TreeSet<>((a, b) -> a.ending != b.ending
                ? Integer.compare(a.ending, b.ending) : (a == b ? 0 : 1) );

        for (int i=0; i < K; i++) lastMovieWatched.add(new Movie(0, 0));

        int count=0;
        for (final Movie movie : movies) {
           Movie m = lastMovieWatched.floor(new Movie(-1, movie.starting));
           if (m != null) {
               count++;
               lastMovieWatched.remove(m);
               lastMovieWatched.add(movie);
           }
        }
        io.print(count);
        io.close();
    }

    //BeginCodeSnip{Kattio}
    static class Kattio extends PrintWriter {
        private final DataInputStream din = new DataInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int bufferPointer, bytesRead;

        public Kattio() {
            super(System.out);
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, bufferPointer = 0, 1 << 16);
                if (bytesRead == -1) buffer[0] = -1;
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }
    }
    //EndCodeSnip

}