import java.util.*;

public class entry_15650924 {
    static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : c) {
            for (int sum = coin; sum <= x; sum++) {
                dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
            }
        }

        System.out.println(dp[x] == INF ? -1 : dp[x]);
    }
}