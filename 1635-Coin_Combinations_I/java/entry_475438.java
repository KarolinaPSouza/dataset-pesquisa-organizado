import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class entry_475438 extends PrintWriter {
    entry_475438() { super(System.out); }

    static class Scanner {
        Scanner(InputStream in) { this.in = in; } InputStream in;
        int k, l; byte[] bb = new byte[1 << 15];
        byte getc() {
            if (k >= l) {
                k = 0;
                try { l = in.read(bb); } catch (IOException e) { l = 0; }
                if (l <= 0) return -1;
            }
            return bb[k++];
        }
        int nextInt() {
            byte c = 0; while (c <= 32) c = getc();
            int a = 0;
            while (c > 32) { a = a * 10 + c - '0'; c = getc(); }
            return a;
        }
    }

    public static void main(String[] $) {
        entry_475438 o = new entry_475438();
        o.main();
        o.flush();
    }

    public void main() {
        Scanner sc = new Scanner(System.in);
        final int modVal = (int) (Math.pow(10, 9) + 7);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        long[] dp = new long[x + 1];
        dp[0] = 1;

        for (int y = 1; y <= x; y++) {
            long z = 0;
            for (int i = 0; i < n; i++) {
                int c = coins[i];
                if (y >= c) {
                    z = (z + dp[y - c]);
                }
            }
            dp[y] = z%modVal;
        }
        System.out.println(dp[x]);
    }
}