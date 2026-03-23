import java.io.*;
import java.util.*;

public class entry_15717681 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        int[] applicants = new int[n];
        int[] entry_15717681 = new int[m];

        for (int i = 0; i < n; i++) {
            applicants[i] = fs.nextInt();
        }
        for (int i = 0; i < m; i++) {
            entry_15717681[i] = fs.nextInt();
        }

        Arrays.sort(applicants);
        Arrays.sort(entry_15717681);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            if (entry_15717681[j] < applicants[i] - k) {
                j++;  // apartment too small
            } else if (entry_15717681[j] > applicants[i] + k) {
                i++;  // apartment too big
            } else {
                count++;  // match
                i++;
                j++;
            }
        }

        System.out.println(count);
    }

    // 🚀 FAST INPUT
    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}