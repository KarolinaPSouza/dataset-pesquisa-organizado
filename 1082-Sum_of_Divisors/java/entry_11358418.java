import java.io.*;

public class entry_11358418 {
    private static final long MOD = (long) 1e9 + 7;


    private static long sigma(long x) {
        return (x % MOD) * ((x + 1) % MOD) / 2 % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(reader.readLine().trim());
        long sum = 0;
        for (long l = 1; l <= N; ) {
            long r = N / (N / l); 
            long term = (N / l) % MOD * (sigma(r) - sigma(l - 1) + MOD) % MOD;
            sum = (sum + term) % MOD; 
            l = r + 1; 
        }

        System.out.println(sum);
    }
}