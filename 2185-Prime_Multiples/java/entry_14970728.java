import java.io.*;
import java.util.*;

public class entry_14970728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] a = new long[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long ans = 0;
        long totalMasks = 1L << k;

        for (long mask = 1; mask < totalMasks; mask++) {
            int count = Long.bitCount(mask); // equivalent of __builtin_popcount in C++
            long currNum = 1;
            boolean overflow = false;

            for (int j = 0; j < k; j++) {
                if ((mask & (1L << j)) != 0) {
                    if (currNum > n / a[j]) { // prevent overflow
                        overflow = true;
                        break;
                    }
                    currNum *= a[j];
                }
            }

            if (overflow) continue;

            if (count % 2 == 1) {
                ans += n / currNum;
            } else {
                ans -= n / currNum;
            }
        }

        System.out.println(ans);
    }
}