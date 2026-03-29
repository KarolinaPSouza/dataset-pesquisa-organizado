import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Edge{
    int from,to;
    long cost;
    Edge(){

    }
    Edge(int from, int to, long cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class entry_15335800 {
    final static long MAX_INF = (long)1e18;
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws IOException{
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Edge[] edges = new Edge[m];
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextInt();

            edges[i] = new Edge(a,b,c);
        }
        long[] dist = new long[n+1];
        Arrays.fill(dist, 0);
        int[] parent = new int[n+1];
        for(int i=1;i<n;i++){
            for(Edge edge :edges){
                if(dist[edge.to] > dist[edge.from] + edge.cost){
                    dist[edge.to] = Math.max(-MAX_INF, dist[edge.from] + edge.cost);
                    parent[edge.to] = edge.from;
                }
            }
        }
        boolean isCycle = false;
        int startNode = 0;
        for(Edge edge :edges){
                if(dist[edge.to] > dist[edge.from] + edge.cost){
                    isCycle = true;
                    dist[edge.to] = Math.max(-MAX_INF, dist[edge.from] + edge.cost);
                    parent[edge.to] = edge.from;
                    startNode = edge.to;
                    break;
            }
        }
        for(int i=1;i<=n;i++){
            startNode = parent[startNode];
        }
        if(!isCycle){
            System.out.println("NO");
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.insert(0, startNode + " ");
        int currNode = parent[startNode];
        while(currNode != startNode){
            sb.insert(0, currNode + " ");
            currNode = parent[currNode];
        }
        sb.insert(0,startNode + " ");
        // sb.reverse();
        sb.insert(0, "YES" + "\n");
        System.out.println(sb);

    }

}