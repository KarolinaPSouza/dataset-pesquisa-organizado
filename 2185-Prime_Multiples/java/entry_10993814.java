import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_10993814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long count = 0;
        // Iterate over all subsets of primes using bitmask
        for (int i = 1; i < (1 << k); i++) {
            long lcm = 1;
            int bitCount = 0;
            boolean validSubset = true;

            for (int j = 0; j < k; j++) {
                if ((i & (1 << j)) > 0) { // Check if jth prime is in subset
                    bitCount++;
                    // To avoid overflow, check if the next lcm computation would exceed n
                    if (lcm > n / arr[j]) {
                        validSubset = false;
                        break;
                    }
                    lcm *= arr[j];
                }
            }

            if (!validSubset) continue;

            long divisibleCount = n / lcm;
            if (bitCount % 2 == 1) {
                count += divisibleCount;
            } else {
                count -= divisibleCount;
            }
        }

        System.out.println(count);
    }
}