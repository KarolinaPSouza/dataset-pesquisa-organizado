import java.util.*;

public class entry_12228081 {

    public static int count(int[] arr, int x) {
        int[] dp=new int[x+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i=1;i<=x;i++) {
            for (int j : arr) {
                if (j <= i && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i]=Math.min(dp[i],1+dp[i-j]);
                }
            }
        }
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        Arrays.sort(coins);

        int val=count(coins,x);

        System.out.print(val);
        scanner.close();


    }
}