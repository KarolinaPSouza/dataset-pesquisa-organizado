import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_8433122 {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int num_cities = in.nextInt();
        int num_flights = in.nextInt();
        List<City> graph = new ArrayList<>(num_cities + 1);
        for (int i = 0; i <= num_cities; i++) {
            graph.add(new City());
        }
        for (int i = 0; i < num_flights; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            long cost = in.nextLong();
            graph.get(start).neighbors.add(new Flight(end, cost));
        }
        dijkstra(graph, 1);
        for (int i = 1; i <= num_cities; i++) {
            out.print((graph.get(i).cost == Long.MAX_VALUE ? -1 : graph.get(i).cost) + " ");
        }
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class City {
        List<Flight> neighbors;
        long cost;

        public City() {
            this.neighbors = new ArrayList<>();
            this.cost = Long.MAX_VALUE;
        }
    }

    static class Flight {
        int dest;
        long flight_cost;

        public Flight(int dest, long flight_cost) {
            this.dest = dest;
            this.flight_cost = flight_cost;
        }
    }

    static void dijkstra(List<City> graph, int start) {
        PriorityQueue<Flight> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.flight_cost));
        graph.get(start).cost = 0;
        pq.add(new Flight(start, 0));
        while (!pq.isEmpty()) {
            Flight cur_Flight = pq.poll();
            int cur_dest = cur_Flight.dest;
            long cur_cost = cur_Flight.flight_cost;
            if (graph.get(cur_dest).cost < cur_cost) continue;
            for (Flight edge : graph.get(cur_dest).neighbors) {
                int flight_dest = edge.dest;
                long new_cost = cur_cost + edge.flight_cost;
                if (new_cost < graph.get(flight_dest).cost) {
                    graph.get(flight_dest).cost = new_cost;
                    pq.add(new Flight(flight_dest, new_cost));
                }
            }
        }
    }

}