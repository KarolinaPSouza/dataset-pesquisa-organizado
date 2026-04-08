import java.io.*;
import java.util.*;

public class entry_11140651 {
    public static void main(String[] args) {
        FastIO io = new FastIO();

        // Read the number of movies (n) and club members (k)
        int n = io.nextInt();
        int k = io.nextInt();

        // Create an array of Interval objects to store start and end times for each
        // movie
        Interval[] movies = new Interval[n];
        for (int i = 0; i < n; i++) {
            movies[i] = new Interval(io.nextInt(), io.nextInt());
        }

        // Sort movies by their end time (greedy strategy for optimal assignment)
        Arrays.sort(movies, Comparator.comparingInt(movie -> movie.end));

        int maxMovies = 0; // Total number of movies watched by the club members

        // TreeMap to track the available times of each member
        TreeMap<Integer, Integer> endTimes = new TreeMap<>();
        endTimes.put(0, k); // Initialize: all k members are available at time 0

        // Iterate over each movie, attempting to assign it to a member
        for (Interval movie : movies) {
            // Find the latest available time (<= movie's start time) in endTimes
            Integer lower = endTimes.floorKey(movie.start);

            // If a member is available to watch this movie
            if (lower != null) {
                maxMovies++; // Successfully assigned movie to a member

                // Update the count of members available at this specific time
                int lowerValue = endTimes.get(lower);

                // If only one member was available at "lower", remove that time
                if (lowerValue - 1 == 0) {
                    endTimes.remove(lower);
                } else {
                    endTimes.put(lower, lowerValue - 1);
                }

                // Update the member's availability to movie's end time
                endTimes.put(movie.end, endTimes.getOrDefault(movie.end, 0) + 1);
            }
        }

        // Print the total number of movies watched by the club members
        io.println(maxMovies);
        io.close();
    }

    // Interval class represents a movie with a start and end time
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // BeginCodeSnip{FastIO}
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

        // Standard input and output streams
        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        // Fast file input and output handling
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        private int nextByte() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1)
                    return -1; // end of file
            }
            return buf[curChar++];
        }

        public String next() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public int nextInt() {
            int c;
            do {
                c = nextByte();
            } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    // EndCodeSnip{FastIO}
}