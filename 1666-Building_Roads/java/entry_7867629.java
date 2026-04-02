import java.io.*;
import java.util.*;

public class entry_7867629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] roads;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = readInt(), b = readInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1);
        roads=new int[n+1];
        System.out.println(connectedComponents(n));
        for(int i=0; i<roads.length; i++){
            if(roads[i]!=0){
                System.out.println("1 "+roads[i]);
            }
        }
    }
    static int connectedComponents(int n) {
        int cnt = 0;
        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                roads[cnt++]=v;
                dfs(v);
            }
        }
        return cnt;
    }

    static void dfs(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int neighbor : adj[i]) {
            dfs(neighbor);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}