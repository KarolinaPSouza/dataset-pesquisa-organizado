import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_15815798 {
    static FastScanner sc = new FastScanner(System.in);
    static final int MOD = (int)1e9 + 7;

    public static void main(String[] args){
        int n = sc.nextInt();
        int x = sc.nextInt();
        int prices[] = new int[n];
        int pages[] = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            pages[i] = sc.nextInt();
        }
        int dp[][] = new int[n][x + 1];
        for(int j = 0; j < x + 1; j++){
            if(prices[0] <= j){
                dp[0][j] = pages[0];
            }
        }

        for(int idx = 1; idx < n; idx++){
            for(int amount = 1; amount < x + 1; amount++){
                int notTake = dp[idx - 1][amount];
                int take = (int)-1e9;
                if(prices[idx] <= amount){
                    take = pages[idx] + dp[idx - 1][amount - prices[idx]];
                }
                dp[idx][amount] = Math.max(notTake, take);
            }
        }
        System.out.println(dp[n - 1][x]);
    }

    public static int solve(int idx, int amount, int prices[], int pages[], int dp[][]){
        if(amount == 0){
            return 0; 
        }
        if(idx == 0){
            if(prices[0] <= amount){
                return pages[0];
            }   
            return 0;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int notTake = solve(idx - 1, amount, prices, pages, dp);
        int take = (int)-1e9;
        if(prices[idx] <= amount){
            take = pages[idx] + solve(idx - 1, amount - prices[idx], prices, pages, dp);
        }
        return dp[idx][amount] = Math.max(notTake, take);
    }

    // Fast Scanner using InputStream + StringTokenizer
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}