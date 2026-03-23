//package tree_queries.tree_diameter.dfs_max_and_second_max;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.function.IntConsumer;

class FastReader {
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastReader() {
        in = new BufferedInputStream(System.in, BS);
    }

    // dont' use this to read chars.
    private char readChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int readInt() {
        return (int) readLong();
    }

    public int[] readInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) readLong();
        }
        return res;
    }

    public long[] readLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public long readLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = readChar();
        for (; (c < '0' || c > '9'); c = readChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = readChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = readLong();
        return c != '.' ? cur : cur + readLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String readString() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c > 32) {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public String readLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c != '\n') {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = readChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}

class Dfs{
    private Stack<Iterator<Integer>> itrStack;
    private Stack<Integer> nodeStack;

    void dfs(List<Integer>[] tree, int root, IntConsumer visit, IntConsumer exit, int[] parent){

        nodeStack =  new Stack<>();
        itrStack = new Stack<>();

        nodeStack.push(root);
        itrStack.push(tree[root].iterator());
        visit.accept(root);
        parent[root] = -1;


        while (!nodeStack.isEmpty()){
            int s = nodeStack.peek();
            Iterator<Integer> itr = itrStack.peek();
            if (!itr.hasNext()){
                nodeStack.pop();
                itrStack.pop();
                exit.accept(s);
            }
            else{
                int next = itr.next();
                if (next == parent[s]) continue;

                nodeStack.push(next);
                itrStack.push(tree[next].iterator());

                parent[next] = s;
                visit.accept(next);
            }
        }
    }
}

public class entry_10004750 {
    private PrintWriter writer;
    private FastReader reader;
    private int[] depth;
    private List<Integer>[] tree;
    private int[] parent;
    private int diameter;
    private void visit(int s){
        // do nothing, all the work is done at exit.
    }
    private void exit(int x){
        int max = -1, secondMax = -1;
        for (int v : tree[x]){
            if (v == parent[x]) continue;
            if (depth[v] > max){
                secondMax = max;
                max = depth[v];
            }
            else if (depth[v] > secondMax){
                secondMax = depth[v];
            }
        }
        depth[x] = max+1;
        int longestAlongX;
        if (secondMax == -1) longestAlongX = max+1;
        else longestAlongX = max + secondMax + 2;
        diameter = Math.max(longestAlongX, diameter);
    }

    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        int n = reader.readInt();
        readTree(n);
        depth = new int[n];
        parent = new int[n];

        new Dfs().dfs(tree, 0, this::visit, this::exit, parent);

        writer.println(diameter);

        writer.close();

    }
    private void readTree(int n){
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++){
            int u = reader.readInt()-1;
            int v = reader.readInt()-1;
            tree[u].add(v);
            tree[v].add(u);
        }
    }

    public static void main(String[] args) {
        new Thread(null, ()-> new entry_10004750().solve(), "SolutionThread", 1<<25).start();
    }
}