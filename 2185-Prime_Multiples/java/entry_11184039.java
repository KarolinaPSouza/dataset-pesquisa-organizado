import java.io.*;
import java.util.*;


public class entry_11184039 {

    private static final int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}}; // used for grid bfs
    private static StringTokenizer st;
    private static final int mod1 = (int) 1e9 + 7;
    private static final int mod2 = 998244353;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] primes = new long[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            primes[i] = Long.parseLong(st.nextToken());
        }
        long res = 0;
        for (int i = 1; i < (1 << k); i++) {
            long divisor = 1;
            int count = 0;
            for (int j = 0; j < k; j++) {
                if ((i & (1 << j)) > 0) {
                    count++;
                    if (divisor > n / primes[j]) {
                        divisor = n+1;
                        break;
                    }
                    divisor *= primes[j];
                }
            }
            if (count % 2 == 1) {
                res += n / divisor;
            } else if (count > 0){
                res -= n / divisor;
            }
        }
        pw.println(res);
        pw.flush();
    }
    // inclusion exclusion principle

    public static int LIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pos = Collections.binarySearch(dp, nums[i]);
            pos = pos < 0? Math.abs(pos + 1): pos;
            if (pos == dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(pos, nums[i]);
            }
        }
        return dp.size();
    }


}




class FenwickTree {
    private long[] tree;
    private int n;
    private int mod = (int) 1e9 + 7;

    public FenwickTree(int n) {
        this.n = n;
        this.tree = new long[n+1]; // 1-based
    }

    public void update(int i, long value) {
        while (i <= n) {
            tree[i] += value;
            i += lsb(i);
        }
    }
    public long query(int i) {
        long sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lsb(i);
        }
        return sum;
    }
    // inclusive query from l to r
    public long rangeQuery(int l, int r) {
        return query(r) - query(l-1);
    }

    // Initialize the tree with an input array
    public void build(int[] arr) {
        for (int i = 1; i <= n; i++) {
            update(i, arr[i - 1]); // Adjust for 1-based indexing
        }
    }

    public int lsb(int i) {
        return i & -i;
    }
}

class Item {
    private long seg;
    private long pref;
    private long suf;
    private long sum;

    // Constructor
    public Item(long seg, long pref, long suf, long sum) {
        this.seg = seg;
        this.pref = pref;
        this.suf = suf;
        this.sum = sum;
    }

    // Getters
    public long getSeg() {
        return seg;
    }

    public long getPref() {
        return pref;
    }

    public long getSuf() {
        return suf;
    }

    public long getSum() {
        return sum;
    }

    // Setters
    public void setSeg(long seg) {
        this.seg = seg;
    }

    public void setPref(long pref) {
        this.pref = pref;
    }

    public void setSuf(long suf) {
        this.suf = suf;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Item{seg=" + seg + ", pref=" + pref + ", suf=" + suf + ", sum=" + sum + "}";
    }
}
class LazySegmentTree {
    private static final int mod1 = (int) 1e9 + 7;
    private long NeutralValue = 0;
    private long NO_OPERATION = Long.MAX_VALUE - 1;

    private int size;
    private long[] operations;
    private long[] values;


    public LazySegmentTree(int n) {
        size = 1;
        while (size < n) size *= 2;
        operations = new long[2 * size];
        values = new long[2 * size];

    }
    public void propogate(int node, int lx, int rx) {
        if (rx - lx == 1) return;
        int mid = (lx + rx) / 2;
        operations[2 * node + 1] = modify_op(operations[2 * node + 1], operations[node], 1);
        values[2 * node + 1] = modify_op(values[2 * node + 1], operations[node], mid - lx);

        operations[2 * node + 2] = modify_op(operations[2 * node + 2], operations[node], 1);
        values[2 * node + 2] = modify_op(values[2 * node + 2], operations[node],rx - mid);

        operations[node] = NO_OPERATION;
    }

    public long modify_op(long a, long b, int len) {
        if (b == NO_OPERATION) return a;
        return b * len;
    }
    public long calc_op(long a, long b) {
        return a + b;
    }

    public void modify(int l, int r, int v, int node, int lx, int rx) {
        propogate(node, lx, rx);
        if (lx >= r || l >= rx) return;
        if (lx >= l && rx <= r) {
            operations[node] = modify_op(operations[node], v, 1);
            values[node] = modify_op(values[node], v, rx - lx);
            return;
        }
        int m = (lx + rx) / 2;
        modify(l, r, v, 2 * node + 1, lx, m);
        modify(l, r, v, 2 * node + 2, m, rx);
        values[node] = calc_op(values[2 * node + 1], values[2 * node + 2]);
    }
    public void modify(int l, int r, int v) {
        modify(l, r, v, 0, 0, size);
    }

    public long calc(int l, int r, int node, int lx, int rx) {
        propogate(node, lx, rx);
        if (lx >= r || l >= rx) return NeutralValue;
        if (lx >= l && rx <= r) return values[node];
        int m = (lx + rx) / 2;
        long left = calc(l, r, 2 * node + 1, lx, m);
        long right = calc(l, r, 2 * node + 2, m, rx);
        return calc_op(left, right);
    }

    public long calc(int l, int r) {
        return calc(l, r, 0, 0, size);
    }



}


class SegmentTree {
    private long neutralValue = Long.MAX_VALUE;
    private int size;
    private long[] values;

    public SegmentTree(int n) {
        size = 1;
        while (size < n) size *= 2;
        values = new long[2 * size - 1];
    }


    public void build(int[] nums) {
        build(nums, 0, 0, size);
    }
    public void build(int[] nums, int node, int lx, int rx) {
        if (rx - lx == 1) {
            if (lx < nums.length) {
                values[node] = nums[lx];
            }
            return;
        }
        int middle = (lx + rx) / 2;
        build(nums, 2 * node + 1, lx, middle);
        build(nums, 2 * node + 2, middle, rx);
        values[node] = merge(values[2 * node + 1], values[2 * node + 2]);
    }
    // Function to handle merging, allows for different operations like sum, min, max
    private long merge(long left, long right) {
        return Math.min(left, right);
    }

    public void set(int i, int v) {
        set(i, v, 0, 0, size);
    }
    public void set(int i, int v, int node, int lx, int rx) {
        if (rx - lx == 1)  {
            values[node] = v;
            return;
        }
        int middle = (lx + rx) / 2;
        if (i < middle) {
            set(i, v, 2 * node + 1, lx, middle);
        } else {
            set(i, v, 2 * node + 2, middle, rx);
        }
        values[node] = merge(values[2 * node + 1], values[2 * node + 2]);
    }

    public long query(int l, int r) {
        return query(l, r, 0, 0, size);
    }
    public long query(int l, int r, int node, int lx, int rx) {
        if (lx >= r || rx <= l) return neutralValue;
        if (lx >= l && rx <= r) return values[node];
        int middle = (lx + rx) / 2;
        long left = query(l, r, 2 * node + 1, lx, middle);
        long right = query(l, r, 2 * node + 2, middle, rx);
        return merge(left, right);
    }

    //  add a value to index i
    public void add(int i, long increment) {
        add(i, increment, 0, 0, size);
    }

    private void add(int i, long increment, int node, int lx, int rx) {
        if (rx - lx == 1) {
            values[node] += increment;
            return;
        }
        int middle = (lx + rx) / 2;
        if (i < middle) {
            add(i, increment, 2 * node + 1, lx, middle);
        } else {
            add(i, increment, 2 * node + 2, middle, rx);
        }
        // After the recursion, update the current node by merging the children
        values[node] = merge(values[2 * node + 1], values[2 * node + 2]);
    }
}
class MultiSet {
    private TreeMap<Integer, Integer> multiset;
    private int size;

    public MultiSet() {
        this.multiset = new TreeMap<>();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return this.multiset.isEmpty();
    }
    public void remove(int x) {
        if (multiset.containsKey(x)) {
            int count = multiset.get(x);
            if (count > 1) {
                multiset.put(x, count - 1);
            } else {
                multiset.remove(x);
            }
            size--;
        }
    }

    public void add(int x) {
        multiset.put(x, multiset.getOrDefault(x, 0) + 1);
        size++;
    }

    public boolean contains(int x) {
        return multiset.containsKey(x);
    }

    public int count(int x) {
        return multiset.getOrDefault(x, 0);
    }

    public void clear() {
        multiset.clear();
        size = 0;
    }

    public int firstKey() {
        return multiset.isEmpty() ? null : multiset.firstKey();
    }

    public Integer lastKey() {
        return multiset.isEmpty() ? null : multiset.lastKey();
    }

    @Override
    public String toString() {
        return multiset.toString();
    }


}
class UnionFind {
    int[] parent;
    int[] rank;
    int[] size; // Tracks the size of each component
    int count; // Tracks the number of connected components
    int maxSize;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        count = n;
        maxSize = 1;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false; // Already connected

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            maxSize = Math.max(maxSize, size[rootX]);
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
            maxSize = Math.max(maxSize, size[rootY]);
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            maxSize = Math.max(maxSize, size[rootX]);
            rank[rootX]++;
        }
        count--; // Reduce the number of connected components
        return true;
    }
    public boolean sameComponent(int x, int y) {
        return find(x) == find(y);
    }
    public int components() {
        return count-1;
    }
    public int largestComponentSize() {
        return maxSize;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    // Constructor
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Setters
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
