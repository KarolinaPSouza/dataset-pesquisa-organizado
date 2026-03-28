//package tree_queries.tree_distances_I;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.*;
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
    private Stack<IntListIterator> itrStack;
    private IntList nodeStack;

    void dfs(IntList[] tree, int root, IntConsumer visit, IntConsumer exit, int[] parent){

        nodeStack =  new IntList();
        itrStack = new Stack<>();

        nodeStack.add(root);
        itrStack.push(new IntListIterator(tree[root]));
        visit.accept(root);
        parent[root] = -1;


        while (!(nodeStack.size() == 0)){
            int s = nodeStack.peek();
            IntListIterator itr = itrStack.peek();
            if (!itr.hasNext()){
                nodeStack.pop();
                itrStack.pop();
                exit.accept(s);
            }
            else{
                int next = itr.next();
                if (next == parent[s]) continue;
                nodeStack.add(next);
                itrStack.push(new IntListIterator(tree[next]));
                parent[next] = s;
                visit.accept(next);
            }
        }
    }
}
class IntListIterator{
    IntList list;
    int idx;
    IntListIterator(IntList list){
        this.list = list;
        idx = 0;
    }
    int next(){
        return list.get(idx++);
    }
    boolean hasNext(){
        return idx < list.size();
    }
}
class IntList{
    private int[] arr;
    private int size;
    IntList(int initialCapacity){
        arr = new int[initialCapacity];
        size = 0;
    }
    IntList(){
        this(1);
    }

    int get(int idx){
        return arr[idx];
    }

    void doubleArraySize(){
        int[] copy = new int[2*arr.length];
        for (int i = 0; i < size; i++) copy[i] = arr[i];
        arr = copy;
    }
    void add(int val){
        if (size == arr.length){
            doubleArraySize();
        }
        arr[size] = val;
        size++;
    }
    int size(){
        return size;
    }
    int peek(){
        return arr[size-1];
    }
    int pop(){
        int val = arr[size-1];
        size--;
        return val;
    }

    @Override
    public String toString() {
        return "IntList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}

public class entry_6197042 {
    private PrintWriter writer;
    private FastReader reader;


    private IntList[] tree;
    int[] parent;
    int[] inDp;
    int[] size;
    int[] outDp;
    int n;
    private void emptyVisit(int s){

    }
    private void emptyExit(int s){

    }

    private void computeInDp(int s){

        size[s] = 1;
        for (int i = 0; i < tree[s].size(); i++){
            int v = tree[s].get(i);
            if (v == parent[s]) continue;
            inDp[s] = Math.max(1+inDp[v], inDp[s]);
            size[s] += size[v];
        }
    }

    private void computeOutDp(int s){
        int  childrenMax1 = -1, childrenMax2 = -1;

        for (int i = 0; i < tree[s].size(); i++){
            int v = tree[s].get(i);
            if (v == parent[s]) continue;
            if (inDp[v] > childrenMax1){
                childrenMax2 = childrenMax1;
                childrenMax1 = inDp[v];
            }
            else if (inDp[v] > childrenMax2){
                childrenMax2 = inDp[v];
            }
        }



        for (int i = 0; i < tree[s].size(); i++){
            int v = tree[s].get(i);
            if (v == parent[s]) continue;

            outDp[v] = 1 + outDp[s];
            int maxInDpOtherThanV = inDp[v] == childrenMax1 ? childrenMax2:childrenMax1;
            if (maxInDpOtherThanV != -1) outDp[v] = Math.max(2+maxInDpOtherThanV, outDp[v]);

        }
    }

    private void readTree(int n){
        tree = new IntList[n];
        for (int i = 0; i < n; i++) tree[i] = new IntList();
        for (int i = 0; i < n-1; i++){
            int u = reader.readInt()-1, v = reader.readInt()-1;
            tree[u].add(v);
            tree[v].add(u);
        }
    }
    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        n = reader.readInt();
        readTree(n);

        parent = new int[n];
        size = new int[n];
        inDp = new int[n];
        outDp = new int[n];

        int root = new Random().nextInt(n); // just to prove that the solution works no matter what root is chosen.


        new Dfs().dfs(tree, root, this::emptyVisit, this::computeInDp, parent);
        new Dfs().dfs(tree, root, this::computeOutDp, this::emptyExit, parent);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int maxDist = Math.max(inDp[i], outDp[i]);
            sb.append(maxDist).append(" ");
        }
        writer.println(sb);

        writer.close();

    }

    public static void main(String[] args) {
        new entry_6197042().solve();
    }
}