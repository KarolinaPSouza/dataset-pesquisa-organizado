import java.util.*;
public class entry_8399708 {
    // static int[][] dp;
    static int mod=(int)1e9+7;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum=sc.nextInt();
        int[] dp = new int[sum+1];
        // for(int[] i :dp){
        //     Arrays.fill(i, -1);
        // }

        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int weight = 0; weight <= sum; weight++) {
                if (weight - coins[i - 1] >= 0) {  
                    dp[weight] += dp[weight - coins[i - 1]];
                    dp[weight] %= mod;
                }
            }
        }

        System.out.println(dp[sum]);
        sc.close();
    }
    // static int func(int[] coins, int sum, int i) {
    //     if(i>=coins.length)return 0;
    //     if(sum==0)return 1;
    //     if(dp[i][sum]!=-1)return dp[i][sum];
    //     int take=0, ntake=0;
    //     if(sum>=coins[i])take= func(coins, sum-coins[i], i);
    //     ntake= func(coins, sum, i+1);
    //     return dp[i][sum]=(take%mod+ntake%mod)%mod;
    // }
}