import java.util.*;
public class entry_10381952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int coins[] = new int[n];
        for(int i = 0; i < n ; i++){
            coins[i] = sc.nextInt();
        }
        int dp[] = new int[sum+1];
        Arrays.fill(dp , sum+1);
        dp[0] = 0;

        for(int i = 1; i <= sum ; i++) {
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i] , dp[i-coin]+1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int ans = dp[sum] == sum+1 ? -1 : dp[sum];
        System.out.println(ans);
        // for(int i = 0 ; i <= sum ; i++){
        //     if(dp[i] == null) continue;
        //     for(int coin : coins){
        //         int index = i + coin;
        //         long check = (long)i + (long)coin;
        //         if(check > sum){
        //             continue;
        //         }

        //         int right = Integer.MAX_VALUE;
        //         if(dp[index] != null){
        //             right = dp[index];
        //         }

        //         dp[index] = Math.min(right , dp[i]+1);
        //     }
        // }


        // for(int i =0 ; i <= n ; i++){
        //     Arrays.fill(dp[i], Integer.MAX_VALUE);
        // }
        // for(int i = 0 ; i < n ; i++){
            // dp[i][0] = 0;
        // }



        // for(int i = 0 ; i < n ; i++){
        //    for(int target = 1 ; target <= sum ; target++){
        //     int left = Integer.MAX_VALUE;
        //     if(target  - coins[i] >= 0 && dp[i][target-coins[i]] != Integer.MAX_VALUE)
        //     left = dp[i][target - coins[i]]+1;
        //     int up = Integer.MAX_VALUE;
        //     if(i > 0 && dp[i-1][target] != Integer.MAX_VALUE)
        //         up = dp[i-1][target];
        //     dp[i][target] = Math.min(left , up);
        //     }
        //    System.out.println(dp[i][target]);
        // }
        // for(int i = 0 ; i < n ; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        // int ans = dp[n-1][sum] == Integer.MAX_VALUE ? -1 : dp[n-1][sum];
        // System.out.println(ans);
        // helper(sum,n-1, coins, 0 ,dp);
        // int ans = helper(coins , sum  , coins.length-1 , 0 , dp);
        // System.out.println(ans == Integer.MAX_VALUE-10 ?-1 : ans);
    }
    public static int helper(int []coins , int target , int index , int steps , Integer [][]dp){
        if(index < 0){
            return Integer.MAX_VALUE - 10;
        }
        if(target <= 0){
            if(target == 0){
                return 0;
            }
            return Integer.MAX_VALUE -10;
        }
        if(dp[index][target] != null) return dp[index][target];
        //  take
        int left = helper(coins , target - coins[index] , index , steps+1 , dp)+1;
        int right = helper(coins , target , index-1 , steps ,dp);

        int ans = Math.min(left , right); 
        dp[index][target] = ans;
        // System.out.println("For "+ coins[index] + " target "+ target + " ans " + ans);
        return ans;
    }
}