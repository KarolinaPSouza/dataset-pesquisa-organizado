import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author akherbouch
 */
public class entry_1701529 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ConcertTickets solver = new ConcertTickets();
        solver.solve(1, in, out);
        out.close();
    }

    static class ConcertTickets {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] h = new int[n];
            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
                pos[i] = i;
            }
            Algo2.shuffleAndSort(h);
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int ti = in.nextInt();
                int p = Algo2.floor(h, ti);
                while (p != -1 && pos[p] != p) {
                    int tmp = pos[p];
                    if (tmp != -1) pos[p] = pos[tmp];
                    p = tmp;
                }
                //p = find(pos, p);
                if (p != -1) {
                    buf.append(h[p]).append("\n");
                    pos[p]--;
                } else {
                    buf.append(-1).append("\n");
                }
            }
            out.println(buf.toString());
        }

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = new StringTokenizer("");
        }

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static final class Algo2 {
        public static void shuffleAndSort(int[] a) {
            shuffle(a);
            Arrays.sort(a);
        }

        public static void shuffle(int[] a) {
            Random r = new Random();
            int n = a.length;
            for (int i = 0; i < n; i++) {
                int j = r.nextInt(n);
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        public static int floor(int[] a, int value) {
            int low = -1;
            int high = a.length;
            while (high - low > 1) {
                int mid = (high + low) / 2;
                if (a[mid] <= value) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            return low;
        }

    }
}
