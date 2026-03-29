import java.util.*;
import java.io.*;

public class entry_1217883 {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new entry_1217883().run(in, out);
        out.close();
    }

    int n;
    int[][] p;

    int[] stackTime;
    long[] stackPrice;
    int si;
    void run(FastScanner in, PrintWriter out) {

        n = in.nextInt();
        p = new int[n][3];
        for (int i = 0; i < n; i++) {
            p[i][0] = in.nextInt();
            p[i][1] = in.nextInt();
            p[i][2] = in.nextInt();
        }

        // sort by ending time
        Arrays.sort(p, (a, b) -> a[1]-b[1]);

        stackTime = new int[n+1];
        stackPrice = new long[n+1];
        si = 1;
        long max = 0;

        for (int i = 0; i < n; i++) {

            // find pos of time < me (strictly)
            int index = lb(p[i][0]);
            long newPrice = stackPrice[index] + p[i][2];
            if (newPrice <= stackPrice[si-1]) continue;

            stackTime[si] = p[i][1];
            stackPrice[si] = newPrice;
            max = Math.max(max, newPrice);
            si++;
        }
        out.println(max);

    }

    int lb(int time) {

        int lo = 0;
        int hi = si;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (stackTime[m] > time) {
                hi = m;
            } else {
                lo = m+1;
            }
        }

        if (stackTime[lo-1] == time) return lo-2;
        return lo-1;
    }



    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}