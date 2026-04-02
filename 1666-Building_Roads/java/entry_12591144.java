import java.io.*;
import java.util.*;

public class entry_12591144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            union(parent, rank, u - 1, v - 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(find(i, parent) == i) {
                list.add(i);
            }
        }

        System.out.println(list.size() - 1);
        for(int i = 1; i < list.size(); i++) {
            System.out.println((list.get(i - 1) + 1) + " " + (list.get(i) + 1));
        }
    }

    public static void union(int[] parent, int[] rank, int u, int v) {
        int x = find(u, parent);
        int y = find(v, parent);

        if(x != y) {
            if(rank[x] > rank[y]) {
                parent[y] = x;
            } else if(rank[x] < rank[y]) {
                parent[x] = y;
            } else {
                parent[y] = x;
                rank[x]++;
            }
        }
    }

    public static int find(int x, int[] parent) {
        if(parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}