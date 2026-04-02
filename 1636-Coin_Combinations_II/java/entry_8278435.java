import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_8278435 {


    private static final int MODULO = 1000000007;


    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(InputReader sc, PrintWriter out) {
            //Solution Here

            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) coins[i] = sc.nextInt();
            Arrays.sort(coins);

            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = 1; i <= target; i++) {
                    if (coin > i) continue;
      dp[i] = (dp[i] + dp[i - coin]) % MODULO;

                }
            }
            out.print(dp[target]);

            //Solution End
        }

        public static long lcm(long a, long b) {
            return Math.abs(a * b) / gcd(a, b);
        }

        public static long gcd(long a, long b) {
            while (b != 0) {
                long temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public Double nextDouble() {
            return Double.parseDouble(next());
        }

    }


}
