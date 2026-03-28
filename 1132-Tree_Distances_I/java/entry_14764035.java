import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;  

public class entry_14764035 {
    static List<List<Integer>> adj;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int[] dist = bfs(1);
        int A = farthestNodes(dist);

        int[] distA = bfs(A); // this stores distance of each node from endpoint A
        int B = farthestNodes(distA);

        int[] distB = bfs(B); // this stores distance of each node from endpoint B

        int[] res = new int[n+1];
        for(int i=1; i<=n; i++){
            res[i] = Math.max(distA[i], distB[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static int farthestNodes(int[] dist){
        int farthestNode = 1;
        for(int i=2; i<=n; i++){
            if(dist[i] > dist[farthestNode]){
                farthestNode = i;
            }
        }

        return farthestNode;
    }

    public static int[] bfs(int src){
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(Integer it : adj.get(node)){
                if(dist[it] == -1){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        return dist;
    }
}