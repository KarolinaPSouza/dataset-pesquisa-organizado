import java.util.Scanner;

public class entry_11509821 {
    public static void main(String[] args){
        long mod = (long)1e9+7;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int a[] = new int[n];

        for(int i=0; i<n; i++) a[i] = s.nextInt();

        long[] dp = new long[x+1];
        dp[0] = 0;

        for(int i=1; i<=x; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                if(i-a[j]>=0)
                dp[i] = Math.min(dp[i], 1+dp[i-a[j]]);
            }
        }
        if(dp[x]==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[x]);
    }
}
