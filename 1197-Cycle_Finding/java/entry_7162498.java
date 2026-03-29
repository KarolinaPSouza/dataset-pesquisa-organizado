import java.io.*;
import java.util.*;

class Edge {
    int a, b, c;
    Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}


public class entry_7162498 {
    static int n, m;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer s = new StringTokenizer(r.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());
        List<Edge> edges = new ArrayList<Edge>();
        List<Integer>[] adj = new ArrayList[n+1];
        Arrays.setAll(adj, element->new ArrayList<>());
        for (int i = 1; i <= m; i++) {
            s = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());
            edges.add(new Edge(a, b, c));
            adj[a].add(b);
        }


        long[] d = new long[n+1];
        int[] pred = new int[n+1];
        int x= -1;

        visited = new boolean[n+1];
        Arrays.fill(d, 0);
        Arrays.fill(pred, -1);
        for (int i = 0; i < n; i++) {
            x = -1;
            for (Edge e : edges) {
                if (d[e.a] < Long.MAX_VALUE) {
                    if (d[e.a] + e.c < d[e.b]) {
                        d[e.b] = Math.max(-Long.MAX_VALUE, e.c + d[e.a]);
                        pred[e.b] = e.a;
                        x = e.b;
                    }
                }

            }
        }


        if (x == -1) pw.println("NO");
        else {
            for (int i = 0; i < n; i++) x = pred[x];
            List<Integer> cyc = new ArrayList<>();
            for (int i = x;;i = pred[i]) {
                cyc.add(i);
                if (i == x && cyc.size() > 1) break;
            }
            pw.println("YES");
            for (int i = cyc.size()-1; i >= 0; i--) pw.print(cyc.get(i) + " ");
            pw.println();
        }
        pw.close();
    }
}