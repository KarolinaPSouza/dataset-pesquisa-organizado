import java.util.Scanner;

public class entry_11730358 {
//    static int[] prices;
//    static int[] pages;
//    static int[][] memo;

    //    private static int solve(int idx,int page, int amount){
//        if(idx == prices.length || amount == 0) return page;
//        if (memo[idx][amount]!=-1)return memo[idx][amount];
//        int pick = 0;
//        if (amount-prices[idx] >= 0){
//            pick = solve(idx+1,page+pages[idx],amount-prices[idx]);
//        }
//        int notPick = solve(idx+1,page,amount);
//        return memo[idx][amount] = Math.max(pick,notPick);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }
//        memo = new int[n][x + 1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(memo[i], -1);
//        }
//        System.out.println(solve(0, 0, x));
        sc.close();
        int[] dp = new int[x+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = x; j > 0; j--) {
                    if (prices[i-1] > j) continue;
                    dp[j] = Math.max(dp[j],pages[i-1]+dp[j-prices[i-1]]);

            }
        }
        System.out.println(dp[x]);
    }
}