import java.util.*;

public class entry_4557623 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int MOD = (int) 1e9 + 7;
        int n, x;
        n = in.nextInt();
        x = in.nextInt();
        int a[] = new int[n];
        int dp[] = new int[x+1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        dp[0] = 1;
        // sort(a,a+n);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                if (j - a[i - 1] >= 0) {
                    dp[j] += dp[j - a[i - 1]];
                    // if (dp[j] > MOD)
                    //     dp[j] -= MOD;
                     dp[j]%=MOD;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
