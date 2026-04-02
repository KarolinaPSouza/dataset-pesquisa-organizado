import java.io.*;
import java.util.*;
import java.lang.*;

public class entry_5920852 {
    static int MOD=1000000000+7;
    static int cnt[];
    static int rec(int i,int j,char s[],char t[],int dp[][])
    {
        if(i==s.length  && j==t.length)
            return 0;
        if(i==s.length)
            return t.length-j;
        if(j==t.length)
            return s.length-i;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=0;
        if(s[i]==t[j])
        {
            ans=Math.min(rec(i+1,j+1,s,t,dp),Math.min(1+rec(i+1,j,s,t,dp),1+rec(i,j+1,s,t,dp)));
        }
        else
        {
            ans=Math.min(1+rec(i+1,j+1,s,t,dp),Math.min(1+rec(i+1,j,s,t,dp),1+rec(i,j+1,s,t,dp)));
        }
        return dp[i][j]=ans;
    }
    static int solve(int n,int m,char s[],char t[])
    {
           int dp[][]=new int[n][m];
           for(int j=0;j<n;j++)
               Arrays.fill(dp[j],-1);
           return rec(0,0,s,t,dp);
    }
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        /*
        String st1[]=(buf.readLine().split(" "));
        int n=Integer.parseInt(st1[0]);
        String st2[]=(buf.readLine()).split(" ");
        int arr[]=new int[n];
        for(int j=0;j<n;j++)
            arr[j]=Integer.parseInt(st2[j]);
        cnt=new int[100000+1];
        //set=new HashSet<>();
        solve(n,arr);
        int ct=0;
        for(int j=1;j<=100000;j++)
        {
            if(cnt[j]>=1)
            {
                ct++;
                sb.append(j+" ");
            }
        }
        System.out.println(ct);
        System.out.println(sb);
          */
        char s[]=(buf.readLine().trim()).toCharArray();
        char t[]=(buf.readLine().trim()).toCharArray();
        System.out.println(solve(s.length,t.length,s,t));
    }
}