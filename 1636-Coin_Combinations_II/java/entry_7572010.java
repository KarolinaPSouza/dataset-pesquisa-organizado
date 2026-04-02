import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_7572010 {
    public static void main(String[] args) throws Exception {
        BufferedScanner in = new BufferedScanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt();
        int X = in.nextInt();

        int[] dp = new int[X + 1];
        dp[0] = 1;

        int MOD = 1000000007;

        for (int i = 0; i < N; i++) {
            int coin = in.nextInt();
            for (int j = coin; j <= X; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }

        System.out.println(dp[X]);

        in.close();
        out.flush();
        out.close();
    }
}

class BufferedScanner {
    private BufferedReader in;
    private StringTokenizer tokens;
    private String line;

    public BufferedScanner(BufferedReader in) throws IOException {
        this.in = in;
        line = "";
    }

    public String nextLine() throws IOException {
        line = in.readLine();
        initTokens();
        return line;
    }

    public String getCurrentLine() {
        return line;
    }

    private void initTokens() {
        if (line == null) {
            tokens = null;
            return;
        }
        tokens = new StringTokenizer(line);
        checkTokenizer();
    }

    private void checkTokenizer() {
        if (tokens != null && !tokens.hasMoreTokens()) {
            tokens = null;
        }
    }

    public boolean hasMoreTokensInLine() {
        return tokens != null;
    }

    public String nextToken() throws IOException {
        if (line == null) {
            return null;
        }

        if (!hasMoreTokensInLine()) {
            nextLine();
            return nextToken();
        }

        String retTok = tokens.nextToken();
        checkTokenizer();

        return retTok;
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public void close() throws IOException {
        in.close();
        tokens = null;
        line = null;
    }

}