import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_15983192 {
    private static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        int[] dist = new int[n+1];
        bfs(1, dist);
        int node1 = 1;
        for(int i=1;i<=n;i++){
            if(dist[i] > dist[node1]){
                node1 = i;
            }
        }
        //System.out.printf("node1: %d, dist: %s\n", node1, Arrays.toString(dist));
        bfs(node1, dist);
        int node2 = node1;
        for(int i=1;i<=n;i++){
            if(dist[i] > dist[node2]){
                node2 = i;
            }
        }
        //System.out.printf("node2: %d, dist: %s\n", node2, Arrays.toString(dist));
        System.out.println(dist[node2]);
    }

    private static void bfs(int root, int[] dist){
        Arrays.fill(dist, -1);
        dist[root] = 0;
        Queue<Integer> q = new LinkedList<>(Collections.singleton(root));
        while (!q.isEmpty()){
            int u = q.poll();
            for(Integer v : tree[u]){
                if(dist[v] < 0){
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }
}