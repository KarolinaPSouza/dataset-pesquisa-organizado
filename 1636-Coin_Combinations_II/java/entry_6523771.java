import java.util.*;
import java.io.*;

/*
    problem link - > https://cses.fi/problemset/task/1635/
    1. state => dp[i][sum] means no of ways to make sum == x from i to len(coins)
    2. transition => dp[i][sum] = dp[i][sum + coins[i]] + dp[i + 1][sum] 
    3. base case => dp[i][X] = 1, dp[i][> X] = 0
    4. Final subproblem => dp[n-1][sum]
    5. t.c = O(n * X)
    6. s.c = O(N * X)
*/

public class entry_6523771 {

    private static final int MOD = 1000000007;

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = scn.nextInt();
        int coins[] =  new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = scn.nextInt();
        }

        int ans = helper(n, x, coins);
        System.out.println(ans);
    }

    private static int helper(int n, int sum, int coins[]){

        int dp[] = new int[sum + 1];
        int current[] = new int[sum + 1];

        for(int i = 0; i <= n-1; i++){
           for(int j = 0; j <= sum; j++){
                if(j == 0){
                    current[j] = 1;
                }else{
                    if (i - 1 >= 0) current[j] = dp[j] % MOD; 
                    if (j - coins[i] >= 0) current[j] = (current[j] + current[j - coins[i]]) % MOD;
                }
           }

           dp = current;
        }

        //  final subproblem
        return dp[sum];
    }
}
