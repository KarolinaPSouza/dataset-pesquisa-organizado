import java.io.*;
import java.util.*;

public class entry_15305211 {

    static class Project {
        long a, b, p;
        Project(long a, long b, long p) {
            this.a = a;
            this.b = b;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        Project[] arr = new Project[n];

        for (int i = 0; i < n; i++) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            long p = fs.nextLong();
            arr[i] = new Project(a, b, p);
        }

        Arrays.sort(arr, (x, y) -> Long.compare(x.b, y.b));

        long[] end = new long[n];
        for (int i = 0; i < n; i++) end[i] = arr[i].b;

        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            Project cur = arr[i - 1];

            int j = upperBound(end, cur.a - 1); 

            long take = dp[j] + cur.p;
            long skip = dp[i - 1];

            dp[i] = Math.max(take, skip);
        }

        System.out.println(dp[n]);
    }

    static int upperBound(long[] arr, long key) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= key) l = mid + 1;
            else r = mid;
        }
        return l;
    }

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
            while ((c = read()) <= ' ') if (c == -1) return -1;
            long sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            long val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + c - '0';
            return val * sgn;
        }

        int nextInt() throws IOException { return (int) nextLong(); }
    }
}