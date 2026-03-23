import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_13831808 {

    static int res = 0;
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer tk;
        long n = Long.parseLong(sc.readLine());
        long res = 0;

        for (long i = 1, last; i <= n; i = last + 1) {
            long q = n / i;
            last = n / q;
            long sumD = (sum(last) - sum(i - 1) + mod) % mod;
            res = (res + q % mod * sumD % mod) % mod;
        }

        out.println(res);
        out.close();
    }

    static long sum(long x) {
        x %= mod;
        return x * (x + 1) / 2 % mod;
    }
}

