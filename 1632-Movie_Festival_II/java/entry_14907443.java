import java.io.*;
import java.util.*;

class compare1 implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
}

class Solution {
    public int solve(int a[][], int n, int k) {
        int ans = 0;
        Arrays.sort(a, new compare1());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(a[i][1]);
            pq1.add(a[i][1]);
        }

        for (int i = k; i < n; i++) {
            int min = pq.peek();
            int max = pq1.peek();

            if (a[i][0] >= min) {
                ans++;
                int removed = pq.poll();
                pq1.remove(removed);
                pq.add(a[i][1]);
                pq1.add(a[i][1]);
            } else if (a[i][1] < max) {
                pq.remove(max);
                pq1.poll();
                pq.add(a[i][1]);
                pq1.add(a[i][1]);
            }
        }

        return ans + pq.size();
    }
}

public class entry_14907443 {
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;
        FastScanner(InputStream in) { this.in = in; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return val * sign;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = fs.nextInt();
        int k = fs.nextInt();
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = fs.nextInt();
            a[i][1] = fs.nextInt();
        }

        Solution sol = new Solution();
        int ans = sol.solve(a, n, k);

        sb.append(ans).append('\n');
        System.out.print(sb);
    }
}