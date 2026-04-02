//package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_15520931 {
//    static int fxn(int[] nums, int sum, int curr, int[] dp){
//        if(curr > sum) return 0;
//        if(curr == sum){
//            return 1 % (int)(1e9 + 7);
//        }
//        if (dp[curr] != -1) return dp[curr] % MOD;
//        long count = 0;
//        for (int num : nums) {
//            count = (count + fxn(nums, sum, curr + num, dp)) % MOD;
//        }
//        return dp[curr] = (int) count;
//    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int sum = Integer.parseInt(first[1]);
        int[] nums = new int[n];
        String[] second = br.readLine().split(" ");
        for(int i = 0; i < second.length; i++){
            nums[i] = Integer.parseInt(second[i]);
        }
//        int[] dp = new int[sum + 1];
//        Arrays.fill(dp, -1);
//        System.out.println(fxn(nums, sum, 0, dp));

        int[] dpt = new int[sum + 1];
        dpt[0] = 1;
        for(int i = 1; i < sum + 1; i++){
            for(int num : nums){
                if(i - num >= 0){
                    dpt[i] = (dpt[i] + dpt[i - num]) % (int)(1e9 + 7);
                }
            }
        }

        System.out.println(dpt[sum]);

    }
}