import java.util.*;
import java.io.*;

// public class entry_3266967 {

public class entry_3266967 {



    // end of fast i/o code
    public static void main(String[] args) {
        // FastReader reader = new FastReader();
        Scanner sc = new Scanner(System.in);

        int i,n,j,x;
         n = sc.nextInt();
         x = sc.nextInt();

        int[] a = new int[n];

        for(i=0;i<n;i++)
         a[i] = sc.nextInt();

        int[] dp = new int[x+1];

        dp[0]=1;

        int mod = (int)1e9+7;

        for(j=0;j<n;j++){
            for(i=a[j];i<=x;i++){
                dp[i] = (dp[i] + dp[i-a[j]])%mod;
            }
        }

        System.out.println(dp[x]);

    }
}