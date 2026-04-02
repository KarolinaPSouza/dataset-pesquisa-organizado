//package graph.shortestpath;

import java.io.*;
import java.util.*;

public class entry_8028263 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String s = input.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] adj = new ArrayList[V];
//        for (int i = 0; i < V; i++)
//        {
//            adj[i] = new ArrayList<>();
//        }
        for (int i = 0; i < E; i++)
        {
            s = input.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (adj[a] == null)
            {
                adj[a] = new ArrayList<>();
            }
            adj[a].add(new Edge(b, c));
        }

        // Initially set all distances to infinity
        long[] distTo = new long[V];
        Edge[] edgeTo = new Edge[V];
        shortestPath(0, adj, distTo, edgeTo);

        for (int i = 0; i < V - 1; i++)
        {
            out.print(distTo[i] + " ");
        }
        out.println(distTo[V - 1]);
        input.close();
        out.close();
    }

    public static class Vertex
    {
        int v;           // vertex id
        long distToV;    // distance from source s to v

        public Vertex(int v, long distToV)
        {
            this.v = v;
            this.distToV = distToV;
        }
    }

    public static class Edge
    {
        int to;
        long weight;

        public Edge(int to, long weight)
        {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void shortestPath(int source, ArrayList<Edge>[] adj, long[] distTo, Edge[] edgeTo)
    {
        // Dijkstra's algorithm
//        PriorityQueue<Vertex> pq =
//                new PriorityQueue<>(new Comparator<Vertex>()
//                {
//                    @Override
//                    public int compare(Vertex o1, Vertex o2)
//                    {
//                        return Long.compare(o1.distToV, o2.distToV);
//                    }
//                });
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingLong(v -> v.distToV));

        Arrays.fill(distTo, Long.MAX_VALUE);
        distTo[source] = 0;  // The shortest path from a node to itself is 0
        pq.add(new Vertex(source, 0L));
        while (!pq.isEmpty())
        {
            Vertex curr = pq.poll();    // Get the min dist from s to vertex in pq.
            long distToV = curr.distToV;
            int v = curr.v;

            if (distToV != distTo[v])
            {
                // This means this v was initially added to pq with distToV,
                // but later on there is a shorter distTo[v] found via edge relaxation and added to pq (duplicate v),
                // so this distToV is old and this v should be ignored.
                // This way, we don't need to remove the old v in pq first (O(n)).
                continue;
            }
            if (adj[v] == null)
            {
                continue;
            }
            for (Edge e : adj[v])
            {
                // Relax the edge
                // If we can reach a neighbouring node w faster via v,
                // we update w's minimum distance
                int w = e.to;
                if (distTo[w] > distTo[v] + e.weight)
                {
                    distTo[w] = distTo[v] + e.weight;
                    edgeTo[w] = e;

                    // Don't check if pq.contains(w) and remove if so, since it will take O(n),
                    // just add w with the shorter distTo[w] even if pq already contains w with a longer dist
                    pq.add(new Vertex(w, distTo[w]));
                }
            }
        }
    }
}