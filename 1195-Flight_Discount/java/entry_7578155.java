import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_7578155 {
    private static class Pair{
        long first;
        int second;

        public Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Pair1{
        int first;
        int second;

        public Pair1(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Edge{
        int v;
        int u;
        int w;

        public Edge(int v, int u, int w) {
            this.v = v;
            this.u = u;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Edge> edges = new ArrayDeque<>();

            List<List<Pair1>> directions = new ArrayList<>();
            List<List<Pair1>> reverseDirections = new ArrayList<>();

            directions.add(null);
            reverseDirections.add(null);

            for(int i = 0; i < n; i++) {
                directions.add(new ArrayList<>());
                reverseDirections.add(new ArrayList<>());
            }

            long max = 1000000000000000000L;

            while (m-- > 0){
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                directions.get(v).add(new Pair1(u, w));
                reverseDirections.get(u).add(new Pair1(v, w));
                edges.add(new Edge(v, u, w));
            }

            br.close();

            long[] d1 = new long[n+1];
            long[] d2 = new long[n+1];

            for(int i = 2; i <= n; i++) {
                d1[i] = max;
                d2[i-1] = max;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.first));
            pq.add(new Pair(0L, 1));

            while (!pq.isEmpty()){
                int v = pq.peek().second;

                if(pq.poll().first > d1[v])
                    continue;

                for(Pair1 p : directions.get(v)){

                    if(d1[p.first] > d1[v] + p.second){
                        d1[p.first] = d1[v] + p.second;
                        pq.add(new Pair(d1[p.first], p.first));
                    }
                }
            }

            pq.add(new Pair(0, n));

            while (!pq.isEmpty()){
                int v = pq.peek().second;

                if(pq.poll().first > d2[v])
                    continue;

                for(Pair1 p : reverseDirections.get(v)){
                    if(d2[p.first] > d2[v] + p.second){
                        d2[p.first] = d2[v] + p.second;
                        pq.add(new Pair(d2[p.first], p.first));
                    }
                }
            }

            PrintWriter pw = new PrintWriter(System.out);

            long answer = max;

            while (!edges.isEmpty()){
                Edge e = edges.poll();

                long alternative = d1[e.v] + e.w / 2 + d2[e.u];

                if(answer > alternative)
                    answer = alternative;
            }

            pw.println(answer);
            pw.flush();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}