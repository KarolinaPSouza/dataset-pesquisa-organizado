import java.util.*;
import java.io.*;

public class entry_12103832 {
    static int[] parent, rank;
    static Set<Integer> roots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        rank = new int[n + 1];
        roots = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
            roots.add(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        List<Integer> reps = new ArrayList<>(roots);
        int k = reps.size() - 1;
        System.out.println(k);

        if (k > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < reps.size(); i++) {
                sb.append(reps.get(i - 1)).append(" ").append(reps.get(i)).append("\n");
            }
            System.out.print(sb.toString());
        }
    }
    private static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
                roots.remove(rootB);
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
                roots.remove(rootA);
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
                roots.remove(rootB);
            }
        }
    }
}