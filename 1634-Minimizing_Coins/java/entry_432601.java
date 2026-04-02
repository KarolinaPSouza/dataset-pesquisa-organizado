import java.io.*;
import java.util.*;

public class entry_432601 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp1[] = br.readLine().split(" ");
        int n=Integer.parseInt(inp1[0]);
        int x=Integer.parseInt(inp1[1]);
        int l[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int dp[] = new int[x+1];
        for(int i=0; i<x+1; i++){
            dp[i]=Integer.MAX_VALUE-10;
        }
        dp[0]=0;
        for(int i=1; i<x+1; i++){
            for(int j=0; j<n; j++){
                if(i>=l[j]){
                    dp[i]=Math.min(dp[i],dp[i-l[j]]+1);
                }
            }
        }
        int ans=dp[x];
        if(ans==Integer.MAX_VALUE-10){
            ans=-1;
        }
        System.out.println(ans);
    }
}