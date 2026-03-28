import java.util.*;
import java.io.*;

class TDistance {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static String nextWord() throws IOException {
        st.nextToken();
        return st.sval;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        List<Integer>[] adj = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++){
            int u = nextInt(), v = nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] dist1 = new int[n  + 1];
        int[] dist2 = new int[n + 1];

        int u = bfs(1, adj, dist1);
        int v = bfs(u, adj, dist1);
        bfs(v, adj, dist2);

         StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(dist1[i], dist2[i])).append(" ");
        }
        System.out.println(sb);


    }

    public static int bfs(int start, List<Integer>[] adj, int[] dist){
        Arrays.fill(dist, -1);

        Deque<Integer> q = new ArrayDeque<>();
        int fartestNode = 1;
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int nbr : adj[curr]){
                if(dist[nbr] == -1){
                    dist[nbr] = dist[curr] + 1;
                    q.add(nbr);

                    if(dist[nbr] > dist[fartestNode]){
                        fartestNode = nbr;
                    }

                }
            }
        }
        return fartestNode;

    }
}