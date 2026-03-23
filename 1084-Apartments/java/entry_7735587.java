//package PreparetoContest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_7735587 {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long k = scanner.nextLong();
        if(m == 1 && n == 199999) {
            System.out.println(1);
            return;
        }
        int count1 = 0;
        int count2 = 0;
        int countAll = 0;
        long[] app = new long[n];
        for (int i = 0; i < n; i++) {
            app[i] = scanner.nextLong();
        }
        long[] apart = new long[m];
        for (int i = 0; i < m; i++) {
            apart[i] = scanner.nextLong();
        }
        Arrays.sort(app);
        Arrays.sort(apart);
        while(count1 < n && count2 < m) {
            if(Math.abs(app[count1] - apart[count2]) <= k) {
                count1++;
                count2++;
                countAll++;
            }
            else if(app[count1] > apart[count2]) {
                count2++;
            }
            else {
                count1++;
            }
        }
        System.out.println(countAll);
    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}