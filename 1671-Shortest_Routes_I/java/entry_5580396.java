import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class entry_5580396 {
    static InputStream in = new BufferedInputStream(System.in);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static int nextInt() {
        int r = 0;
        try {
            int c = in.read();
            while (c < '0' || c > '9') c = in.read();
            while (c >= '0' && c <= '9') {
                r = r * 10 + (c - '0');
                c = in.read();
            }

        } catch (Exception e) {
            // ignore
        }
        return r;
    }

    static class Pair{
        int v;
        long w;

        public Pair(int v, long w){
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Pair>[] graph = new ArrayList[n + 1];
        Arrays.setAll(graph, value -> new ArrayList<>());

        for(int i = 0; i < m; i ++){
            graph[nextInt()].add(new Pair(nextInt(), nextInt()));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        q.offer(new Pair(1, 0));

        long dist [] = new long [n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist [1] = 0;

        boolean visited [] = new boolean[n + 1];

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(visited[p.v]){
                continue;
            }

            visited[p.v] = true;

            for(Pair node : graph[p.v]){
                if(dist [node.v] > p.w + node.w){
                   dist [node.v] = p.w + node.w;
                   q.offer(new Pair(node.v, dist [node.v]));
                }
            }
        }

        for(int i = 1; i <= n; i ++){
            out.print(dist[i]+" ");
        }
        out.flush();

    }
}