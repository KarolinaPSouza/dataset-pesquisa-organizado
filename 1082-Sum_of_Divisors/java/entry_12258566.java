import java.io.*;

public class entry_12258566 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        long n = Long.parseLong(br.readLine()); // Read input
        long result = 0;

        for (long i = 1; i <= n; ) {
            long quotient = n / i;  // Value of floor(n / i)
            long nextI = n / quotient + 1; // The next index where quotient changes

            // Sum of numbers from i to nextI-1 using arithmetic sum formula
            long sumRange = ((nextI - i) % MOD * ((i + nextI - 1) % MOD) % MOD * 500000004) % MOD; // (modular inverse of 2 is 500000004)

            // Multiply by quotient and add to result
            result = (result + (sumRange * quotient) % MOD) % MOD;

            i = nextI; // Move to the next range
        }

        pw.println(result);
        pw.flush();
    }
}