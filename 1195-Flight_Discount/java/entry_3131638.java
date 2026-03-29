import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import java.util.*;
import java.io.*;

public class entry_3131638 {
    static int n, m;
    static int[] arr;
    static char[] s;
    static List<edge>[] adj;
    static List<edge>[] rev_adj;
    static int[][] edges;
    public static void main(String[] args) throws IOException
    {
        f = new Flash();
        out = new PrintWriter(System.out);

        int T = 1; //ni();
        for(int tc = 1; tc <= T; tc++){
         n = ni(); m = ni(); 
         adj = new ArrayList[n];
         for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
         rev_adj = new ArrayList[n];
         for(int i = 0; i < n; i++) rev_adj[i] = new ArrayList<>();
         edges = new int[m][];
         for(int i = 0; i < m; i++) {
          int u = ni()-1, v = ni()-1, c = ni();
          adj[u].add(new edge(v, c));

          rev_adj[v].add(new edge (u, c));

          edges[i] = new int[] {u, v, c};
         }

         sop(fn());
        }

        out.flush(); out.close();
    }

    static long fn()
    {
        long[] dist1 = dijkstras(0, adj);
        long[] dist2 = dijkstras(n-1, rev_adj);
        long ans = inf;
        for(int[] e : edges) {
         ans = min(ans, dist1[e[0]] + e[2]/2 + dist2[e[1]]);
        }

        return ans;
    }

    static long[] dijkstras(int src, List<edge>[] g) {
     long[] dist = new long[n];
     Arrays.fill(dist, inf);
     dist[src] = 0l;
     PriorityQueue<long[]> q = new PriorityQueue<>(new cpr());
     boolean[] vis = new boolean[n];
     q.add(new long[] {src, 0l});
     while(!q.isEmpty()) {
      long[] cur = q.poll();
      int u = (int)cur[0];
      long cost = cur[1];

      if(vis[u]) continue;
      vis[u] = true;
      dist[u] = cost;
      for(edge e : g[u]) {
       q.add(new long[] {e.v, cost + e.cost});
      }
     }

     return dist;
    }

    static class edge {
     int v, cost;
     edge(int v, int cost) {
      this.v = v;
      this.cost = cost;
     }
    }

    static Flash f;
    static PrintWriter out;
    static final long mod = (long)1e9+7;
    static final long inf = (long)1e18;
    static final int _inf = (int)1e9;
    static final int maxN = (int)1e6;
    static long[] fact, inv;

    static class cpr implements Comparator<long[]>{
     public int compare(long[] a, long[] b) {
      return Long.compare(a[1], b[1]);
     }
    }

    static void sort(int[] a){
        List<Integer> entry_3131638 = new ArrayList<>();
        for(int i : a) entry_3131638.add(i);
        Collections.sort(entry_3131638);
        for(int i = 0; i < entry_3131638.size(); i++) a[i] = entry_3131638.get(i);
    }

    static void sort(long[] a){
        List<Long> entry_3131638 = new ArrayList<>();
        for(long i : a) entry_3131638.add(i);
        Collections.sort(entry_3131638);
        for(int i = 0; i < entry_3131638.size(); i++) a[i] = entry_3131638.get(i);
    }

    static void print(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int v : a) sb.append(v + " ");
        out.println(sb);
    }

    static void print(long[] a){
        StringBuilder sb = new StringBuilder();
        for(long v : a) sb.append(v + " ");
        out.println(sb);
    }

    static void print(List<Integer> entry_3131638){
        StringBuilder sb = new StringBuilder();
        for(int v : entry_3131638) sb.append(v + " ");
        out.println(sb);
    }

    static int swap(int itself, int dummy){return itself;}
    static long swap(long itself, long dummy){return itself;}
    static char swap(char itself, char dummy){return itself;}
    static void sop(Object o){out.println(o);}
    static int ni(){return f.ni();}
    static long nl(){return f.nl();}
    static double nd(){return f.nd();}
    static String next(){return f.next();}
    static String ns(){return f.ns();}
    static String yes = "YES", no = "NO";
    static char[] nc(){return f.nc();}
    static int[] arr(int len){return f.arr(len);}
    static int gcd(int a, int b){if(b == 0) return a; return gcd(b, a%b);}
    static long gcd(long a, long b){if(b == 0) return a; return gcd(b, a%b);}
    static int fcm(int a, int b){return (a*b)/gcd(a, b);}
    static long fcm(long a, long b){return (a*b)/gcd(a, b);}
    static double log2(long N) {return Math.log(N) / Math.log(2);}
    static void debug(int[] a) {sop(Arrays.toString(a));}
    static void debug(long[] a) {sop(Arrays.toString(a));}

    static class Flash
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next(){
            while(!st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        String ns(){
            String s = new String();
            try{
                s = br.readLine().trim();
            }catch(IOException e){
                e.printStackTrace();
            }

            return s;
        }

        int[] arr(int n){
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

        char[] nc(){return ns().toCharArray();}
        int ni(){return Integer.parseInt(next());}
        long nl(){return Long.parseLong(next());}
        double nd(){return Double.parseDouble(next());}
    }
}