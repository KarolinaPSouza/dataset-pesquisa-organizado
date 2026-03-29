import java.util.Scanner;

public class entry_13401519 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // number of books
        int x = sc.nextInt();  // max cost
        sc.nextLine();

        int[] cost = new int[n];
        int[] pages = new int[n];

        for(int i=0;i<n;i++){
            cost[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            pages[i] = sc.nextInt();
        }

        sc.close();

        int[] dp = new int[x+1];

        for(int i=0; i<n; i++) {
            // traverse budget backwards to avoid using overwritten dp[j - cost[i]]
            for(int j=x; j>=cost[i]; j--) {
                dp[j] = Math.max(dp[j], pages[i] + dp[j - cost[i]]);
            }
        }

        System.out.println(dp[x]);
    }
}