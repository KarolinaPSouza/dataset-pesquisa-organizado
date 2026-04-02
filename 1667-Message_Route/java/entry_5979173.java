//package graph_theory.message_route;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

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
public class entry_5979173 {
    private PrintWriter writer;
    private FastReader reader;
    private List<Integer>[] readerGraph(int n, int m){
        List<Integer>[] graph = new List[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++){
            int u = reader.readInt(), v = reader.readInt();;
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
    private  static final int NULL_PARENT = -1;
    private List<Integer> getShortestDistPath(List<Integer>[] graph, int src, int dest){
        int[] bfsParent = new int[graph.length];
        bfsParent[src] = NULL_PARENT;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int adj : graph[node]){
                boolean isVis = bfsParent[adj] != 0;
                if (isVis) continue;
                queue.add(adj);
                bfsParent[adj] = node;
                if (adj == dest) return getPath(bfsParent, dest);
            }
        }
        return null;
    }

    private List<Integer> getPath(int[] bfsParent, int dest) {
        List<Integer> revPath = new Stack<>();

        int node = dest;
        while (node != NULL_PARENT) {
            revPath.add(node);
            node = bfsParent[node];
        }
        Collections.reverse(revPath);
        return revPath;
    }

    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        int n = reader.readInt();
        int m = reader.readInt();
        List<Integer>[] graph = readerGraph(n, m);
       List<Integer> path = getShortestDistPath(graph, 1, n);

        if (path == null) writer.println("IMPOSSIBLE");
        else {
            writer.println(path.size());
            writer.println(path.stream().map(x -> "" + x).collect(Collectors.joining(" ")));
        }

        writer.close();

    }

    public static void main(String[] args) {
        new entry_5979173().solve();
    }
}