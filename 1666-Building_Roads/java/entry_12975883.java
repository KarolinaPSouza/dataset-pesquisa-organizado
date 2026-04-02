import java.io.*;
import java.util.*;

public class entry_12975883 {
    static List<List<Integer>> adj;
    static boolean[] visited;

    public static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]) - 1;
            int v = Integer.parseInt(edge[1]) - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[n];
        List<Integer> reps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                reps.add(i); // First node of this component
                dfs(i);
            }
        }

        pw.println(reps.size() - 1); // Number of roads to build

        for (int i = 0; i < reps.size() - 1; i++) {
            pw.println((reps.get(i) + 1) + " " + (reps.get(i + 1) + 1));
        }

        pw.flush();
        pw.close();
    }
}