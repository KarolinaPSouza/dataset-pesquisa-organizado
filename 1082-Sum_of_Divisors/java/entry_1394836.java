import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class entry_1394836 {
    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return first - o.first;
        }
    }

    static class SegmentTreeRMQ {
        int[] elems;
        int size = 1;

        SegmentTreeRMQ(int[] arr) {

            while (size < arr.length) {
                size = 2 * size;
            }
            this.elems = new int[2 * size - 1];
            build(arr, 0, 0, size);
        }

        private void build(int[] arr, int node, int lx, int rx) {
            if (rx - lx == 1) {
                if (lx < arr.length)
                    elems[node] = arr[lx];

                return;
            }

            int mid = (lx + rx) / 2;
            build(arr, 2 * node + 1, lx, mid);
            build(arr, 2 * node + 2, mid, rx);
            elems[node] = Math.min(elems[2 * node + 1], elems[2 * node + 2]);
        }

        public void set(int index, int value) {
            set(index, value, 0, 0, size);
        }

        public long min(int from, int to) {
            return min(from, to, 0, 0, size);
        }

        private void set(int index, int value, int node, int lx, int rx) {
            //this means leaf
            if (rx - lx == 1) {
                elems[node] = value;
                return;
            }
            int mid = (lx + rx) / 2;

            if (index < mid) {
                set(index, value, 2 * node + 1, lx, mid);
            } else {
                set(index, value, 2 * node + 2, mid, rx);
            }

            elems[node] = Math.min(elems[2 * node + 1], elems[2 * node + 2]);
        }

        private long min(int l, int r, int node, int lx, int rx) {
            //not overlapping
            if (l >= rx || lx >= r) {
                return INF_LONG;
            }
            //fully inside
            if (lx >= l && rx <= r) {
                return elems[node];
            }

            int mid = (lx + rx) / 2;

            long leftMin = min(l, r, 2 * node + 1, lx, mid);
            long rightMin = min(l, r, 2 * node + 2, mid, rx);

            return Math.min(leftMin, rightMin);

        }
    }

    static class SegmentTree {
        long[] elems;
        int size = 1;

        SegmentTree(int[] arr) {

            while (size < arr.length) {
                size = 2 * size;
            }
            this.elems = new long[2 * size - 1];
            build(arr, 0, 0, size);
        }

        private void build(int[] arr, int node, int lx, int rx) {
            if (rx - lx == 1) {
                if (lx < arr.length)
                    elems[node] = arr[lx];

                return;
            }

            int mid = (lx + rx) / 2;
            build(arr, 2 * node + 1, lx, mid);
            build(arr, 2 * node + 2, mid, rx);
            elems[node] = elems[2 * node + 1] ^ elems[2 * node + 2];
        }

        public void set(int index, int value) {
            set(index, value, 0, 0, size);
        }

        public long calc(int from, int to) {
            return calc(from, to, 0, 0, size);
        }

        private void set(int index, int value, int node, int lx, int rx) {
            //this means leaf
            if (rx - lx == 1) {
                elems[node] = value;
                return;
            }
            int mid = (lx + rx) / 2;

            if (index < mid) {
                set(index, value, 2 * node + 1, lx, mid);
            } else {
                set(index, value, 2 * node + 2, mid, rx);
            }

            elems[node] = elems[2 * node + 1] + elems[2 * node + 2];
        }

        private long calc(int l, int r, int node, int lx, int rx) {
            //not overlapping
            if (l >= rx || lx >= r) {
                return 0;
            }
            //fully inside
            if (lx >= l && rx <= r) {
                return elems[node];
            }

            int mid = (lx + rx) / 2;

            long leftResult = calc(l, r, 2 * node + 1, lx, mid);
            long rightResult = calc(l, r, 2 * node + 2, mid, rx);

            return leftResult ^ rightResult;

        }
    }

    static class DSU {
        int[] parents;
        int[] sizes;

        DSU(int size) {
            this.parents = new int[size];
            this.sizes = new int[size];

            for (int i = 1; i < size; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        int get(int component) {
            if (parents[component] == component) {
                return component;
            }

            int parent = get(parents[component]);
            parents[component] = parent;
            return parent;

        }

        void union(int component1, int component2) {
            int pc1 = get(component1);
            int pc2 = get(component2);

            if (pc1 == pc2) return;

            if (sizes[pc1] > sizes[pc2]) {
                int temp = pc1;
                pc1 = pc2;
                pc2 = temp;

            }

            parents[pc1] = pc2;
            sizes[pc2] += pc1;

        }

        List<Integer> getComponents() {

            List<Integer> components = new ArrayList<>();
            for (int i = 1; i < parents.length; i++) {
                if (get(i) == i) {
                    components.add(i);
                }
            }
            return components;
        }
    }

    static Set<Integer> visited = new HashSet<>();
    static int[] parent;
    static boolean found = false;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    static long INF_LONG = (long) 1e14 + 1;

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static Map<Integer, List<Integer>> adjList = new HashMap<>();

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;


        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
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
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
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
            if (din == null)
                return;
            din.close();
        }
    }

    private static final long MOD = 1000000007;

    static long choose2(long x) {
        return x%MOD*((x-1)%MOD)%MOD*((MOD+1)/2)%MOD;
    }
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(); //for faster input
        StringBuilder sb = new StringBuilder();

        long x = reader.nextLong();

        long sum = 0;

        for (long i = 1; i <= x; i++) {
            long left = i;
            long right = x/(x/i);
            sum +=(x/i%MOD)*(choose2(right+1) - choose2(left) + MOD)%MOD;
            i = right;
        }

        System.out.println(sum%MOD);
    }
    /*
     *
     * HINT: OVERFLOW CHECK for INT
     *
     * Add to stringbuilder then print all at once when using java
     *
     * */
}