// import java.util.*;
// class CoinCombinatorics{
//     static final int MOD = (int)(1e9 + 7);
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int x = sc.nextInt();
//         int[] denomination = new int[n+1];
//         for(int i = 1;i <= n;i++){
//             denomination[i] = sc.nextInt();
//         }
//         int[][] dp = new int[n+1][x+1];

//         for(int i  = 1;i <= n;i++){
//             for(int sum = 0;sum <= x;sum++){
//                 if(sum == 0)
//                     dp[i][sum] = 1;
//                 else{
//                     int take = (denomination[i] > sum) ? 0 : dp[i][sum - denomination[i]];
//                     int notTake = (i == 1) ? 0 : dp[i - 1][sum];
//                     dp[i][sum] = (take + notTake) % MOD;
//                 }
//             }
//         }
//         System.out.println(dp[n][x]);       
//     }
// }
import java.util.*;

public class entry_10617452 {
    static final int MOD = (int) (1e9 + 7);

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] denomination = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            denomination[i] = sc.nextInt();
        }

        // Using a 1D dp array
        int[] dp = new int[x + 1];
        dp[0] = 1;  // Base case: only one way to get sum 0 (choose nothing)

        // Iterate over each coin denomination
        for (int i = 1; i <= n; i++) {
            for (int sum = denomination[i]; sum <= x; sum++) {
                dp[sum] = (dp[sum] + dp[sum - denomination[i]]) % MOD;
            }
        }

        System.out.println(dp[x]);
    }
}
