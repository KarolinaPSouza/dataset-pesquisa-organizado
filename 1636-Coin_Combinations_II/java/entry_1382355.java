import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class entry_1382355 {
    private static final int mod=1000000007;
    public static void main(String[]args){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int x=sc.nextInt();
//        long Coins[]=new long[n];
//        for(int i=0;i<n;i++){
//            Coins[i]=sc.nextInt();
//        }
//        long dp[]=new long[x+1];
//        for(int i=0;i<=x;i++){
//            dp[i]=Integer.MAX_VALUE;
//        }
//        dp[0]=0;
//        for(int i=1;i<=x;i++){
//            for(int j=0;j<n;j++){
//                if(Coins[j]>i)continue;
//                dp[i]=Math.min(dp[i],1+dp[(int) (i-Coins[j])]);
//            }
//        }
//        if(dp[x]==Integer.MAX_VALUE)System.out.println(-1);
//        else{
//            System.out.println(dp[x]);
//        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        long Coin[]= new long[n];
        for(int i=0;i<n;i++){
            Coin[i]=sc.nextInt();
        }
        long dp[]=new long[x+1];
        for (int i=0;i<=x;i++){
            dp[i]=0;
        }
        dp[0]=1;
        for(int j=0;j<n;j++){
            for(int i=1;i<=x;i++){
                if(Coin[j]>i)continue;
                dp[i]=(dp[i]+dp[(int) (i-Coin[j])])%mod;
            }
        }
        System.out.println(dp[x]);
    }
}