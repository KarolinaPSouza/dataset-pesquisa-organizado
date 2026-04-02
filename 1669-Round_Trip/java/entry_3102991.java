import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import java.util.*;
import java.io.*;

public class entry_3102991 {
    static int n, m;
    static int[] arr;
    static char[] s;
    static List<Integer>[] adj;
    static boolean done = false;
    static List<Integer> ans;
    public static void main(String[] args) throws IOException
    {
        f = new Flash();
        out = new PrintWriter(System.out);

        int T = 1; //ni();
        for(int tc = 1; tc <= T; tc++){
         n = ni(); m = ni(); adj = new ArrayList[n];
         for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
         for(int i = 0; i < m; i++) {
          int u = ni()-1, v = ni()-1;
          adj[u].add(v);
          adj[v].add(u);
         }

         fn();
        }

        out.flush(); out.close();
    }

    static void fn()
    {
        int[] color = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
         if(color[i] == 0) dfs(i, -1, color, parent);
        }

        if(ans.size() == 0) {
         sop("IMPOSSIBLE");
         return;
        }

        sop(ans.size());
        print(ans);
    }

    static void dfs(int u, int p, int[] color, int[] parent) {
     if(done) return;
     if(color[u] == 2) return;
     if(color[u] == 1) {
      done = true;
      ans.add(u+1);
      int node = p;
      while(node != -1 && node != u) {
       ans.add(node+1);
       node = parent[node];
      }

      ans.add(u+1);
      return;
     }

     color[u] = 1;
     parent[u] = p;

     for(int v : adj[u]) {
      if(v == p) continue;
      dfs(v, u, color, parent);
     }

     color[u] = 2;
    }

    static Flash f;
    static PrintWriter out;
    static final long mod = (long)1e9+7;
    static final long inf = (long)1e18;
    static final int _inf = (int)1e9;
    static final int maxN = (int)1e6;
    static long[] fact, inv;

    static class cpr implements Comparator<int[]>{
     public int compare(int[] a, int[] b) {
      return Integer.compare(a[0], b[0]);
     }
    }

    static void sort(int[] a){
        List<Integer> entry_3102991 = new ArrayList<>();
        for(int i : a) entry_3102991.add(i);
        Collections.sort(entry_3102991);
        for(int i = 0; i < entry_3102991.size(); i++) a[i] = entry_3102991.get(i);
    }

    static void sort(long[] a){
        List<Long> entry_3102991 = new ArrayList<>();
        for(long i : a) entry_3102991.add(i);
        Collections.sort(entry_3102991);
        for(int i = 0; i < entry_3102991.size(); i++) a[i] = entry_3102991.get(i);
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

    static void print(List<Integer> entry_3102991){
        StringBuilder sb = new StringBuilder();
        for(int v : entry_3102991) sb.append(v + " ");
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