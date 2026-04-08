import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class entry_9135695 {

    public static void main(String[] args) {
        FastIO io = new FastIO();
        int testcases = 1;
        outer:
        for (int t = 0; t < testcases; t++) {
            int n = io.nextInt();
            int k = io.nextInt();
            Pair[] a = new Pair[n];
            for (int i = 0; i < n; i++)
                a[i] = new Pair(io.nextInt(), io.nextInt());
            Arrays.sort(a, Comparator.comparingInt(Pair -> Pair.b));
            int count = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                Integer key = map.floorKey(a[i].a);
                if (key != null) {
                    k++;
                    int val = map.get(key);
                    if (val == 1)
                        map.remove(key);
                    else
                        map.put(key, val - 1);
                }
                if (k >= 1) {
                    map.put(a[i].b, map.getOrDefault(a[i].b, 0) + 1);
                    count++;
                    k--;
                }
            }
            io.println(count);
            io.close();
        }
    }

    static class FastIO extends PrintWriter {

        private InputStream stream;

        private byte[] buf = new byte[1 << 16];

        private int curChar, numChars;


        // standard input

        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {

            super(o);

            stream = i;

        }

        // file input

        public FastIO(String i, String o) throws IOException {

            super(new FileWriter(o));

            stream = new FileInputStream(i);

        }


        // throws InputMismatchException() if previously detected end of file

        private int nextByte() {

            if (numChars == -1) throw new InputMismatchException();

            if (curChar >= numChars) {

                curChar = 0;

                try {

                    numChars = stream.read(buf);

                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars == -1) return -1;  // end of file

            }

            return buf[curChar++];

        }


        // to read in entire lines, replace c <= ' '

        // with a function that checks whether c is a line break

        public String next() {

            int c;

            do {
                c = nextByte();
            } while (c <= ' ');

            StringBuilder res = new StringBuilder();

            do {

                res.appendCodePoint(c);

                c = nextByte();

            } while (c > ' ');

            return res.toString();

        }

        public int nextInt() {  // nextLong() would be implemented similarly

            int c;

            do {
                c = nextByte();
            } while (c <= ' ');

            int sgn = 1;

            if (c == '-') {

                sgn = -1;

                c = nextByte();

            }

            int res = 0;

            do {

                if (c < '0' || c > '9') throw new InputMismatchException();

                res = 10 * res + c - '0';

                c = nextByte();

            } while (c > ' ');

            return res * sgn;

        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
    public static class SegmentTree
    {
        private long[] lazy, A, st;
        private long neutral = 0;
        private int n, size;
        public SegmentTree (long[] B)
        {
            int size1 = B.length;
            n = 1;
            while (n < size1)
                n <<= 1;
            size1 = n;
            long[] trueB = new long [size1];
            for (int i = 0; i < B.length; i++)
                trueB[i] = B[i];
            A = trueB;
            n <<= 1;
            st = new long [n];
            lazy = new long [n];
            size = size1;
            Arrays.fill(st, neutral);
            Arrays.fill(lazy, 0);
            build(1,0,size-1);
        }

        public static long merge (long val1, long val2)
        {
            return val1 + val2;
        }
        public void build (int index, int l, int r)
        {
            if (l == r)
            {
                st[index] = A[l];
            }
            else
            {
                int mid = (l+r) >> 1;
                build (index << 1, l, mid);
                build ((index << 1) | 1, mid+1, r);
                st[index] = merge(st[index << 1], st[(index << 1) | 1]);
            }
        }

        public void update (int l, int r, long value)
        {
            update (0, size-1, 1, l, r, value);
        }

        private void update (int start, int end, int index, int l, int r, long value)
        {
            if (l > end || r < start)
                return;
            else if (start == end)
            {
                st[start] += value;
            }
            else
            {
                int mid = (start + end) >> 1;
                update(start, mid, index << 1, l, r, value);
                update(mid+1, end, (index << 1) | 1, l, r, value);
                st[index] = merge(st[index << 1], st[(index<<1)|1]);
            }
        }

        public void propagate (int index)
        {
            int left = index<<1;
            int right = (index << 1) | 1;
            if (index >= size)
            {
                if (lazy[index] == 0)
                    return;
                st[index] += lazy[index];
                lazy[index] = 0;
                return;
            }
            if (lazy[index] != 0)
            {
                lazy[left] = lazy[left] == 0 ? lazy[index]/2 : lazy[left] + lazy[index]/2;
                lazy[right] = lazy[right] == 0 ? lazy[index]/2 : lazy[right] + lazy[index]/2;
                st[index] += lazy[index];
                lazy[index] = 0;
            }
        }

        public long query (int i, int j)
        {
            return query (0, size-1, 1, i, j);
        }

        private long query (int start, int end, int index, int l, int r)
        {
            if (start == end)
            {
                return st[index];
            }
            else if (l > end || r < start)
                return neutral;
            else
            {
                int mid = (start + end) >> 1;
                long s1 = query(start, mid, index << 1, l, r);
                long s2 = query(mid+1, end, (index << 1) | 1, l, r);
                return merge(s1, s2);
            }
        }
    }

    public static int LSOne(int S)
    {
        return ( (S) & -(S) );
    }

    static class SegmentTreeSet {                              // OOP style
        private int n;                                         // n = (int)A.size()
        private long[] A, st, lazy;                                // the arrays

        private int l(int p) { return  p<<1; }                 // go to left child
        private int r(int p) { return (p<<1)+1; }              // go to right child

        private long conquer(long a, long b) {
            if (a == -1) return b;                       // corner case
            if (b == -1) return a;
            return a+b;                            // RMQ
        }

        private void build(int p, int L, int R) {              // O(n)
            if (L == R)
                st[p] = A[L];                              // base case
            else {
                int m = (L+R)/2;
                build(l(p), L  , m);
                build(r(p), m+1, R);
                st[p] = conquer(st[l(p)], st[r(p)]);
            }
        }

        private void propagate(int p, int L, int R) {
            if (lazy[p] != -1) {                         // has a lazy flag
                st[p] = lazy[p];                           // [L..R] has same value
                if (L != R)                                // not a leaf
                    lazy[l(p)] = lazy[r(p)] = lazy[p];       // propagate downwards
                else                                       // L == R, a single index
                    A[L] = lazy[p];                          // time to update this
                lazy[p] = -1;                              // erase lazy flag
            }
        }

        private long RMQ(int p, int L, int R, int i, int j) {   // O(log n)
            propagate(p, L, R);                          // lazy propagation
            if (i > j) return -1;                        // infeasible
            if ((L >= i) && (R <= j)) return st[p];      // found the segment
            int m = (L+R)/2;
            return conquer(RMQ(l(p), L, m, i, Math.min(m, j)),
                    RMQ(r(p), m+1, R, Math.max(i, m+1), j));
        }

        private void update(int p, int L, int R, int i, int j, int val) { // O(log n)
            propagate(p, L, R);                          // lazy propagation
            if (i > j) return;
            if ((L >= i) && (R <= j)) {                  // found the segment
                lazy[p] = val;                             // update this
                propagate(p, L, R);                        // lazy propagation
            }
            else {
                int m = (L+R)/2;
                update(l(p), L  , m, i, Math.min(m, j), val);
                update(r(p), m+1, R, Math.max(i, m+1), j        , val);
                st[p] = conquer(st[l(p)], st[r(p)]);
            }
        }

        public SegmentTreeSet(int sz)
        {
            n = sz;
            st = new long [4*n];
            lazy = new long [4*n];
            for (int i = 0 ; i < 4*n; i++)
                lazy[i] = -1;
        }

        public SegmentTreeSet(long[] initialA)
        {
            this(initialA.length);
            A = initialA;
            build(1, 0, n-1);
        }

        public void update(int i, int j, int val) { update(1, 0, n-1, i, j, val); }

        public long RMQ(int i, int j) { return RMQ(1, 0, n-1, i, j); }

        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }
    };

    static class FenwickTree {
        int[] ft;
        public FenwickTree(int m)
        {
            ft = new int[m+1];
        }
        public void build (int[] f)
        {
            int m = f.length -1;
            ft = new int [m+1];
            for (int i = 0; i < m+1 ;i++)
                ft[i] = 0;
            for (int i = 1; i <= m; ++i)
            {
                ft[i] += f[i];
                if (i+LSOne(i) <= m)
                    ft[i+LSOne(i)] += ft[i];
            }
        }

        FenwickTree (int[] f)
        {
            build(f);
        }

        FenwickTree(int m, int[] s)
        {
            int[] f = new int [m+1];
            for (int i = 0; i < s.length; i++)
            {
                ++f[s[i]];
            }
            build(f);
        }

        long rsq (int j)
        {
            long sum = 0;
            for (; j > 0; j -= LSOne(j))
                sum += ft[j];
            return sum;
        }

        long rsq (int i, int j) {return rsq(j) - rsq(i-1);}

        //updates value of the i-th element by v (v can be +ve/inc or -ve/dec)
        public void update(int i, long v)
        {
            while (i < ft.length) {
                ft[i] += v;
                i += LSOne(i);
            }
        }

        int select (int k) {
            int lo = 1, hi = ft.length-1;
            for (int i =0; i < 30; ++i)
            {
                int mid = (lo+hi)/2;
                if (rsq(1, mid) < k)
                    lo = mid;
                else
                    hi = mid;
            }
            return hi;
        }
    };



    static class RUPQ {                                     // RUPQ variant
        private FenwickTree ft;                                // internally use PURQ FT
        public RUPQ(int m)
        {
            ft = new FenwickTree(m);
        }
        void range_update(int ui, int uj, long v) {
            ft.update(ui, v);                            // [ui, ui+1, .., m] +v
            ft.update(uj+1, -v);                         // [uj+1, uj+2, .., m] -v
        }                                              // [ui, ui+1, .., uj] +v
        long point_query(int i) { return ft.rsq(i); }    // rsq(i) is sufficient
    };

    static class RURQ  {                                    // RURQ variant
        private RUPQ rupq;                                     // one RUPQ and
        private FenwickTree purq;                              // one PURQ
        public RURQ(int m){
            rupq = new RUPQ(m);
            purq = new FenwickTree(m);
        }
        public void range_update(int ui, int uj, long v) {
            rupq.range_update(ui, uj, v);                // [ui, ui+1, .., uj] +v
            purq.update(ui, v*(ui-1));                   // -(ui-1)*v before ui
            purq.update(uj+1, -v*uj);                    // +(uj-ui+1)*v after uj
        }
        public long rsq(int j) {
            return rupq.point_query(j)*j -               // optimistic calculation
                    purq.rsq(j);                          // cancelation factor
        }
        public long rsq(int i, int j) { return rsq(j) - rsq(i-1); } // standard
    };

    static class Triplet implements Comparable{
        int a;
        int b;
        int c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo (Object o)
        {
            Triplet t= (Triplet) o;
            if (b != t.b)
                return b - t.b;
            if (a != t.a)
                return a - t.a;
            return c - t.c;
            //           return a == t.a ? b == t.b ? c - t.c : b - t.b : a - t.a;
        }
        public String toString() {
            return String.valueOf(this.a) + " " + this.b + " " + this.c;
        }

    }

    public static int digSum(int n) {
        if (n == 0)
            return 0;
        return (n % 9 == 0) ? 9 : (n % 9);
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    static class COUNT {
        long a;

        public COUNT(long a) {
            this.a = a;
        }

        public void add() {
            this.a++;
        }

        public void add(int value) {
            this.a = this.a + value;
        }

        public void subtract() {
            this.a--;
        }

        public String toString() {
            return String.valueOf(a);
        }

    }

    static boolean isPrime(long num) {
        if (num == 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 || num % 3 == 0 || num % (int) Math.sqrt(num) == 0)
            return false;
        for (int i = 4; i < (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static class Node {
        public boolean next;
        int node;
        int edge;

        public Node(int node, int edge) {
            this.node = node;
            this.edge = edge;
        }

        public String toString()
        {
            return this.node + " " + this.edge + "\n";
        }

    }

    static class MIN {
        long a;

        public MIN() {
            this.a = Integer.MAX_VALUE;
        }

        public void add(long a) {
            if (a < this.a)
                this.a = a;
        }

        public String toString() {
            return String.valueOf(this.a);
        }
    }

    static class MAX {
        long a;

        public MAX() {
            this.a = -1;
        }

        public void add(long a) {
            if (a > this.a)
                this.a = a;
        }

        public String toString() {
            return String.valueOf(this.a);
        }

    }

    static class Pair implements Comparable<Pair>{
        int a,b;
        public Pair (int a, int b)
        {
            this.a = a;
            this.b = b;
        }
        public String toString() {
            return "" + this.a + " | " + this.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public boolean equals(Object a1) {
            if (this == a1)
                return true;
            if (a1 == null || getClass() != a1.getClass())
                return false;
            Pair idk = (Pair) a1;
            return a == idk.a && b == idk.b;
        }

        public int compareTo(Pair u1)
        {
            if (u1.a == a)
                return Integer.compare(b, u1.b);
            return Integer.compare(a, u1.a);
        }
    }

    private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    public static double round_to_d_decimal_places(double n, int d) {
        n *= Math.pow(10, d);
        n = Math.round(n);
        n /= Math.pow(10, d);
        return n;
    }

    static class UnionFind {
        private ArrayList<Integer> p, rank, setSize;
        private int numSets;

        public UnionFind(int N) {
            p = new ArrayList<>(N);
            rank = new ArrayList<>(N);
            setSize = new ArrayList<>(N);
            numSets = N;
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i) return i;
            else {
                int ret = findSet(p.get(i)); p.set(i, ret);
                return ret; } }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) { numSets--;
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
                else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
        public int numDisjointSets() { return numSets; }
        public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String readAllLines(BufferedReader reader) throws IOException {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            return content.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public long[] nextlongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public Long[] nextLongArray(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }

    public static class RedBlackTree {

        class Node {
            int data;
            Node parent;
            Node left;
            Node right;
            int color;
            int rank;  // New field to represent the rank

            public Node() {
                this.rank = 0;  // Initialize the rank to 0
            }
        }

        private Node root;
        private Node TNULL;

        // Preorder
        private void preOrderHelper(Node node) {
            if (node != TNULL) {
                System.out.print(node.data + " ");
                preOrderHelper(node.left);
                preOrderHelper(node.right);
            }
        }

        // Inorder
        private void inOrderHelper(Node node) {
            if (node != TNULL) {
                inOrderHelper(node.left);
                System.out.print(node.data + " ");
                inOrderHelper(node.right);
            }
        }

        // Post order
        private void postOrderHelper(Node node) {
            if (node != TNULL) {
                postOrderHelper(node.left);
                postOrderHelper(node.right);
                System.out.print(node.data + " ");
            }
        }

        // Search the tree
        private Node searchTreeHelper(Node node, int key) {
            if (node == TNULL || key == node.data) {
                return node;
            }

            if (key < node.data) {
                return searchTreeHelper(node.left, key);
            }
            return searchTreeHelper(node.right, key);
        }

        private void rbTransplant(Node u, Node v) {
            if (u.parent == null) {
                root = v;
            } else if (u == u.parent.left) {
                u.parent.left = v;
            } else {
                u.parent.right = v;
            }
            if (v != null) {
                v.parent = u.parent;  // Make sure to update the parent of v
            }
        }


        private void deleteNodeHelper(Node node, int key) {
            Node z = TNULL;
            Node x, y;
            while (node != TNULL) {
                if (node.data == key) {
                    z = node;
                }

                if (node.data <= key) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }

            if (z == TNULL) {
                System.out.println("Couldn't find key in the tree");
                return;
            }

            y = z;
            int yOriginalColor = y.color;
            if (z.left == TNULL) {
                x = z.right;
                rbTransplant(z, z.right);
            } else if (z.right == TNULL) {
                x = z.left;
                rbTransplant(z, z.left);
            } else {
                y = minimum(z.right);
                yOriginalColor = y.color;
                x = y.right;
                if (y.parent == z) {
                    x.parent = y;
                } else {
                    rbTransplant(y, y.right);
                    y.right = z.right;
                    y.right.parent = y;
                }

                rbTransplant(z, y);
                y.left = z.left;
                y.left.parent = y;
                y.color = z.color;
            }
            if (yOriginalColor == 0) {
                fixDelete(x);
            }
        }

        private void fixInsert(Node k) {
            Node u;
            while (k.parent != null && k.parent.color == 1) {
                if (k.parent == k.parent.parent.right) {
                    u = k.parent.parent.left;
                    if (u != null && u.color == 1) {
                        u.color = 0;
                        k.parent.color = 0;
                        k.parent.parent.color = 1;
                        k = k.parent.parent;
                    } else {
                        if (k == k.parent.left) {
                            k = k.parent;
                            rightRotate(k);
                        }
                        if (k.parent != null) {
                            k.parent.color = 0;
                            if (k.parent.parent != null) {
                                k.parent.parent.color = 1;
                                leftRotate(k.parent.parent);
                            }
                        }
                    }
                } else {
                    u = k.parent.parent.right;
                    if (u != null && u.color == 1) {
                        u.color = 0;
                        k.parent.color = 0;
                        k.parent.parent.color = 1;
                        k = k.parent.parent;
                    } else {
                        if (k == k.parent.right) {
                            k = k.parent;
                            leftRotate(k);
                        }
                        if (k.parent != null) {
                            k.parent.color = 0;
                            if (k.parent.parent != null) {
                                k.parent.parent.color = 1;
                                rightRotate(k.parent.parent);
                            }
                        }
                    }
                }
                if (k == root) {
                    break;
                }
            }
            root.color = 0;
        }


        private void leftRotate(Node x) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != TNULL) {
                y.left.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                this.root = y;
            } else if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
            y.left = x;
            x.parent = y;
        }

        // Delete a node with the given key
        public void deleteNode(int key) {
            deleteNodeHelper(this.root, key);
        }

        private void rightRotate(Node x) {
            Node y = x.left;
            x.left = y.right;
            if (y.right != TNULL) {
                y.right.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                this.root = y;
            } else if (x == x.parent.right) {
                x.parent.right = y;
            } else {
                x.parent.left = y;
            }
            y.right = x;
            x.parent = y;
        }

        public void insert(int key) {
            Node node = new Node();
            node.parent = null;
            node.data = key;
            node.left = TNULL;
            node.right = TNULL;
            node.color = 1;  // new node must be red

            Node y = null;
            Node x = this.root;

            while (x != TNULL) {
                y = x;
                if (node.data < x.data) {
                    x.rank++;  // Increase rank when moving left
                    x = x.left;
                } else {
                    node.rank = y.rank + 1;  // Set rank to parent's rank + 1 when moving right
                    x = x.right;
                }
            }

            node.parent = y;
            if (y == null) {
                root = node;
            } else if (node.data < y.data) {
                y.left = node;
            } else {
                y.right = node;
            }

            if (node.parent != null) {
                fixInsert(node);
            } else {
                root.color = 0;
            }
        }

        // Find the rank of a given key in the sorted order
        public int findRank(int key) {
            return findRankHelper(root, key);
        }

        private int findRankHelper(Node node, int key) {
            if (node == TNULL) {
                return 0;  // Element not found
            }

            if (key < node.data) {
                return findRankHelper(node.left, key);
            } else if (key > node.data) {
                return node.rank + findRankHelper(node.right, key);
            } else {
                return node.rank;  // Element found, return its rank
            }
        }

        // Find the rank of a given key in the sorted order

        // Helper method to get the size of the subtree rooted at a given node
        private int size(Node node) {
            if (node == TNULL) {
                return 0;
            }
            return 1 + size(node.left) + size(node.right);
        }

        // Balancing the tree after deletion of a node
        private void fixDelete(Node x) {
            Node s;
            while (x != root && x.color == 0) {
                if (x == x.parent.left) {
                    s = x.parent.right;
                    if (s.color == 1) {
                        s.color = 0;
                        x.parent.color = 1;
                        leftRotate(x.parent);
                        s = x.parent.right;
                    }

                    if (s.left.color == 0 && s.right.color == 0) {
                        s.color = 1;
                        x = x.parent;
                    } else {
                        if (s.right.color == 0) {
                            s.left.color = 0;
                            s.color = 1;
                            rightRotate(s);
                            s = x.parent.right;
                        }

                        s.color = x.parent.color;
                        x.parent.color = 0;
                        s.right.color = 0;
                        leftRotate(x.parent);
                        x = root;
                    }
                } else {
                    s = x.parent.left;
                    if (s.color == 1) {
                        s.color = 0;
                        x.parent.color = 1;
                        rightRotate(x.parent);
                        s = x.parent.left;
                    }

                    if (s.right.color == 0 && s.right.color == 0) {
                        s.color = 1;
                        x = x.parent;
                    } else {
                        if (s.left.color == 0) {
                            s.right.color = 0;
                            s.color = 1;
                            leftRotate(s);
                            s = x.parent.left;
                        }

                        s.color = x.parent.color;
                        x.parent.color = 0;
                        s.left.color = 0;
                        rightRotate(x.parent);
                        x = root;
                    }
                }
            }
            x.color = 0;
        }

        public int size() {
            return size(root);
        }

        // Finding the minimum key value node in a subtree
        private Node minimum(Node node) {
            while (node.left != TNULL) {
                node = node.left;
            }
            return node;
        }

        // Print the tree
        public void printTree() {
            inOrderHelper(this.root);
            System.out.println();
        }
    }
}
//0 1 0 1 0 1 0 1 0 1