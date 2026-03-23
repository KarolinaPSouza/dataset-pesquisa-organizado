import java.util.*;
import java.io.*;

public class entry_14214285 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(read.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=1; i<n; i++){
            st = new StringTokenizer(read.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        int diameter = 0;
        boolean[] visit = new boolean[n+1];
        // dfs(1, adj, visit);
        ArrayList<Integer>[] visitedNodes = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            visitedNodes[i] = new ArrayList<>();
        }
        int[] stack = new int[n];
        int idx = 0;
        stack[idx++] = 1;
        visit[1] = true;
        int[] result = new int[n+1];
        while (idx > 0) {
            int node = stack[idx-1];
            boolean added = false;
            for(int x: adj[node]){
                if (visit[x]) {
                    continue;
                }
                stack[idx++] = x;
                visit[x] = true;
                visitedNodes[node].add(x);
                added = true;
            }
            if (!added) {
                int max1 = 0;
                int max2 = 0;
                for(int x: visitedNodes[node]){
                    int len = result[x];
                    if (max1 < len) {
                        max2 = max1;
                        max1 = len;
                    } else if (max2 < len) {
                        max2 = len;
                    }
                }
                result[node] = max1+1;
                diameter = Math.max(diameter, max1+max2);
                idx--;
            }
        }
        out.println(diameter);
        out.flush();
    }
}