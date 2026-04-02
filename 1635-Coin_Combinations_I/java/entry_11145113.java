import java.util.*;

public class entry_11145113 {
    static long solve(int N, int X, List<Integer> coins) {
        long[] dp = new long[X + 1];
        final int MOD = 1_000_000_007;

        dp[0] = 1;

        for (int i = 1; i <= X; i++) {
            for (int j = 0; j < N; j++) {
                if (coins.get(j) > i) {
                    continue;
                }
                dp[i] = (dp[i] + dp[i - coins.get(j)]) % MOD;
            }
        }

        return dp[X];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }

        sc.close();

        System.out.println(solve(n, x, coins));
    }
}