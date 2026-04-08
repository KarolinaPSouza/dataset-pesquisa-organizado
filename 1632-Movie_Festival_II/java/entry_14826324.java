import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class entry_14826324 {
 // Fast scanner (byte buffer), ~3–5x faster than Scanner/StringTokenizer on large input
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c; do { c = read(); } while (c <= 32);
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            long x = 0;
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return neg ? -x : x;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }

    static final class Movie {
        long a, b;
        Movie(long a, long b) { this.a = a; this.b = b; }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt(), k = fs.nextInt();

        Movie[] arr = new Movie[n];
        for (int i = 0; i < n; i++) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            arr[i] = new Movie(a, b);
        }
        // Sort by end time ascending
        Arrays.sort(arr, new Comparator<Movie>() {
            public int compare(Movie u, Movie v) { return Long.compare(u.b, v.b); }
        });

        // Multiset of member-free times (end times); size <= k
        TreeMap<Long, Integer> ends = new TreeMap<>();
        int used = 0;      // how many members currently in the multiset
        long ans = 0;

        for (Movie m : arr) {
            // find latest member free by m.a
            Map.Entry<Long, Integer> e = ends.floorEntry(m.a);
            if (e != null) {
                long free = e.getKey();
                int cnt = e.getValue();
                if (cnt == 1) ends.remove(free);
                else ends.put(free, cnt - 1);
                // assign this member to current movie; insert new end b
                ends.put(m.b, ends.getOrDefault(m.b, 0) + 1);
                ans++;
            } else if (used < k) {
                // take a fresh member
                ends.put(m.b, ends.getOrDefault(m.b, 0) + 1);
                used++;
                ans++;
            }
            // else: all k members busy past start -> skip
        }

        System.out.println(ans);
    }
}