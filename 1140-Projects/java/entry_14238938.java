import java.io.*;
import java.util.*;

public class entry_14238938 {
    static class FastScanner {
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
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return Long.MIN_VALUE;
            }
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }

    static class Project implements Comparable<Project> {
        long a, b, p;
        Project(long a, long b, long p) { this.a = a; this.b = b; this.p = p; }
        public int compareTo(Project o) { return Long.compare(this.b, o.b); }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        Project[] proj = new Project[n];
        for (int i = 0; i < n; i++) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long p = fs.nextLong();
            proj[i] = new Project(a, b, p);
        }
        Arrays.sort(proj);

        long[] ends = new long[n];
        for (int i = 0; i < n; i++) ends[i] = proj[i].b;

        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            // find rightmost entry_14238938 j < i with ends[j] < proj[i].a
            int l = 0, r = i - 1, res = -1;
            long key = proj[i].a;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (ends[mid] < key) {
                    res = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            long include = proj[i].p + (res == -1 ? 0L : dp[res]);
            long exclude = (i == 0 ? 0L : dp[i - 1]);
            dp[i] = Math.max(include, exclude);
        }

        System.out.println(dp[n - 1]);
    }
}