//package DynamicProgramming;

import java.util.*;

public class entry_9803783 {
    static int n;
    static int MOD = 1000000007;
    static long[] dp1;
    static long waysOfDiceRecursive(int target) {
        if(target == 0) return 1;
        else if(target < 0) return 0;
        if(dp1[target] != -1) return dp1[target];
        dp1[target] = 0;
        for(int i = 1; i <= 6; i++) dp1[target] += waysOfDiceRecursive(target-i)%MOD;
        return dp1[target]%MOD;
    }
    static long waysOfDiceIterative(int target) {
//        long[] dp = new long[target+1];
//        dp[0] = 1;
//        for(int i = 1; i <= target; i++) {
//            for(int j = 1; j <= 6; j++) {
//                if(i-j >= 0) dp[i] += dp[i-j]%MOD;
//                else break;
//            }
//        }
//        return dp[target]%MOD;
        long[] curr = new long[7];
        long[] prev = new long[7];
        prev[0] = 1;
        for(int i = 1; i <= target; i++) {
            if(i%7 == 0) prev = Arrays.copyOfRange(prev, 1, 8);
            for(int j = 1; j <= 6; j++) {
                if(i-j >= 0) prev[i%7] += prev[(i-j)%7]%MOD;
                else break;
            }
//            curr = Arrays.copyOfRange(prev, 0, 7);
        }
        return prev[target%7]%MOD;
    }
    static int[] coins;
    static long[] entry_9803783;
    static long minimizingCoinsIterative(int target) {
//        Arrays.sort(coins);
        entry_9803783[0] = 0;
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < n; j++) {
                if(i-coins[j] >= 0) entry_9803783[i] = Math.min(entry_9803783[i], (long)entry_9803783[i-coins[j]]+1);
//                else break;
            }
        }
        return entry_9803783[target];
    }
    static long[] dp3;
    static long coinCombinationWaysRecursive(int target, int[] coins) {
        if(target == 0) return 1;
        else if(target < 0) return 0;
        if(dp3[target] != 0) return dp3[target];
        for(int i = 0; i < coins.length; i++) {
            dp3[target] += coinCombinationWaysRecursive(target-coins[i], coins)%MOD;
        }
        return dp3[target]%MOD;
    }
    static long coinCombinationWaysIterative(int target, int[] coins) {
        long[] dp = new long[target+1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0) dp[i] += dp[i-coins[j]]%MOD;
            }
        }
        return dp[target]%MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int target = sc.nextInt();
//        dp1 = new long[target+1];
//        Arrays.fill(dp1, -1);
//        System.out.println(waysOfDiceRecursive(target));
//        System.out.println(waysOfDiceIterative(target));


       n = sc.nextInt();
       int target = sc.nextInt();
       coins = new int[n];
       entry_9803783 = new long[target+1];
       Arrays.fill(entry_9803783, Integer.MAX_VALUE);
       for(int i = 0; i < n; i++) coins[i] = sc.nextInt();
       long temp = minimizingCoinsIterative(target);
       System.out.println((temp < Integer.MAX_VALUE)?temp: -1);

//        n = sc.nextInt();
//        int x = sc.nextInt();
//        int[] coins = new int[n];
//        for(int i = 0; i < n; i++) coins[i] = sc.nextInt();
//        dp3 = new long[x+1];
//        System.out.println(coinCombinationWaysRecursive(x));
//        System.out.println(coinCombinationWaysIterative(x));
    }
}