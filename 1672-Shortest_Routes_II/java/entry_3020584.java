import java.io.*;
import java.util.*;



//import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class entry_3020584 {
    public static long mod = 998244353;
    public static ArrayList<Integer>[] graph;

    public static void sort(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        for (int u : arr)
            list.add(u);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    public static void sort(long[] arr) {
        ArrayList<Long> list = new ArrayList<>(arr.length);
        for (long u : arr)
            list.add(u);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
    static PrintWriter out;
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);
        int t = 1;
        //t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(in, out);
        }
        out.close();
    }

    public static long solveR(int[] list) {
        long res = 0;
        return res;
    }

    public static long solveL(int[] list) {
        long res = 0;
        return res;
    }

    public static void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long INF = (long)Math.pow(10, 15);
        int m = in.nextInt();
        int q = in.nextInt();
        long[][] dist = new long[n][n];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i],INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            int w = in.nextInt();
            dist[u][v] = Math.min(w,dist[u][v]);
            dist[v][u] = Math.min(w,dist[v][u]); 
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    //dist[i][j] = dist[j][i] = Math.min(dist[j][i],dist[i][j]);
                }
            }
        }
        for (int i = 0; i <q; i++) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            out.println(dist[u][v]==INF?-1:dist[u][v]);
        }
     }
    private static void dfs(int i, int par) {
        if(done) return;
        parent[i] = par;
        color[i] = 1;
        for(int u:graph[i]) if(u!=par){
            if(color[u]==0) dfs(u,i);
            else if(color[u]==2) return;
            else{
                if(done) return;
                int paro = i;
                int cnt = 1;
                StringBuilder ans = new StringBuilder("");
                ans.append((u+1)).append(" ");
                while(paro!=u){
                    ans.append((paro+1)).append(" ");
                    paro = parent[paro];
                    cnt++;
                }
                ans.append(u+1).append(" ");
                out.println(++cnt);
                out.println(ans);
                done = true;
                return;
            }
        }
        color[i] = 2;
    }
    static boolean done;
    static int[] color;
    static int[] parent;
    static boolean[][] visited;

    private static void bfs(char[][] grid, int i, int j) {
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int[] dx = new int[]{1,0,-1,0};
            int[] dy = new int[]{0,1,0,-1};
            for(int k = 0;k<dx.length;k++){
                if(valid(grid,temp[0]+dx[k],temp[1]+dy[k])){
                    visited[temp[0]+dx[k]][temp[1]+dy[k]] = true;
                    q.add(new int[]{temp[0]+dx[k],temp[1]+dy[k]});
                }
            }
        }
    }

    private static boolean valid(char[][] grid, int i, int i2) {
        return i<grid.length && i2<grid[0].length && i>=0 && i2>=0 && !visited[i][i2] && grid[i][i2]=='.';
    }

    private static long findoo(int[] list, long r) {
        int lo = 0;
        int hi = list.length - 1;
        long ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list[mid] <= r) {
                ans = mid;
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return ans;
    }

    public static long invmod(long i) {
        long pow = mod - 2;
        long ans = 1;
        while (pow > 0) {
            if (pow % 2 == 1)
                ans = (ans * i) % mod;
            i = (i * i) % mod;
            pow /= 2;
        }
        return ans;
    }

    private static long modpow(long u, long k) {
        long res = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                res = (res * u) % mod;
            }
            u = (u * u) % mod;
            k /= 2;
        }
        return res;
    }

    private static long total(int[] list, long mid) {
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > mid) {
                return Integer.MAX_VALUE;
            } else if (sum + list[i] <= mid)
                sum += list[i];
            else {
                ans++;
                sum = list[i];
            }
        }
        return (ans + 1);
    }

    private static long prod(long[] list, long mid) {
        long ans = 0;
        for (long k : list)
            ans += mid / k;
        return ans;
    }


    static TreeSet<String> all;

    private static String ktimes(char c, int i) {
        StringBuilder str = new StringBuilder("");
        for (int j = 0; j < i; j++) {
            str.append(c);
        }
        return str.toString();
    }

    static class DSU {
        int[] parent;
        int[] weight;
        int maxweight = 1;
        int numc;

        public DSU(int n) {
            numc = n;
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
                // min[i] = max[i] = i;
            }
        }

        public void union(int u, int v) {
            int p = get(u);
            int q = get(v);
            if (p == q)
                return;
            if (weight[p] >= weight[q]) {
                parent[q] = p;
                weight[p] += weight[q];
                maxweight = Math.max(maxweight, weight[p]);
            } else {
                parent[p] = q;
                weight[q] += weight[p];
                maxweight = Math.max(maxweight, weight[q]);
            }
            numc--;
        }

        public int get(int u) {
            while (parent[u] != u) {
                u = parent[u];
            }
            return u;
        }

    }

    private static boolean valid(int i, int j) {
        return i >= 0 && i < 3 && j < 3 && j >= 0;
    }

    private static boolean valid(char[][] grid, boolean[][] visited, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != '#' && !visited[i][j];
    }

}

class InputReader {
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

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int[] readIntArray(int size) {
        int[] list = new int[size];
        for (int i = 0; i < size; i++)
            list[i] = nextInt();
        return list;
    }

    public long[] readLongArray(int size) {
        long[] list = new long[size];
        for (int i = 0; i < size; i++)
            list[i] = nextLong();
        return list;
    }

    public double[] readDoubleArray(int size) {
        double[] list = new double[size];
        for (int i = 0; i < size; i++)
            list[i] = nextDouble();
        return list;
    }

    public String linereader() {
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

}

class Pair<T extends Comparable<T>, K extends Comparable<K>> implements Comparable<Pair<T, K>> {
    T first;
    K second;

    public Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " " + second;
    }

    @Override
    public int compareTo(Pair<T, K> o) {
        // TODO Auto-generated method stub
        if ((first).compareTo(o.first) != 0)
            return first.compareTo(o.first);
        else
            return second.compareTo(o.second);
    }

}
class SegmentTree {

    private Node[] heap;
    private int[] array;
    private int size;

    /**
     * Time-Complexity:  O(n*log(n))
     *
     * @param array the Initialization array
     */
    public SegmentTree(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        //The max size of this array is about 2 * 2 ^ log2(n) + 1
        size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) array.length) / Math.log(2.0)) + 1)));
        heap = new Node[size];
        build(1, 0, array.length);
    }


    public int size() {
        return array.length;
    }

    //Initialize the Nodes of the Segment tree
    private void build(int v, int from, int size) {
        heap[v] = new Node();
        heap[v].from = from;
        heap[v].to = from + size - 1;

        if (size == 1) {
            heap[v].sum = array[from];
            heap[v].min = array[from];
        } else {
            //Build childs
            build(2 * v, from, size / 2);
            build(2 * v + 1, from + size / 2, size - size / 2);

            heap[v].sum = heap[2 * v].sum + heap[2 * v + 1].sum;
            //min = min of the children
            heap[v].min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
        }
    }

    /**
     * Range Sum Query
     *
     * Time-Complexity: O(log(n))
     *
     * @param  from from index
     * @param  to to index
     * @return sum
     */
    public int rsq(int from, int to) {
        return rsq(1, from, to);
    }

    private int rsq(int v, int from, int to) {
        Node n = heap[v];

        //If you did a range update that contained this node, you can infer the Sum without going down the tree
        if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
            return (to - from + 1) * n.pendingVal;
        }

        if (contains(from, to, n.from, n.to)) {
            return heap[v].sum;
        }

        if (intersects(from, to, n.from, n.to)) {
            propagate(v);
            int leftSum = rsq(2 * v, from, to);
            int rightSum = rsq(2 * v + 1, from, to);

            return leftSum + rightSum;
        }

        return 0;
    }

    /**
     * Range Min Query
     * 
     * Time-Complexity: O(log(n))
     *
     * @param  from from index
     * @param  to to index
     * @return min
     */
    public int rMinQ(int from, int to) {
        return rMinQ(1, from, to);
    }

    private int rMinQ(int v, int from, int to) {
        Node n = heap[v];


        //If you did a range update that contained this node, you can infer the Min value without going down the tree
        if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
            return n.pendingVal;
        }

        if (contains(from, to, n.from, n.to)) {
            return heap[v].min;
        }

        if (intersects(from, to, n.from, n.to)) {
            propagate(v);
            int leftMin = rMinQ(2 * v, from, to);
            int rightMin = rMinQ(2 * v + 1, from, to);

            return Math.min(leftMin, rightMin);
        }

        return Integer.MAX_VALUE;
    }


    /**
     * Range Update Operation.
     * With this operation you can update either one position or a range of positions with a given number.
     * The update operations will update the less it can to update the whole range (Lazy Propagation).
     * The values will be propagated lazily from top to bottom of the segment tree.
     * This behavior is really useful for updates on portions of the array
     * <p>
     * Time-Complexity: O(log(n))
     *
     * @param from  from index
     * @param to    to index
     * @param value value
     */
    public void update(int from, int to, int value) {
        update(1, from, to, value);
    }

    private void update(int v, int from, int to, int value) {

        //The Node of the heap tree represents a range of the array with bounds: [n.from, n.to]
        Node n = heap[v];

        /**
         * If the updating-range contains the portion of the current Node  We lazily update it.
         * This means We do NOT update each position of the vector, but update only some temporal
         * values into the Node; such values into the Node will be propagated down to its children only when they need to.
         */
        if (contains(from, to, n.from, n.to)) {
            change(n, value);
        }

        if (n.size() == 1) return;

        if (intersects(from, to, n.from, n.to)) {
            /**
             * Before keeping going down to the tree We need to propagate the
             * the values that have been temporally/lazily saved into this Node to its children
             * So that when We visit them the values  are properly updated
             */
            propagate(v);

            update(2 * v, from, to, value);
            update(2 * v + 1, from, to, value);

            n.sum = heap[2 * v].sum + heap[2 * v + 1].sum;
            n.min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
        }
    }

    //Propagate temporal values to children
    private void propagate(int v) {
        Node n = heap[v];

        if (n.pendingVal != null) {
            change(heap[2 * v], n.pendingVal);
            change(heap[2 * v + 1], n.pendingVal);
            n.pendingVal = null; //unset the pending propagation value
        }
    }

    //Save the temporal values that will be propagated lazily
    private void change(Node n, int value) {
        n.pendingVal = value;
        n.sum = n.size() * value;
        n.min = value;
        array[n.from] = value;

    }

    //Test if the range1 contains range2
    private boolean contains(int from1, int to1, int from2, int to2) {
        return from2 >= from1 && to2 <= to1;
    }

    //check inclusive intersection, test if range1[from1, to1] intersects range2[from2, to2]
    private boolean intersects(int from1, int to1, int from2, int to2) {
        return from1 <= from2 && to1 >= from2   //  (.[..)..] or (.[...]..)
                || from1 >= from2 && from1 <= to2; // [.(..]..) or [..(..)..
    }

    //The Node class represents a partition range of the array.
    static class Node {
        int sum;
        int min;
        //Here We store the value that will be propagated lazily
        Integer pendingVal = null;
        int from;
        int to;

        int size() {
            return to - from + 1;
        }

    }
}