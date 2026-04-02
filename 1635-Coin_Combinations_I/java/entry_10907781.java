import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_10907781 {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    static PrintWriter out = new PrintWriter(System.out);
    static FastScanner in = new FastScanner();

    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }

        int[] dp = new int[1_000_0001];
        dp[0] = 1;

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i - coins[j]];
                    dp[i] %= MOD;
                }
            }
        }

        out.println(dp[x]);
        out.flush();
    }
}
