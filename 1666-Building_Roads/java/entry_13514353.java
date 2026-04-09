import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class entry_13514353 {

}

class buildingRoads {
    private int[] parent;
    private int[] rank;
    int count = 0;

    public void find_roads(int n, int[][] edges) {

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (find(i) == i)
                res.add(i);
        }

        int roads = res.size() - 1;
        System.out.println(roads);
        for (int i = 1; i < res.size(); i++) {
            System.out.println(res.get(i - 1) + " " + res.get(i));
        }
    }

    private int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    private boolean union(int x, int y) {
        int parent_x = find(x);
        int parent_y = find(y);
        if (parent_x == parent_y)
            return false;

        int rank_x = rank[parent_x];
        int rank_y = rank[parent_y];

        if (rank_x > rank_y)
            parent[parent_y] = parent_x;
        else if (rank_x < rank_y)
            parent[parent_x] = parent_y;
        else {
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            String[] edgeLine = reader.readLine().split(" ");
            edges[i][0] = Integer.parseInt(edgeLine[0]);
            edges[i][1] = Integer.parseInt(edgeLine[1]);
        }

        buildingRoads br = new buildingRoads();
        br.find_roads(n, edges);
    }
}
