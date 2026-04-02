import java.io.*;
import java.util.*;

// Fast I/O class for competitive programming
class FastIO {
    private BufferedReader br;
    private StringTokenizer st;
    private BufferedWriter bw;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public void println(Object obj) {
        try {
            bw.write(obj.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(Object obj) {
        try {
            bw.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Component {
    int[] parent;
    int[] rank;

    Component(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);  // Path compression
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        // Union by rank
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public List<Integer> getUniqueRoots(int n) {
        Set<Integer> uniqueRoots = new HashSet<>();

        for (int i = 0; i < n; i++) {
            uniqueRoots.add(find(i));
        }

        return new ArrayList<>(uniqueRoots);
    }
}

public class entry_15958748 {
    public static void main(String[] args) {
        FastIO io = new FastIO();

        int n = io.nextInt();
        int m = io.nextInt();

        Component component = new Component(n);

        // Read all roads
        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1;  // Convert to 0-indexed
            int b = io.nextInt() - 1;
            component.union(a, b);
        }

        // Get all unique components
        List<Integer> roots = component.getUniqueRoots(n);

        // Output number of roads needed
        io.println(roots.size() - 1);

        // Connect all components
        for (int i = 1; i < roots.size(); i++) {
            io.println((roots.get(i-1) + 1) + " " + (roots.get(i) + 1));
        }

        io.close();
    }
}