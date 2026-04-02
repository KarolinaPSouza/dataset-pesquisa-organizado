import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class entry_8809316 {
    static final Random random = new Random();
    static final long MOD = 1_000_000_007L;
    static final int inf = Integer.MAX_VALUE / 4;
    static final int N = 200001;
    static final long INF = Long.MAX_VALUE / 4;
    static FastScanner fs = new FastScanner();
    // static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static PrintWriter out = new PrintWriter(System.out);
    static boolean LOCAL = System.getProperty("ONLINE_JUDGE") == null;

    public static void main(String args[]) throws IOException {
        int T = 1;
        //T = fs.nextInt();
        long start = System.currentTimeMillis();
        for (int testcase = 1; testcase <= T; ++testcase) {
            // debug("Case := " + testcase + " ");
            solve();
        }
        System.err.println("Runtime:= " + (System.currentTimeMillis() - start) + " :ms");
        out.close();
    }

    private static void solve() {
        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = fs.nextInt();
        }
        long[] dp = new long[n];
        Arrays.fill(dp,-INF);
        dp[0] = a[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }
        long res = -INF;
        for (var i : dp) res = Math.max(res, i);
        out.println(res);
    }

    private static void Sort(int[] a) {
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        for (int i : a) list.add(i);
        list.sort(null);
        for (int i = 0; i < n; ++i) a[i] = list.get(i);
    }

    private static void debug(Object... O) {
        if (LOCAL)
            System.err.println(Arrays.deepToString(O));
    }
}


/*Fast Input Template */
class FastScanner {
    private final int BS = 1 << 16;
    private final char NC = (char) 0;
    private final byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastScanner() {
        in = new BufferedInputStream(System.in, BS);
    }

    public FastScanner(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        } catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }

    private char getChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public long nextLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = getChar();
        for (; (c < '0' || c > '9'); c = getChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = getChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public String next() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c > 32) {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }

    public String nextLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c != '\n') {
            res.append(c);
            c = getChar();
        }
        return res.toString();
    }
}
