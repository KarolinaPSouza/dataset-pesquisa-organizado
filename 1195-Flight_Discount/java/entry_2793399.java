import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Mubtasim Shahriar
 */

public class entry_2793399 {

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
//  int t = sc.nextInt();
        int t = 1;
        while (t-- != 0) {
            solver.solve(sc, out);
        }
        out.close();

    }

    static class Solver {
        final long INF = (long) 1e17;
        public void solve(InputReader sc, PrintWriter out) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<int[]>[] gp = new ArrayList[n];
            ArrayList<int[]>[] reverseGp = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                gp[i] = new ArrayList<>();
                reverseGp[i] = new ArrayList<>();
            }
            int[][] edges = new int[m][3];
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt()-1;
                int v = sc.nextInt()-1;
                int d = sc.nextInt();
                gp[u].add(new int[] {v,d});
                reverseGp[v].add(new int[] {u,d});
                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = d;
            }
            long[] sp1 = new long[n];
            long[] spn = new long[n];
            Arrays.fill(sp1,INF);
            Arrays.fill(spn,INF);
            boolean[] processed = new boolean[n];
            sp1[0] = 0;
            spn[n-1] = 0;
            PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o1[0],o2[0]);
                }
            });
            pq.add(new long[] {0,0});
            getSp(gp,sp1,processed,pq);
            Arrays.fill(processed,false);
            pq.clear();
            pq.add(new long[] {0,n-1});
            getSp(reverseGp,spn,processed,pq);
            long min = INF;
            for(int edge = 0; edge < m; edge++) {
                int u = edges[edge][0];
                int v = edges[edge][1];
                long nowdist = edges[edge][2];
                min = Math.min(min,sp1[u]+spn[v]+nowdist/2);
            }
            out.println(min);
        }

        private void getSp(ArrayList<int[]>[] gp, long[] dist, boolean[] processed, PriorityQueue<long[]> pq) {
            while(!pq.isEmpty()) {
                long[] top = pq.poll();
                int src = (int)top[1];
                if(processed[src]) continue;
                processed[src] = true;
                long nowdist = top[0];
                for(int[] vs : gp[src]) {
                    int v = vs[0];
                    long odist = vs[1];
                    if(nowdist+odist<dist[v]) {
                        pq.add(new long[] {nowdist+odist,v});
                        dist[v] = nowdist+odist;
                    }
                }
            }

        }

    }

    static void sort(int[] arr) {
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = rand.nextInt(n);
            if (idx == i) continue;
            arr[i] ^= arr[idx];
            arr[idx] ^= arr[i];
            arr[i] ^= arr[idx];
        }
        Arrays.sort(arr);
    }

    static void sort(long[] arr) {
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = rand.nextInt(n);
            if (idx == i) continue;
            arr[i] ^= arr[idx];
            arr[idx] ^= arr[i];
            arr[i] ^= arr[idx];
        }
        Arrays.sort(arr);
    }

    static void sortDec(int[] arr) {
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = rand.nextInt(n);
            if (idx == i) continue;
            arr[i] ^= arr[idx];
            arr[idx] ^= arr[i];
            arr[i] ^= arr[idx];
        }
        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            l++;
            r--;
        }
    }

    static void sortDec(long[] arr) {
        Random rand = new Random();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = rand.nextInt(n);
            if (idx == i) continue;
            arr[i] ^= arr[idx];
            arr[idx] ^= arr[i];
            arr[i] ^= arr[idx];
        }
        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            l++;
            r--;
        }
    }

    static class InputReader {
        private boolean finished = false;

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(nextString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }

        public String next() {
            return nextString();
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) array[i] = nextInt();
            return array;
        }

        public int[] nextSortedIntArray(int n) {
            int array[] = nextIntArray(n);
            Arrays.sort(array);
            return array;
        }

        public int[] nextSumIntArray(int n) {
            int[] array = new int[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i) array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i) array[i] = nextLong();
            return array;
        }

        public long[] nextSumLongArray(int n) {
            long[] array = new long[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i) array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextSortedLongArray(int n) {
            long array[] = nextLongArray(n);
            Arrays.sort(array);
            return array;
        }
    }


}