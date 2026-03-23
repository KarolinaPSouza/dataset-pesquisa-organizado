import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_1342264 {
    static long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long res = 0;
        for (long i = 1,j; i <= n; i=j) {
            long q = n / i;
            j = n / q+1;
            long x = j-i, y = i+j-1; // x*y/2 = sum(i..j-1)
            if (x%2 == 0) x /= 2;
            else y /= 2;
            x %= MOD; y %= MOD;
            res = (res+q%MOD*x%MOD*y%MOD)%MOD;
        }
        System.out.println(res);
    }
}