import java.io.*;
import java.util.*;

public class entry_14629044 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        long[] s = new long[n];
        long[] e = new long[n];
        long[] w = new long[n];

        for (int i = 0; i < n; i++) {
            s[i] = fs.nextLong();
            e[i] = fs.nextLong();
            w[i] = fs.nextLong();
        }

        // Sort indices by end time
        Integer[] ord = new Integer[n];
        for (int i = 0; i < n; i++) ord[i] = i;
        Arrays.sort(ord, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Long.compare(e[a], e[b]);
            }
        });

        long[] S = new long[n], E = new long[n], W = new long[n];
        for (int i = 0; i < n; i++) {
            int id = ord[i];
            S[i] = s[id];
            E[i] = e[id];
            W[i] = w[id];
        }

        long[] dp = new long[n];
        dp[0] = W[0];

        for (int i = 1; i < n; i++) {
            long take = W[i];
            // last j with E[j] < S[i]  (strictly before start)
            int j = upperBound(E, i, S[i] - 1); // returns last idx with E[idx] <= S[i]-1
            if (j >= 0) take += dp[j];
            dp[i] = Math.max(dp[i - 1], take);
        }

        System.out.println(dp[n - 1]);
    }

    // upperBound over a[0..hiExclusive-1]: last index with a[idx] <= key, else -1
    static int upperBound(long[] a, int hiExclusive, long key) {
        int lo = 0, hi = hiExclusive;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo - 1;
    }

    // Fast input
    static final class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}