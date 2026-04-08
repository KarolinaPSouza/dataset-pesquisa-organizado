import java.io.*;
import java.util.*;

public class entry_15006637 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int k = fs.nextInt();

        int[][] movies = new int[n][2];
        for (int i = 0; i < n; i++) {
            movies[i][0] = fs.nextInt(); // start
            movies[i][1] = fs.nextInt(); // end
        }

        Arrays.sort(movies, Comparator.comparingInt(o -> o[1])); // sort by end time

        TreeMap<Integer, Integer> free = new TreeMap<>();
        free.put(0, k); // k viewers free at time 0

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int st = movies[i][0];
            int ed = movies[i][1];

            Map.Entry<Integer, Integer> e = free.floorEntry(st);
            if (e == null) continue; // no viewer free in time
            int t = e.getKey();
            int cnt = e.getValue();
            // consume one viewer at time t
            if (cnt == 1) free.remove(t);
            else free.put(t, cnt - 1);

            // that viewer becomes busy until 'ed'
            free.put(ed, free.getOrDefault(ed, 0) + 1);
            ans++;
        }

        System.out.println(ans);
    }

    // FastScanner for fast input
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { this.in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') { if (c == -1) return Integer.MIN_VALUE; }
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}