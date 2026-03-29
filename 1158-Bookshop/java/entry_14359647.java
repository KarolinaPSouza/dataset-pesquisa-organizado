import java.io.*;
import java.util.*;
public class entry_14359647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // int t = Integer.parseInt(br.readLine());
        // while (t-- > 0) {
            solve(br, pw);
        // }
        pw.flush();
        pw.close();
    }

    private static void solve(BufferedReader br, PrintWriter pw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] cost = new int[n];
        int[] pages = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n+1][x+1];
        for(int j=1;j<=x;j++) {
            if(cost[0] > j) continue;
            dp[0][j] = pages[0]; 
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<=x;j++) {
                if(cost[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], pages[i] + dp[i-1][j-cost[i]]);
                }
            }
        }
        pw.println(dp[n-1][x]);
    }
}