import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_12810299 {

    private static int minCoinsHelper(int[] nums, int remTarget, int index, int[][] dp){
        if(remTarget==0){
            return 0;
        }
        if(index<0){
            return (int)1e9;
        }

        if(dp[index][remTarget]!=-1){
            return dp[index][remTarget];
        }

        int take = Integer.MAX_VALUE;
        if(remTarget>=nums[index]){
            take = 1 + minCoinsHelper(nums, remTarget-nums[index], index, dp);
        }
        int notTake = minCoinsHelper(nums, remTarget, index-1, dp);
        return dp[index][remTarget] = Math.min(take, notTake);
    }

    // public static int minCoins(int[] nums, int target){
    //     int n = nums.length;
    //     int[][] dp = new int[n][target+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);

    //     }
    //     return minCoinsHelper(nums, target, n-1, dp)==(int)(1e9)?-1:minCoinsHelper(nums, target, n-1, dp);
    // }

    public static int minCoins(int[] nums, int target) {
        // Initialize dp array where dp[i] stores the minimum number of coins to make sum i
        int[] dp = new int[target + 1];

        // Set dp[0] to 0 because 0 coins are needed to make sum 0
        dp[0] = 0;

        // Initialize other values with a large number (infinity)
        Arrays.fill(dp, 1, dp.length, (int) 1e9);

        // Loop over all possible sums from 1 to target
        for (int i = 1; i <= target; i++) {
            // Loop over all available coins
            for (int coin : nums) {
                // If coin can be used for the current sum `i`
                if (i - coin >= 0) {
                    // Update dp[i] by considering using this coin
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[target] is still infinity, it means it's not possible to form the target sum
        return dp[target] == (int) 1e9 ? -1 : dp[target];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(minCoins(nums, target));
    }
}