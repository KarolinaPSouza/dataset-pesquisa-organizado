import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class entry_13009458 {

    private static class Pair{
        int first;
        long second;
        Pair(int first,long second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<List<Pair>>adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] curr = reader.readLine().split(" ");
            int a = Integer.parseInt(curr[0]);
            int b = Integer.parseInt(curr[1]);
            int wt = Integer.parseInt(curr[2]);
            adj.get(a-1).add(new Pair(b-1, wt));
        }
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        djikstra(adj,distance);
        for (int i = 0; i < distance.length; i++) {
            writer.write(distance[i]+" ");
        }
        writer.flush();
        writer.close();
    }

    public static void djikstra(List<List<Pair>>adj,long[]distance){
        distance[0] = 0;
        PriorityQueue<Pair>pq = new PriorityQueue<>(
            (a,b) ->{
                if(a.second != b.second) return Long.compare(a.second, b.second);
                else return a.first - b.first;
            }
        );
        boolean[] visited = new boolean[adj.size()];
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.first;
            long wt = curr.second;
            if(visited[node] || wt > distance[node]) continue;
            visited[node] = true;
            for(Pair neigh : adj.get(node)){
                int neighNode = neigh.first;
                long neighWt = neigh.second;
                if(wt + neighWt < distance[neighNode]){
                    distance[neighNode] = wt + neighWt;
                    pq.add(new Pair(neighNode, distance[neighNode]));
                }
            }
        }
    }
}