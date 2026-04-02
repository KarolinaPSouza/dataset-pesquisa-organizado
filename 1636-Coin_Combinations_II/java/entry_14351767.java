import java.util.*;

public class entry_14351767 {

    static final int mod = (int)1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        long[] dp = new long[x + 1];
        dp[0] = 1;
        for(int entry_14351767 : coins){
            for(int j = entry_14351767;j<=x;j++){
                dp[j] = (dp[j] + dp[j - entry_14351767]) % mod;
            }
        }
        System.out.println(dp[x]);
    }
}