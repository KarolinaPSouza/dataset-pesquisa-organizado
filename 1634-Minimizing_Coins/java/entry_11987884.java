import java.util.*;
public class entry_11987884 {
//    static int minimumcoins(int x,int[] coins,int[] dp){
//        if(x == 0) return 0;
//        if(x < 0) return Integer.MAX_VALUE;
//        if(dp[x] != -1) return dp[x];
//        int maxcoins = Integer.MAX_VALUE;
//        for(int i=0;i<coins.length;i++){
//            int res = minimumcoins(x-coins[i],coins,dp);
//            if(res != Integer.MAX_VALUE){
//                maxcoins = Math.min(maxcoins,res + 1);
//            }
//        }
//        return dp[x] = maxcoins;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] dp = new int[x + 1];
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int j=1;j<=x;j++){
            for(int i=0;i<coins.length;i++){
                if(j >= coins[i] && dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        System.out.println(dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
    }
}
