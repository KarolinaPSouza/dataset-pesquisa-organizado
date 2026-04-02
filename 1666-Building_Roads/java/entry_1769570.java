import java.io.*;
import java.util.*;

public class entry_1769570 {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
            }
        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }
        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }
    }
    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static ArrayList<Integer> adj[];
    public static ArrayList<Integer> rep = new ArrayList<Integer>();
    public static boolean visited[];
    public static void main(String[] args) {
        int n = r.nextInt();
        int m = r.nextInt();
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i<=n; i++) adj[i] = new ArrayList<Integer>();
        for(int i = 0 ; i<m; i++){
            int u = r.nextInt();
            int v=  r.nextInt();
            adj[u].add(v); adj[v].add(u);
        }
        int ans = count_components();
        pw.println(ans-1);
        for(int i = 1; i<ans; i++){
            pw.println(rep.get(i-1) + " " + rep.get(i));
        }

        pw.close(); // flushes the output once printing is done
    }
    public static void dfs(int node){
        visited[node] = true;
        for(int u: adj[node]){
            if(!visited[u]) dfs(u);
        }
    }
    public static int count_components(){
        int count = 0;
        for(int i = 1; i<= adj.length-1; i++){
            if(!visited[i]){
                count++;
                rep.add(i);
                dfs(i);
            }
        }
        return count;
    }
}