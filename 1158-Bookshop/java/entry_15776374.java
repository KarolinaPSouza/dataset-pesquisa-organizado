
import java.util.Arrays;
import java.util.Scanner;

public class entry_15776374 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int []h= new int[n];
        int[]s= new int[n];
        for(int i=0;i<n;i++){
            h[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            s[i] = sc.nextInt();
        }
        /*int[][] dp = new int[n+1][x+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        System.out.println(helper(h,s,0,x,dp));
    }
    public static int helper(int[]h,int[]s,int i,int x,int[][]dp){
        if(i==h.length|| x==0){
            return 0;
        }
        if(dp[i][x]!=-1) return dp[i][x];
        if(h[i]>x) return dp[i][x]= helper(h,s,i+1,x,dp);
        int option1= helper(h,s,i+1,x,dp);
        int option2= s[i]+helper(h,s,i+1,x-h[i],dp);
        return dp[i][x]=Math.max(option1,option2);
    }*/
        long[] dp =new long[x+1];
        for(int i =0;i <n;i++){
            int p =h[i];
            int v =s[i];
            for(int j = x;j >=p;j--){
                dp[j] = Math.max(dp[j],dp[j-p] +v);
            }
        }
        System.out.println(dp[x]);
    }
}