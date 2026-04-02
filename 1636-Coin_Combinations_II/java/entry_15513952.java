import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class entry_15513952 {

    final long MOD = (long) 1e9 + 7;
    final int MAX_SIZE = 1_000_000;
    final int[] arr = new int[MAX_SIZE];
    int t = 1;

    final BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    final PrintWriter out = new PrintWriter(System.out, false);
    String[] tokens;
    int currentTokenIndex = 0;

    public static void main(String[] args) {
        new entry_15513952().go();
    }

    String next() throws IOException {
        if (tokens == null || currentTokenIndex >= tokens.length) {
            tokens = in.readLine().split(" ");
            currentTokenIndex = 0;
        }
        return tokens[currentTokenIndex++];
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String stringify(Object input) {
        if (input instanceof int[]) {
            return IntStream.of((int[]) input)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        } else if (input instanceof long[]) {
            return LongStream.of((long[]) input)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        } else if (input instanceof String[]) {
            return String.join("\n", (String[])input);
        } else if (input instanceof Integer || input instanceof Long || input instanceof Double || input instanceof Character) {
            return String.valueOf(input);
        } else if (input instanceof String) {
            return (String) input;
        } else if (input instanceof Boolean) {
            return (boolean)input ? "YES" : "NO";
        } else {
            return "Unsupported type";
        }
    }

    public void go() {
        try {
            //t = nextInt();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < t; i++) {
                sb.append(stringify(solve())).append("\n");
            }
            out.print(sb);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long solve() throws IOException {
        int n = nextInt(), x = nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) coins[i] = nextInt();

        long[][] dp = new long[2][x+1];
        dp[0][0] = dp[1][0] = 1;

        for(int i = 1; i <= n; i++) {
            int it = i%2;
            for(int j = 1; j <= x; j++) {
                if(coins[i-1] <= j) dp[it][j] = (dp[it][j-coins[i-1]] + dp[1-it][j])%MOD;
                else dp[it][j] = dp[1-it][j];
            }
        }
        return dp[n%2][x]%MOD;
    }
}