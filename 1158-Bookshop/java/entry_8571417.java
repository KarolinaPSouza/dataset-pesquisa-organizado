import java.util.Scanner;

public class entry_8571417 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] prices = new int[n + 1];
        int[] pages = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prices[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            pages[i] = scanner.nextInt();
        }

        int[] dp = new int[x + 1];

        for (int iBook = 1; iBook <= n; iBook++) {
            for (int currentPrice = x; currentPrice >= prices[iBook]; currentPrice--) {
                int left = currentPrice - prices[iBook];
                int include = pages[iBook] + dp[left];
                dp[currentPrice] = Math.max(dp[currentPrice], include);
            }
        }

        System.out.println(dp[x]);
    }
}
