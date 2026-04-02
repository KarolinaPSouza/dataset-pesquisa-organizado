import java.util.*;
public class entry_4183246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();        
        int x = sc.nextInt(); 

        int[] coins = new int[n];
        int[] dp = new int[x+1];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= x; j++) {
                dp[j] += dp[j-coins[i]];
                dp[j] %= 1000000007;
            }
        }

        System.out.println(dp[x]);
    }

}