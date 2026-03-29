import java.io.*;
import java.util.*;

public class entry_14240796 {
    static FastReader sc;
    static PrintWriter out;
    static StringBuilder sb = new StringBuilder();
    static final long INF = (long) 1e18;
    // static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        // USACO file I/O
//        sc = new FastReader("speeding.in");
//        out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        // Terminal I/O
        sc = new FastReader();
        out = new PrintWriter(System.out);

        solve();
        out.print(sb.toString());
        out.close();
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for(int i=0;i<m;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
            edges[i][2]=sc.nextInt();
        }
        long[] dist = new long[n+1];
        int[] relaxant = new int[n+1];
        Arrays.fill(relaxant,-1);
        Arrays.fill(dist,0);
        int x = -1;
        for(int i=0;i<n;i++){
            x=-1;
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dist[u]+wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    relaxant[v] = u;
                    x = v;
                }
            }
        }
        if(x==-1){
            sb.append("NO");
            return;
        }
        for(int i=0;i<n;i++){
            x = relaxant[x];
        }
        List<Integer> cycle = new ArrayList<>();
        for(int curr=x;;curr=relaxant[curr]){
            cycle.add(curr);
            if(curr == x && cycle.size() > 1){
                break;
            }
        }
        Collections.reverse(cycle);
        sb.append("YES\n");
        for(int vr:cycle){
            sb.append(vr).append(" ");
        }
    }
    // ------------------ FastReader ------------------
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }
        FastReader(){
            br =  new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
class Pair{
    int node;
    int weight;
    Pair(int _node,int _weight){
        this.node = _node;
        this.weight = _weight;
    }
}
class Tuple{
    long weight;
    int node;
    int used;
    Tuple(long _weight,int _node,int _used){
        this.weight = _weight;
        this.node = _node;
        this.used = _used;
    }
}