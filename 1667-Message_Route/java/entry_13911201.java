import java.io.*;
import java.util.*;

class DSU{
    int[] par;
    int[] size;
    DSU(int n){
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
    }
    public int findpar(int n){
        if(par[n] == n){
            return n;
        }
        return par[n]=findpar(par[n]);
    }
    public boolean union(int u,int v){
        int pu=findpar(u);
        int pv=findpar(v);
        if(pu == pv) return false;
        if(size[pu] < size[pv]){
            size[pv]+=size[pu];
            par[pu]=pv;
        }
        else{
            size[pu]+=size[pv];
            par[pv]=pu;
        }
        return true;
    }
}
public class entry_13911201 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        // Example: Read a single integer
        int n = fr.nextInt();
        int m = fr.nextInt();
        // Example: Read array of integers
        int[][] e = new int[m][2];
        for (int i = 0; i < m; i++) {
            e[i][0] = fr.nextInt()-1;
            e[i][1] = fr.nextInt()-1;
        }
        solve(e,n,m);
    }
    public static void solve(int[][] e, int n, int m) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

    for (int[] ed : e) {
        adj.get(ed[0]).add(ed[1]);
        adj.get(ed[1]).add(ed[0]);
    }

    int[] parent = new int[n];
    Arrays.fill(parent, -1);
    boolean[] vis = new boolean[n];

    Queue<Integer> q = new LinkedList<>();
    q.offer(0); // start from node 1 (0-indexed)
    vis[0] = true;

    while (!q.isEmpty()) {
        int u = q.poll();
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                vis[v] = true;
                parent[v] = u;
                q.offer(v);
            }
        }
    }

    if (!vis[n - 1]) {
        System.out.println("IMPOSSIBLE");
        return;
    }

    List<Integer> path = new ArrayList<>();
    for (int cur = n - 1; cur != -1; cur = parent[cur]) {
        path.add(cur + 1); // convert back to 1-indexed
    }

    Collections.reverse(path);
    System.out.println(path.size());
    for (int x : path) {
        System.out.print(x + " ");
    }
    System.out.println();
}

}

class FastReader {
    final private int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastReader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String nextLine() throws IOException {
        byte[] buf = new byte[64];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public String next() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = read()) > ' ');
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -ret : ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -ret : ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
        return neg ? -ret : ret;
    }

    public char nextChar() throws IOException {
        byte c = read();
        while (c <= ' ') c = read();
        return (char) c;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    public void close() throws IOException {
        din.close();
    }
}