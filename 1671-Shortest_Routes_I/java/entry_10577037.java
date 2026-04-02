import java.io.*;
import java.util.*;

public class entry_10577037 {

    // Custom class to store city and distance (used in priority queue)
    static class Pair implements Comparable<Pair> {
        int city;
        long distance;

        Pair(int city, long distance) {
            this.city = city;
            this.distance = distance;
        }

        // For priority queue, we need to compare based on the distance
        public int compareTo(Pair other) {
            return Long.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(int n, List<List<Pair>> adjList, long[] dist) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start from city 1 (Syrjälä), distance is 0
        dist[1] = 0;
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int city = current.city;
            long distance = current.distance;

            // If the current distance is larger than the best-known distance, skip it
            if (distance > dist[city]) {
                continue;
            }

            // Explore all neighbors of the current city
            for (Pair neighbor : adjList.get(city)) {
                int nextCity = neighbor.city;
                long edgeWeight = neighbor.distance;
                long newDist = dist[city] + edgeWeight;

                // Relaxation step: update distance if a shorter path is found
                if (newDist < dist[nextCity]) {
                    dist[nextCity] = newDist;
                    pq.add(new Pair(nextCity, newDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Reading input: number of cities (n) and number of flights (m)
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // Adjacency list representation of the graph
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Reading the flight connections
        for (int i = 0; i < m; i++) {
            String[] flightInfo = br.readLine().split(" ");
            int a = Integer.parseInt(flightInfo[0]); // start city
            int b = Integer.parseInt(flightInfo[1]); // end city
            int c = Integer.parseInt(flightInfo[2]); // length of the flight
            adjList.get(a).add(new Pair(b, c)); // add edge from city a to b with weight c
        }

        // Initialize distances to "infinity" (here, Long.MAX_VALUE)
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        // Call Dijkstra's algorithm to find shortest paths from city 1 (Syrjälä)
        dijkstra(n, adjList, dist);

        // Print the distances from city 1 to all cities
        for (int i = 1; i <= n; i++) {
            out.print(dist[i] + " ");
        }
        out.flush();
    }
}