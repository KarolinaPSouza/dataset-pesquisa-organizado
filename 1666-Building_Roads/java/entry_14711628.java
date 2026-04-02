import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_14711628 {
    // Disjoint Set Union (Union-Find) with path compression and union by size
    private final static class DSU {
        private final int[] p, sz;
        DSU(int n) {
            p = new int[n+1];
            sz = new int[n+1];
            for (int i = 1; i <= n; i++) { p[i]=i; sz[i]=1; }
        }
        private int find(int x) { return p[x]==x?x:(p[x]=find(p[x])); }
        private boolean union(int a, int b) {
            a=find(a); b=find(b);
            if (a==b) return false;
            if (sz[a]<sz[b]) { int t=a; a=b; b=t; }
            p[b]=a; sz[a]+=sz[b];
            return true;
        }
        // Get representatives of all components
        List<Integer> getRepresentatives(int n) {
            List<Integer> reps = new ArrayList<>();
            boolean[] seen = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                int root = find(i);
                if (!seen[root]) {
                    reps.add(root);
                    seen[root] = true;
                }
            }
            return reps;
        }
    }

    // Fast input reader
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(); // number of cities
        int m = fs.nextInt(); // number of roads
        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            dsu.union(u, v);
        }
        List<Integer> representatives = dsu.getRepresentatives(n);
        int k = representatives.size();
        try (BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            fw.write(Integer.toString(k-1));
            fw.newLine();
            // Connect each component to form a single connected graph
            for (int i = 1; i < k; i++) {
                fw.write(representatives.get(i-1) + " " + representatives.get(i));
                fw.newLine();
            }
            fw.flush();
        }
    }
}