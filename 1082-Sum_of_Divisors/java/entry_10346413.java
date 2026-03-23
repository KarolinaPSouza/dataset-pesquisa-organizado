import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_10346413 {
    public static void main (String argv []) throws IOException {
        BufferedReader sumDivisors = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter crow = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(sumDivisors.readLine());
        long n = Long.parseLong(st.nextToken());
        long sum = 0;
        long i = 1;
        long mod = 1000000007;
        long mod2 = 500000004;
        while (i <= n) {
            sum = ((sum + ((n/i)%mod) * (((((n/(n/i) - i + 1) % mod) * ((i + n/(n/i)) % mod)) % mod) * mod2 % mod)) % mod) % mod;
            i = n/(n/i) + 1;
        }
        long temp = mod * mod;
        crow.println(sum);
        sumDivisors.close();
        crow.close();
    }
}