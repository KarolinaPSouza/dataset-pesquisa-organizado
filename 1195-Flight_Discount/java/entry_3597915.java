import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class entry_3597915 {
    static class FastScanner {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st=new StringTokenizer("");
  String next() {
   while (!st.hasMoreTokens())
    try {
                                        st=new StringTokenizer(br.readLine());
                                } catch (IOException e) {}
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }
  long nextLong() {
   return Long.parseLong(next());
  }
 }

    static class pair implements Comparable<pair> {
        int f;
            long s;
        pair(int a, long b) {
            f = a;
            s = b;
        }

        public int compareTo(pair o) {
            if (s < o.s)  return -1;
            else if (s == o.s) return 0;
            return 1;
        }

        public String toString() {
            return "{f=" + f + ", s=" + s + "}";
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int test = 1;
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<pair>> adj = new ArrayList<>();
            List<List<pair>> adj_ = new ArrayList<>();
            IntStream.range(0,n).forEach(x -> adj.add(new ArrayList<>()));
            IntStream.range(0,n).forEach(x -> adj_.add(new ArrayList<>()));
            for (int i=1; i<=m; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                long w = sc.nextLong();

                adj.get(u).add(new pair(v, w));
                adj_.get(v).add(new pair(u, w));

            }
            long[] d1 = get(adj, 0);
            long[] d2 = get(adj_, n-1);
            //out.println("dist => " + d1[n-1]);
            long ans = d1[n-1];
            for (int i=0; i<n; i++) {
                //out.printf((d1[i]+d2[i]) + " ");
                for (pair p: adj.get(i)) {
                    int to = p.f;
                    long w = p.s;
                    ans = Math.min(ans, d1[i] + w/2 + d2[to]);
                }
            }
            //out.println();
            out.println(ans);
            out.close();
        }
    }

    static long[] get(List<List<pair>> adj, int src) {
        long[] d = new long[adj.size()];
        Arrays.fill(d, 1L << 55);
        PriorityQueue<pair> q = new PriorityQueue<>();
        q.add(new pair(src, 0));
        boolean vis[] = new boolean[d.length];
        d[src] = 0;
        while (q.size() > 0) {
            pair p = q.poll();
            int cur = p.f;
            long cost = p.s;
            if (vis[cur]) continue;
            vis[cur] = true;
            for (pair pp: adj.get(cur)) {
                int to = pp.f;
                long w = pp.s;
                long nd = cost + w;
                if (nd < d[to]) {
                    d[to] = nd;
                    q.offer(new pair(to, nd));
                }
            }
        }
        return d;
    }

    static boolean dfs(List<List<pair>> adj, int src, Set<Integer> cycle, boolean[] vis) {
        if (cycle.contains(src)) return true;
        vis[src] = true;
        for (pair p : adj.get(src)) {
            if (!vis[p.f]) {
                if (dfs(adj, p.f, cycle, vis)) return true;
            }
        }
        return false;
    }
}