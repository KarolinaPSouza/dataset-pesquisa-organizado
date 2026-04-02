/*
 * Raja Ramchandra ki Jai
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * Authored by Yash (@yashvardhan3)
 */
public class entry_14570332 {


    public static void main(String[] args) {
        InputStream inputStrm = System.in;
        OutputStream outputStrm = System.out;
        InputReader in = new InputReader(inputStrm);
        PrintWriter out = new PrintWriter(outputStrm);
        TaskY solverY = new TaskY();
        solverY.solveY(1, in, out);
        out.close();
    }

    static class TaskY {
        public void solveY(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();

            List<List<Edge>> adj = new ArrayList<>();
for (int i = 0; i <= n; i++) { // From 0 to n to handle 1-based indexing
    adj.add(new ArrayList<>());
}
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b  = in.nextInt();
                long c = in.nextLong();
                    adj.get(a).add(new Edge(b, c));
            }

            long[] dis = new long[n+1];

            Arrays.fill(dis, Long.MAX_VALUE);
            dis[1] =0;

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            pq.add(new Pair(1, 0));

            while (!pq.isEmpty()) {
                Pair curr = pq.poll();

                int u = curr.node;
                long d = curr.distance;

                if (d>dis[u]) {
                    continue;
                }

                for (Edge edge : adj.get(u)) {
                    int v= edge.to;
                    long weight = edge.weight;

                    if (dis[u]+weight<dis[v]) {
                        dis[v] = dis[u]+weight;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }

            for (int i = 1; i <=n; i++) {
                out.print(dis[i]+" ");
            }
            out.println();
            // Write code here


            // ends here
        }



    }

    static class Edge{
        int to ;
        long weight;

        Edge(int to, long weight){
            this.to = to;
            this.weight = weight;
        }
    }

    // Make the Pair class implement Comparable
static class Pair implements Comparable<Pair> {
    int node;
    long distance;

    public Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }

    // Override the compareTo method to define the sorting order
    @Override
    public int compareTo(Pair other) {
        return Long.compare(this.distance, other.distance);
    }
}
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
          }

    }
}