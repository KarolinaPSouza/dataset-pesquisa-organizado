import java.util.*;

public class entry_12002039 {
    static int n, x, a[], MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = solve();
        System.out.println(ans);
    }

    public static int solve() {
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int coin : a) {
            for (int xi = 1; xi <= x; xi++) {
                    if (xi-coin >= 0) {
                        dp[xi] = (dp[xi] + dp[xi - coin]) % MOD;
                    }
                }
        }

        return dp[x];
    }
}