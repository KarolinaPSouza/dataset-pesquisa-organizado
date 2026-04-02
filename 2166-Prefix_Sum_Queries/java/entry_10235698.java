import java.io.*;

public class entry_10235698 {
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
            din = new DataInputStream( 
                new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public String readLine() throws IOException { 
            byte[] buf = new byte[64];
            int cnt = 0, c; 
            while ((c = read()) != -1) { 
                if (c == '\n') { 
                    if (cnt != 0)
                        break; 
                    else
                        continue; 
                } 
                buf[cnt++] = (byte)c; 
            } 
            return new String(buf, 0, cnt); 
        } 

        public int nextInt() throws IOException { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') { 
                c = read(); 
            } 
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
            } while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 

        public double nextDouble() throws IOException { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') {
                c = read(); 
            }
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

        private void fillBuffer() throws IOException { 
            bytesRead = din.read(buffer, bufferPointer = 0, 
                                 BUFFER_SIZE); 
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

    private static final Reader s = new Reader(); 
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n, q;
    private static long var;
    private static int[] nums;
    private static long[][] tree;

    private static void readInput() throws IOException {
        n = s.nextInt();
        q = s.nextInt();

        nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.nextInt();

        tree = new long[3 * n][2];
        buildTree(0, 0, n - 1);
    }

    private static void solve() throws IOException {
        int[] query = new int[3];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 3; j++) query[j] = s.nextInt();

            if (query[0] == 1) {
                lazyUpdate(0, 0, n - 1, query[1] - 1, n - 1, query[2] - nums[query[1] - 1]);
                nums[query[1] - 1] = query[2];
            }
            else {
                long res = maxQuery(0, 0, n - 1, query[1] - 1, query[2] - 1);
                if (query[1] > 1)
                    res -= find(0, 0, n - 1, query[1] - 2);
                bw.write(Math.max(res, 0) + "\n");
            }
        }
    }

    private static void buildTree(int node, int left, int right) {
        if (left == right) {
            var += nums[left];
            tree[node][0] = var;
        }
        else {
            int mid = (left + right) / 2;
            buildTree(2 * node + 1, left, mid);
            buildTree(2 * node + 2, mid + 1, right);
            tree[node][0] = Math.max(tree[2 * node + 1][0], tree[2 * node + 2][0]);
        }
    }

    private static void lazyUpdate(int node, int left, int right, int start, int end, int add) {
        if (right < start || left > end)
            return;
        if (left >= start && right <= end) {
            tree[node][0] += add;
            tree[node][1] += add;
            return;
        }

        lazyCheck(node);
        int mid = (left + right) / 2;
        lazyUpdate(2 * node + 1, left, mid, start, end, add);
        lazyUpdate(2 * node + 2, mid + 1, right, start, end, add);
        tree[node][0] = Math.max(tree[2 * node + 1][0], tree[2 * node + 2][0]);
    }

    private static long maxQuery(int node, int left, int right, int start, int end) {
        if (right < start || left > end)
            return Long.MIN_VALUE;
        if (left >= start && right <= end)
            return tree[node][0];

        lazyCheck(node);
        int mid = (left + right) / 2;
        long maxLeft = maxQuery(2 * node + 1, left, mid, start, end);
        long maxRight = maxQuery(2 * node + 2, mid + 1, right, start, end);
        return Math.max(maxLeft, maxRight);
    }

    private static void lazyCheck(int node) {
        if (tree[node][1] != 0) {
            tree[2 * node + 1][0] += tree[node][1];
            tree[2 * node + 1][1] += tree[node][1];

            tree[2 * node + 2][0] += tree[node][1];
            tree[2 * node + 2][1] += tree[node][1];
            tree[node][1] = 0;
        }
    }

    private static long find(int node, int left, int right, int idx) {
        if (left == right)
            return tree[node][0];
        else {
            lazyCheck(node);
            int mid = (left + right) / 2;
            if (idx > mid)
                return find(2 * node + 2, mid + 1, right, idx);
            else
                return find(2 * node + 1, left, mid, idx);
        }
    }

    public static void main(String[] args) throws IOException {
        readInput();
        solve();

        s.close();
        bw.flush();
        bw.close();
    }
}