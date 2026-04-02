import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class entry_9404131 {

    static int V;
    static List<List<node>> l;
    static long[] d;

    public entry_9404131(int n) {
        V = n;
        l = new ArrayList<>();
        d = new long[V];
        Arrays.fill(d, Long.MAX_VALUE);
        for (int i = 0; i < V; i++) {
            l.add(new ArrayList<node>());
        }
    }

    static class node implements Comparable<node> {

        int id;
        long p;
        node(int id, long p) {
            this.id = id;
            this.p = p;
        }

        public int compareTo(node mm) {
            return Long.compare(this.p, mm.p);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter o = new PrintWriter(System.out);
        String[] st;

        st = x.readLine().trim().split(" ");
        int n = Integer.parseInt(st[0]);
        int v = Integer.parseInt(st[1]);

        new entry_9404131(n);

        for (int i = 0; i < v; i++) {
            st = x.readLine().trim().split(" ");
            int a = Integer.parseInt(st[0]) - 1;
            int b = Integer.parseInt(st[1]) - 1;
            long c = Long.parseLong(st[2]);
            l.get(a).add(new node(b, c));
        }

        dijkstra(0);

        for (int i = 0; i < n; i++) {
            o.print(d[i] + " ");
        }

        o.flush();
    }

    static void dijkstra(int a) {

        PriorityQueue<node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[V];
        d[0] = 0;
        pq.add(new node(a, 0));

        while (!pq.isEmpty()) {
            node p = pq.poll();
            if (v[p.id]) continue;
            v[p.id] = true;
            for (node i : l.get(p.id)) {
                long nd = d[p.id] + i.p;
                if (d[i.id] > nd) {
                    d[i.id] = nd;
                    pq.add(new node(i.id, nd));
                }
            }
        }
    }


}