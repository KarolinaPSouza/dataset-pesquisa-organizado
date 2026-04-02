//package CSES.DP;

import java.util.Arrays;
import java.util.Scanner;

public class entry_4753317 {
    private static int[][] dp;
    private static int[] memo;

    private static int minNumberOfCoins(int[] arr, int idx, int x) {
        if (x == 0) return 0;
        else if (x < 0 || idx >= arr.length) return (int) 1e9;
        else if (dp[idx][x] != -1) return dp[idx][x];

        int opt1 = 1 + minNumberOfCoins(arr, idx, x - arr[idx]);
        int opt2 = minNumberOfCoins(arr, idx + 1, x);

        return dp[idx][x] = Math.min(opt1, opt2);
    }

    private static int minNumberOfCoins(int[] arr, int target) {
        int[][] memo = new int[2][target + 1];
        for (int idx = arr.length; idx >= 0; idx--) {
            for (int x = 0; x <= target; x++) {
                memo[idx % 2][x] = (int) 1e9;
                if (idx >= arr.length) memo[idx % 2][x] = (int) 1e9;
                else if (x == 0) memo[idx % 2][x] = 0;
                else {
                    if (x - arr[idx] >= 0) {
                        memo[idx % 2][x] = Math.min(memo[idx % 2][x], 1 + memo[idx % 2][x - arr[idx]]);
                    }
                    memo[idx % 2][x] = Math.min(memo[idx % 2][x], memo[(idx + 1) % 2][x]);
                }
            }
        }
        return memo[0][target];
    }

    private static int minCoins(int[] arr, int target) {
        if (target == 0) return 0;
        else if (target < 0) return (int) 1e9;
        else if (memo[target] != -1) return memo[target];

        int ans = (int) 1e9;
        for (int i = 0; i < arr.length; i++) {
            if (target - arr[i] >= 0) {
                ans = Math.min(ans, 1 + minCoins(arr, target - arr[i]));
            }
        }

        return memo[target] = ans;
    }

    private static int minCoinsTabulation(int[] arr, int target) {
        int[] states = new int[target + 1];
        for (int x = 0; x <= target; x++) {
            if (x == 0) states[x] = 0;
            else {
                int ans = (int) 1e9;
                for (int i = 0; i < arr.length; i++) {
                    if (x - arr[i] >= 0) {
                        ans = Math.min(ans, 1 + states[x - arr[i]]);
                    }
                }
                states[x] = ans;
            }
        }
        return states[target];
    }

    public static void main(String[] args) {
        int n, x;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        memo = new int[x + 1];
        Arrays.fill(memo, -1);
        int ans = minCoinsTabulation(arr, x);
        System.out.println((ans == 1e9 ? "-1" : ans));
    }
}
