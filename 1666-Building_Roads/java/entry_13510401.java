import java.io.*;
import java.util.*;

public class entry_13510401 {
    static int[] parent;

    // DSU find with path compression
    static int find(int u) {
        if (parent[u] != u)
            parent[u] = find(parent[u]);
        return parent[u];
    }

    // DSU union
    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootV] = rootU;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]); // number of cities
        int m = Integer.parseInt(firstLine[1]); // number of roads

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Process each road and perform union
        for (int i = 0; i < m; i++) {
            String[] road = br.readLine().split(" ");
            int a = Integer.parseInt(road[0]);
            int b = Integer.parseInt(road[1]);
            union(a, b);
        }

        // Find all unique components
        Set<Integer> components = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            components.add(find(i));
        }

        List<Integer> compList = new ArrayList<>(components);
        int k = compList.size();
        out.println(k - 1);

        for (int i = 1; i < k; i++) {
            out.println(compList.get(i - 1) + " " + compList.get(i));
        }

        out.flush();
        out.close();
        br.close();
    }
}