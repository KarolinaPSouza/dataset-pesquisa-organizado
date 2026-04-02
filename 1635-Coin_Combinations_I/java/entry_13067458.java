import java.util.Scanner;

public class entry_13067458 {
    public static void main(String[] args) {
        //unordered
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] dp = new int[x+1];
        int[] coins = new int[n];
        for(int i = 0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        dp[0] = 1;
        for(int j =1;j<=x;j++){
        for(int i =1;i<=n;i++){
              if(j>=coins[i-1])dp[j] = (dp[j-coins[i-1]]+dp[j])%1000000007;
           }
        }
        System.out.println(dp[x]);
    }
}