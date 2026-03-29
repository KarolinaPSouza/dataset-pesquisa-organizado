import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_10262981 {
    private static class Project {
        int start, end, amount;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        Project[] projects = new Project[n];
        for (int i = 0; i < n; ++i) {
            projects[i] = new Project();
            StringTokenizer st = new StringTokenizer(in.readLine());
            projects[i].start = Integer.parseInt(st.nextToken());
            projects[i].end = Integer.parseInt(st.nextToken());
            projects[i].amount = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(projects, (a, b) -> {
            return a.end - b.end;
        });

        long dp[] = new long[n + 1];
        for (int i = 0; i < projects.length; ++i) {
            int mid, left = -1, right = i;
            while (right - left > 1) {
                mid = (left + right) >> 1;
                if (projects[mid].end < projects[i].start) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            long amount = projects[i].amount;
            if (left >= 0) {
                amount += dp[left + 1];
            }
            dp[i + 1] = Math.max(dp[i], amount);
        }

        out.println(dp[n]);
        out.flush();
    }
}