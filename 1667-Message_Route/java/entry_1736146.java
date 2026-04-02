import java.io.*;
import java.util.*;

public class entry_1736146 {//unweighted graph

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        FastScanner fs = new FastScanner( inputStream );
        int vertex = fs.nextInt();
        int edges = fs.nextInt();

        List<Integer>[] adj = new ArrayList[100005];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            int src = fs.nextInt(), dest = fs.nextInt();
            --src;
            --dest;
            adj[src].add( dest );
            adj[dest].add( src );
        }
        int src = 0;
        int dest = vertex - 1;

        printShortestDistance( adj, src, dest, vertex );

    }

    private static void printShortestDistance(List<Integer>[] adj, int src, int dest, int vertex) {
        int pred[] = new int[vertex];
        int dist[] = new int[vertex];
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter( outputStream );
        if (bfs( adj, src, dest, dist, pred, vertex )) {
            List<Integer> path = new ArrayList<>();
            while (dest != src) {
                path.add( dest );
                dest = pred[dest];
            }
            path.add( src );
            out.println( path.size() );
            for (int i = path.size() - 1; i >= 0; i--) {
                out.print( (path.get( i ) + 1) + " " );
            }
            out.close();
            return;
        }
        out.println( "IMPOSSIBLE" );
        out.close();
        return;

    }

    private static boolean bfs(List<Integer>[] adj, int src, int dest, int[] dist, int[] pred, int vertex) {
        boolean visited[] = new boolean[vertex];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < vertex; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[src] = true;
        q.add( src );
        dist[src] = 0;

        while (!q.isEmpty()) {
            Integer currVertex = q.poll();
            for (Integer val : adj[currVertex]) {
                if (!visited[val]) {
                    visited[val] = true;
                    pred[val] = currVertex;
                    dist[val] = dist[currVertex] + 1;
                    q.add( val );
                    if (val.equals( dest )) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static class FastScanner {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader( new InputStreamReader( stream ), 32768 );
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer( reader.readLine() );
                } catch (IOException e) {
                    throw new RuntimeException( e );
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt( next() );
        }

        public long nextLong() {
            return Long.parseLong( next() );
        }

    }
}