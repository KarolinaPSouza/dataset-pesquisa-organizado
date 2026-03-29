import java.io.*;
import java.util.*;

public class entry_15193593 {
    static class Project implements Comparable<Project> {
        long start, end, reward;
        Project(long a, long b, long p) { start = a; end = b; reward = p; }
        public int compareTo(Project o) {
            return Long.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long p = fs.nextLong();
            projects[i] = new Project(a, b, p);
        }

        Arrays.sort(projects); // sort by ending day

        long[] dp = new long[n + 1]; // dp[i] = max reward considering first i projects
        long[] ends = new long[n];
        for (int i = 0; i < n; i++) ends[i] = projects[i].end;

        for (int i = 1; i <= n; i++) {
            Project cur = projects[i - 1];
            // find latest project that ends before cur.start
            int j = Arrays.binarySearch(ends, 0, i - 1, cur.start - 1);
            if (j < 0) j = -j - 2; // if not found, take the previous index
            long include = cur.reward + (j >= 0 ? dp[j + 1] : 0);
            dp[i] = Math.max(dp[i - 1], include);
        }

        System.out.println(dp[n]);
    }

    // ---------- FAST INPUT ----------
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int len = 0, ptr = 0;
        private final InputStream in;
        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do c = readByte(); while (c <= ' ');
            long val = 0;
            boolean neg = false;
            if (c == '-') { neg = true; c = readByte(); }
            for (; c > ' '; c = readByte()) val = val * 10 + (c - '0');
            return neg ? -val : val;
        }

        int nextInt() throws IOException { return (int) nextLong(); }
    }
}