import java.io.*;
import java.util.*;

public class entry_14306376 {

    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    public static void main(String[] args) throws IOException {
        int t = 1;
        // Uncomment below if multiple test cases
        // t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush(); // flush once at the end
    }

    static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        TreeMap<Integer, Integer> pq = new TreeMap<>();

        long ans = 0;
        pq.put(0, k);
        for (int i = 0; i < n; i++) {
            int startTime = arr[i][0];
            int endTime = arr[i][1];
            Map.Entry<Integer, Integer> ent = pq.floorEntry(startTime);
            if (ent != null) {
                ans++;
                int key = ent.getKey();
                int val = ent.getValue();
                if (val == 1) {
                    pq.remove(key);
                } else {
                    pq.put(key, val - 1);
                }
                pq.put(endTime, pq.getOrDefault(endTime, 0) + 1);
            }

            // pq.put();

        }

        out.println(ans);
    }

    static class FastReader {

        private final int BUFFER_SIZE = 1 << 16;
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;
        private final DataInputStream din;

        public FastReader() {
            din = new DataInputStream(System.in);
        }

        public FastReader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1024];
            int cnt = 0, c;
            while ((c = read()) != -1 && c != '\n') {
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String next() throws IOException {
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
            } while ((c = read()) > ' ');
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer >= bytesRead) {
                fillBuffer();
                if (bytesRead == -1) {
                    return -1;
                }
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) {
                din.close();
            }
        }
    }

    static class FastWriter {

        private final BufferedOutputStream bos;
        private final PrintWriter pw;

        public FastWriter() {
            bos = new BufferedOutputStream(System.out);
            pw = new PrintWriter(bos);
        }

        public void print(Object o) {
            pw.print(o);
        }

        public void println(Object o) {
            pw.println(o);
        }

        public void println() {
            pw.println();
        }

        public void flush() {
            pw.flush();
        }
    }

    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);

        sort(left);
        sort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int leftLength = left.length;
        int rightLength = right.length;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftLength) {
            arr[k++] = left[i++];
        }
        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }
}