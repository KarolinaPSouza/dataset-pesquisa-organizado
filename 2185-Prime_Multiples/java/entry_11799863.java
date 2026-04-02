import java.io.*;
import java.util.*;

public class entry_11799863 {

    public static void main(String... args) throws IOException {

//        BufferedReader reader = new BufferedReader(new FileReader("input.in"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] primes = new long[K];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < K; i++) {
            primes[i] = Long.parseLong(st.nextToken());
        }

        long ans = 0;
        for (long mask = 1; mask < (1L << K); mask++) {
            long primeProduct = 1;

            for (int i = 0; i < K; i++) {
                if ((mask & (1L << i)) != 0) {
                    if (primeProduct > N / primes[i]) {
                        primeProduct = N + 1;
                        break;
                    }
                    primeProduct *= primes[i];
                }
            }

            int num1s = 0;
            for (int i = 0; i < K; i++) {
                if ((mask & (1L << i)) != 0) {
                    num1s++;
                }
            }

            if (num1s % 2 == 0) {
                ans -= N / primeProduct;
            } else {
                ans += N / primeProduct;
            }
        }

        writer.println(ans);
        writer.close();
    }
}