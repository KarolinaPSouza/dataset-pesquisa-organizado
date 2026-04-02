import java.io.*;
import java.util.*;

public class entry_13510308 {
    static int n,m;
    static int[] color ;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        F f = new F();
        n = f.ni();
        m = f.ni();
        color = new int[n+1];
        visited = new boolean[n+1];
        graph = new List[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int u = f.ni();
            int v = f.ni();
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean flag = true;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                color[i] = 1;
                if(!bfs(i)){
                    flag = false;
                    break;
                }

            }
        }
        if(!flag){
            System.out.println("IMPOSSIBLE");
        }else{
            for(int i=1;i<=n;i++){
                System.out.print(color[i]+" ");
            }
        }
    }

    static boolean bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    color[v] =(color[u]==1)?2:1;
                    q.add(v);
                }else if(color[v]==color[u]){
                    return false;
                }
            }
        }
        return true;
    }

    static class F {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String n() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String l = br.readLine();
                if (l == null) return null;
                st = new StringTokenizer(l);
            }
            return st.nextToken();
        }

        int ni() throws IOException {
            return Integer.parseInt(n());
        }

        long nl() throws IOException {
            return Long.parseLong(n());
        }

        String sl() throws IOException {
            return br.readLine();
        }
    }
}