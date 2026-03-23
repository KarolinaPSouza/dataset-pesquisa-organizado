import java.io.BufferedReader;
import java.io.InputStreamReader;

public class entry_15510474 {
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        long result = 0;
        long start = 1;

        while (start <= N) {
            long quotient = N / start;
            long end = N / quotient;

            long left = start;
            long right = end;

            long count = right - left + 1;

            long sumRange = ((left + right) % MOD) * (count % MOD) % MOD;
            sumRange = sumRange * ((MOD + 1) / 2) % MOD;

            result = (result + quotient % MOD * sumRange) % MOD;

            start = end + 1;
        }

        System.out.println(result % MOD);
    }
}