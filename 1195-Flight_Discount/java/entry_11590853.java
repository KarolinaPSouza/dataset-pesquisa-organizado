import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.*;

public class entry_11590853 {

    static class FastScanner {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while(!st.hasMoreTokens()) {
                try {     
                    st = new StringTokenizer(bf.readLine());
                } catch(IOException e) { }
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

        char nextChar() {
            return next().charAt(0);
        }

        String nextLine() throws IOException{
            return bf.readLine().trim();
        }

    }
    private static void dijikstra(int source, List<List<int[]>> graph, long[] distance) {

        Arrays.fill(distance, Long.MAX_VALUE);
        Queue<long[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] < b[0]) return -1;
            else return 1;
        });

        distance[source] = 0L;
        pq.add(new long[]{0L, source});

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();

            int vertex = (int) curr[1];
            long distV = curr[0];

            if(distance[vertex] != distV) continue;

            for(int[] adj : graph.get(vertex)) {
                long distAdj = adj[1];
                int adjacent = adj[0];

                if(distance[adjacent] > distV + distAdj) {
                    distance[adjacent] = distV + distAdj;
                    pq.add(new long[]{distance[adjacent], adjacent});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        // int t = sc.nextInt();
        int t = 1;
        while(t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();

            List<List<int[]>> graph = IntStream.range(0,n+1)
                .mapToObj(i -> new ArrayList<int[]>())
                .collect(Collectors.toList());

            List<List<int[]>> invertedGraph = IntStream.range(0,n+1)
                .mapToObj(i -> new ArrayList<int[]>())
                .collect(Collectors.toList());

            List<int[]> edges = new ArrayList<int[]>();

            for(int i=0;i<m;i++) {
                int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

                graph.get(a).add(new int[]{b,c});
                invertedGraph.get(b).add(new int[]{a,c});

                edges.add(new int[]{a,b,c});
            }


            long[] a = new long[n+1];
            long[] b = new long[n+1];

            dijikstra(1, graph, a);
            dijikstra(n, invertedGraph, b);

            long minDistance = Long.MAX_VALUE;
            for(int[] edge : edges) {
                int v1 = edge[0], v2 = edge[1];
                long weight = edge[2]/2;

                if(a[v1] < Long.MAX_VALUE && b[v2] < Long.MAX_VALUE) {
                    minDistance = Math.min(minDistance, weight + a[v1] + b[v2]);
                }
            }

            out.println(minDistance);

        }

        out.close();
    }

}