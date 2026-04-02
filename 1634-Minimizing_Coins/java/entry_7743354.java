import java.io.*;
import java.util.*;

public class entry_7743354 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String [] inp = buf.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int x = Integer.parseInt(inp[1]);
        String []a  = buf.readLine().split(" ");
        int []arr = new int[n];
        for(int i = 0;i<n;i++)arr[i] = Integer.parseInt(a[i]);
        Arrays.sort(arr);
        int [][]dp = new int[n+1][x+1];
        for(int []k:dp)Arrays.fill(k, (int)1e9);
        dp[n][0] = 0;
        for(int i = n-1;i>=0;i--){
            dp[i][0] = 0;
            for(int s = arr[i];s<=x;s++){
                dp[i][s] = dp[i+1][s];
                dp[i][s] = Math.min(dp[i][s], 1+dp[i][s-arr[i]]);
            }
        }
        System.out.println(dp[0][x]>=(int)1e9?-1:dp[0][x]);
    }
}