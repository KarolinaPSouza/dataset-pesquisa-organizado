import java.io.*;
import java.util.*;

public class entry_4757179 {

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        StringBuilder output = new StringBuilder();

        int n = s.nextInt();
        int m = s.nextInt();

        Node[] graph = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            graph[s.nextInt()].addEdge(s.nextInt(), s.nextInt());
        }

        // dijkstra
        long[] dist = new long[n+1];
        for (int i = 0; i <= n; i++) dist[i] = Long.MAX_VALUE;
        boolean[] seen = new boolean[n+1];
        dist[1] = 0L;
        PriorityQueue<QueueItem> q = new PriorityQueue<>();
        q.add(new QueueItem(0, 1));
        while (!q.isEmpty()) {
            int cur = q.poll().ind;
            if (seen[cur]) continue;
            seen[cur] = true;
            for (int[] neighbour : graph[cur].neighbours) {
                int nInd = neighbour[0];
                int w = neighbour[1];

                if (dist[cur] + w < dist[nInd]) {
                    dist[nInd] = dist[cur] + w;
                    q.add(new QueueItem(dist[nInd], nInd));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            output.append(dist[i]).append(" ");
        }
        System.out.println(output);



    }

    static class QueueItem implements Comparable<QueueItem>{
        long weight;
        int ind;
        public QueueItem(long weight, int ind) {
            this.weight = weight;
            this.ind = ind;
        }


        // unintuitve compareTo to ensure queue is correct
        public int compareTo(QueueItem other) {
            return other.weight > this.weight ? -1 : 1;
        }
    }

    static class Node {
        int ind;
        List<int[]> neighbours;

        public Node(int ind) {
            this.ind = ind;
            this.neighbours = new ArrayList<>();
        }

        public void addEdge(int dest, int weight) {
            this.neighbours.add(new int[]{dest, weight});
        }
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        public Reader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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

        // next int, skippt zeilen wenn nötig
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int log2(long i) {
        int res = -1;
        while (i > 0) {
            i = i / 2;
            res++;
        }
        return res;
    }

}