import java.util.*;
import java.io.*;

public class entry_4156077 {
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];
        Arrays.setAll(arr, i -> in.nextInt());
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(x - arr[i])) {
                pw.println(mp.get(x - arr[i]) + " " + (i + 1));
                pw.close();
                return;
            }
            mp.put(arr[i], i + 1);
        }
        pw.println("IMPOSSIBLE");
        /*Another solution--
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Pair(in.nextInt(), i + 1));
        }
        Collections.sort(arr);
        int i = 0, j = n - 1;
        while (i < j) {
            int temp = arr.get(i).v + arr.get(j).v;
            if (temp < x) i++;
            else if (temp > x) j--;
            else {
                pw.println(arr.get(i).indx + " " + arr.get(j).indx);
                pw.close();
                return;
            }
        }
        pw.println("IMPOSSIBLE");*/

        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class Pair implements Comparable<Pair> {
        int v, indx;

        Pair(int v, int indx) {
            this.v = v;
            this.indx = indx;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(v, o.v);
        }
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }


        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}