import java.io.*;
import java.util.*;
public class entry_7185125 {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer l1 = new StringTokenizer(scan.readLine());

        int num = Integer.parseInt(l1.nextToken()); int m = Integer.parseInt(l1.nextToken());
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0;i<num;i++)
            adj.add(new ArrayList<>());

        for (int i = 0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(scan.readLine());
            int a = Integer.parseInt(st.nextToken())-1; int b = Integer.parseInt(st.nextToken())-1; int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Pair(b,c));
        }

        long[] ans = dijkstra(adj,0);

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0;i<num;i++) {
            out.print(ans[i]+" ");
        }
        out.close();
    }

    public static long[] dijkstra (ArrayList<ArrayList<Pair>> adj, int start) {
        int num = adj.size();
        long[] dis = new long[num]; Arrays.fill(dis, Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (int) ((a.val-b.val)%1000000));
        pq.add(new Pair(start,0)); dis[start] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll(); int node = curr.n; long d = curr.val;
            if (dis[node]!=d) continue;

            for (Pair v : adj.get(node)) {
                int n = v.n; long w = v.val;

                if (d+w<dis[n]) {
                    dis[n] = d+w;
                    pq.add(new Pair(n,dis[n]));
                }
            }
        }

        return dis;
    }

    public static class Pair {
        int n; long val; //node to and value (weight or curr dis)

        Pair (int n, long val) {
            this.n = n; this.val = val;
        }
    }
}