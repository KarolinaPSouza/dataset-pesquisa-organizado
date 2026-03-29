import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class entry_13059571 {

    private static class Edge{
        int u,v;
        long wt;
        Edge(int u, int v, long wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            String[] edgeCases = reader.readLine().split(" ");
            int u = Integer.parseInt(edgeCases[0]);
            int v = Integer.parseInt(edgeCases[1]);
            long wt = Long.parseLong(edgeCases[2]);
            edges[i] = new Edge(u, v, wt);
        }
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);
        long[] dist = new long[n+1];
        Arrays.fill(dist, 0);

        int lastUpdatedNode = -1;
        //bellman ford
        for (int i = 0; i < n-1; i++) {
            boolean updatedNode = false;
            for(Edge e : edges){
                int u = e.u;
                int v = e.v;
                long wt = e.wt;
                if(dist[u]+wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    parent[v] = u;
                    updatedNode = true;
                }
            }
            if(!updatedNode){
                break;
            }
        }

        // check for negative cycle
        for(Edge e : edges){
            int u = e.u;
            int v = e.v;
            long wt = e.wt;
            if(dist[u]+wt < dist[v]){
                dist[v] = dist[u] + wt;
                parent[v] = u;
                lastUpdatedNode = v;
            }
        }

        if (lastUpdatedNode == -1) {
            writer.write("NO\n");
            writer.flush();
            writer.close();
            return;
        }else{
            // first move to the node in cycle
            for (int i = 0; i < n; i++) {
                lastUpdatedNode = parent[lastUpdatedNode];
            }
            List<Integer>ans = new ArrayList<>();
            int currentNode = lastUpdatedNode;
            do{
                ans.add(currentNode);
                currentNode = parent[currentNode];
            }while(currentNode != lastUpdatedNode);
            ans.add(currentNode);
            Collections.reverse(ans);
            writer.write("YES\n");
            for(int node : ans){
                writer.write(node + " ");
            }
            writer.flush();
            writer.close();
        }
    }
}