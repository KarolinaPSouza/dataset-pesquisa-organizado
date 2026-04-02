// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class entry_14520872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int amount=sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        System.out.print(mincoin(coins,amount));
        sc.close();

    }
    public static int mincoin(int[] coins,int amount){
        int n=coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i:coins){
            for(int j=i;j<=amount;j++){
                dp[j]=Math.min(dp[j],dp[j-i]+1);
            }
        }
        if(dp[amount]==amount+1) return -1;
        return dp[amount];
    }


}
