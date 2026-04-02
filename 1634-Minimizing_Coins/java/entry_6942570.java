import java.util.*;
import java.io.*;
public class entry_6942570{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0; i<n; i++) coins[i] = sc.nextInt();
        long[] dp = new long[x+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<=x; i++){
            for(int j=0; j<n; j++){
                int coin=coins[j];
                if(i-coin>=0){
                    dp[i]=Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        System.out.println(dp[x]==Integer.MAX_VALUE?-1:dp[x]);
    }
}
