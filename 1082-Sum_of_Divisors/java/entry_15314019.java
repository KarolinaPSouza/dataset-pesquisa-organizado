import java.io.*;
import java.util.*;

public class entry_15314019 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int MOD= 1000000007;
        long n= Long.parseLong(br.readLine());



         long result = 0;
    long i = 1;
    while (i <= n) {
        long quotient = n / i;
        long next = n / quotient;
        long count = next - i + 1;

        long sumRange;
        if ((i + next) % 2 == 0) {
            // (i + next) is even, divide it by 2 first to keep integer division
            sumRange = (((i + next) / 2) % MOD) * (count % MOD) % MOD;
        } else {
            // count is even, divide it by 2 first
            sumRange = ((i + next) % MOD) * ((count / 2) % MOD) % MOD;
        }

        long term = (quotient % MOD) * sumRange % MOD;
        result = (result + term) % MOD;

        i = next + 1;
    }
    pw.println(result);








        pw.close();
    }
}
