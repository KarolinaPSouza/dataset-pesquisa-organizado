import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_1780543 {

    static final long mod = (long) 1e9 + 7l;
    static ArrayList[] adj;
    static int parent[];
    static int path[];
    static int count;

    private static void solve(int t) {
        int v = fs.nextInt();
        int e = fs.nextInt();
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new ArrayList<Integer>();
        while (e-- > 0) {
            int i = fs.nextInt() - 1;
            int j = fs.nextInt() - 1;
            adj[i].add( j );
            adj[j].add( i );
        }

        parent = new int[v];
        Arrays.fill( parent, -1 );
        path = new int[v + 1];
        for (int i = 0; i < v; i++)
            if (parent[i] == -1) {
                parent[i] = i;
                if (dfs( i ))
                    break;
            }
        if (count == 0) {
            pn( "IMPOSSIBLE" );
        } else {
            pn( count );
            while (count-- > 0)
                p( path[count] + 1 + " " );
        }
    }

    private static boolean dfs(int i) {
        ArrayList<Integer> ad = adj[i];
        for (Integer val : ad) {
            if (parent[val] == -1) {
                parent[val] = i;
                if (dfs( val )) return true;
            } else if (val != parent[i]) {
                path[count++] = val;
                while (i != val) {
                    path[count++] = i;
                    i = parent[i];
                }
                path[count++] = val;
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        fs = new FastScanner();
        out = new PrintWriter( System.out );
        long s = System.currentTimeMillis();
        int t = 1;//fs.nextInt();
        for (int i = 1; i <= t; i++) solve( t );
        out.close();
        System.err.println( System.currentTimeMillis() - s + "ms" );
    }

    static boolean DEBUG = true;
    static PrintWriter out;
    static FastScanner fs;

    static void pn(Object o) {
        out.println( o );
    }

    static void p(Object o) {
        out.print( o );
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        StringTokenizer st = new StringTokenizer( "" );

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer( br.readLine() );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt( next() );
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong( next() );
        }
    }
}