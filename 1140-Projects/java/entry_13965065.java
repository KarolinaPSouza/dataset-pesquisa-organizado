import java.io.*;
import java.util.*;

public class entry_13965065 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    // 🔹 Binary search to find index of last project with endTime <= time
    static int findLast(int[] endTimes, int time) {
        int l = 0, r = endTimes.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (endTimes[mid] <= time) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt(); 
            arr[i][1] = sc.nextInt(); 
            arr[i][2] = sc.nextInt(); 
        }

        // Sort by end time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) endTimes[i] = arr[i][1];

        long[] dp = new long[n];
        dp[0] = arr[0][2];

        for (int i = 1; i < n; i++) {
            long take = arr[i][2];

            // Find last project that ends before current project starts
            int idx = findLast(endTimes, arr[i][0] - 1);
            if (idx != -1) take += dp[idx];

            // Either take or skip
            dp[i] = Math.max(dp[i - 1], take);
        }

        System.out.println(dp[n - 1]);
    }
}