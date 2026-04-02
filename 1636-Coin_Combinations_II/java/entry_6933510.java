import java.util.Scanner;

public class entry_6933510 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }

        int mod = (int)(1e9 + 7);
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i < dp.length; i++){
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }

        System.out.println(dp[sum]);
    }
}