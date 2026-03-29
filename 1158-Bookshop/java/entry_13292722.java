import java.util.*;

public class entry_13292722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of books
        int x = sc.nextInt(); // total budget

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        int[] pages = new int[n];
        for (int i = 0; i < n; i++) pages[i] = sc.nextInt();

        // 1D DP array
        int[] dp = new int[x + 1];

        for (int i = 0; i < n; i++) {
            for (int j = x; j >= prices[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - prices[i]] + pages[i]);
            }
        }

        System.out.println(dp[x]); // max pages within budget
    }
}