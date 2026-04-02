import java.util.Arrays;
import java.util.Scanner;

public class entry_15813263 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(new File("D:/Striver's 79/CSES/test_case.txt"));
        int n=sc.nextInt(), x=sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        Arrays.sort(coins);
        System.out.println(comb1(coins,x));
        sc.close();
    }
    static int mod = 1000000007;
    public static int comb1(int[] coins, int sum){
        int n=coins.length;
        int[] dp = new int[sum+1];
        dp[0]=1;
        for(int x=1;x<=sum;x++){
            int res=0;
            for(int coin:coins){
                if(x<coin) break;
                res+=dp[x-coin];
                if(res>=mod) res-=mod;
            }
            dp[x]=res;
        }
        return dp[sum];
    }
}