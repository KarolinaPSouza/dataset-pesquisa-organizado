import java.util.*;
import java.io.*;

public class entry_1338172 {
    int mod = 1000000007;

    // SOLUTION BEGIN
    void pre() throws Exception {

    }

    void solve() throws Exception {
        int n = ni();
        int x = ni();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = ni();
        pn(coinThrowCombination(n, x, coins));
    }

    // 1
    int recursionCoinThrow(int sum) {
        if (sum == 0)
            return 1;
        int res = 0;
        for (int i = 1; i <= 6 && sum - i >= 0; i++) {
            res = res + recursionCoinThrow(sum - i);
        }
        return res;
    }

    int dpCoinThrow(int sum) {
        int dp[] = new int[sum + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= sum; i++) {
            for (int j = 1; j <= 6 && i - j >= 0; j++) {
                dp[i] = dp[i] + dp[i - j];
            }
        }
        return dp[sum];
    }

    // 2
    int coinThrowCombination(int n, int x, int[] coins) {

        int dp[] = new int[x + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= x; i++) {
                if (coin > i)
                    continue;
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }
        return dp[x] % mod;
    }

    static boolean multipleTC = false;
    static FastReader in;
    static PrintWriter out;
    static Scanner sc;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        sc = new Scanner(System.in);
        int T = (multipleTC) ? ni() : 1;
        pre();
        for (int t = 1; t <= T; t++)
            solve();
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        try {
            new entry_1338172().run();
        } catch (Exception e) {

        }
    }

    int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String n() throws Exception {
        return in.next();
    }

    String nln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return in.nextInt();
    }

    long nl() throws Exception {
        return in.nextLong();
    }

    double nd() throws Exception {
        return in.nextDouble();
    }

}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}