import java.io.*;
import java.util.*;

public class entry_15769416 {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val;
        }
    }

    static class Movie {
        int start, end;
        Movie(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int k = fs.nextInt();

        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            movies[i] = new Movie(fs.nextInt(), fs.nextInt());
        }

        // Sort movies by end time
        Arrays.sort(movies, (a, b) -> a.end - b.end);

        // Multiset of ending times
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int usedMembers = 0;
        int answer = 0;

        for (Movie m : movies) {
            Integer prev = map.floorKey(m.start);
            if (prev != null) {
                remove(map, prev);
                map.put(m.end, map.getOrDefault(m.end, 0) + 1);
                answer++;
            } else if (usedMembers < k) {
                map.put(m.end, map.getOrDefault(m.end, 0) + 1);
                usedMembers++;
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void remove(TreeMap<Integer, Integer> map, int key) {
        int cnt = map.get(key);
        if (cnt == 1) map.remove(key);
        else map.put(key, cnt - 1);
    }
}