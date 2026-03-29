import java.io.*;
import java.util.*;
public class entry_7923408 {

    public static int MAX = (int)1e9 + 7;
    public static int[][] dir = {{-1,0},{0,-1}}; 

    public static void solve(int n,int x,int[] h,int[] s){

        int[] dp = new int[x+1];
        for(int i=1;i<=n;i++){
            for(int j=x;j>=h[i-1];j--){
                dp[j] = Math.max(dp[j],dp[j-h[i-1]] + s[i-1]);
            }
        }

        System.out.println(dp[x]);

        /*
        int[][] dp = new int[n+1][x+1];
        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=x;j++){  
                dp[i][j] = dp[i-1][j];  // not take
                if (j >= h[i-1]){ // possible to take
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-h[i-1]] + s[i-1]);
                }
            }
        }
        System.out.println(dp[n][x]);
        */
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] h = new int[n];
        int[] s = new int[n];
        for(int i=0;i<n;i++){
            h[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            s[i] = sc.nextInt();
        }
        solve(n,x,h,s);
        sc.close();
    }
}