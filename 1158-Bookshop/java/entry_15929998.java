import java.util.Scanner;

public class entry_15929998 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int x = input.nextInt();

        int[] prices = new int[n];
        int[] pages = new int[n];

        for(int i = 0; i < n; i++){
            prices[i] = input.nextInt();
        }

        for(int i = 0; i < n; i++){
            pages[i] = input.nextInt();
        }
        // How many states are needed for this problem
        // Think about the recursive way to solve the problem and then memoize it.
        int[][] dp = new int[n+1][x+1];

//        for(int i = 0; i <= n; i++){
//            Arrays.fill(dp[i],-1);
//        }
//        int maxPages = recursion(n-1,x,prices,pages,dp);
//        System.out.println(maxPages);

        tabulation(x,prices,pages,dp);
    }

    public static int recursion(int idx, int capacity, int[] prices, int[] pages, int[][] dp){

        if(idx < 0){
            return 0;
        }

        if(dp[idx][capacity] != -1){
            return dp[idx][capacity];
        }

        int leave = recursion(idx-1, capacity, prices, pages,dp);
        int pick = Integer.MIN_VALUE;

        if(prices[idx] <= capacity){
            pick = pages[idx] + recursion(idx-1, capacity - prices[idx], prices, pages,dp);
        }

        return dp[idx][capacity] = Math.max(pick , leave);
    }

    public static void tabulation(int capacity, int[] prices, int[] pages, int[][] dp){
        int n = prices.length;

        for(int i = 1; i <= n; i++){

            for(int c = 1; c <= capacity; c++){

               if(prices[i-1] <= c){
                   dp[i][c] = Math.max(dp[i-1][c] , pages[i-1] + dp[i-1][c - prices[i-1]]);
               }
               else{
                   dp[i][c] = dp[i-1][c];
               }
            }
        }

        System.out.println(dp[n][capacity]);
    }
}