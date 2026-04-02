import java.io.*;
import java.util.*;

public class entry_7744389 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        //using the concrete method
        int[] dp = new int[x + 1];
        dp[0] = 1;
        Arrays.sort(arr);
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= arr[j]) {
                    dp[i] += dp[i - arr[j]];
                    dp[i] %= (int) 1e9 + 7 ;
                } else break;
            }
        }
        System.out.println(dp[x]);
    }
}