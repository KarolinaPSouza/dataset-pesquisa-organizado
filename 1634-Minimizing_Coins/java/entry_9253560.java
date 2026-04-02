import java.util.*;

public class entry_9253560 {
    public static void main(String[] args) {
        Scanner ans = new Scanner(System.in);
        int n = ans.nextInt();
        int sum = ans.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i]= ans.nextInt();
        }
        Arrays.sort(coin);
        long[] dp = new long[sum+1];
        for (int i = 1; i <=sum ; i++) {
            int j = 0; long val = Integer.MAX_VALUE;
            while(j<n && coin[j]<=i){
                val = Math.min(val,1+dp[i-coin[j]]);
                j++;
            }
            dp[i]=val;
        }
        if(dp[sum]==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(dp[sum]);
        }
    }
}












