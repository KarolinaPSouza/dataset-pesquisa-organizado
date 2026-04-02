import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class entry_7973309 {

    static class Pair {
        int firstIndex;
        int secondIndex;

        public Pair(int firstIndex, int secondIndex) {
            assert firstIndex != secondIndex;
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }
    }

    static void solve(InputReader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = in.nextIntArray(n);
        Map<Integer, Pair> sumToIndexPair = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                final Pair pair = new Pair(i, j);
                sumToIndexPair.put(a[i] + a[j], pair);
            }
        }

        for (int i = 0; i < n; i++) {
            if (a[i] > x - 3) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] > x - 2) {
                    continue;
                }
                int rest = x - a[i] - a[j];
                final Pair pair = sumToIndexPair.get(rest);
                if (pair == null) {
                    continue;
                }
                if (pair.firstIndex != i && pair.secondIndex != i && pair.firstIndex != j && pair.secondIndex != j) {
                    out.println((i + 1) + " " + (j + 1) + " " + (pair.firstIndex + 1) + " " + (pair.secondIndex + 1));
                    return;
                }
            }
        }
        out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(System.out);
             InputReader in = new InputReader(System.in)) {
            solve(in, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static final Random random = new Random();

    static void ruffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            int temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void sort(int[] a) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : a) {
            arrayList.add(i);
        }
        Collections.sort(arrayList);
        for (int i = 0; i < a.length; i++) {
            a[i] = arrayList.get(i);
        }
    }

    private static class InputReader implements AutoCloseable {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public InputReader(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String nextString() throws IOException {
            byte c = read();
            while (Character.isWhitespace(c)) {
                c = read();
            }

            StringBuilder builder = new StringBuilder();
            builder.append((char) c);
            c = read();
            while (!Character.isWhitespace(c)) {
                builder.append((char) c);
                c = read();
            }

            return builder.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public char nextChar() throws IOException {
            byte c = read();
            while (Character.isWhitespace(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}