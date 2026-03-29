import java.io.*;
import java.util.*;

public class entry_14608745 {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = readInt();
        int m = readInt();
        List<List<Pair>> adjList = new ArrayList<>();
        long[] dist = new long[n+1];
        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            parent[i] = -1;
            adjList.add(new ArrayList<>());
        }
        int[][] edges = new int[m][3];
        for(int i = 0; i < m; i++){
            int u = readInt();
            int v = readInt();
            int c = readInt();
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = c;
            adjList.get(u).add(new Pair(v,c));
        }


        //Run Bellman Algo
        //Relax Edges N-1 times then do N iteration if N iteration also cycle possible means cycle there
        for(int i = 0; i < n-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int c = edge[2];
                if(dist[u] + c <  dist[v]){
                    dist[v] = dist[u] + c;
                    parent[v] = u;
                }
            }
        }
        int cycleNode = -1;
        //N time relaxtion,if happenns cycle found
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];
            if(dist[u] + c <  dist[v]){
                dist[v] = dist[u] + c;
                parent[v] = u;
                cycleNode = v;
            }
        }
        if(cycleNode == -1) out.println("NO");
        else{
            //cycle found
            List<Integer> cycle = new ArrayList<>();
            out.println("YES");
            for(int i = 0; i < n; i++) cycleNode = parent[cycleNode];
            for(int curr = cycleNode;; curr = parent[curr]){
                cycle.add(curr);
                if(curr == cycleNode && cycle.size() > 1) break;
            }
            Collections.reverse(cycle);
            for(int path : cycle) out.print(path + " ");

        }
        out.flush();
    }
    static class Pair{
        int v;
        int c;
        public Pair(int v,int c){
            this.v = v;
            this.c = c;
        }
    }

}