import java.io.*;
import java.util.*;
public class entry_5729002 {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int x = reader.nextInt();
        int[] denom = new int[n];
        for ( int i = 0 ; i < n ; i++)
        {
            denom[i] = reader.nextInt();
        }
        long mod = 1000000000 + 7 ;
        long[] dp = new long[1000000+1];
        dp[0] = 1 ;
        for( int i = 1 ; i <= 1000000 ; i++)
        {
            long answer = 0 ;
            for ( int j = 0 ; j < n ; j++)
            {
                if( i -denom[j] < 0)
                {
                    continue;
                }
                if(dp[i-denom[j]] >= mod)
                {
                    dp[i-denom[j]] -= mod ;
                }
                answer +=  dp[i-denom[j]] ;
            }
            dp[i] = answer % mod;
        }
        System.out.println(dp[x]);
    }
}