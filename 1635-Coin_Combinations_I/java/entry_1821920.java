import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_1821920 {
    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner();
        int size = fastScanner.nextInt();
        int amount = fastScanner.nextInt();
        int[] coins = fastScanner.readArray(size);
        int modulo = 1000000007;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            long c = 0;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    c+=dp[i-coin];
                }
            }
            dp[i] = (int) (c % modulo);
        }
        System.out.println(dp[amount]);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}