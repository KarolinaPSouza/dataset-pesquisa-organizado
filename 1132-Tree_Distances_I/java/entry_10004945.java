//package tree_queries.tree_distances_I.bfs_and_diameter_properties;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.*;

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

class BfsData{
    int[] distTable;
    int farthestNode;

    public BfsData(int[] distTable, int farthestNode) {
        this.distTable = distTable;
        this.farthestNode = farthestNode;
    }
}
public class entry_10004945 {
    private PrintWriter writer;
    private FastReader reader;

    private List<Integer>[] tree;

    // returns the farthest node from s, along with its farthest distance.
    private BfsData getFarthestNodeAndDistance(int s){
        Queue<Integer> bfsQue = new ArrayDeque<>();
        int n = tree.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        bfsQue.add(s);
        dist[s] = 0;

        int farthestNode = -1;
        while (!bfsQue.isEmpty()){
            int size = bfsQue.size();
            for (int i = 0; i < size; i++){
                int node = bfsQue.poll();
                farthestNode = node;
                for (int adj :tree[node]){
                    if (dist[adj] != -1) continue;
                    dist[adj] = dist[node]+1;
                    bfsQue.add(adj);
                }
            }
        }
        return new BfsData(dist, farthestNode);
    }
    private int[] getFarthestNodeDistances(){
        int diameterEndPoint1 = getFarthestNodeAndDistance(0).farthestNode;
        BfsData data1 = getFarthestNodeAndDistance(diameterEndPoint1);
        int diameterEndPoint2 = data1.farthestNode;
        BfsData data2 = getFarthestNodeAndDistance(diameterEndPoint2);

        int[] maxDist = new int[tree.length];
        for (int node = 0; node < tree.length; node++){
            // the farthest node from a given node must be one of the diameter endpoints
            maxDist[node] = Math.max(data1.distTable[node], data2.distTable[node]);
        }
        return maxDist;
    }
    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        int n = reader.readInt();
        readTree(n);
        int[] maxDist = getFarthestNodeDistances();

        StringBuilder sb = new StringBuilder();
        for (int x : maxDist) sb.append(x).append(" ");
        writer.println(sb);

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
        new Thread(null, ()-> new entry_10004945().solve(), "SolutionThread", 1<<25).start();
    }
}