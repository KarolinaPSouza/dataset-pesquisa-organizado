import java.io.*;
import java.util.*;

public class entry_15437084 {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() {
            if (ptr >= len) {
                ptr = 0;
                try {
                    len = in.read(buffer);
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + (c - '0');
            }
            return val * sign;
        }
    }

    static class Project implements Comparable<Project> {
        long a, b, p;
        Project(long a, long b, long p) {
            this.a = a;
            this.b = b;
            this.p = p;
        }
        public int compareTo(Project o) {
            return Long.compare(this.b, o.b);
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();

        int n = (int) fs.nextLong();
        Project[] arr = new Project[n];

        for (int i = 0; i < n; i++) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long p = fs.nextLong();
            arr[i] = new Project(a, b, p);
        }

        Arrays.sort(arr);

        long[] ends = new long[n];
        for (int i = 0; i < n; i++) ends[i] = arr[i].b;

        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            long take = arr[i].p;

            // find last project ending < arr[i].a
            int idx = Arrays.binarySearch(ends, arr[i].a - 1);

            if (idx < 0) idx = -idx - 2;
            if (idx >= 0) take += dp[idx];

            long skip = (i > 0 ? dp[i - 1] : 0);
            dp[i] = Math.max(skip, take);
        }

        System.out.println(dp[n - 1]);
    }
}