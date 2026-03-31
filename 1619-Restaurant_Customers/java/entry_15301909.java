import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_15301909 {
    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int n = sc.nextInt();

        int[] arriving = new int[n];
        int[] leaving = new int[n];

        for (int i = 0; i < n; i++) {
            arriving[i] = sc.nextInt();
            leaving[i] = sc.nextInt();
        }

        Arrays.sort(arriving);
        Arrays.sort(leaving);

        int current = 0;
        int maxCustomers = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arriving[i] < leaving[j]) {
                current++;
                maxCustomers = Math.max(maxCustomers, current);
                i++;
            } else{
                current--;
                j++;
            }
        }
        System.out.println(maxCustomers);
    }
}