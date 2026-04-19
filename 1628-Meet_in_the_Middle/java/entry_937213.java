import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class entry_937213 {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 27);
        thread.start();
        thread.join();
    }
 
    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastReader in = new FastReader(inputStream);
            PrintWriter out = new PrintWriter(outputStream);
            MeetInTheMiddle solver = new MeetInTheMiddle();
            solver.solve(1, in, out);
            out.close();
        }
    }
 
    static class MeetInTheMiddle {
        int[] f1 = new int[1 << 20];
        int[] f2 = new int[1 << 20];
        int P = 1 << 20;
 
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int n = s.nextInt(), x = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = s.nextInt();
            long res = 0;
            int nn = n >> 1, MX = 1 << nn;
            boolean ok;
            Arrays.fill(f1, (int) 1e9 + 1);
            Arrays.fill(f2, (int) 1e9 + 1);
            for (int i = 0; i < MX; i++) {
                int sum = 0, t = i, cur = 0;
                ok = true;
                while (t > 0) {
                    if ((t & 1) == 1) {
                        sum += a[cur];
                        if (sum > x) {
                            ok = false;
                            break;
                        }
                    }
                    cur++;
                    t >>= 1;
                }
                if (ok) f1[i] = sum;
            }
 
            int nm = n - nn;
            MX = 1 << nm;
            for (int i = 0; i < MX; i++) {
                int sum = 0, t = i, cur = nn;
                ok = true;
                while (t > 0) {
                    if ((t & 1) == 1) {
                        sum += a[cur];
                        if (sum > x) {
                            ok = false;
                            break;
                        }
                    }
                    cur++;
                    t >>= 1;
                }
                if (ok) f2[i] = sum;
            }
            func.sort(f1);
            func.sort(f2);
            for (int i = P - 1, l = 0, r = 0; i >= 0; i--) {
                int req = x - f1[i];
                while (l < P && f2[l] < req) l++;
                while (r < P && f2[r] <= req) r++;
                if (l < P && f1[i] + f2[l] == x) res += r - l;
            }
            w.println(res);
        }
 
    }
 
    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;
 
        public FastReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
 
            if (numChars == -1)
                throw new InputMismatchException();
 
            if (curChar >= numChars) {
 
                curChar = 0;
 
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
 
                if (numChars <= 0)
                    return -1;
            }
 
            return buf[curChar++];
        }
 
        public int nextInt() {
 
            int c = read();
 
            while (isSpaceChar(c))
                c = read();
 
            int sgn = 1;
 
            if (c == '-') {
                sgn = -1;
                c = read();
            }
 
            int res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
 
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public boolean isSpaceChar(int c) {
 
            if (filter != null)
                return filter.isSpaceChar(c);
 
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
 
        }
 
    }
 
    static class func {
        public static void sort(int[] arr) {
            int n = arr.length, mid, h, s, l, i, j, k;
            int[] res = new int[n];
            n--;
            for (s = 1; s <= n; s <<= 1) {
                for (l = 0; l < n; l += (s << 1)) {
                    h = Math.min(l + (s << 1) - 1, n);
                    mid = Math.min(l + s - 1, n);
                    i = l;
                    j = mid + 1;
                    k = l;
                    while (i <= mid && j <= h) res[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
                    while (i <= mid) res[k++] = arr[i++];
                    while (j <= h) res[k++] = arr[j++];
                    for (k = l; k <= h; k++) arr[k] = res[k];
                }
            }
        }
 
    }
}
