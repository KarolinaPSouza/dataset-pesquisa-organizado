import java.util.*;

public class entry_6800652 {
    public static final int MOD = 1000000007;
    public static int[] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new int[sum+1];
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j - arr[i] >= 0) {
                    dp[j] += dp[j - arr[i]];
                    dp[j] %= MOD;
                }
            }
        }

        System.out.println(dp[sum]);
    }
}