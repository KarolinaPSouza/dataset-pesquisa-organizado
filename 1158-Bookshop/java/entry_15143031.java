import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class entry_15143031 {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
    static long LONG_MAX = Long.MAX_VALUE, LONG_MIN = Long.MIN_VALUE;

    static int mod = (int)1e9 + 7;
    static int N = (int)1e5 + 1;
    void solve() throws IOException {
        int n = parseInt(nextToken()), target = parseInt(nextToken());
        int[] s = new int[n], h = new int[n];
        for (int i = 0; i < n; i++) { h[i] = parseInt(nextToken()); }
        for (int i = 0; i < n; i++) { s[i] = parseInt(nextToken()); }

        // take, not_take problem
        // dp[i][x] = max pages that can be purchased
        int[] prev = new int[target + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[target + 1];
            for (int x = 1; x <= target; x++) {
                if (i == 0) {
                    curr[x]  = 0;
                } else {
                    if (x - h[i - 1] >= 0) {
                       curr[x] = s[i - 1] + prev[x - h[i - 1]];
                    }
                   curr[x] = max(curr[x], prev[x]);
                }
            }
            prev = curr;
        }
        out.println(prev[target]);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int TC = 1;
        while (TC-- > 0) new entry_15143031().solve();
        out.flush();
        out.close();
        br.close();
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
}