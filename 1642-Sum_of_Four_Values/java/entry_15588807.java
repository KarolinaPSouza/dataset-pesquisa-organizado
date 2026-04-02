import java.io.*;
import java.util.*;

public class entry_15588807 {

    static class Pair {

        long value, index;

        Pair(long v, long i) {
            value = v;
            index = i;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        Pair[] a = new Pair[n];

        int i = 0;
        while (i < n) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            long x = Long.parseLong(st.nextToken());
            a[i] = new Pair(x, i + 1);
            i++;
        }

        Arrays.sort(a, Comparator.comparingLong(p -> p.value));

        for (int p1 = 0; p1 < n - 3; p1++) {
            for (int p2 = p1 + 1; p2 < n - 2; p2++) {
                int p3 = p2 + 1;
                int p4 = n - 1;

                while (p3 < p4) {
                    long sum = a[p1].value + a[p2].value
                            + a[p3].value + a[p4].value;

                    if (sum == k) {
                        System.out.println(
                                a[p1].index + " "
                                + a[p2].index + " "
                                + a[p3].index + " "
                                + a[p4].index
                        );
                        return;
                    } else if (sum > k) {
                        p4--;
                    } else {
                        p3++;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}