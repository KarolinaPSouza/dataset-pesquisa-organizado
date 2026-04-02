import java.io.*;
import java.util.*;

public class entry_15271046 {
    public static void main(String[] args) throws IOException{
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(io.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        ArrayList<Edge>[] adj = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) adj[i] = new ArrayList<Edge>(); //make them not null

        for(int i = 0; i < m; i++) {
            token = new StringTokenizer(io.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            Edge temporary = new Edge(b, c);
            adj[a].add(temporary);
        }
        //----------------------------
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;
        pq.add(new Edge(1, 0));
        boolean[] visited = new boolean[n+1];
        while (pq.size()>0){
            Edge current = pq.poll();
            int node = current.node;
            if (visited[node]){
                continue;
            }
            visited[node] = true;

            for (Edge e : adj[node]) {
                int next = e.node;
                long newDist = current.distance + e.distance;
                if (newDist < distance[next]) {
                    distance[next] = newDist;
                    pq.add(new Edge(next, newDist));
                }
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        for (int i=1; i<distance.length; i++){
            if (i==distance.length-1){
                out.print(distance[i]);
                break;
            }
            out.print(distance[i] + " ");
        }
        out.flush();
    }

    static class Edge implements Comparable<Edge>{
        int node;
        long distance;

        Edge(int node, long distance){
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge other){
            return Long.compare(this.distance, other.distance);
        }
    }
}