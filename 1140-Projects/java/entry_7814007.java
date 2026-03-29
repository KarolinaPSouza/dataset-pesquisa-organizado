import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class entry_7814007 {

    /**
     * projects[i][0]: "starting" day of ith project.
     * projects[i][1]: "ending" day of ith project.
     * projects[i][2]: "reward" value of ith project.
     */
    public long maxMoney(int n, int[][] projects) {
        Arrays.sort(projects, Comparator.comparingInt(a -> a[1]));

        long[] dp = new long[n];
        dp[0] = projects[0][2];

        for (int i = 1; i < n; i++) {
            // select current project
            long ans1 = projects[i][2];
            int rightmostNonOverlappingProject = upperBound(projects, i - 1, projects[i][0] - 1);
            //System.out.println("rightmost for " + i + " is: " + rightmostNonOverlappingProject);
            if (rightmostNonOverlappingProject >= 0) {
                ans1 += dp[rightmostNonOverlappingProject];
            }

            // skip current project
            long ans2 = dp[i - 1];

            dp[i] = Math.max(ans1, ans2);
        }

        return dp[n - 1];
    }

    /**
     * Find the rightmost index where we can insert the input element
     * (In our case, we want to find rightmost project where we can insert a project with given endTime)
     */
    private int upperBound(int[][] projects, int index, int startingDay) {
        int start = 0;
        int end = index;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (projects[mid][1] <= startingDay) {
                ans = mid;
                // check if a better solution exists in the right half
                start = mid + 1;
            } else {
                // search in the left half
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main_old(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] projects = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                projects[i][j] = scanner.nextInt();
            }
        }

        entry_7814007 sol = new entry_7814007();
        System.out.println(sol.maxMoney(n, projects));

        scanner.close();
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner fs = new FastScanner();
        long ct = System.currentTimeMillis();

        int n = fs.nextInt();
        int[][] projects = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                projects[i][j] = fs.nextInt();
            }
        }
        entry_7814007 sol = new entry_7814007();
        var ans = sol.maxMoney(n, projects);

        System.err.println(System.currentTimeMillis() - ct + " ms");
        out.printf("%d", ans);
        out.flush();
        out.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

}