import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_13262644 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static long INF = 2000000000000000000L;
    static List<Map<Integer, Long>> graph = new ArrayList<>();

    // public static class Edge {
    //     int v;
    //     long w;
    //     Edge(int v, long w) {
    //         this.v = v;
    //         this.w = w;
    //     }
    // }

    public static class Node {
        int u;
        long Dist_u;
        Node(int u, long Dist_u) {
            this.u = u;
            this.Dist_u = Dist_u;
        }
    }

    public static void dijkstra(int n, int s, long[] D){
        Arrays.fill(D, 1, n+1, INF);
        boolean[] P = new boolean[n+1];
        D[s] = 0;
        PriorityQueue<Node> h = new PriorityQueue<>((a, b) -> Long.compare(a.Dist_u, b.Dist_u));
        h.add(new Node(s,D[s]));
        while (!h.isEmpty()){
            Node x = h.poll();
            int u = x.u;
            if(P[u]) continue;
            P[u] = true;
            for (Map.Entry<Integer, Long> entry : graph.get(u).entrySet()){
                int v = entry.getKey();
                long w = entry.getValue();
                if(D[v] > D[u] + w){
                    D[v] = D[u] + w;
                    h.add(new Node(v, D[v]));
                }
            }
        }
    }

    public static void main(String[] args){
        FastReader inp = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = inp.nextInt();
        int m = inp.nextInt();
        for (int i = 0; i <= n; i++){
            graph.add(new HashMap<>());
        }
        long[] D = new long[n+1];
        while (m-- > 0){
            int a = inp.nextInt();
            int b = inp.nextInt();
            long c = inp.nextLong();
            graph.get(a).merge(b, c, Math::min);
        }
        dijkstra(n, 1, D);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++){
            sb.append(D[i]).append(" ");
        }
        pw.println(sb);
        pw.close();
    }
}