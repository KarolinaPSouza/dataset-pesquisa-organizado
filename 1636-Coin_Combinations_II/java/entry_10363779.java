
import java.util.*;

public class entry_10363779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of different coins
        int x = sc.nextInt(); // target sum
        int[] a = new int[n]; // array to hold the coin values
        int mod = 1000000007; // modulo value for large numbers

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // input for each coin
        }
        sc.close();

        int[] dp = new int[x + 1]; // dp array to store the number of ways to form each sum
        dp[0] = 1; // base case: there's one way to form the sum of 0 (using no coins)

        // Process each coin
        for (int i = 0; i < n; i++) {
            for (int sum = a[i]; sum <= x; sum++) {
                dp[sum] = (dp[sum] + dp[sum - a[i]]) % mod; // update the dp array
            }
        }

        System.out.println(dp[x]); // final result: number of ways to form the sum x
    }
}