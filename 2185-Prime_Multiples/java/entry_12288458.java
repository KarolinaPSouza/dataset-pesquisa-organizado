import java.io.*;
import java.util.*;

public class entry_12288458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] prime = new long[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            prime[i] = Long.parseLong(st.nextToken());
        }

        long res = 0;

        // Using bitwise operations for Inclusion-Exclusion Principle
        for (int mask = 1; mask < (1 << k); mask++) {
            long product = 1;
            int freq = 0;
            boolean overflow = false;

            for (int i = 0; i < k; i++) {
                if ((mask & (1 << i)) != 0) { // Checking if bit 'i' is set
                    if (product > n / prime[i]) { // Prevent overflow before multiplication
                        overflow = true;
                        break;
                    }
                    product *= prime[i];
                    freq++;
                }
            }

            if (!overflow) {
                long cnt = n / product;
                if (freq % 2 == 1) {
                    res += cnt; // Include odd sets
                } else {
                    res -= cnt; // Exclude even sets
                }
            }
        }

        pw.println(res);
        pw.flush();
    }
}