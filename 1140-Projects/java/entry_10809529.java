import java.io.*;
import java.util.*;

public class entry_10809529 {
    public static int findPredecessor(int[][] projects, int high, int target) {
        int l = 0;
        int h = high;
        while (l <= h) {
            int mid = (l + h) / 2;

            // Move right if the middle element is less than the target
            if (projects[mid][1] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        // At this point, high will be the index of the largest element less than target
        return h >= 0 ? h : -1; // Return -1 if no predecessor exists
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] projects = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            projects[i][0] = Integer.parseInt(st.nextToken());
            projects[i][1] = Integer.parseInt(st.nextToken());
            projects[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(projects, (p1, p2) -> (p1[1] - p2[1]));

        /*************** O(n^2) Approach *****************/

        // long[] dp = new long[n];
        // for (int i = 0; i < n; i++) {
        // dp[i] = projects[i][2];
        // }

        // long max = projects[0][2];
        // for (int i = 1; i < n; i++) {
        // int j = i - 1;
        // while (j >= 0) {
        // if (projects[i][0] > projects[j][1]) {
        // dp[i] = Math.max(dp[i], projects[i][2] + dp[j]);
        // }

        // j--;
        // }

        // max = Math.max(max, dp[i]);
        // }

        // sb.append(max);

        long[] dp = new long[n];
        dp[0] = projects[0][2];

        for (int i = 1; i < n; i++) {
            // using binary search to find the predecessor (whose end time is smaller than
            // current project start time)
            int pred = findPredecessor(projects, i, projects[i][0]);

            long ans1 = dp[i - 1];
            long ans2 = projects[i][2] + (pred == -1 ? 0 : dp[pred]);

            dp[i] = Math.max(ans1, ans2);
        }

        sb.append(dp[n - 1]);
        System.out.println(sb);
    }
}