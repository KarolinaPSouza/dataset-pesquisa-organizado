// Consider a money system consisting of n
//  coins. Each coin has a positive integer value. Your task is to produce a sum of money x
//  using the available coins in such a way that the number of coins is minimal.

// For example, if the coins are {1,5,7}
//  and the desired sum is 11
// , an optimal solution is 5+5+1
//  which requires 3
//  coins.

// Input

// The first input line has two integers n
//  and x
// : the number of coins and the desired sum of money.

// The second line has n
//  distinct integers c1,c2,…,cn
// : the value of each coin.

// Output

// Print one integer: the minimum number of coins. If it is not possible to produce the desired sum, print −1
// .

// Constraints
// 1≤n≤100

// 1≤x≤106

// 1≤ci≤106

// Example

// Input:
// 3 11
// 1 5 7

// Output:
// 3

import java.util.*;
import java.io.*;
public class entry_6839549 {

    // Recursive approach

    static int minCoinsRecursive(int noOfCoins, int sum, int []coins){

        // Base Case:- For sum 0 zero coins required
        if (sum == 0){
            return 0;
        }

        // Initialize result
       int res = Integer.MAX_VALUE;

        for (int i=0;i<noOfCoins;i++){

            if (coins[i]<=sum){
                int sub_result = minCoinsRecursive(noOfCoins, sum-coins[i], coins);

                // Check for INT_MAX to avoid overflow and see if
             // result can minimized
                if (sub_result != Integer.MAX_VALUE && sub_result + 1 < res){
                    res = sub_result + 1;
                }
            }
        }
        return res;
    }

    // Top Bottom Approach

    public static int minCoinsTopBottom(int noOfCoins, int sum, int []coins, int []dp){

        // Base case: If target value V is 0, no coins are
        // needed
        if (sum== 0)
            return 0;

        // If subproblem is already solved, return the
        // result from DP table

        if (dp[sum] !=-1){
            return dp[sum];
        }
        // Initialize result
        int res = Integer.MAX_VALUE;

        for (int i=0;i<noOfCoins;i++){

            if (coins[i]<=sum){
                int sub_result = minCoinsTopBottom(noOfCoins, sum-coins[i], coins, dp);

                if (sub_result != Integer.MAX_VALUE && sub_result + 1 < res){
                    res = sub_result + 1;
                }
            }
        }
        // Save the result in the DP table
        dp[sum] = res;
        return dp[sum];

    }

    // Bottom Top Approach
    public static int minCoinsBottomTop(int noOfCoins, int sum, int []coins){

        // dp[i] will be storing the minimum coins required to achieve sum i

        int[] dp = new int[sum+1];

        // Base case if value is 0
        dp[0] = 0;

        for (int i=1;i<=sum;i++){
            dp[i] = Integer.MAX_VALUE;
        }

        // Compute minimum coins required for all
        // values from 1 to sum

        for (int i=1;i<=sum;i++){
            for (int j =0;j<noOfCoins;j++){
                if (coins[j] <=i){
                    int sub_result = dp[i-coins[j]];
                    if (sub_result != Integer.MAX_VALUE && sub_result + 1 < dp[i]){
                    dp[i] = sub_result + 1;
                }
                }
            }
        }

        if (dp[sum] == Integer.MAX_VALUE){
            return -1;
        }

        return dp[sum];

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter n and x separated by a space: ");
        int noOfCoins = scanner.nextInt();
        int sum = scanner.nextInt();

        // Input the second line containing 'n' numbers separated by spaces
        // System.out.print("Enter " + n + " numbers separated by spaces: ");

        int []coins = new int[noOfCoins];

        for (int i=0;i<noOfCoins;i++){
            coins[i] = scanner.nextInt();
        }

        // Close the scanner
        scanner.close();

        // Recursive Approach
        // System.out.println(minCoinsRecursive(noOfCoins, sum, coins));

        // Top Bottom Approach
        // int[] dp = new int[sum+1];

        // Arrays.fill(dp, -1);

        // System.out.println(minCoinsTopBottom(noOfCoins, sum, coins, dp));

        // Bottom Top Approach

        System.out.println(minCoinsBottomTop(noOfCoins, sum, coins));

    }
}
