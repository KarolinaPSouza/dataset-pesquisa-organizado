import java.util.*;
public class entry_13750788 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int i,j;
        int[] coins=new int[n];
        int[] dp=new int[x+1];
        for(i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        dp[0]=0;
        //Arrays.sort(coins);
        for(i=1;i<=x;i++){
            dp[i]=Integer.MAX_VALUE;
            for(j=0;j<n;j++){
                if(i-coins[j]>=0){
                    if(dp[i-coins[j]]==Integer.MAX_VALUE){
                        dp[i]=Math.min(dp[i],dp[i-coins[j]]);
                    }
                    else{
                        dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                    }

                }
            }
        }
        if(dp[x]==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[x]);
        }


    }
}