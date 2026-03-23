import java.io.*;
import java.util.*;

public class entry_14763957 {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;
        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c; while ((c = readByte()) <= ' ') if (c == -1) return -1;
            int sign = 1; if (c == '-') { sign = -1; c = readByte(); }
            long val = c - '0';
            while ((c = readByte()) > ' ') val = val * 10 + c - '0';
            return val * sign;
        }
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            while ((c = readByte()) <= ' ') ;
            if (c == '-') { sign = -1; c = readByte(); }
            do { val = val * 10 + (c - '0'); }
            while ((c = readByte()) > ' ');
            return val * sign;
        }
         int[] readIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] =nextInt();
            }
            return a;
        }
        String nextLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            // skip any '\n' or '\r' from previous reads
            while ((c = readByte()) != -1 && (c == '\n' || c == '\r')) ;
            if (c == -1) return null;
            sb.append((char)c);
            // read until newline
            while ((c = readByte()) != -1 && c != '\n' && c != '\r') {
                sb.append((char)c);
            }
            return sb.toString();
        }

    }
    static class Ds{
        int parent[];
        int size[];
        Ds(int n){
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i] = i;
            }
            for(int i=0;i<=n;i++){
                size[i] = 1;
            }
        }
        int findUp(int u){
            if(parent[u]!=u){
                parent[u] = findUp(parent[u]);
            }
            return parent[u];
        }
        void uionsize(int u,int v){
            int up = findUp(u);
            int vp = findUp(v);
            if(size[up]>size[vp]){
                size[up]+=size[vp];
                parent[vp] = up;
            }else{
                size[vp]+=size[up];
                parent[up] = vp;
            }
        }
        int getSize(int x) {
            return size[findUp(x)];
        }
    }
    static class Pair {
        long val;
        int idx;
        Pair(long v, int i) { val = v; idx = i; }
    }

    static ArrayList<ArrayList<Integer>> adj, adjRev;
    static Stack<Integer> order = new Stack<>();
    static int[] component;
    static String[] assignment;
    static boolean[] vis;
    static int n;

    static int negateVar(int x) {
        return (x < n) ? (x + n) : (x - n);
    }

    static void addClause(int x, int y) {
        adj.get(negateVar(x)).add(y);
        adj.get(negateVar(y)).add(x); 
        adjRev.get(y).add(negateVar(x));
        adjRev.get(x).add(negateVar(y));
    }

    static void dfs1(int u) {
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v]) dfs1(v);
        }
        order.add(u);
    }

    static void dfs2(int u, int compId) {
        component[u] = compId;
        for (int v : adjRev.get(u)) {
            if (component[v] == -1) dfs2(v, compId);
        }
    }


    static final int MOD = 1000000007;

    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static class State {
        int node;
        long cost;
        State(int node, long cost) { this.node = node; this.cost = cost; }
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        n = fs.nextInt();
        adj = new ArrayList<>();
        used = new boolean[n+1];
        int n1 = n+1;

        while (n1-->0) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int a = fs.nextInt()-1;
            int b = fs.nextInt()-1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] first = bfs(0);
        int farthestNode = first[0];

        int[] second = bfs(farthestNode);
        int diameter = second[1];

        out.println(diameter);
        out.flush();
    }
     static int[] bfs(int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > maxDist) {
                        maxDist = dist[v];
                        farthestNode = v;
                    }
                }
            }
        }

        return new int[]{farthestNode, maxDist};
    }

    static boolean used[];


}