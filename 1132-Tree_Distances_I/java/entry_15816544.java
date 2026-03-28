import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int val;
    int[] dist;
    Pair(int val, int[] dist) {
        this.val = val;
        this.dist = dist;
    }
}       

public class entry_15816544 {

    static List<List<Integer>> adj;

    static Pair bfsFarthest(int node, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int farthestNode = node;
        int maxDist = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        dist[node] = 0;
        while(!q.isEmpty()) {
            int it = q.poll();
            for(int adjNode : adj.get(it)) {
                if(dist[adjNode] == -1) {
                    dist[adjNode] = 1 + dist[it];
                    q.add(adjNode);
                    if(maxDist < dist[adjNode]) {
                        maxDist = dist[adjNode];
                        farthestNode = adjNode;
                    }
                }
            }
        }
        return new Pair(farthestNode, dist);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        Pair one = bfsFarthest(0, n);

        Pair second = bfsFarthest(one.val, n);
        int[] distU = second.dist;
        int[] distV = bfsFarthest(second.val, n).dist;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Math.max(distU[i], distV[i])).append(' ');
        }
        System.out.print(sb.toString());


    }
}