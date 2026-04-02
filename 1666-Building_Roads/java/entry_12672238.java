import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_12672238 {

    static class DSU {
        private int[] parent;
        private int[] rank;

        public DSU(int size) {
            parent = new int[size + 1];
            rank   = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
                rank[i]   = 0;
            }
        }

        public int find(int x) {
            int root = x;
            while (root != parent[root]) {
                root = parent[root];
            }

            while (x != root) {
                int next = parent[x];
                parent[x] = root;
                x = next;
            }
            return root;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        DSU dsu = new DSU(n);

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            dsu.union(u, v);
        }

        boolean[] seen = new boolean[n + 1];
        List<Integer> representatives = new ArrayList<>();

        for (int city = 1; city <= n; city++) {
            int root = dsu.find(city);
            if (!seen[root]) {
                seen[root] = true;
                representatives.add(city);
            }
        }

        PrintWriter writer = new PrintWriter(System.out);

        int roadsNeeded = representatives.size() - 1;
        writer.println(roadsNeeded);

        for (int i = 0; i < roadsNeeded; i++) {
            int cityA = representatives.get(i);
            int cityB = representatives.get(i + 1);
            writer.println(cityA + " " + cityB);
        }

        writer.flush();
        writer.close();
    }
}
