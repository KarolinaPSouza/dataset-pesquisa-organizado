import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_12786812 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static final int maxN = 100001;
    static int n;
    static int[] d = new int[maxN];
    static int[] par = new int[maxN];
    static boolean[] visited = new boolean[maxN];
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();

    public static void bfs(int s){
        Arrays.fill(d, 1, n+1, 0);
        Arrays.fill(par, 1, n+1, -1);
        Arrays.fill(visited, 1, n+1, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()){
            int u = q.poll();
            for (int v : g.get(u)){
                if (!visited[v]){
                    d[v] = d[u] + 1;
                    par[v] = u;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void printPath(int u){
        if (!visited[u]){
            System.out.println("IMPOSSIBLE");
        }
        else {
            List<Integer> path = new ArrayList<>();
            for (int v = u; v != -1; v = par[v]){
                path.add(v);
            }
            Collections.reverse(path);
            System.out.println(path.size());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i)).append(" ");
            }
            System.out.println(sb);
        }
    }
    public static void main(String[] args){
        FastReader inp = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        n = inp.nextInt();
        int m = inp.nextInt();
        for (int i = 0; i <= n; i++){
            g.add(new ArrayList<>());
        }
        while (m-- > 0){
            int a = inp.nextInt();
            int b = inp.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }
        bfs(1);
        printPath(n);
        pw.close();
    }
}