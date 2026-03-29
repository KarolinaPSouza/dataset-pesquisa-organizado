import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class entry_14625430 {
    static PrintWriter out = new PrintWriter(System.out);
    static long mod = (long) (1e9 + 7);

    public static void main(String[] args) throws IOException {
        BufferInput in = new BufferInput();
        int n = in.nextInt();
        int max = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(n);
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(a[i], b[i]);
        }
        int[][] dp = new int[n+1][max+1];
        for(int i=n-1;i>=0;i--){
            for(int curr=0;curr<=max;curr++){
                int pick = 0;
                if(arr[i].x<=curr) {
                    pick = arr[i].y + dp[i + 1][curr-arr[i].x];
                }
                int notPick = dp[i+1][curr];
                dp[i][curr] = Math.max(pick, notPick);
            }
        }
        out.println(dp[0][max]);
        out.flush();
    }
    private static int solve(Pair[] arr, int i, int curr, int[][] dp) {
       if(i==arr.length) return 0;
       if(dp[i][curr]!=-1) return dp[i][curr];
        int pick = 0;
        if(arr[i].x<=curr) {
           pick = arr[i].y + solve(arr, i + 1, curr - arr[i].x, dp);
       }
        int notPick = solve(arr, i+1, curr, dp);
        dp[i][curr] = Math.max(pick, notPick);
        return dp[i][curr];
    }

    private static long dfs(int n, List<List<Integer>> adj, boolean[] visited, int curr, long[] dp) {
        if(visited[curr]) return dp[curr];
        visited[curr] = true;
        if(curr==n) return 1;
        for(int i:adj.get(curr)){
            dp[curr] = (dp[curr] + dfs(n, adj, visited, i, dp)%mod)%mod;
        }
        return dp[curr];
    }

    static class SegmentTreeNode{
        long sum;
        int start;
        int end;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.sum = 0;
        }

    }
    static class SegmentTree{
        private SegmentTreeNode root;

        public SegmentTree(int [] arr){
            root = build(arr, 0, arr.length-1);
        }
        SegmentTreeNode build(int[] arr, int i, int j){
            if(j<i) return null;
            SegmentTreeNode node = new SegmentTreeNode(i, j);
            if(i==j){
                node.sum = arr[i];
            }else {
                int mid = (i + j) / 2;
                node.left = build(arr, i, mid);
                node.right = build(arr, mid + 1, j);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }

        long rangeSum(int i, int j){
            return rangeSum(this.root, i, j);
        }

        long rangeSum(SegmentTreeNode node, int start, int end){
            if(node==null || node.end<start || node.start>end) return 0;
            if(start<=node.start && node.end<=end){
                return node.sum;
            }
            long left = rangeSum(node.left, start, end);
            long right = rangeSum(node.right, start, end);
            return left + right;

        }

        public void update(int i, int val) {
            update(root, i, val);
        }

        private void update(SegmentTreeNode node, int index, int val) {
            if(node.start == node.end){
                node.sum = val;
            }else{
                int mid = (node.start + node.end)/2;
                if(index<=mid){
                    update(node.left, index, val);
                }else{
                    update(node.right, index, val);
                }
                node.sum = node.left.sum + node.right.sum;
            }
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

static class BufferInput {

    final private int BUFFER_SIZE = 1 << 16;

    private DataInputStream din;

    private byte[] buffer;

    private int bufferPointer, bytesRead;

    public BufferInput() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public BufferInput(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
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
        int arr[] = new int[n];
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
        long arr[] = new long[n];
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
        double arr[] = new double[n];
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
        if (din == null)
            return;
        din.close();
    }
}
}