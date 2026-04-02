import java.io.*;
import java.util.*;

public class entry_15679062 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static boolean dfs(int node, int par){
        visited[node] = true;
        parent[node] = par;

        for(int nxt : graph[node]){

            if(nxt == par) continue;

            if(visited[nxt]){
                // -------- cycle found ----------
                ArrayList<Integer> cycle = new ArrayList<>();

                int cur = node;
                cycle.add(cur);

                while(cur != nxt){
                    cur = parent[cur];
                    cycle.add(cur);
                }

                cycle.add(node); 

                out.println(cycle.size());
                for(int x : cycle) out.print(x + " ");
                out.println();
                out.flush();
                System.exit(0);
            }

            dfs(nxt, node);
        }

        return false;
    }

    public static void main(String[] args){
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i=1;i<=n;i++) graph[i] = new ArrayList<>();

        while(m-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(i, -1);
            }
        }

        out.println("IMPOSSIBLE");
        out.close();
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next(){
            while(st == null || !st.hasMoreElements()){
                try { st = new StringTokenizer(br.readLine()); }
                catch(Exception e){}
            }
            return st.nextToken();
        }
        int nextInt(){ return Integer.parseInt(next()); }
    }
}