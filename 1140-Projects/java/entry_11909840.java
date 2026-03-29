import java.io.*;
import java.util.*;

public class entry_11909840 {
    public static long maxReward(int n, List<long[]> projects) {
        Collections.sort(projects, (a, b) -> Long.compare(a[1], b[1]));

        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            long[] currentProject = projects.get(i - 1);
            long start = currentProject[0];
            long end = currentProject[1];
            long reward = currentProject[2];

            int j = binarySearch(projects, start - 1);
            dp[i] = Math.max(dp[i - 1], reward + dp[j]);
        }

        return dp[n];
    }

    public static int binarySearch(List<long[]> projects, long target) {
        int left = 0, right = projects.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (projects.get(mid)[1] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<long[]> projects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            projects.add(new long[] { a, b, p });
        }

        System.out.println(maxReward(n, projects));
    }
}