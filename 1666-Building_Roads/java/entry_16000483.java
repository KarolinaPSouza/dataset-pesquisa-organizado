import java.io.*;
import java.util.*;

public class entry_16000483 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<Integer> reps;

    static void dfs(int u) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) dfs(v);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];
        reps = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                reps.add(i);
                dfs(i);
            }
        }
        System.out.println(reps.size()-1);
        for(int i = 1; i < reps.size(); i++) {
            System.out.println(reps.get(i-1)+" "+reps.get(i));
        }
    }
}