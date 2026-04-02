import java.util.*;
public class entry_13314427 {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();

        int [] dp = new int[x + 1];
         Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;

        for(int i = 1; i <= x; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i - coin] + 1 , dp[i]);
                }
            }
        }
        sc.close();
        System.out.println(dp[x] == Integer.MAX_VALUE/2 ? -1 : dp[x]);
    }
}