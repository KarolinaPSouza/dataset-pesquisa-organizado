import java.util.*;

public class entry_12234376 {
    static final int MOD = 1000000007;
    static long solve(int N, int X, List<Integer> coins) {
        long[] dp = new long[X + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = coins.get(i); j <= X; j++) {
                dp[j] = (dp[j] + dp[j - coins.get(i)]) % MOD;
            }
        }
        return dp[X];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i = 0; i<N; i++){
            coins.add(sc.nextInt());
        }
        System.out.println(solve(N, X, coins));
    }
}