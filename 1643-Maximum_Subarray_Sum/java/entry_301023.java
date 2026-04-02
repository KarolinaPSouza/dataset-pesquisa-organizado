import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_301023 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader f = new BufferedReader(new
        // FileReader("test_input.txt"));
        PrintWriter w = new PrintWriter(System.out);
        String input = f.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        long[] nums = new long[n];
        input = f.readLine();
        st = new StringTokenizer(input);
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        long ans = Integer.MIN_VALUE;
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (dp[i] < 0) {
                dp[i + 1] = nums[i];
            } else {
                dp[i + 1] = nums[i] + dp[i];
            }
            ans = Math.max(ans, dp[i + 1]);
        }
        w.println(ans);
        w.close();
        f.close();
    }
}