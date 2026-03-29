import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_5498209 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(f.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        long[] dp = new long[n + 1]; // dp[i] is max cost considering first i values
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            int start = arr[i - 1][0];
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (arr[mid][1] < start) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (arr[l][1] < start)
                dp[i] = Math.max(dp[i], dp[l + 1] + arr[i - 1][2]);
            else
                dp[i] = Math.max(dp[i], arr[i - 1][2]);
        }
        out.println(dp[n]);
        out.close();
        f.close();
    }
}