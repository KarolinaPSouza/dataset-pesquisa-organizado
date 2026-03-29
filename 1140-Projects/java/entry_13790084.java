import java.io.*;
import java.util.*;

public class entry_13790084 {
    static class Project {
        int start, end, reward;
        Project(int start, int end, int reward) {
            this.start = start;
            this.end = end;
            this.reward = reward;
        }
    }

    public static long maxReward(int n, int[][] projects) {
        Project[] proj = new Project[n];
        for (int i = 0; i < n; i++) {
            proj[i] = new Project(projects[i][0], projects[i][1], projects[i][2]);
        }

        // Sort projects by their ending time
        Arrays.sort(proj, Comparator.comparingInt(p -> p.end));

        // DP array to store max rewards
        long[] dp = new long[n];
        dp[0] = proj[0].reward;

        for (int i = 1; i < n; i++) {
            // Include current project
            long include = proj[i].reward;

            // Binary search to find the last non-overlapping project
            int low = 0, high = i - 1, lastNonOverlap = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (proj[mid].end < proj[i].start) {
                    lastNonOverlap = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (lastNonOverlap != -1) {
                include += dp[lastNonOverlap];
            }

            // Exclude current project
            dp[i] = Math.max(dp[i - 1], include);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] projects = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            projects[i][0] = Integer.parseInt(st.nextToken()); // Start day
            projects[i][1] = Integer.parseInt(st.nextToken()); // End day
            projects[i][2] = Integer.parseInt(st.nextToken()); // Reward
        }

        System.out.println(maxReward(n, projects));
    }
}