import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prem_cse
 */
public class entry_585131 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EditDistance solver = new EditDistance();
        solver.solve(1, in, out);
        out.close();
    }

    static class EditDistance {
        public void solve(int testNumber, FastReader sc, PrintWriter out) {

            String src = sc.next();
            String des = sc.next();

            int[][] dp = new int[src.length() + 1][des.length() + 1];
            for (int i = 1; i < dp.length; ++i) dp[i][0] = dp[i - 1][0] + 1;
            for (int i = 1; i < dp[0].length; ++i) dp[0][i] = dp[0][i - 1] + 1;

            for (int i = 1; i < dp.length; ++i) {
                for (int j = 1; j < dp[i].length; ++j) {
                    int c1 = dp[i - 1][j - 1]; // replace
                    int c2 = dp[i][j - 1]; // insertion
                    int c3 = dp[i - 1][j]; // deletion
                    if (src.charAt(i - 1) == des.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.min(c1, Math.min(c2, c3)) + 1;

                }
            }

            out.println(dp[src.length()][des.length()]);
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new
                    InputStreamReader(stream), 32768);
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

    }
}
