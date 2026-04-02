//@author : vishal_kumarsahu

import java.io.*;
import static java.lang.System.*;
import java.util.*;

public class entry_7357794 {
    static Reader rd;
    static long mod = (long) (1e9 + 7);
    static final Random random = new Random();


    static int N = 2 * (int)(1e5) + 1;
    static int size = 4 * N;
    static int []map = new int[N];
    static int []lo = new int[size];
    static int []hi = new int[size];

    static long []sum = new long[size];
    static long []pre = new long[size];


    static void solve() throws Exception {
//        int tests = scanInt();
        int tests = 1;

        for (int test = 0; test < tests; test++) {

            int n = scanInt();
            int q = scanInt();

            build(1, 1, n);

            for(int i = 0; i < q; i++){
                int t = scanInt();
                if(t == 1){
                    int k = scanInt();
                    long val = scanLong();

                    update(k, val);
                }
                else{
                    int a = scanInt();
                    int b = scanInt();

                    out.println(query(1, a, b).pre);
                }
            }















        }
    }

    static void build(int ind, int low, int high) throws IOException {
        lo[ind] = low;
        hi[ind] = high;

        if(low == high){
            sum[ind] = scanLong();
            pre[ind] = Math.max(0L, sum[ind]);
            map[low] = ind;
            return;
        }

        int mid = low + (high - low)/2;
        build(2*ind, low, mid);
        build(2*ind + 1, mid + 1, high);

        pull(ind);
    }
    static void  pull(int ind){
        pre[ind] = Math.max(pre[2*ind], sum[2*ind] + pre[2*ind + 1]);
        sum[ind] = sum[2*ind] + sum[2*ind + 1];
    }

    static void update(int idx, long val){
        int ind = map[idx];
        sum[ind] = val;
        pre[ind] = Math.max(0L, sum[ind]);

        ind >>= 1;
        while (ind != 0){
            pull(ind);
            ind >>= 1;
        }
    }

    static pair query(int ind, int l, int h){
        if(l > hi[ind] || h < lo[ind]){
            return new pair(0, 0);
        }

        if(l <= lo[ind] && hi[ind] <= h){
            return new pair(pre[ind], sum[ind]);
        }

        pair ll = query(2*ind, l, h);
        pair rr = query(2*ind + 1, l, h);

        return new pair(Math.max(ll.pre, ll.sum + rr.pre), ll.sum + rr.sum);
    }


    static class pair{
        long sum;
        long pre;

        pair(long pre, long sum){
            this.sum = sum;
            this.pre = pre;
        }
    }









    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    static long power(long base, long exp) {

        long b = 1;
        long A = base;
        if((exp & 1) == 1){
            b = base % mod;
        }
        exp  = (exp >> 1);
        while(exp > 0){
            A = (A * A) % mod;
            if((exp & 1) == 1){
                b = (A * b) % mod;
            }
            exp = (exp >> 1);
        }

        return b % mod;
    }
    static int[] arrI(int N) throws Exception {
        int []A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanInt();
        }
        return A;
    }
    static long[] arrL(int N) throws Exception {
        long []A = new long[N];
        for (int i = 0; i < A.length; i++)
            A[i] = scanLong();
        return A;
    }
    static void ruffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i]; a[i] = temp;
        }
        Arrays.sort(a);
    }
    static void ruffleSort(long[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            long oi = random.nextInt(n), temp = a[(int)oi];
            a[(int)oi] = a[i]; a[i] = temp;
        }
        Arrays.sort(a);
    }

    static int scanInt() throws IOException {
        return rd.nextInt();
    }
    static double scanDouble() throws IOException {
        return rd.nextDouble();
    }
    static long scanLong() throws IOException {
        return rd.nextLong();
    }
    static String scanString() throws IOException {
        return rd.readLine();
    }
    static PrintWriter out;

    public static void main(String[] args) {
        try {
            rd = new Reader();
            out = new PrintWriter(System.out);
            solve();
            rd.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
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
            byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
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
}
class DSU {
    private int[] parent;
    private int[] rank;
    private int groups;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        groups = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]); // path compression
        }
        return parent[n];
    }

    public boolean isConnected(int a, int b){
        return find(a) == find(b);
    }

    public int numDisjointSet(){
        return groups;
    }

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        if (rank[rootA] > rank[rootB]) {
            rootA ^= rootB;
            rootB ^= rootA;
            rootA ^= rootB;
        }

        parent[rootA] = rootB;
        if (rank[rootA] == rank[rootB]) {
            rank[rootB]++;
        }
        groups--;
        return true;
    }
}

class SparseTable {
    int n, k;
    long[][] table;
    int[] log2;

    void init(int maxN) {
        n = maxN;
        // log base 2 computation
        log2 = new int[n + 1];
        log2[1] = 0;
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
            k = Math.max(log2[i], k);
        }

        table = new long[k + 1][n + 1];
    }

    long operation(long x, long y) {
        return Math.min(x, y);
    }

    void build(int []arr) {
        for (int i = 0; i < n; i++) {
            table[0][i] = (long)arr[i];
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                table[j][i] = operation(table[j - 1][i], table[j - 1][i + (1 << (j - 1))]);
            }
        }
    }

    long query(int l, int r) {
        int j = log2[r - l + 1];
        long answer = operation(table[j][l], table[j][r - (1 << j) + 1]);
        return answer;
    }
}

class BITree_SUM{    // 1-based indexing implemented
    // But 0-based implementation is used
    long []tree;
    int n;

    BITree_SUM(int n){
        this.n = n;
        tree = new long[n+1];
    }

    BITree_SUM(int []arr){ // takes less time i.e O(n) -- Linear Time Construction
        n = arr.length;
        tree = new long[n+1];

        for (int i = 1; i <= n; i++) {
            tree[i] += (long) arr[i-1];

            int lower_i = i + (i & (-i));
            if (lower_i <= n){
                tree[lower_i] += tree[i];
            }
        }
    }

    void built(int []arr){ // takes more time i.e O(nlog(n))
        for(int i = 0; i < arr.length; i++){
            increase(i, (long)arr[i]);
        }
    }

    void increase(int i, long add){
        ++i;
        while(i <= n){
            tree[i] += add;
            i += (i & (-i));
        }
    }

    long sum(int i){ // it answers query [1, i] i.e sum from 1 to i
        ++i;
        long s = 0;
        while(i > 0){
            s += tree[i];
            i -= (i & (-i));
        }
        return s;
    }

    long rangeSum(int l, int r){
        return (sum(r) - sum(l-1));
    }
}

class BITree_RUPQ{    // 1-based indexing implemented
    // But 0-based implementation is used
    long []tree;
    int n;

    BITree_RUPQ(int n){
        this.n = n;
        tree = new long[n+1];
    }
    BITree_RUPQ(int []arr){
        n = arr.length;
        tree = new long[n+1];

        for(int i = 0; i < n; i++){
            rangeIncrease(i, i, (long) arr[i]);
        }
    }

    public void increase(int i, long add){
        ++i;
        while(i <= n){
            tree[i] += add;
            i += (i & (-i));
        }
    }

    public void rangeIncrease(int l, int r, long add){
        increase(l, add);
        increase(r + 1, -add);
    }

    public long pointQuery(int i){
        ++i;

        long s = 0;
        while(i > 0){
            s += tree[i];
            i -= (i & (-i));
        }
        return s;
    }
}

class BITree_MIN{    // 1-based indexing implemented
    // But 0-based implementation is used
    int []tree;
    int n;

    BITree_MIN(int n){
        this.n = n;
        tree = new int[n+1];
        Arrays.fill(tree, (int)1e9);
    }

    BITree_MIN(int []arr){ // takes less time i.e O(n)
        n = arr.length;
        tree = new int[n+1];
        Arrays.fill(tree, (int)1e9);

        for (int i = 1; i <= n; i++) {
            tree[i] = Math.min(tree[i], arr[i-1]);

            int lower_i = i + (i & (-i));
            if (lower_i <= n){
                tree[lower_i] = Math.min(tree[lower_i], tree[i]);
            }
        }
    }

    void built(int []arr){ // takes more time i.e O(nlog(n))
        for(int i = 0; i < arr.length; i++){
            update(i, arr[i]);
        }
    }

    void update(int i, int newVal){
        ++i;
        tree[i] = newVal;
        i += (i & (-i));

        while(i <= n){
            tree[i] = Math.min(tree[i], newVal);
            i += (i & (-i));
        }
    }

    int getMin(int i){
        ++i;
        int min = (int)1e9;
        while(i > 0){
            min = Math.min(min, tree[i]);
            i -= (i & (-i));
        }
        return min;
    }
}

class BITree_SUM_2D{    // 1-based indexing implemented
    // But 0-based implementation is used
    long [][]tree;
    int n;
    int m;

    BITree_SUM_2D(int n, int m){
        this.n = n;
        this.m = m;
        tree = new long[n+1][m+1];
    }

    BITree_SUM_2D(int [][]arr){
        this(arr.length, arr[0].length);
        built(arr);
    }

    void built(int [][]arr){ // takes more time i.e O(nlog(n))
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                increase(i, j, (long)arr[i][j]);
            }
        }
    }

    void increase(int x, int y, long add){
        ++x;
        ++y;
        while(x <= n){
            int j = y;
            while(j <= m) {
                tree[x][j] += add;
                j += (j & (-j));
            }
            x += (x & (-x));
        }
    }

    long sum(int x, int y){ // it answers query [1, i] i.e sum from 1 to i
        ++x;
        ++y;
        long s = 0;
        while(x > 0){
            int j = y;
            while(j > 0) {
                s += tree[x][j];
                j -= (j & (-j));
            }
            x -= (x & (-x));
        }
        return s;
    }

    long rangeSum(int x1, int y1, int x2, int y2){
        return (sum(x2, y2) - sum(x2, y1 - 1) - sum(x1 - 1, y2) + sum(x1 - 1, y1 - 1));
    }
}

class SegmentTree_SUM{
    private long []tree;
    private int n;

    SegmentTree_SUM(int n){
        this.n = n;
        tree = new long[(4 * n) + 5];
    }

    SegmentTree_SUM(int []arr){
        this(arr.length);
        build(arr, 1, 1, n);
    }

    private long operation(long a, long b){
        return a + b;
    }

    public void build(int []arr){
        build(arr, 1, 1, n);
    }

    private void build(int []arr, int ind, int low, int high){
        if(low == high){
            tree[ind] = arr[low - 1];
            return;
        }
        int mid = low + (high - low)/2;
        build(arr, 2*ind, low, mid);
        build(arr, 2*ind + 1, mid + 1, high);
        tree[ind] = operation(tree[2*ind], tree[2*ind + 1]);
    }

    private long querySearch(int ind, int low, int high, int l, int r){
        if(l > high || r < low){
            return 0;
        }
        if(low >= l && high <= r){
            return tree[ind];
        }
        int mid = low + (high - low)/2;
        long left = querySearch(2*ind, low, mid, l, Math.min(r, mid));
        long right = querySearch(2*ind + 1, mid+1, high, Math.max(l, mid+1), r);
        return operation(left, right);
    }

    public long query(int l, int r){
        return querySearch(1, 1, n, l + 1, r + 1); // converted to 1-based indexing
    }

    public void update(int pos, int add){
        pointUpdate(1, 1, n, pos + 1, add); // converted to 1-based indexing
    }
    private void pointUpdate(int ind, int low, int high, int pos, int val){
        if(low == high){
            tree[ind] += (long) val;
        }
        else {
            int mid = low + (high - low) / 2;
            if (pos <= mid && pos >= low) {
                pointUpdate(2*ind, low, mid, pos, val);
            } else {
                pointUpdate(2*ind + 1, mid + 1, high, pos, val);
            }
            tree[ind] = operation(tree[2*ind], tree[2*ind + 1]);
        }
    }
}
class SegmentTree_MIN{
    private int []tree;
    private int n;

    SegmentTree_MIN(int n){
        this.n = n;
        tree = new int[(4 * n) + 5];
    }

    SegmentTree_MIN(int []arr){
        this(arr.length);
        build(arr, 1, 1, n);
    }

    private int operation(int a, int b){
        return Math.min(a, b);
    }

    public void build(int []arr){
        build(arr, 1, 1, n);
    }

    private void build(int []arr, int ind, int low, int high){
        if(low == high){
            tree[ind] = arr[low - 1];
            return;
        }
        int mid = low + (high - low)/2;
        build(arr, 2*ind, low, mid);
        build(arr, 2*ind + 1, mid + 1, high);
        tree[ind] = operation(tree[2*ind], tree[2*ind + 1]);
    }

    private int querySearch(int ind, int low, int high, int l, int r){
        if(l > high || r < low){
            return (int)1e9 + 7;
        }
        if(low >= l && high <= r){
            return tree[ind];
        }
        int mid = low + (high - low)/2;
        int left = querySearch(2*ind, low, mid, l, r);
        int right = querySearch(2*ind + 1, mid+1, high, l, r);
        return operation(left, right);
    }

    public int query(int l, int r){ // asked for 0-based indexing
        return querySearch(1, 1, n, l + 1, r + 1); // converted to 1-based indexing
    }

    public void update(int pos, int add){ // asked for 0-based indexing
        pointUpdate(1, 1, n, pos + 1, add); // converted to 1-based indexing
    }
    private void pointUpdate(int ind, int low, int high, int pos, int val){ // works in 1-based indexing
        if(low == high){
            tree[ind] = val;
        }
        else {
            int mid = low + (high - low) / 2;
            if (pos <= mid && pos >= low) {
                pointUpdate(2*ind, low, mid, pos, val);
            } else {
                pointUpdate(2*ind + 1, mid + 1, high, pos, val);
            }
            tree[ind] = operation(tree[2*ind], tree[2*ind + 1]);
        }
    }
}

