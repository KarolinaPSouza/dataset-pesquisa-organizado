import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class entry_13250033 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution sol = new Solution();

        String s = reader.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);
        int[][] edges = new int[m][2];
        for(int i = 0; i < m; i++) {
            String t = reader.readLine();

            edges[i][0] = Integer.parseInt(t.split(" ")[0]);
            edges[i][1] = Integer.parseInt(t.split(" ")[1]);

        }
        //System.out.println(n);
        sol.solve(n, edges);

    }

}


class DSU {
    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int a) {
        if(a == parent[a]) {
            return a;
        }
        int parenta = findParent(parent[a]);
        parent[a] = parenta;
        return parenta;
    }

    public void union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);

        if(pa == pb) {
            return;
        }
        if(size[pa] > size[pb]) {
            parent[pb] = pa;
            size[pa] = size[pa] + size[pb];
        }
        else {
            parent[pa] = pb;
            size[pb] = size[pb] + size[pa];
        }
    }

}


class Solution {
    public void solve(int n, int[][] edges) {
        //System.out.println("Hey " + n);
        DSU dsu = new DSU(n);
        List<Integer> parent = new ArrayList<>();
        for(int[] edge: edges) {
            dsu.union(edge[0], edge[1]);
        }
        for(int i = 1; i <= n; i++) {
            if(dsu.findParent(i) == i) {
                parent.add(i);
            }
        }

        System.out.println(parent.size() - 1);
        for(int i = 1; i < parent.size(); i++) {
            System.out.println(parent.get(i-1) + " " + parent.get(i));
        }

    }

}