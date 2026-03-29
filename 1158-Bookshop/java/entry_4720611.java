import java.io.*;
import java.util.*;

public class entry_4720611 {

    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s0 = br.readLine().split(" ");
      int n = Integer.parseInt(s0[0]);
      int x = Integer.parseInt(s0[1]);
      int[][] a = new int[n][2];
      String[] s1 = br.readLine().split(" ");
      String[] s2 = br.readLine().split(" ");
      for(int i=0;i<n;i++) {
          a[i][0]=Integer.parseInt(s1[i]);
          a[i][1]=Integer.parseInt(s2[i]);
      }

      int[][] dp = new int[x+1][2];
      for(int i=1;i<=n;i++) {
          for(int j=1;j<=x;j++) {
              if(j-a[i-1][0]>=0 && dp[j-a[i-1][0]][0]!=-1) {
                  dp[j][1] = Math.max(dp[j][0],dp[j-a[i-1][0]][0]+a[i-1][1]);
              } else {
                  dp[j][1] = dp[j][0];
              }
          }
          for(int j=0;j<=x;j++) {
              dp[j][0]=dp[j][1];
          }
      }
      System.out.println(dp[x][0]);
    }

    public static void print(int[][] a) {
        for(int[] b : a) {
            for(int c : b) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    public static int f(int[][] a,int x,int idx,int[][] dp) {
        // System.out.println(x);
        if(idx>=a.length) {
            if(x<0) return -1;
            return 0;
        }
        if(x==0) return 0;
        if(x<0) return -1;
        if(dp[idx][x]!=-2) return dp[idx][x];
        int ans = Integer.MIN_VALUE;
        int v1 = f(a,x-a[idx][0],idx+1,dp);
        int v2 = f(a,x,idx+1,dp);
        if(v1!=-1) {
            ans = Math.max(ans,v1+a[idx][1]);
        }
        if(v2!=-1) {
            ans = Math.max(ans,v2);
        }
        if(ans == Integer.MIN_VALUE) ans=-1;
        // System.out.println(idx+" "+x+" "+v1+" "+v2+" "+ans);
        return dp[idx][x]=ans;
    }
}