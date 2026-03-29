import java.io.*;
import java.util.*;

public class entry_15382482 {

    // FAST SCANNER (faster than BufferedReader + StringTokenizer)
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do c = read(); while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static class Project {
        long a, b, p; // start, end, reward
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        Project[] arr = new Project[n];

        for (int i = 0; i < n; i++) {
            Project pr = new Project();
            pr.a = fs.nextLong();
            pr.b = fs.nextLong();
            pr.p = fs.nextLong();
            arr[i] = pr;
        }

        // Sort by end time
        Arrays.sort(arr, (x, y) -> Long.compare(x.b, y.b));

        long[] dp = new long[n];
        long[] end = new long[n];

        for (int i = 0; i < n; i++) {
            end[i] = arr[i].b;
        }

        for (int i = 0; i < n; i++) {
            long start = arr[i].a;
            long reward = arr[i].p;

            // binary search for last project with end < start
            int lo = 0, hi = i - 1, res = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (end[mid] < start) {
                    res = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            long best = reward;
            if (res != -1) best += dp[res];

            dp[i] = (i == 0 ? best : Math.max(dp[i - 1], best));
        }

        System.out.println(dp[n - 1]);
    }
}