import java.io.*;
import java.util.*;

public class entry_4565765 {
    private static MyScanner sc;
    private static PrintWriter out;

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // Start

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        Arrays.sort(coins);

        int[] dp = new int[x+1];
        dp[0] = 1;
        for (int money = 1; money <= x; money++) {
            int sum = 0;
            for (int coin : coins) {
                if (money < coin)
                    break;
                sum += dp[money - coin];
                sum %= MOD;
            }
            dp[money] = sum;
        }

        out.println(dp[x]);

        // Stop
        out.close();
    }

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}