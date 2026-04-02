import java.util.*;

public class entry_14583300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // For multiple test cases
        // int t = sc.nextInt();
        // while(t-- > 0){
        //  solve(sc);
        // }

        solve(sc);
    }

    static int helper(int[] dp, int[] arr, int target) {
        if(target == 0) return 0;

        if(dp[target] != -1) return dp[target];

        int res =  Integer.MAX_VALUE;
        for(int i = arr.length - 1; i >= 0; i--) {
            int pick = Integer.MAX_VALUE;
            if (arr[i] <= target) {
                pick = helper(dp, arr, target - arr[i]);
                if (pick != Integer.MAX_VALUE) pick++;
            }
            res = Math.min(pick, res);
        }

        dp[target] = res;

        return dp[target];
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[x+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i =  0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 0;

        for(int i = 1; i <= x; i++) {
            for (int c: arr) {
                if (i - c >= 0 && dp[i-c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
                }
            }
        }
        System.out.println(dp[x] != Integer.MAX_VALUE ? dp[x] : -1);
    }
}